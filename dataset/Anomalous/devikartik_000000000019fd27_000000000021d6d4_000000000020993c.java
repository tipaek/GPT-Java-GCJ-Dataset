import java.io.*;
import java.util.Scanner;

public class Solution {

    static int calculateTrace(int[][] matrix, int size) {
        int trace = 0;
        for (int i = 0; i < size; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    static int countDuplicateRows(int[][] matrix, int size) {
        int duplicateRowCount = 0;
        for (int i = 0; i < size; i++) {
            boolean hasDuplicate = false;
            for (int j = 0; j < size - 1; j++) {
                for (int k = j + 1; k < size; k++) {
                    if (matrix[i][j] == matrix[i][k]) {
                        hasDuplicate = true;
                        break;
                    }
                }
                if (hasDuplicate) {
                    duplicateRowCount++;
                    break;
                }
            }
        }
        return duplicateRowCount;
    }

    static int countDuplicateColumns(int[][] matrix, int size) {
        int duplicateColumnCount = 0;
        for (int j = 0; j < size; j++) {
            boolean hasDuplicate = false;
            for (int i = 0; i < size - 1; i++) {
                for (int k = i + 1; k < size; k++) {
                    if (matrix[i][j] == matrix[k][j]) {
                        hasDuplicate = true;
                        break;
                    }
                }
                if (hasDuplicate) {
                    duplicateColumnCount++;
                    break;
                }
            }
        }
        return duplicateColumnCount;
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

            int trace = calculateTrace(matrix, size);
            int duplicateRows = countDuplicateRows(matrix, size);
            int duplicateColumns = countDuplicateColumns(matrix, size);

            System.out.println("Case #" + (t + 1) + ": " + trace + " " + duplicateRows + " " + duplicateColumns);
        }

        scanner.close();
    }
}