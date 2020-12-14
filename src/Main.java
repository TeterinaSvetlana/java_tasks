import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        StaffMember[] persArray = new StaffMember[5];
        persArray[0] = new StaffMember("Ivanov Ivan", "Engineer", "ivivan@mailbox.com",
                                        "892312312", 30000, 30);
        persArray[1] = new StaffMember("Alexandrov Alexandr", "Programmer", "aaa@mailbox.com",
                                        "892312333", 60000, 29);
        persArray[2] = new StaffMember("Maria Mashina", "Director", "mainPerson@mailbox.com",
                                        "890312333", 180000, 49);
        persArray[3] = new StaffMember("Olga Olegovna", "Programmer", "ooo@mailbox.com",
                                        "892312333", 50000, 25);
        persArray[4] = new StaffMember("Alexandrov Igor", "Analyst", "Igor@mailbox.com",
                                        "892162333", 45000, 41);

        for (int i = 0; i < persArray.length; i++) {
            if (persArray[i].getAge() > 40) persArray[i].printInfo();
        }

    }
}
