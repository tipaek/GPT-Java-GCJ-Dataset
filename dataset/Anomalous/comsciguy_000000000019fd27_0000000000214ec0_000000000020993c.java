import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());

        for (int t = 0; t < testCases; t++) {
            int n = Integer.parseInt(reader.readLine());
            int[][] matrix = new int[n][n];

            for (int i = 0; i < n; i++) {
                StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = Integer.parseInt(tokenizer.nextToken());
                }
            }

            int traceValue = calculateTrace(matrix);
            int rowDuplicates = countRowDuplicates(matrix);
            int columnDuplicates = countColumnDuplicates(matrix);

            System.out.printf("Case #%d: %d %d %d%n", t + 1, traceValue, rowDuplicates, columnDuplicates);
        }
        reader.close();
    }

    private static int calculateTrace(int[][] matrix) {
        int trace = 0;
        for (int i = 0; i < matrix.length; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private static int countRowDuplicates(int[][] matrix) {
        int duplicateRows = 0;
        for (int[] row : matrix) {
            Set<Integer> uniqueElements = new HashSet<>();
            for (int element : row) {
                uniqueElements.add(element);
            }
            if (uniqueElements.size() != matrix.length) {
                duplicateRows++;
            }
        }
        return duplicateRows;
    }

    private static int countColumnDuplicates(int[][] matrix) {
        int duplicateColumns = 0;
        for (int j = 0; j < matrix.length; j++) {
            Set<Integer> uniqueElements = new HashSet<>();
            for (int[] row : matrix) {
                uniqueElements.add(row[j]);
            }
            if (uniqueElements.size() != matrix.length) {
                duplicateColumns++;
            }
        }
        return duplicateColumns;
    }
}