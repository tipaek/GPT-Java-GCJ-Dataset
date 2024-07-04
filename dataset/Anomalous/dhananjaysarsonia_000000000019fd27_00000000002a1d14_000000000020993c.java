import java.util.Scanner;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    private static Scanner scanner = new Scanner(System.in);
    private static int testCaseNumber = 1;

    public static void main(String[] args) {
        int numberOfTestCases = scanner.nextInt();
        scanner.nextLine();

        while (numberOfTestCases-- > 0) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            int diagonalSum = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                    if (i == j) {
                        diagonalSum += matrix[i][j];
                    }
                }
            }

            int rowCount = countDuplicateRows(matrix, n);
            int columnCount = countDuplicateColumns(matrix, n);

            System.out.println("Case #" + (testCaseNumber++) + ": " + diagonalSum + " " + rowCount + " " + columnCount);
        }
    }

    private static int countDuplicateRows(int[][] matrix, int size) {
        int rowCount = 0;
        for (int i = 0; i < size; i++) {
            Set<Integer> uniqueElements = new HashSet<>();
            for (int j = 0; j < size; j++) {
                if (!uniqueElements.add(matrix[i][j])) {
                    rowCount++;
                    break;
                }
            }
        }
        return rowCount;
    }

    private static int countDuplicateColumns(int[][] matrix, int size) {
        int columnCount = 0;
        for (int i = 0; i < size; i++) {
            Set<Integer> uniqueElements = new HashSet<>();
            for (int j = 0; j < size; j++) {
                if (!uniqueElements.add(matrix[j][i])) {
                    columnCount++;
                    break;
                }
            }
        }
        return columnCount;
    }
}