import java.util.*;

public class Main {
    public static void main(String[] args) {

        // 1.
        String [] words = {"one", "two", "three", "four", "five",
                            "one", "two", "six", "four", "five",
                            "one", "two", "seven", "four", "five",};
        HashSet<String> hashSetWords = new HashSet<String>(Arrays.asList(words));
        System.out.println(hashSetWords);

        for (String el: hashSetWords) {
            int k = 0;
            for (int j = 0; j < words.length; j++) {
                if (el == words[j]) k++;
            }
            System.out.println(el + ": " + k);
        }

        // 2.
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Ivanov", "89081234312");
        phoneBook.add("Ketov", "89121231745");
        phoneBook.add("Ivanov", "89511270310");

        phoneBook.get("Ivanov");
    }
}
