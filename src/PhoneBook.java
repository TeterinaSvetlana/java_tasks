import java.util.HashMap;
import java.util.Map;

public class PhoneBook {
    Map<String, String>  phoneBook = new HashMap<>();

    public void add (String surname, String phoneNumber) {
        this.phoneBook.put(phoneNumber, surname);
    }

    public void get (String surname) {
        for (Map.Entry<String, String> pb:phoneBook.entrySet()) {
            if (pb.getValue() == surname)
            System.out.println(pb.getKey());
        }

    }
}
