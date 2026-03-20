import java.util.Comparator;

public class Main {

    public static void main(String[] args) {
        CustomArrayList arrayList = new CustomArrayList();
        arrayList.add(5);
        arrayList.add(2);
        arrayList.add(8);
        arrayList.add(1);


        System.out.println("Before sort:      " + arrayList);

        arrayList.sort();
        System.out.println("After sort():     " + arrayList);

        arrayList.sort(Comparator.comparingInt(a -> a));
        System.out.println("After sort(desc): " + arrayList);


    }
}