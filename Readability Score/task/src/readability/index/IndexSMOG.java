package readability.index;

import readability.ParameterText;

public class IndexSMOG extends Index {
    private double _index;

    @Override
    public String getName() {
        return "Simple Measure of Gobbledygook";
    }

    @Override
    public double getIndex(){return _index;}
    public IndexSMOG(ParameterText parameterText) {
        this._index=1.043*Math.sqrt(parameterText.get_polysyllablesCount()*30.0/parameterText.get_sentencesCount())
                +3.1291;
    }
}
