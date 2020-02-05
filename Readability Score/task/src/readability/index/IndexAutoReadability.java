package readability.index;

import readability.ParameterText;

public class IndexAutoReadability extends Index {
    private double _index;
    @Override
    public double getIndex(){return _index;}

    @Override
    public String getName() {
        return "Automated Readability Index";
    }

    public IndexAutoReadability(ParameterText parameterText) {
        this._index= 4.71*parameterText.get_length()/parameterText.get_wordsCount()+
                0.5*parameterText.get_wordsCount()/parameterText.get_sentencesCount()-
                21.43;
    }
}
