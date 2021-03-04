import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Car implements Runnable {
    private static int CARS_COUNT;
    public static int carsReady;
    ReentrantLock locker;
    Condition condition;

    static {
        CARS_COUNT = 0;
        carsReady = 0;
    }
    private Race race;
    private int speed;
    private String name;
    public String getName() {
        return name;
    }
    public int getSpeed() {
        return speed;
    }
    public Car(Race race, int speed) {
//        locker = new ReentrantLock(); // создаем блокировку
//        condition = locker.newCondition(); // получаем условие связанное с блокировкой

        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
    }
    @Override
    public void run() {
        System.out.println(this.name + " готовится");

        locker = new ReentrantLock(); // создаем блокировку
        condition = locker.newCondition(); // получаем условие связанное с блокировкой

        try {
//            System.out.println(this.name + " готовится");
            locker.lock();
//            try {
            Thread.sleep(500 + (int)(Math.random() * 800));

            while (Thread.interrupted()) {
                condition.await();
            }

//                Thread.sleep(500 + (int)(Math.random() * 800));
            System.out.println(this.name + " готов");
            condition.signal();

        } catch (Exception e) {
            e.printStackTrace();
//        }
//        } catch (Exception ignored) {
        } finally {
            {
//                System.out.println(this.name + " готов");
                carsReady++;
                locker.unlock();

                for (int i = 0; i < race.getStages().size(); i++) {
                    race.getStages().get(i).go(this);
                }
            }
        }

//        for (int i = 0; i < race.getStages().size(); i++) {
//            race.getStages().get(i).go(this);
//        }




//        try {
//            System.out.println(this.name + " готовится");
//            Thread.sleep(500 + (int)(Math.random() * 800));
//            System.out.println(this.name + " готов");
//            carsReady++;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        for (int i = 0; i < race.getStages().size(); i++) {
//            race.getStages().get(i).go(this);
//        }

    }

    public static int getReady() {
        return carsReady;
    }
}