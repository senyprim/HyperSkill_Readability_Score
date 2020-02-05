package readability;

import java.util.regex.Pattern;

public class SplitText {
    private static final Pattern  splitPattern=Pattern.compile("\\|");
    private static final Pattern endSentence =Pattern.compile("[.?!]",Pattern.MULTILINE);
    private static final Pattern endWord = Pattern.compile("(,\\s+)|(\\s+)",Pattern.MULTILINE);
    private static final Pattern notSymbol=Pattern.compile("(\\t+)|(\\s+)|(\\n+)|(\\r+)",Pattern.MULTILINE);

    private static final Pattern vowels=Pattern.compile("[aeiouy]+",Pattern.CASE_INSENSITIVE);

    public static String[] getSentences(String text){
        String textWithSplit=endSentence.matcher(text.trim()).replaceAll(matchResult->matchResult.group()+splitPattern.pattern());
        return splitPattern.split(textWithSplit);
    }

    private static String[] splitWords(String text){
        String textWithSplit=endWord.matcher(text.trim()).replaceAll(matchResult->matchResult.group()+splitPattern.pattern());
        String onlyVisibleSymbol=notSymbol.matcher(textWithSplit).replaceAll("");
        return splitPattern.split(onlyVisibleSymbol);
    }

    public static  String[][] getWords(String text){
        String[] sentences=getSentences(text);
        String[][] words=new String[sentences.length][];
        for(int i=0;i<sentences.length;i++)
            words[i]= splitWords(sentences[i]);
        return words;
    }

    public static String getOnlyVisibleSymbols(String text){
        return notSymbol.matcher(text).replaceAll("");
    }

    public static int SyllableCount(String word)
    {
        word=endWord.matcher(word).replaceAll("");
        word=endSentence.matcher(word).replaceAll("");
        int count = vowels.split(word,-1).length-1;
        if (word.endsWith("e")||word.endsWith("e,")||word.endsWith("e.")) count--;
        return count==0?1:count;
    }
}
