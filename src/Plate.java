public class Plate {
    private int food;
    public Plate(int food) {
        this.food = food;
    }
    public boolean decreaseFood(int n) {
        if (food >= n) {
            food -= n;
            System.out.println("Done! Food is left: " + food);
            return  true;
        }
        else {
            System.out.println("Not enough food! Food is left: " + food);
            return false;
        }
    }
    public void addFood(int n) {
        food += n;
    }
    public void info() {
        System.out.println("plate: " + food);
    }
}