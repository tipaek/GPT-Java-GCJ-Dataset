import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];

            for (int row = 0; row < matrixSize; row++) {
                for (int col = 0; col < matrixSize; col++) {
                    matrix[row][col] = scanner.nextInt();
                }
            }

            System.out.println("Case #" + testCase + ": " +
                calculateTrace(matrix, matrixSize) + " " +
                countDuplicateRows(matrix, matrixSize) + " " +
                countDuplicateCols(matrix, matrixSize));
        }
    }

    private static long calculateTrace(int[][] matrix, int size) {
        long trace = 0;
        for (int i = 0; i < size; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private static int countDuplicateRows(int[][] matrix, int size) {
        int duplicateRowCount = 0;
        for (int row = 0; row < size; row++) {
            Set<Integer> uniqueElements = new HashSet<>();
            for (int col = 0; col < size; col++) {
                if (!uniqueElements.add(matrix[row][col])) {
                    duplicateRowCount++;
                    break;
                }
            }
        }
        return duplicateRowCount;
    }

    private static int countDuplicateCols(int[][] matrix, int size) {
        int duplicateColCount = 0;
        for (int col = 0; col < size; col++) {
            Set<Integer> uniqueElements = new HashSet<>();
            for (int row = 0; row < size; row++) {
                if (!uniqueElements.add(matrix[row][col])) {
                    duplicateColCount++;
                    break;
                }
            }
        }
        return duplicateColCount;
    }
}