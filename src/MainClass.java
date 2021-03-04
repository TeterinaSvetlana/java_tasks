import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class MainClass {
    public static final int CARS_COUNT = 4;
    static ReentrantLock locker;
    static Condition condition;
    private static int ready = 0;


    public static void main(String[] args) {
        locker = new ReentrantLock(); // создаем блокировку
        condition = locker.newCondition(); // получаем условие связанное с блокировкой

        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");


        Race race = new Race(new Road(60), new Tunnel(), new Road(40));
        Car[] cars = new Car[CARS_COUNT];

        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10));
        }

        for (int i = 0; i < cars.length; i++) {
            new Thread(cars[i]).start();
        }


        locker.lock();
        try {
//            System.out.println(this.name + " готовится");

//            try {
//            Thread.sleep(500 + (int)(Math.random() * 800));
//            int k = 0;
            while (Car.carsReady < CARS_COUNT) {
                condition.await();
//                continue;
            }
            ready = Car.getReady();
//            for (int i = 0; i < cars.length; i++) {
//                new Thread(cars[i]).start();
////                k++;
//            }

//                Thread.sleep(500 + (int)(Math.random() * 800));
//            System.out.println(this.name + " готов");
            condition.signalAll();

            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");

        } catch (Exception ignored) {
//            e.printStackTrace();
//        }
//        } catch (Exception ignored) {
        } finally {
            {
//                System.out.println(this.name + " готов");
                locker.unlock();

//                System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
//                System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
            }
        }



//        locker.lock();
//        try {
//            condition.await();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//            for (int i = 0; i < cars.length; i++) {
//                cars[i] = new Car(race, 20 + (int) (Math.random() * 10));
//            }
//            for (int i = 0; i < cars.length; i++) {
//                new Thread(cars[i]).start();
//            }
//            condition.signalAll();
//
////        } catch (Exception ignored e) {
////            e.printStackTrace();
//        }finally{
//            {
//                locker.unlock();
//            }
//        }


//            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
//        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
    }
}