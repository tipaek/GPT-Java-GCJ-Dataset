package Package_Practice;
import java.util.Scanner;

public class Solution {
    
    static int countOccurrences(int[] array, int value) {
        int count = 0;
        for (int element : array) {
            if (element == value) {
                count++;
            }
        }
        return count;
    }
    
    static int calculateTrace(int[][] matrix) {
        int trace = 0;
        for (int i = 0; i < matrix.length; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }
    
    static int countDuplicateRows(int[][] matrix) {
        int duplicateRows = 0;
        for (int[] row : matrix) {
            for (int j = 0; j < matrix.length; j++) {
                if (countOccurrences(row, j + 1) > 1) {
                    duplicateRows++;
                    break;
                }
            }
        }
        return duplicateRows;
    }
    
    static int[][] transposeMatrix(int[][] matrix) {
        int size = matrix.length;
        int[][] transposed = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                transposed[i][j] = matrix[j][i];
            }
        }
        return transposed;
    }
    
    static int countDuplicateColumns(int[][] matrix) {
        int duplicateColumns = 0;
        int[][] transposedMatrix = transposeMatrix(matrix);
        for (int[] column : transposedMatrix) {
            for (int j = 0; j < matrix.length; j++) {
                if (countOccurrences(column, j + 1) > 1) {
                    duplicateColumns++;
                    break;
                }
            }
        }
        return duplicateColumns;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for (int t = 0; t < testCases; t++) {
            int size = scanner.nextInt();
            int[][] matrix = new int[size][size];
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }
            System.out.println("Case #" + (t + 1) + ": " + calculateTrace(matrix) + " " + countDuplicateRows(matrix) + " " + countDuplicateColumns(matrix));
        }
        scanner.close();
    }
}