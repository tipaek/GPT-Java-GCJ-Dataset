import java.util.HashSet;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        while (testCases-- > 0) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            processMatrix(matrix);
        }
    }

    private static void processMatrix(int[][] matrix) {
        int[] results = new int[3];
        int diagonalSum = 0;

        // Calculate the sum of the main diagonal
        for (int i = 0; i < matrix.length; i++) {
            diagonalSum += matrix[i][i];
        }

        HashSet<Integer> uniqueElements = new HashSet<>();

        // Check rows for duplicates
        int rowDuplicates = 0;
        for (int[] row : matrix) {
            uniqueElements.clear();
            boolean hasDuplicates = false;
            for (int element : row) {
                if (!uniqueElements.add(element)) {
                    hasDuplicates = true;
                }
            }
            if (hasDuplicates) {
                rowDuplicates++;
            }
        }

        // Check columns for duplicates
        int columnDuplicates = 0;
        for (int col = 0; col < matrix.length; col++) {
            uniqueElements.clear();
            boolean hasDuplicates = false;
            for (int row = 0; row < matrix.length; row++) {
                if (!uniqueElements.add(matrix[row][col])) {
                    hasDuplicates = true;
                }
            }
            if (hasDuplicates) {
                columnDuplicates++;
            }
        }

        results[0] = diagonalSum;
        results[1] = rowDuplicates;
        results[2] = columnDuplicates;

        System.out.println(results[0] + " " + results[1] + " " + results[2]);
    }
}