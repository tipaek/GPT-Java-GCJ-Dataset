import java.util.*;

public class Solution {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int testCases = scanner.nextInt();
        for (int i = 1; i <= testCases; i++) {
            System.out.print("Case #" + i + ": ");
            processTestCase();
        }
    }

    private static void processTestCase() {
        int n = scanner.nextInt();
        int d = scanner.nextInt();
        long[] array = new long[n];
        Map<Long, Long> frequencyMap = new HashMap<>();
        long maxFrequency = 1;

        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextLong();
            frequencyMap.put(array[i], frequencyMap.getOrDefault(array[i], 0L) + 1);
            maxFrequency = Math.max(maxFrequency, frequencyMap.get(array[i]));
        }

        if (maxFrequency >= d) {
            System.out.println("0\n");
        } else if (d == 2 || maxFrequency == 2) {
            System.out.println("1\n");
        } else {
            if (hasRequiredPair(array)) {
                System.out.println("1\n");
            } else {
                System.out.println("2\n");
            }
        }
    }

    private static boolean hasRequiredPair(long[] array) {
        Set<Long> set = new HashSet<>();
        for (long value : array) {
            if (set.contains(value * 2) || (value % 2 == 0 && set.contains(value / 2))) {
                return true;
            }
            set.add(value);
        }
        return false;
    }
}