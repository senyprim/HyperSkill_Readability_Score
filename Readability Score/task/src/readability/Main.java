package readability;
import  java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String text= scanner.nextLine();
        String[] sentences= text.split("\\.|\\?|!");
        int countWords=0;
        for(String sectence : sentences){
            List<String> words=new ArrayList<>();
            for(String word:sectence.trim().split("\\s+|,")){
                if (!word.trim().equals("")) words.add(word);
            }
            countWords+=words.size();
        }
        double average=(double) countWords/sentences.length;
        String answer = average>10?"HARD":"EASY";
        System.out.print(answer);
    }
}
