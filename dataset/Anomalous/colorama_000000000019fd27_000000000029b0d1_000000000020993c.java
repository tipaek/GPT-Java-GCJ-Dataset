import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine().trim());

        for (int t = 1; t <= testCases; t++) {
            int matrixSize = Integer.parseInt(reader.readLine().trim());
            int[][] matrix = new int[matrixSize][matrixSize];

            for (int i = 0; i < matrixSize; i++) {
                String[] rowValues = reader.readLine().trim().split("\\s+");
                for (int j = 0; j < matrixSize; j++) {
                    matrix[i][j] = Integer.parseInt(rowValues[j]);
                }
            }

            int traceValue = calculateTrace(matrixSize, matrix);
            int rowDuplicates = countRowDuplicates(matrixSize, matrix);
            int colDuplicates = countColumnDuplicates(matrixSize, matrix);

            System.out.println("Case #" + t + ": " + traceValue + " " + rowDuplicates + " " + colDuplicates);
        }
    }

    private static int calculateTrace(int size, int[][] matrix) {
        int trace = 0;
        for (int i = 0; i < size; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private static int countRowDuplicates(int size, int[][] matrix) {
        int duplicateRows = 0;
        for (int i = 0; i < size; i++) {
            Set<Integer> uniqueElements = new HashSet<>();
            for (int j = 0; j < size; j++) {
                if (!uniqueElements.add(matrix[i][j])) {
                    duplicateRows++;
                    break;
                }
            }
        }
        return duplicateRows;
    }

    private static int countColumnDuplicates(int size, int[][] matrix) {
        int duplicateColumns = 0;
        for (int i = 0; i < size; i++) {
            Set<Integer> uniqueElements = new HashSet<>();
            for (int j = 0; j < size; j++) {
                if (!uniqueElements.add(matrix[j][i])) {
                    duplicateColumns++;
                    break;
                }
            }
        }
        return duplicateColumns;
    }
}