public class Main {

    public static void main(String[] args) {
        Cat cat1 = new Cat();
        cat1.run(100);
        cat1.run(500);

        Dog dog1 = new Dog();
        dog1.run(500);
        dog1.run(600);
        dog1.setMaxRun(600);
        dog1.run(600);


    }
}
