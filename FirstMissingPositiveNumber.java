import java.util.*;

public class FirstMissingPositiveNumber {
    public static void main(String[] args) {
        Map<Integer, Boolean> presentNumbers = new HashMap<>();

        int arraySize;

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Please enter the size of the array: ");
            arraySize = scanner.nextInt();

            int[] numbers = new int[arraySize];

            for (int i = 0; i < arraySize; i++) {
                numbers[i] = scanner.nextInt();
            }

            int positiveNumberCounter = 1;
            for (int i = 0; i < numbers.length; i++) {
                presentNumbers.put(numbers[i], true);
            }

            while (true) {
                if (presentNumbers.containsKey(positiveNumberCounter)) {
                    positiveNumberCounter++;
                } else {
                    break;
                }
            }
            System.out.println(positiveNumberCounter);
        }
    }
}
