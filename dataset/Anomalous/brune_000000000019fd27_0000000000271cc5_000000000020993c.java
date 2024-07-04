import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCaseCount = Integer.parseInt(reader.readLine());

        for (int testCase = 1; testCase <= testCaseCount; testCase++) {
            int size = Integer.parseInt(reader.readLine());
            int[][] matrix = new int[size][size];

            for (int row = 0; row < size; row++) {
                String[] rowData = reader.readLine().split(" ");
                for (int col = 0; col < size; col++) {
                    matrix[row][col] = Integer.parseInt(rowData[col]);
                }
            }

            int traceValue = calculateTrace(matrix);
            int rowDuplicates = countRowDuplicates(matrix);
            int colDuplicates = countColumnDuplicates(matrix);

            System.out.println("Case #" + testCase + ": " + traceValue + " " + rowDuplicates + " " + colDuplicates);
        }
    }

    private static int calculateTrace(int[][] matrix) {
        int trace = 0;
        for (int i = 0; i < matrix.length; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private static int countRowDuplicates(int[][] matrix) {
        int duplicateCount = 0;
        for (int[] row : matrix) {
            HashSet<Integer> uniqueElements = new HashSet<>();
            for (int value : row) {
                uniqueElements.add(value);
            }
            if (uniqueElements.size() != matrix.length) {
                duplicateCount++;
            }
        }
        return duplicateCount;
    }

    private static int countColumnDuplicates(int[][] matrix) {
        int duplicateCount = 0;
        for (int col = 0; col < matrix.length; col++) {
            HashSet<Integer> uniqueElements = new HashSet<>();
            for (int row = 0; row < matrix.length; row++) {
                uniqueElements.add(matrix[row][col]);
            }
            if (uniqueElements.size() != matrix.length) {
                duplicateCount++;
            }
        }
        return duplicateCount;
    }
}