import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());

        for (int testCase = 1; testCase <= testCases; testCase++) {
            String[] input = reader.readLine().trim().split(" ");
            int n = Integer.parseInt(input[0]);

            int[][] matrix = new int[n + 1][n + 1];
            for (int i = 1; i <= n; i++) {
                String[] row = reader.readLine().trim().split(" ");
                for (int j = 1; j <= n; j++) {
                    matrix[i][j] = Integer.parseInt(row[j - 1]);
                }
            }

            processTestCase(testCase, matrix);
        }
        reader.close();
    }

    private static void processTestCase(int testCaseNumber, int[][] matrix) {
        int trace = calculateTrace(matrix);
        int duplicateRows = countDuplicateRows(matrix);
        int duplicateColumns = countDuplicateColumns(matrix);

        System.out.println("Case #" + testCaseNumber + ": " + trace + " " + duplicateRows + " " + duplicateColumns);
    }

    private static int calculateTrace(int[][] matrix) {
        int n = matrix.length;
        int trace = 0;
        for (int i = 1; i < n; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private static int countDuplicateRows(int[][] matrix) {
        int duplicateRows = 0;
        int n = matrix.length;
        for (int i = 1; i < n; i++) {
            Set<Integer> uniqueElements = new HashSet<>();
            for (int j = 1; j < n; j++) {
                uniqueElements.add(matrix[i][j]);
            }
            if (uniqueElements.size() != n - 1) {
                duplicateRows++;
            }
        }
        return duplicateRows;
    }

    private static int countDuplicateColumns(int[][] matrix) {
        int duplicateColumns = 0;
        int n = matrix.length;
        for (int j = 1; j < n; j++) {
            Set<Integer> uniqueElements = new HashSet<>();
            for (int i = 1; i < n; i++) {
                uniqueElements.add(matrix[i][j]);
            }
            if (uniqueElements.size() != n - 1) {
                duplicateColumns++;
            }
        }
        return duplicateColumns;
    }
}