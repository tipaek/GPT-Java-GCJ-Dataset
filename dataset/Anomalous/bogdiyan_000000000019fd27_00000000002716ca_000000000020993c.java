import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        StringBuilder result = new StringBuilder();

        for (int testCase = 0; testCase < testCases; testCase++) {
            int matrixSize = scanner.nextInt();
            int traceSum = 0, repeatedRows = 0, repeatedCols = 0;

            Map<Integer, Set<Integer>> columnMap = new HashMap<>();
            for (int i = 0; i < matrixSize; i++) {
                Set<Integer> rowNumbers = new HashSet<>();

                for (int j = 0; j < matrixSize; j++) {
                    int number = scanner.nextInt();
                    rowNumbers.add(number);

                    if (i == j) {
                        traceSum += number;
                    }

                    columnMap.computeIfAbsent(j, k -> new HashSet<>()).add(number);
                }

                if (rowNumbers.size() < matrixSize) {
                    repeatedRows++;
                }
            }

            for (int c = 0; c < matrixSize; c++) {
                if (columnMap.get(c).size() < matrixSize) {
                    repeatedCols++;
                }
            }

            result.append("Case #").append(testCase + 1).append(": ")
                  .append(traceSum).append(" ")
                  .append(repeatedRows).append(" ")
                  .append(repeatedCols);

            if (testCase + 1 < testCases) {
                result.append("\n");
            }
        }

        System.out.print(result);
    }
}