import java.util.HashSet;
import java.util.Scanner;

public class Solution {
    public static int countDuplicateColumns(int[][] matrix, int size) {
        int duplicateColumnCount = 0;
        for (int col = 0; col < size; col++) {
            HashSet<Integer> columnValues = new HashSet<>();
            for (int row = 0; row < size; row++) {
                columnValues.add(matrix[row][col]);
            }
            if (columnValues.size() < size) {
                duplicateColumnCount++;
            }
        }
        return duplicateColumnCount;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int size = scanner.nextInt();
            int[][] matrix = new int[size][size];
            int diagonalSum = 0;
            int duplicateRowCount = 0;

            for (int row = 0; row < size; row++) {
                HashSet<Integer> rowValues = new HashSet<>();
                for (int col = 0; col < size; col++) {
                    matrix[row][col] = scanner.nextInt();
                    rowValues.add(matrix[row][col]);
                    if (row == col) {
                        diagonalSum += matrix[row][col];
                    }
                }
                if (rowValues.size() < size) {
                    duplicateRowCount++;
                }
            }

            int duplicateColumnCount = countDuplicateColumns(matrix, size);
            System.out.println("Case #" + testCase + ": " + diagonalSum + " " + duplicateRowCount + " " + duplicateColumnCount);
        }
        scanner.close();
    }
}