import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCaseCount = scanner.nextInt();

        for (int testCase = 1; testCase <= testCaseCount; testCase++) {
            int n = scanner.nextInt();
            int d = scanner.nextInt();
            long[] numbers = new long[n];
            Map<Long, Integer> frequencyMap = new HashMap<>();

            for (int i = 0; i < n; i++) {
                numbers[i] = scanner.nextLong();
                frequencyMap.merge(numbers[i], 1, Integer::sum);
            }

            int result = calculateResult(d, n, numbers, frequencyMap);
            System.out.printf("Case #%d: %d\n", testCase, result);
        }
    }

    private static int calculateResult(int d, int n, long[] numbers, Map<Long, Integer> frequencyMap) {
        if (d == 2) {
            return (frequencyMap.size() == n) ? 1 : 0;
        } else if (d == 3) {
            return calculateResultForD3(n, numbers, frequencyMap);
        }
        return -1; // Default case, should not reach here based on problem constraints
    }

    private static int calculateResultForD3(int n, long[] numbers, Map<Long, Integer> frequencyMap) {
        int result = 2;

        for (Map.Entry<Long, Integer> entry : frequencyMap.entrySet()) {
            long key = entry.getKey();
            int count = entry.getValue();

            if (count == 3) {
                return 0;
            } else if (count == 2) {
                if (hasGreaterFrequency(n, numbers, count)) {
                    return 1;
                }
            } else if (frequencyMap.containsKey(key * 2)) {
                return 1;
            }
        }

        return result;
    }

    private static boolean hasGreaterFrequency(int n, long[] numbers, int count) {
        for (int i = 0; i < n; i++) {
            if (numbers[i] > count) {
                return true;
            }
        }
        return false;
    }
}