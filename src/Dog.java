public class Dog extends Animal {
    double maxRun = 500;
    double maxJump = 0.5;
    double maxSwim = 10;

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
