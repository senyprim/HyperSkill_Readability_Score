package readability.index;

public class AgeIndexData {
        public final int startAge;
        public final int endAge;
        public final String gradeLevel;
        public AgeIndexData(int startAge,int endAge,String gradeLevel){
            this.startAge=startAge;
            this.endAge=endAge;
            this.gradeLevel=gradeLevel;
        }
        @Override
        public String toString(){
            return String.format("(about %d year olds).",endAge);
        }
}
