import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PairSumToTarget {
    public static void main(String[] args) {
        int[] numbers = { 8, 2, 7, 5, 5, 3, 8 };
        int targetSum = 10;

        Arrays.sort(numbers);

        List<List<Integer>> resultPairs = new ArrayList<>();

        int leftPointer = 0;
        int rightPointer = numbers.length - 1;

        while (leftPointer < rightPointer) {
            int currentSum = numbers[leftPointer] + numbers[rightPointer];

            if (currentSum == targetSum) {
                resultPairs.add(Arrays.asList(numbers[leftPointer], numbers[rightPointer]));
                leftPointer++;
                rightPointer--;
            } else if (currentSum < targetSum) {
                leftPointer++;
            } else {
                rightPointer--;
            }
        }

        for (List<Integer> pair : resultPairs) {
            System.out.println("<" + pair.get(0) + " " + pair.get(1) + ">");
        }
    }
}
