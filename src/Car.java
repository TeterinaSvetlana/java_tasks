import java.util.concurrent.CountDownLatch;

public class Car implements Runnable {
    private static int CARS_COUNT;
    static {
        CARS_COUNT = 0;
    }
    private final CountDownLatch cdlCarReady;
    private final CountDownLatch cdlCarFinished;
    private static final CountDownLatch countDownLatch = new CountDownLatch(MainClass.CARS_COUNT);

    private Race race;
    private int speed;
    private String name;
    public String getName() {
        return name;
    }
    public int getSpeed() {
        return speed;
    }
    public Car(Race race, int speed, CountDownLatch cdlCarReady, CountDownLatch cdlCarFinished) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
        this.cdlCarReady = cdlCarReady;
        this.cdlCarFinished = cdlCarFinished;

    }
    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int)(Math.random() * 800));
            System.out.println(this.name + " готов");
            countDownLatch.countDown();
            cdlCarReady.countDown();

        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this,  i + 1, race.getStages().size());
        }
        cdlCarFinished.countDown();

    }
}