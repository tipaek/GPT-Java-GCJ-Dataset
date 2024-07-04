import java.util.*;

public class Solution {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        long testCases = sc.nextLong();
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            processTestCase(caseNumber);
        }
    }

    private static void processTestCase(long caseNumber) {
        long matrixSize = sc.nextLong();
        long diagonalSum = 0, rowDuplicates = 0, columnDuplicates = 0;

        List<Map<Long, Long>> columnDigitCounts = new ArrayList<>();
        for (int i = 0; i < matrixSize; i++) {
            columnDigitCounts.add(new HashMap<>());
        }

        for (int i = 0; i < matrixSize; i++) {
            Map<Long, Long> rowDigitCounts = new HashMap<>();
            for (int j = 0; j < matrixSize; j++) {
                long currentValue = sc.nextLong();
                if (i == j) diagonalSum += currentValue;

                rowDigitCounts.put(currentValue, rowDigitCounts.getOrDefault(currentValue, 0L) + 1);
                columnDigitCounts.get(j).put(currentValue, columnDigitCounts.get(j).getOrDefault(currentValue, 0L) + 1);
            }

            if (hasDuplicates(rowDigitCounts)) {
                rowDuplicates++;
            }
        }

        for (Map<Long, Long> columnDigitCount : columnDigitCounts) {
            if (hasDuplicates(columnDigitCount)) {
                columnDuplicates++;
            }
        }

        System.out.println("Case #" + caseNumber + ": " + diagonalSum + " " + rowDuplicates + " " + columnDuplicates);
    }

    private static boolean hasDuplicates(Map<Long, Long> digitCounts) {
        for (long count : digitCounts.values()) {
            if (count > 1) {
                return true;
            }
        }
        return false;
    }
}