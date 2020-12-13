import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {

    static int SIZE_X = 5;
    static int SIZE_Y = 5;
    static int CHIP_NUMBER = 4; // кол-во фишек в ряд для выйгрыша

    static char[][] field = new char[SIZE_Y][SIZE_X];
    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();

    static char PLAYER_DOT = 'X';
    static char AI_DOT = 'O';
    static char EMPTY_DOT = '.';

    static void initField() {
        for (int i = 0; i < SIZE_Y; i++) {
            for (int j = 0; j < SIZE_X; j++) {
                field[i][j] = EMPTY_DOT;
            }
        }
    }

    static void printField() {
        System.out.println("-------");
        for (int i = 0; i < SIZE_Y; i++) {
            System.out.print("|");
            for (int j = 0; j < SIZE_X; j++) {
                System.out.print(field[i][j] + "|");
            }
            System.out.println();
        }
        System.out.println("-------");
    }

    static boolean isCellValid(int y, int x) {
        if (x < 0 || y < 0 || x > SIZE_X - 1 || y > SIZE_Y - 1) {
            return false;
        }
        return field[y][x] == EMPTY_DOT;
    }

    static boolean isFieldFull() {
        for (int i = 0; i < SIZE_Y; i++) {
            for (int j = 0; j < SIZE_X; j++) {
                if (field[i][j] == EMPTY_DOT) {
                    return false;
                }
            }
        }
        return true;
    }

    static void setSym(int y, int x, char sym) {
        field[y][x] = sym;
    }

    static void playerStep() {
        int x,y;
        do {
            System.out.println("Введите координаты: X Y (1-3)");
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
        } while (!isCellValid(y,x));
        setSym(y,x, PLAYER_DOT);
    }

    static void aiStep() {
        int x,y;
        int[] coordinates = new int[2];
        System.out.println("Ходит SkyNet");
        do {

//            x = random.nextInt(SIZE_X);
//            y = random.nextInt(SIZE_Y);
            coordinates = smartAI(PLAYER_DOT);
            y = coordinates[0];
            x = coordinates[1];
        } while (!isCellValid(y,x));
        setSym(y,x, AI_DOT);
    }

    static int[] smartAI(char sym) {
        int[] coordinates = new int[2];
        int currChipNum = 0;
        int maxChipNum = 0;

        for (int i = 0; i < SIZE_Y; i++) {      // проверка по горизонтали
            for (int j = 0; j < SIZE_X; j++) {
                if (field[i][j] == sym) {
                    currChipNum++;
                } else {
                    if (field[i][j] == AI_DOT) continue;
                    if (currChipNum > maxChipNum){
                        maxChipNum = currChipNum;
                        if (isCellValid(i,j)) {
                            coordinates[0] = i;
                            coordinates[1] = j;
                        } else if (isCellValid(i, j-currChipNum)) {
                            coordinates[0] = i;
                            coordinates[1] = j-currChipNum;
                        }

                    }
                    currChipNum = 0;
                }
            }
        }

        for (int j = 0; j < SIZE_X; j++) {      // проверка по вертикали
            for (int i = 0; i < SIZE_Y; i++) {
                if (field[i][j] == sym) {
                    currChipNum++;
                } else {
                    if (field[i][j] == AI_DOT) continue;
                    if (currChipNum > maxChipNum){
                        maxChipNum = currChipNum;
                        if (isCellValid(i,j)) {
                            coordinates[0] = i;
                            coordinates[1] = j;
                        } else if (isCellValid(i-currChipNum, j)) {
                            coordinates[0] = i-currChipNum;
                            coordinates[1] = j;
                        }

                    }
                    currChipNum = 0;
                }
            }
        }

        return coordinates;
    }

    static boolean checkWin(char sym) {
        int currChipNum = 0;
        for (int i = 0; i < SIZE_Y; i++) {      // совпадения по горизонтали
            for (int j = 0; j < SIZE_X; j++) {
                if (field[i][j] == sym) {
                    if (j + CHIP_NUMBER <= SIZE_X) {
                        for (int k = j; k < CHIP_NUMBER; k++) {
                            if (field[i][k] == sym) {
                                currChipNum++;
                                if (currChipNum == CHIP_NUMBER)
                                    return true;
                            } else {
                                currChipNum = 0;
                            }
                        }
                    }
                }
            }
        }

        currChipNum = 0;
        for (int j = 0; j < SIZE_X; j++) {      // совпадения по вертикали
            for (int i = 0; i < SIZE_Y; i++) {
                if (field[i][j] == sym) {
                    if (i + CHIP_NUMBER <= SIZE_Y) {
                        for (int k = i; k < CHIP_NUMBER; k++) {
                            if (field[k][j] == sym) {
                                currChipNum++;
                                if (currChipNum == CHIP_NUMBER)
                                    return true;
                            } else {
                                currChipNum = 0;
                            }
                        }
                    }
                }
            }
        }

        currChipNum = 0;
        for (int i = 0; i < SIZE_Y; i++) {      // совпадения по диагонали
            for (int j = 0; j < SIZE_X; j++) {
                if (field[i][j] == sym) {
                    if (i + CHIP_NUMBER <= SIZE_Y) {
                        if (j >= CHIP_NUMBER - 1) {
                            for (int k = 0; k < CHIP_NUMBER; k++) {
                                if (field[i + k][j - k] == sym) {
                                    currChipNum++;
                                    if (currChipNum == CHIP_NUMBER) {
                                        return true;
                                    }
                                } else {
                                    currChipNum = 0;
                                }
                            }
                        }
                        if (j+CHIP_NUMBER <= SIZE_X) {
                            for (int k = 0; k < CHIP_NUMBER; k++) {
                                if (field[i + k][j + k] == sym) {
                                    currChipNum++;
                                    if (currChipNum == CHIP_NUMBER) {
                                        return true;
                                    }
                                } else {
                                    currChipNum = 0;
                                }
                            }
                        }
                    }
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        initField();
        printField();

        while (true) {
            playerStep();
            printField();
            if (checkWin(PLAYER_DOT)) {
                System.out.println("Player WIN!");
                break;
            }
            if (isFieldFull()) {
                System.out.println("DRAW");
                break;
            }
            aiStep();
            printField();
            if (checkWin(AI_DOT)) {
                System.out.println("WIN SkyNet");
                break;
            }
            if (isFieldFull()) {
                System.out.println("DRAW");
                break;
            }
        }


    }
}
