import java.util.*;

public class Solution {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        long t = sc.nextLong();
        for (int x = 1; x <= t; x++) {
            processTestCase(x);
        }
    }

    private static void processTestCase(long testCaseNumber) {
        long n = sc.nextLong();
        long diagonalSum = 0, rowRepeats = 0, columnRepeats = 0;

        List<Map<Long, Long>> columnDigitCounts = new ArrayList<>();
        for (int i = 0; i < n; i++) columnDigitCounts.add(new HashMap<>());

        for (int i = 0; i < n; i++) {
            Map<Long, Long> rowDigitCounts = new HashMap<>();
            for (int j = 0; j < n; j++) {
                long currentValue = sc.nextLong();
                if (i == j) diagonalSum += currentValue;

                rowDigitCounts.put(currentValue, rowDigitCounts.getOrDefault(currentValue, 0L) + 1);
                columnDigitCounts.get(j).put(currentValue, columnDigitCounts.get(j).getOrDefault(currentValue, 0L) + 1);
            }
            if (containsDuplicate(rowDigitCounts)) rowRepeats++;
        }

        for (Map<Long, Long> columnDigitCount : columnDigitCounts) {
            if (containsDuplicate(columnDigitCount)) columnRepeats++;
        }

        System.out.println("Case #" + testCaseNumber + ": " + diagonalSum + " " + rowRepeats + " " + columnRepeats);
    }

    private static boolean containsDuplicate(Map<Long, Long> digitCount) {
        for (Long count : digitCount.values()) {
            if (count > 1) {
                return true;
            }
        }
        return false;
    }
}