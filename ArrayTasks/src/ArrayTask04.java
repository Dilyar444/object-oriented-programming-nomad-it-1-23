import java.util.ArrayList;
import java.util.List;

public class ArrayTask04 {
    public static void main(String[] args) {
        ArrayList<String> contactsInPhone = new ArrayList<String>(List.of("Andrew", "Ann"));
        ArrayList<String> contactsInSim = new ArrayList<String>(List.of("Alya", "Ann"));
        System.out.println(contactsInSim);
        System.out.println(contactsInPhone);
        for (String name: contactsInPhone) {
            if (!contactsInSim.contains(name)) {
                contactsInSim.add(name);
            }
        }
        System.out.println(contactsInSim);
    }
}
