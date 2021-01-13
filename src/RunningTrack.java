public class RunningTrack implements Barrier{
    private int length;

    public RunningTrack(int length) {
        this.length = length;
    }

    @Override
    public boolean isSuccessful(int maxRun) {
        if(maxRun >= length) {
            System.out.println("Run is done");
            return true;
        }
        else {
            System.out.println("Run is failed");
            return false;
        }
    }
}
