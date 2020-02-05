package readability;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

import readability.index.*;

public class Text{
    public static Text loadFromFile(String fileName) {
        try{
            return new Text(new String(Files.readAllBytes(Paths.get(fileName))));
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    private String _text;
    public  final ParameterText parameterText;
    private Map<String,Index> _readabilityIndex;

    public Text(String text){
            this._text = text.trim();
            this.parameterText=new ParameterText(this._text);
            this._readabilityIndex=new LinkedHashMap<>();
            this._readabilityIndex.put("ARI",new IndexAutoReadability(this.parameterText));
            this._readabilityIndex.put("FK",new IndexFleschKincaid(this.parameterText));
            this._readabilityIndex.put("SMOG",new IndexSMOG(this.parameterText));
            this._readabilityIndex.put("CL",new IndexColemanLiau(this.parameterText));
    }

    public List<Index> getIndex(String key){
        List<Index> list=new ArrayList<>();
        if (!key.equals("all")) return Collections.singletonList(this._readabilityIndex.get(key));
        return new ArrayList<>(_readabilityIndex.values());
    }
    public double getAverageAge(){
        if (this._readabilityIndex.isEmpty()) return 0;
        double sum=0;
        for (Index item : this._readabilityIndex.values()){
            sum+=AgeIndex.getAgeIndex(item.getIndex()).endAge;
        }
        return sum/this._readabilityIndex.size();
    }
}
