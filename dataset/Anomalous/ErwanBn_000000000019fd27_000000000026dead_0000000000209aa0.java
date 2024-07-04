import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        
        int numberOfLines = scanner.nextInt();

        for (int i = 0; i < numberOfLines; i++) {
            int size = scanner.nextInt();
            int targetDiagonalSum = scanner.nextInt();

            int[][] matrix = new int[size][size];

            // Initialize the matrix with values
            for (int row = 0; row < size; row++) {
                for (int col = 0; col < size; col++) {
                    matrix[row][col] = (col + row) % size + 1;
                }
            }

            boolean isPossible = getDiagonalSum(matrix) == targetDiagonalSum;
            if (targetDiagonalSum > size * size) isPossible = false;
            int attempts = 0;

            while (!isPossible && attempts < size * 100) {
                shuffleMatrix(matrix);
                if (getDiagonalSum(matrix) == targetDiagonalSum) {
                    isPossible = true;
                }
                attempts++;
            }

            if (isPossible) {
                System.out.println("Case #" + (i + 1) + ": POSSIBLE");
                printMatrix(matrix);
            } else {
                System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
            }
        }
    }

    private static int getDiagonalSum(int[][] matrix) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            sum += matrix[i][i];
        }
        return sum;
    }

    private static void shuffleMatrix(int[][] matrix) {
        Random rand = new Random();
        for (int i = matrix.length - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1);
            int[] temp = matrix[i];
            matrix[i] = matrix[j];
            matrix[j] = temp;
        }
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}