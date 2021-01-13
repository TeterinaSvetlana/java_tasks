public class Cat implements Contestant{
    private int maxRun;
    private int maxJump;

    public Cat(int maxRun, int maxJump) {
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
        System.out.println("Cat is running");
    }

    @Override
    public void jump(){
        System.out.println("Cat is jumping");
    }

}
