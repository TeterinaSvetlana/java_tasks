public class Wall implements Barrier{
    private int height;

    public Wall(int height) {
        this.height = height;
    }

    @Override
    public boolean isSuccessful(int maxJump) {
        if(maxJump >= height){
            System.out.println("Jump is done");
            return true;
        }
        else
        {
            System.out.println("Jump is failed");
            return false;
        }
    }
}
