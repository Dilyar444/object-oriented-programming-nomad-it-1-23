import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class CustomArrayList {

    private int[] arr;

    private int index;
    private int size;

    public CustomArrayList() {
        size = 4;
        arr = new int[size];
        index = 0;

    }

    public void add(Integer value) {
        if (index >= size - 1) {
            arr = getNewArray();
        }
        arr[index] = value;
        index++;
    }

    public void add(int index, int value) {
        if (this.index <= index || index < 0) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }

        arr[index] = value;

    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.stream(arr).takeWhile(x -> x != 0).toArray());
    }

    public Integer get(int index) {
        return arr[index];
    }

    private int[] getNewArray() {
        size *= 2;
        int[] newArr = new int[size * 2];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }
        return newArr;
    }

    // Natural order sort (ascending) — analogous to Comparable.
    // No Comparator needed; the rule is baked in: smaller number comes first.
    public void sort() {
        sort((a, b) -> Integer.compare(a, b));
    }

    // Comparator-based sort — caller decides the ordering rule.
    // Bubble sort: swaps adjacent elements when comparator says they are out of order.
    public void sort(Comparator<Integer> comparator) {
        for (int i = 0; i < index - 1; i++) {
            for (int j = 0; j < index - i - 1; j++) {
                if (comparator.compare(arr[j], arr[j + 1]) > 0) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

}