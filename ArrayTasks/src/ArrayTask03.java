import java.util.*;
import java.util.stream.Collectors;

public class ArrayTask03 {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 10, 20, 50));
        System.out.println(numbers);
        for (int i = numbers.size() - 1;i >= 0; i--) {
            if (numbers.get(i) % 2 != 0){
                numbers.remove(i);
                System.out.println(numbers);
            }
        }
        System.out.println(numbers);
    }
}