import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder result = new StringBuilder();
            int numberOfCases = Integer.parseInt(reader.readLine().trim());

            for (int caseIndex = 1; caseIndex <= numberOfCases; caseIndex++) {
                int n = Integer.parseInt(reader.readLine().trim());
                int[][] matrix = new int[n][n];

                for (int i = 0; i < n; i++) {
                    String[] row = reader.readLine().trim().split(" ");
                    for (int j = 0; j < n; j++) {
                        matrix[i][j] = Integer.parseInt(row[j]);
                    }
                }

                int trace = calculateTrace(matrix, n);
                int duplicateRows = countDuplicateRows(matrix, n);
                int duplicateColumns = countDuplicateColumns(matrix, n);

                result.append("Case #").append(caseIndex).append(": ")
                      .append(trace).append(" ")
                      .append(duplicateRows).append(" ")
                      .append(duplicateColumns).append("\n");
            }

            System.out.print(result.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int calculateTrace(int[][] matrix, int n) {
        int trace = 0;
        for (int i = 0; i < n; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private static int countDuplicateRows(int[][] matrix, int n) {
        int duplicateRows = 0;
        for (int i = 0; i < n; i++) {
            if (hasDuplicates(matrix[i])) {
                duplicateRows++;
            }
        }
        return duplicateRows;
    }

    private static int countDuplicateColumns(int[][] matrix, int n) {
        int duplicateColumns = 0;
        for (int j = 0; j < n; j++) {
            int[] column = new int[n];
            for (int i = 0; i < n; i++) {
                column[i] = matrix[i][j];
            }
            if (hasDuplicates(column)) {
                duplicateColumns++;
            }
        }
        return duplicateColumns;
    }

    private static boolean hasDuplicates(int[] array) {
        boolean[] seen = new boolean[array.length + 1];
        for (int value : array) {
            if (seen[value]) {
                return true;
            }
            seen[value] = true;
        }
        return false;
    }
}