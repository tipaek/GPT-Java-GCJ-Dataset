import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // Number of test cases
        int testCases = Integer.parseInt(reader.readLine());

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int matrixSize = Integer.parseInt(reader.readLine());
            int[][] matrix = new int[matrixSize][matrixSize];

            // Reading the matrix
            for (int i = 0; i < matrixSize; i++) {
                StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
                for (int j = 0; j < matrixSize; j++) {
                    matrix[i][j] = Integer.parseInt(tokenizer.nextToken());
                }
            }

            // Calculate trace
            int trace = 0;
            for (int i = 0; i < matrixSize; i++) {
                trace += matrix[i][i];
            }

            // Calculate the number of rows with duplicate values
            int rowDuplicates = 0;
            for (int i = 0; i < matrixSize; i++) {
                if (hasDuplicates(matrix[i])) {
                    rowDuplicates++;
                }
            }

            // Calculate the number of columns with duplicate values
            int columnDuplicates = 0;
            for (int j = 0; j < matrixSize; j++) {
                int[] column = new int[matrixSize];
                for (int i = 0; i < matrixSize; i++) {
                    column[i] = matrix[i][j];
                }
                if (hasDuplicates(column)) {
                    columnDuplicates++;
                }
            }

            // Print the result for the current case
            System.out.printf("Case #%d: %d %d %d%n", caseNumber, trace, rowDuplicates, columnDuplicates);
        }
    }

    private static boolean hasDuplicates(int[] array) {
        Set<Integer> seen = new HashSet<>();
        for (int value : array) {
            if (!seen.add(value)) {
                return true;
            }
        }
        return false;
    }
}