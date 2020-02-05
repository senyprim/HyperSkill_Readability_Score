package readability.index;

public abstract class Index  {
    public abstract String getName();
    public abstract double getIndex();
    @Override
    public String toString(){
        return String.format("%s: %.2f",getName(),getIndex());
    }
}
