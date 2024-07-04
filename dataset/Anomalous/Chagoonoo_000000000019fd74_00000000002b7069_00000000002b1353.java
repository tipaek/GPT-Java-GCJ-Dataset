import java.util.Scanner;

public class Solution {
    private static int[][] matrix;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        matrix = generateMatrix(500);
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            System.out.println("Case #" + (i + 1) + ":");

            if (n <= 500) {
                for (int j = 0; j < n; j++) {
                    System.out.println("1 " + (j + 1));
                }
            } else if (n <= 1000) {
                int sum = 1;
                System.out.println("1 1");
                int row = 1;

                while (sum < n) {
                    if (sum + matrix[row][1] <= n) {
                        sum += matrix[row][1];
                        row++;
                        System.out.println((row + 1) + " 2");
                    } else {
                        sum += matrix[row][0];
                        row++;
                        System.out.println((row + 1) + " 1");
                    }
                }
            }
        }
    }

    private static int[][] generateMatrix(int size) {
        if (matrix == null || size > matrix.length) {
            int[][] newMatrix = new int[size][];
            for (int i = 0; i < size; i++) {
                newMatrix[i] = new int[i + 1];
                for (int j = 0; j <= i; j++) {
                    if (j == 0 || j == i) {
                        newMatrix[i][j] = 1;
                    } else {
                        newMatrix[i][j] = newMatrix[i - 1][j - 1] + newMatrix[i - 1][j];
                    }
                }
            }
            matrix = newMatrix;
        }
        return matrix;
    }
}