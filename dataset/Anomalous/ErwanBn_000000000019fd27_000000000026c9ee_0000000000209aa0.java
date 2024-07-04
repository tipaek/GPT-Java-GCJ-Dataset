import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

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

            boolean isPossible = false;
            int attempts = 0;
            int maxAttempts = size * 10;

            while (!isPossible && attempts < maxAttempts) {
                Collections.shuffle(Arrays.asList(matrix));
                if (calculateDiagonalSum(matrix) == targetDiagonalSum) {
                    isPossible = true;
                }
                attempts++;
            }

            if (isPossible) {
                System.out.println("Case #" + (i + 1) + ": POSSIBLE");
                for (int row = 0; row < size; row++) {
                    for (int col = 0; col < size; col++) {
                        System.out.print(matrix[row][col] + " ");
                    }
                    System.out.println();
                }
            } else {
                System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
            }
        }
    }

    private static int calculateDiagonalSum(int[][] matrix) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            sum += matrix[i][i];
        }
        return sum;
    }
}