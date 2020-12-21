public class Cat extends Animal {
    private double maxRun = 200;
    private double maxJump = 2;
    private double maxSwim = 0;

    public void setMaxRun(double maxRun) {
        this.maxRun = maxRun;
    }

    public void setMaxJump(double maxJump) {
        this.maxJump = maxJump;
    }

    public void setMaxSwim(double maxSwim) {
        this.maxSwim = maxSwim;
    }

    @Override
    public void run(double length) {
        boolean canDo = false;
        if (maxRun >= length) canDo = true;
        System.out.println("run: " + canDo);
    }

    @Override
    public void swim(double length) {
        boolean canDo = false;
        if (maxSwim >= length) canDo = true;
        System.out.println("run: " + canDo);
    }

    @Override
    public void jump(double height) {
        boolean canDo = false;
        if (maxJump >= height) canDo = true;
        System.out.println("run: " + canDo);
    }
}
