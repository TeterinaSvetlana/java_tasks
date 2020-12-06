public class Main {

    public static void main(String[] args) {
        masZeroToOne();

        masCycleFillin();

        masDoubledNumbers();

        squareMas(5);

        int[] mas = {1,2,3,4,5,6,7,8,9,0};
        int maxEl = findMaxElement(mas);
        System.out.println(maxEl);

        int[] masForCheckBalance = {1, 1, 1, 2, 1};
        boolean isBalanced = checkBalance(masForCheckBalance);
        System.out.println(isBalanced);

        int[] masMove = {1, 2, 3, 4, 5};
        moveMas(masMove, -1);

    }
    
    // 1. Задать целочисленный массив, состоящий из элементов 0 и 1. 
    // Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. С помощью цикла и условия заменить 0 на 1, 1 на 0;
    public static void masZeroToOne() {
        int[] mas = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        for (int i = 0; i < mas.length; i++) {
            if (mas[i] == 0) {
                mas[i] = 1;
            } else {
                mas[i] = 0;
            }
        }

        for (int element:mas) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    //2. Задать пустой целочисленный массив размером 8.
    // С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;
    public static void masCycleFillin() {
        int[] mas = new int [8];
        for (int i = 0; i < mas.length; i++) {
            mas[i] = i*3;
        }

        for (int element:mas) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    //3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ]
    // пройти по нему циклом, и числа меньшие 6 умножить на 2;
    public static void masDoubledNumbers() {
        int[] mas = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < mas.length; i++) {
            if (mas[i] < 6) {
                mas[i] *= 2;
            }
        }

        for (int element:mas) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    // 4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
    // и с помощью цикла(-ов) заполнить его диагональные элементы единицами;
    public static void squareMas(int n) {
        int[][] mas = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j || i+j == n-1) {
                    mas[i][j] = 1;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(mas[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    // 5. ** Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета);
    public static int findMaxElement(int[] mas) {
        int max = mas[0];
        for (int i = 1; i < mas.length; i++) {
            if (mas[i] > max) max = mas[i];
        }
        return max;
    }

    // 6. ** Написать метод, в который передается не пустой одномерный целочисленный массив, метод должен вернуть true,
    // если в массиве есть место, в котором сумма левой и правой части массива равны.
    // Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true, checkBalance([1, 1, 1, || 2, 1]) → true,
    // граница показана символами ||, эти символы в массив не входят.
    public static boolean checkBalance(int[] mas) {
        int leftSum = 0;
        int rightSum = 0;
        for (int i = 0; i < mas.length; i++) {
            int[] leftMas = new int [i+1];
            int[] rightMas = new int[mas.length - i - 1];


            for (int j = 0; j < mas.length; j++) {
//                do {
//                    leftMas[j] = mas[j];
//                } while (i < j);
                if (i >= j) {
                    leftMas[j] = mas[j];
                } else {
                    rightMas[j - i - 1] = mas[j];
                }
            }
            leftSum = sum(leftMas);
            rightSum = sum(rightMas);
            if (leftSum == rightSum) return true;
        }
        return false;
    }

    public static int sum(int[] mas) {
        int sum = 0;
        for (int i = 0; i < mas.length; i++) {
            sum = sum + mas[i];
        }
        return sum;
    }

    // 7. **** Написать метод, которому на вход подается одномерный массив и число n (может быть положительным,
    // или отрицательным), при этом метод должен сместить все элементымассива на n позиций.
    // Для усложнения задачи нельзя пользоваться вспомогательными массивами.
    public static void moveMas(int[] mas, int n) {
        for (int i = 0; i < Math.abs(n); i++) {
            if (n>0) {
                int temp = mas[mas.length - 1];
                for (int j = mas.length - 1; j > 0; j--) {
                    mas[j] = mas[j - 1];
                }
                mas[0] = temp;
            }
            if (n<0){
                int temp = mas[0];
                for (int j = 0; j < mas.length - 1; j++) {
                    mas[j] = mas[j + 1];
                }
                mas[mas.length - 1] = temp;
            }
        }

        for (int element:mas) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
}
