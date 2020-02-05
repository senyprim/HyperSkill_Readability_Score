package readability;

public class ParameterText {
    private int _length=0;
    private int _wordsCount=0;
    private int _sentencesCount;
    private int _syllablesCount=0;
    private int _polysyllablesCount=0;

    public int get_length() {
        return _length;
    }

    public int get_wordsCount() {
        return _wordsCount;
    }

    public int get_sentencesCount() {
        return _sentencesCount;
    }

    public int get_syllablesCount() {
        return _syllablesCount;
    }

    public int get_polysyllablesCount() {
        return _polysyllablesCount;
    }

    public ParameterText(String[][] words){
        this._sentencesCount=words.length;
        for(int i=0;i<get_sentencesCount();i++){
            _wordsCount+=words[i].length;
            for(int j=0;j<words[i].length;j++){
                _length+=words[i][j].length();
                int syllablyCount=SplitText.SyllableCount(words[i][j]);
                _syllablesCount+=syllablyCount;
                if (syllablyCount>2) _polysyllablesCount++;
            }
        }
    }

    public ParameterText(String text){
        this(SplitText.getWords(text));
    }

    @Override
    public String toString(){
       return String.format("Words:%d\nSentences:%d\nCharacters:%d\nSyllables: %d\nPolysyllables: %d\n",
                get_wordsCount(),
                get_sentencesCount(),
                get_length(),
                get_syllablesCount(),
                get_polysyllablesCount()
        );
    }
}
