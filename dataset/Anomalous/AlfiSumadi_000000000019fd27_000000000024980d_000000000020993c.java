import java.util.*;

public class Solution {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        long t = sc.nextLong();
        for (int caseNumber = 1; caseNumber <= t; caseNumber++) {
            processCase(caseNumber);
        }
    }

    private static void processCase(long caseNumber) {
        long n = sc.nextLong();
        long trace = 0, rowDuplicates = 0, colDuplicates = 0;

        List<Map<Long, Long>> columnDigitCounts = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            columnDigitCounts.add(new HashMap<>());
        }

        for (int i = 0; i < n; i++) {
            Map<Long, Long> rowDigitCounts = new HashMap<>();
            for (int j = 0; j < n; j++) {
                long value = sc.nextLong();
                if (i == j) {
                    trace += value;
                }
                rowDigitCounts.put(value, rowDigitCounts.getOrDefault(value, 0L) + 1);
                Map<Long, Long> colDigitCount = columnDigitCounts.get(j);
                colDigitCount.put(value, colDigitCount.getOrDefault(value, 0L) + 1);
            }
            if (containsDuplicates(rowDigitCounts)) {
                rowDuplicates++;
            }
        }

        for (Map<Long, Long> colDigitCount : columnDigitCounts) {
            if (containsDuplicates(colDigitCount)) {
                colDuplicates++;
            }
        }

        System.out.println("Case #" + caseNumber + ": " + trace + " " + rowDuplicates + " " + colDuplicates);
    }

    private static boolean containsDuplicates(Map<Long, Long> digitCounts) {
        for (long count : digitCounts.values()) {
            if (count > 1) {
                return true;
            }
        }
        return false;
    }
}