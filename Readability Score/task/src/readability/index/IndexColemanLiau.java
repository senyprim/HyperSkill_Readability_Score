package readability.index;

import readability.ParameterText;

public class IndexColemanLiau extends Index {
    private double _index;
    public double getIndex() {return _index;}

    @Override
    public String getName() {
        return "Coleman–Liau index";
    }

    public IndexColemanLiau(ParameterText parameterText)
    {
        double L=(double) parameterText.get_length()/parameterText.get_wordsCount()*100;//L is the average number of characters per 100 words
        double S=(double) parameterText.get_sentencesCount()/parameterText.get_wordsCount()*100;//S is the average number of sentences per 100 words
        this._index= 0.0588*L-0.296*S-15.8;
    }
}
