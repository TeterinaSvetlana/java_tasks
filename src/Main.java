public class Main {

    // 1. Создать пустой проект в IntelliJ IDEA и прописать метод main();
    public static void main(String[] args) {

        // 2. Создать переменные всех пройденных типов данных, и инициализировать их значения;
        byte b = 127;
        short s = 10000;
        int i = 1234567;
        long l = 1234567890L;
        char c = 'c';
        float f = 3.4f;
        double d = 3.14;
        boolean bool = false;

        double exp = expression(2, 10, 6, 3);

        boolean isSumInRange = isSumInRange(5,6);

        isPositive(1);

        boolean isNeg = isNegative(-2);

        hello("Sveta");

        whichYear(2019);
    }

    // 3. Написать метод вычисляющий выражение a * (b + (c / d)) и возвращающий результат,
    // где a, b, c, d – входные параметры этого метода;
    private static double expression (int a, int b, int c, int d) {
        return a * (b+(c/d));
    }

    // 4. Написать метод, принимающий на вход два числа, и проверяющий что их сумма лежит в пределах
    // от 10 до 20(включительно), если да – вернуть true, в противном случае – false;
    private static boolean isSumInRange (int a, int b) {
        int sum = a+b;
        if (sum>=10 && sum <=20)
            return true;
        else return false;
    }

    // 5. Написать метод, которому в качестве параметра передается целое число, метод должен напечатать в консоль
    // положительное ли число передали, или отрицательное; Замечание: ноль считаем положительным числом.
    private static void isPositive (int a) {
        if (a<0)
            System.out.println("Отрицательное число");
        else System.out.println("Положительное число");
    }

    // 6. Написать метод, которому в качестве параметра передается целое число,
    // метод должен вернуть true, если число отрицательное;
    private static boolean isNegative (int a) {
        if (a<0)
            return true;
        else return false;
    }

    // 7. Написать метод, которому в качестве параметра передается строка, обозначающая имя, метод должен вывести
    // в консоль сообщение «Привет, указанное_имя!»;
    private static void hello (String a) {
        System.out.println("Привет, " + a + "!");
    }

    // 8. * Написать метод, который определяет является ли год високосным, и выводит сообщение в консоль.
    // Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.
    private static void whichYear (int a) {
        if (a % 400 == 0) System.out.println("Високосный");
        else if ( a % 100 == 0) System.out.println("Не високосный");
        else if (a % 4 == 0) System.out.println("Високосный");
        else System.out.println("Не високосный");
    }
}
