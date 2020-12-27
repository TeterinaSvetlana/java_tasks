// actually task 7, not task 8
public class Main {

    public static void main(String[] args) {

        Plate plate = new Plate(8);
        Cat cat1 = new Cat("Barsik", 2);
        Cat cat2 = new Cat("Murzik", 8);
        Cat cat3 = new Cat("Murka", 4);

        Cat[] arr = {cat1, cat2, cat3};

        for (int i = 0; i < arr.length; i++) {
            arr[i].eat(plate);
        }

        plate.addFood(20);

        for (int i = 0; i < arr.length; i++) {
            arr[i].eat(plate);
        }
    }

}
