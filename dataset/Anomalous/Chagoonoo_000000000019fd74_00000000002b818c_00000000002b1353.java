import java.util.Scanner;

public class Solution {
    private static int[][] matrix;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        matrix = createMatrix(500);
        int testCases = scanner.nextInt();

        for (int i = 0; i < testCases; i++) {
            int n = scanner.nextInt();
            System.out.println("Case #" + (i + 1) + ":");
            if (n <= 500) {
                for (int j = 0; j < n; j++) {
                    System.out.println((j + 1) + " " + (j + 1));
                }
            } else if (n <= 1000) {
                processLargeN(n);
            }
        }
    }

    private static void processLargeN(int n) {
        int sum = 1;
        System.out.println("1 1");
        System.out.println("2 1");
        System.out.println("2 2");
        int row = 3;

        while (sum < n) {
            if (sum + matrix[row][row - 2] <= n) {
                sum += matrix[row][row - 2];
                System.out.println((row + 1) + " " + (row - 1));
            } else {
                sum += matrix[row][row - 1];
                System.out.println((row + 1) + " " + row);
            }
            row++;
        }
    }

    private static int[][] createMatrix(int size) {
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
            return newMatrix;
        }
        return matrix;
    }
}