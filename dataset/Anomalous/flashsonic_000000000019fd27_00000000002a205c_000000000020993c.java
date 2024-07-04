import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int cases = scanner.nextInt();

        for (int i = 0; i < cases; i++) {
            int N = scanner.nextInt();
            int[][] matrix = new int[N][N];

            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    matrix[j][k] = scanner.nextInt();
                }
            }

            int diagonalSum = 0;
            for (int y = 0; y < N; y++) {
                diagonalSum += matrix[y][y];
            }

            System.out.print("Case #" + (i + 1) + ": " + diagonalSum + " ");

            int rowCount = 0;
            int columnCount = 0;

            for (int j = 0; j < N; j++) {
                boolean[] rowCheck = new boolean[N];
                boolean[] colCheck = new boolean[N];
                boolean rowReset = true;
                boolean colReset = true;

                for (int k = 0; k < N; k++) {
                    rowCheck[matrix[j][k] - 1] = true;
                    colCheck[matrix[k][j] - 1] = true;
                }

                for (int k = 0; k < N; k++) {
                    if (!rowCheck[k] && rowReset) {
                        rowCount++;
                        rowReset = false;
                    }
                    if (!colCheck[k] && colReset) {
                        columnCount++;
                        colReset = false;
                    }
                }
            }

            System.out.println(rowCount + " " + columnCount);
        }
    }
}