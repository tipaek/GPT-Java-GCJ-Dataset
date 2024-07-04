import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            int quotient = k / n;
            int[][] matrix = new int[n][n];

            if (k % n != 0) {
                System.out.println("Case #" + caseNum + ": IMPOSSIBLE");
                continue;
            }

            for (int row = 0; row < n; row++) {
                int value = 1;
                for (int col = 0; col < n; col++) {
                    if (row == col) {
                        matrix[row][col] = quotient;
                    } else {
                        if (value != quotient) {
                            matrix[row][col] = value;
                            value++;
                        } else {
                            matrix[row][col] = value + 1;
                        }
                    }
                }
            }

            matrix[1][0] = matrix[1][2];
            matrix[1][2] = matrix[0][1];

            System.out.println("Case #" + caseNum + ": POSSIBLE");
            for (int[] row : matrix) {
                for (int elem : row) {
                    System.out.print(elem + " ");
                }
                System.out.println();
            }
        }
    }
}