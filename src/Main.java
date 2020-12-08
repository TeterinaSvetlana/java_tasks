import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        guessNumber();
        guessWord();
        taskFromTheLesson();
    }
    
    // 1. Написать программу, которая загадывает случайное число от 0 до 9, и пользователю дается 3 попытки
    // угадать это число. При каждой попытке компьютер должен сообщить больше ли указанное пользователем число
    // чем загаданное, или меньше. После победы или проигрыша выводится запрос – «Повторить игру еще раз?
    // 1 – да / 0 – нет»(1 – повторить, 0 – нет).
    public static void guessNumber() {
        Scanner scanner = new Scanner(System.in);
        boolean game = true;
        while (game) {
            int randomNumber = new Random().nextInt(9);
            for (int i = 0; i < 3; i++) {
                int enteredNumber = scanner.nextInt();
                if (enteredNumber == randomNumber) {
                    System.out.println("Победа!");
                    break;
                }
                if (enteredNumber > randomNumber) {
                    System.out.println("Загаданное число меньше");
                }
                if (enteredNumber < randomNumber) {
                    System.out.println("Загаданное число больше");
                }
            }
            System.out.println("Повторить игру еще раз? 1 – да / 0 – нет");
            int answer = scanner.nextInt();
            switch (answer){
                case (1):
                    break;
                case (0):
                    game = false;
                    break;
                default:
                    System.out.println("Некорректный ответ");
                    break;
            }
        }
    }

    // 2 * Создать массив из слов
    // При запуске программы компьютер загадывает слово, запрашивает ответ у пользователя,
    // сравнивает его с загаданным словом и сообщает правильно ли ответил пользователь.
    // Если слово не угадано, компьютер показывает буквы которые стоят на своих местах.
    public static void guessWord() {
        Scanner scanner = new Scanner(System.in);
        boolean game = true;
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        String randomWord = words[new Random().nextInt(words.length-1)];
        while (game) {
            String enteredWord = scanner.next();
            if (enteredWord.equals(randomWord)) {
                System.out.println("Победа!");
                game = false;
            } else {
                StringBuilder hint = new StringBuilder("###############");
                for (int i = 0; i < Math.min(enteredWord.length(), randomWord.length()); i++) {
                    if (enteredWord.charAt(i) == randomWord.charAt(i)) {
                        hint.setCharAt(i, randomWord.charAt(i));
                    }
                }
                System.out.println(hint);
            }
        }
    }

    // 3. Задачка с лекции
    public static void taskFromTheLesson() {
        String s = "Предложение     один  Теперь     предложение    два   Тут  предложение          три";

        System.out.println(s);
        String s1 = s.replaceAll(" +", " ");

        StringBuilder s2 = new StringBuilder(s1);
        int n = 0;
        for (int i = 1; i < s1.length(); i++) {
            if (s2.charAt(i) >= 'А' && s2.charAt(i) <= 'Я') {
                s2.insert(i - 1, ".");
                i++;
            }
        }
        s2.append('.');

        System.out.println(s2);
    }
}
