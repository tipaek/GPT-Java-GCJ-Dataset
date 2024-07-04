import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCaseCount = scanner.nextInt();

        for (int testCase = 1; testCase <= testCaseCount; testCase++) {
            int arraySize = scanner.nextInt();
            int divisor = scanner.nextInt();
            long[] numbers = new long[arraySize];
            Map<Long, Integer> frequencyMap = new HashMap<>();

            for (int i = 0; i < arraySize; i++) {
                numbers[i] = scanner.nextLong();
                frequencyMap.merge(numbers[i], 1, Integer::sum);
            }

            int result = calculateResult(divisor, numbers, frequencyMap);
            System.out.printf("Case #%d: %d\n", testCase, result);
        }
    }

    private static int calculateResult(int divisor, long[] numbers, Map<Long, Integer> frequencyMap) {
        if (divisor == 2) {
            return frequencyMap.size() == numbers.length ? 1 : 0;
        } else if (divisor == 3) {
            return calculateForDivisorThree(numbers, frequencyMap);
        }
        return -1; // This case should not occur as per the given problem constraints
    }

    private static int calculateForDivisorThree(long[] numbers, Map<Long, Integer> frequencyMap) {
        boolean foundThreeOfAKind = false;
        boolean foundTwoOfAKind = false;
        boolean foundDouble = false;

        for (Map.Entry<Long, Integer> entry : frequencyMap.entrySet()) {
            long key = entry.getKey();
            int count = entry.getValue();

            if (count == 3) {
                foundThreeOfAKind = true;
            } else if (count == 2) {
                foundTwoOfAKind = containsGreaterElement(numbers, key);
            } else if (frequencyMap.containsKey(key * 2)) {
                foundDouble = true;
            }
        }

        if (foundThreeOfAKind) {
            return 0;
        } else if (foundTwoOfAKind || foundDouble) {
            return 1;
        } else {
            return 2;
        }
    }

    private static boolean containsGreaterElement(long[] numbers, long value) {
        for (long number : numbers) {
            if (number > value) {
                return true;
            }
        }
        return false;
    }
}