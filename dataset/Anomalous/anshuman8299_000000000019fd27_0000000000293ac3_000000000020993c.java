import java.util.*;
import java.io.*;

public class Solution {

    private int countDuplicateRows(int[][] matrix, int size) {
        int duplicateCount = 0;

        for (int i = 0; i < size; i++) {
            int[] row = Arrays.copyOf(matrix[i], size);
            Arrays.sort(row);
            for (int j = 1; j < size; j++) {
                if (row[j] == row[j - 1]) {
                    duplicateCount++;
                    break;
                }
            }
        }

        return duplicateCount;
    }

    private int calculateDiagonalSum(int[][] matrix, int size) {
        int sum = 0;

        for (int i = 0; i < size; i++) {
            sum += matrix[i][i];
        }

        return sum;
    }

    private int[][] transposeMatrix(int[][] matrix, int size) {
        int[][] transposed = new int[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                transposed[i][j] = matrix[j][i];
            }
        }

        return transposed;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        Solution solution = new Solution();
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int size = scanner.nextInt();
            int[][] matrix = new int[size][size];

            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            int diagonalSum = solution.calculateDiagonalSum(matrix, size);
            int rowDuplicates = solution.countDuplicateRows(matrix, size);
            int[][] transposedMatrix = solution.transposeMatrix(matrix, size);
            int columnDuplicates = solution.countDuplicateRows(transposedMatrix, size);

            System.out.println("Case #" + t + ": " + diagonalSum + " " + rowDuplicates + " " + columnDuplicates);
        }
    }
}