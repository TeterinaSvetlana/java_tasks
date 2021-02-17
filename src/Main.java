import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String[] array = {"aa", "bb", "cc"};
        changeElementsInArray(array, 0, 1);
        arrayToArrayList(array);
        fruitBoxTest();
    }

    // 1. Написать метод, который меняет два элемента массива местами
    public static Object[] changeElementsInArray (Object[] array, int firstElIndex, int secondElIndex){
        System.out.print("Original array: ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i].toString()+ " ");
        }
        System.out.println();

        Object temp = array[firstElIndex];
        array[firstElIndex] = array[secondElIndex];
        array[secondElIndex] = temp;

        System.out.print("Changed array: ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i].toString()+ " ");
        }
        System.out.println();

        return array;
    }

    // 2. Написать метод, который преобразует массив в ArrayList;
    public static ArrayList arrayToArrayList(Object array) {
        ArrayList arrayList = new ArrayList(Arrays.asList(array));
        return arrayList;
    }

    // 3. Большая задача
    public static void fruitBoxTest(){
        Apple a1 = new Apple();
        Apple a2 = new Apple();
        Orange o1 = new Orange();

        Box box1 = new Box();
        box1.addFruitInBox(a1);
        box1.addFruitInBox(a2);
        box1.addFruitInBox(o1);

        Box box2 = new Box();
        box2.addFruitInBox(o1);

        box2.compare(box1);

        Box box3 = new Box();
        box3.addFruitInBox(a1);
        box2.moveToAnotheBox(box3);
    }
}
