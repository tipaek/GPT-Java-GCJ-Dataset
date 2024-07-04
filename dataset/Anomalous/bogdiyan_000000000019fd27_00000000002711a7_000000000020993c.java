import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        StringBuilder result = new StringBuilder();

        for (int testCase = 0; testCase < testCases; testCase++) {
            int matrixSize = scanner.nextInt();
            int traceSum = 0;
            int repeatedRows = 0;
            int repeatedCols = 0;

            int[][] matrix = new int[matrixSize][matrixSize];
            Set<Integer>[] columnSets = new Set[matrixSize];
            for (int i = 0; i < matrixSize; i++) {
                columnSets[i] = new HashSet<>();
            }

            for (int i = 0; i < matrixSize; i++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int j = 0; j < matrixSize; j++) {
                    int value = scanner.nextInt();
                    matrix[i][j] = value;
                    rowSet.add(value);
                    columnSets[j].add(value);
                    if (i == j) {
                        traceSum += value;
                    }
                }
                if (rowSet.size() < matrixSize) {
                    repeatedRows++;
                }
            }

            for (Set<Integer> columnSet : columnSets) {
                if (columnSet.size() < matrixSize) {
                    repeatedCols++;
                }
            }

            result.append("Case #").append(testCase + 1).append(": ")
                  .append(traceSum).append(" ")
                  .append(repeatedRows).append(" ")
                  .append(repeatedCols).append("\n");
        }

        System.out.print(result);
    }
}