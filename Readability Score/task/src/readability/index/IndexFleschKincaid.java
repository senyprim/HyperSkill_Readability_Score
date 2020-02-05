package readability.index;
import readability.ParameterText;

public class IndexFleschKincaid extends Index {
    private final double _index;
    public IndexFleschKincaid(ParameterText parameterText){
        this._index=  0.39*parameterText.get_wordsCount()/parameterText.get_sentencesCount()+
                11.8*parameterText.get_syllablesCount()/parameterText.get_wordsCount()-
                15.59;
    }
    @Override
    public String getName() {
      return "Flesch–Kincaid readability tests";
    }

    @Override
    public double getIndex() { return _index;}
}
