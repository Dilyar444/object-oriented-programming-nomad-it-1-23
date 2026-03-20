import java.util.ArrayList;

public class ArrayTask01 {
    public static void main(String[] args) {
        ArrayList<String> tasks = new ArrayList<String>();
        tasks.add("Купить молоко");
        tasks.add("Помыть машину");
        tasks.add("Выучить Java");
        System.out.println(tasks.size());
        tasks.remove(1);
        tasks.set(0, "Купить безлактозное молоко");
        for (String item: tasks){
            System.out.println(item);
        }

    }
}