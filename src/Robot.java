public class Robot implements Contestant{
    private int maxRun;
    private int maxJump;

    public Robot(int maxRun, int maxJump) {
        this.maxRun = maxRun;
        this.maxJump = maxJump;
    }
    @Override
    public int getMaxRun(){
        return maxRun;
    }

    @Override
    public int getMaxJump(){
        return maxJump;
    }

    @Override
    public void run(){
        System.out.println("Robot is running");
    }

    @Override
    public void jump(){
        System.out.println("Robot is jumping");
    }
}
