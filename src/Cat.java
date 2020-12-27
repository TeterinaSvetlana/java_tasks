public class Cat {
    private String name;
    private int appetite;
    private boolean isFed;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        this.isFed = false;
    }

    public void eat(Plate p) {
        if (p.decreaseFood(appetite)) this.isFed = true;
    }
    String getName(){
        return name;
    }
}