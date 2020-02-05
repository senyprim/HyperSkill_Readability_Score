package readability;
import readability.index.AgeIndex;
import readability.index.Index;

import  java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        Text text=Text.loadFromFile(args[0]);
        if (text==null) throw new NullPointerException();
        System.out.print(text.parameterText.toString());
        System.out.print("Enter the score you want to calculate (ARI, FK, SMOG, CL, all):");
        String answer=scanner.nextLine();

        System.out.println();
        List<Index> indexes =text.getIndex(answer);
        for(Index index : indexes==null?new ArrayList<Index>():indexes){
            System.out.println(String.format("%s %s",index.toString()
                    , AgeIndex.getAgeIndex(index.getIndex()).toString()));
        }

        System.out.println();
        System.out.println(String.format("This text should be understood in average by %.2f year olds.",text.getAverageAge()));

    }
}
