import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class CJ1 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCaseCount = Integer.parseInt(reader.readLine());

        for (int testCase = 1; testCase <= testCaseCount; testCase++) {
            int matrixSize = Integer.parseInt(reader.readLine().trim().split(" ")[0]);
            int[][] matrix = new int[matrixSize + 1][matrixSize + 1];

            for (int i = 1; i <= matrixSize; i++) {
                String[] rowValues = reader.readLine().trim().split(" ");
                for (int j = 1; j <= matrixSize; j++) {
                    matrix[i][j] = Integer.parseInt(rowValues[j - 1]);
                }
            }

            printResults(testCase, matrix);
        }
    }

    private static void printResults(int testCaseNumber, int[][] matrix) {
        System.out.println("Case #" + testCaseNumber + ": " + calculateTrace(matrix) + " " + countDuplicateRows(matrix) + " " + countDuplicateColumns(matrix));
    }

    private static int calculateTrace(int[][] matrix) {
        int trace = 0;
        for (int i = 1; i < matrix.length; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private static int countDuplicateRows(int[][] matrix) {
        int duplicateRowCount = 0;
        for (int i = 1; i < matrix.length; i++) {
            Set<Integer> uniqueElements = new HashSet<>();
            for (int j = 1; j < matrix.length; j++) {
                uniqueElements.add(matrix[i][j]);
            }
            if (uniqueElements.size() != matrix.length - 1) {
                duplicateRowCount++;
            }
        }
        return duplicateRowCount;
    }

    private static int countDuplicateColumns(int[][] matrix) {
        int duplicateColumnCount = 0;
        for (int j = 1; j < matrix.length; j++) {
            Set<Integer> uniqueElements = new HashSet<>();
            for (int i = 1; i < matrix.length; i++) {
                uniqueElements.add(matrix[i][j]);
            }
            if (uniqueElements.size() != matrix.length - 1) {
                duplicateColumnCount++;
            }
        }
        return duplicateColumnCount;
    }
}