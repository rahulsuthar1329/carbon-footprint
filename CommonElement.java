import java.util.*;

public class CommonElement {
    public static void main(String[] args) {
        int[] numbers1 = { 1, 2, 8, -4, 5, 6 };
        int[] numbers2 = { 1, 3, 4, 6, 7, 6 };
        int[] numbers3 = { 3, 6, 4, 5, 6, 7 };

        Map<Integer, Boolean> presentNumbers1 = new HashMap<>();
        Map<Integer, Boolean> presentNumbers2 = new HashMap<>();
        Map<Integer, Boolean> commonNumbers = new HashMap<>();

        for (int i = 0; i < numbers1.length; i++) {
            presentNumbers1.put(numbers1[i], true);
            presentNumbers2.put(numbers2[i], true);
        }

        for (int i = 0; i < numbers1.length; i++) {
            if (presentNumbers1.containsKey(numbers3[i]) && presentNumbers2.containsKey(numbers3[i])) {
                commonNumbers.put(numbers3[i], true);
            }
        }

        for (Map.Entry entry : commonNumbers.entrySet()) {
            System.out.print(entry.getKey() + " ");
        }
    }
}
