import java.util.ArrayList;
import java.util.Scanner;

public class ArrayTask02 {
    public static void main(String[] args) {
        ArrayList<Integer> examMarks = new ArrayList<Integer>();
        Scanner s = new Scanner(System.in);
        int n;
        while (s.hasNextInt()) {
            n = s.nextInt();
            if (n < 0) {
                break;
            }
            examMarks.add(n);
        }
        int ma = examMarks.get(0);
        int c = 0;
        for (int num: examMarks){
            if (num > ma) {
                ma = num;
            }
            c+=num;
        }
        System.out.println(c / examMarks.size());
        System.out.println(ma);
    }
}