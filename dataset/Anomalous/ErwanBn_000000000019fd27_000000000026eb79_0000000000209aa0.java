import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        
        int numLines = scanner.nextInt();

        for (int i = 0; i < numLines; i++) {
            int size = scanner.nextInt();
            int targetDiagonalSum = scanner.nextInt();

            int[][] matrix = new int[size][size];

            for (int y = 0; y < size; y++) {
                for (int z = 0; z < size; z++) {
                    matrix[y][z] = (y + z) % size + 1;
                }
            }

            boolean isPossible = getDiagonalSum(matrix) == targetDiagonalSum;
            if (targetDiagonalSum > size * size) isPossible = false;
            int attempts = 0;
            while (!isPossible) {
                Collections.shuffle(Arrays.asList(matrix));
                if (getDiagonalSum(matrix) == targetDiagonalSum) isPossible = true;
                if (attempts > size * size * 2) break;
                attempts++;
            }

            if (isPossible) {
                System.out.println("Case #" + (i + 1) + ": POSSIBLE");
                for (int[] row : matrix) {
                    for (int value : row) {
                        System.out.print(value + " ");
                    }
                    System.out.println();
                }
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
}