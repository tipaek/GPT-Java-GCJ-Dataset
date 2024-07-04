import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int testCases = Integer.parseInt(scanner.nextLine());

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            String[] input = scanner.nextLine().split(" ");
            int n = Integer.parseInt(input[0]);
            int k = Integer.parseInt(input[1]);

            int diagonalValue = -1;
            for (int i = 1; i <= n; i++) {
                if (i * n == k) {
                    diagonalValue = i;
                    break;
                }
            }

            if (diagonalValue == -1) {
                System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
            } else {
                int[][] matrix = new int[n][n];
                int filler = diagonalValue;

                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        matrix[i][j] = (filler + j) % n + 1;
                    }
                    filler++;
                }

                System.out.println("Case #" + caseNumber + ": POSSIBLE");
                printMatrix(matrix);
            }
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