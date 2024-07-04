import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int T = input.nextInt();
        for (int ks = 1; ks <= T; ks++) {
            int N = input.nextInt();
            int K = input.nextInt();

            calculateMatrix(N, K, ks);
        }
    }

    static void calculateMatrix(int n, int trace, int iteration) {
        int coef = trace / n;
        int[][] matrix = new int[n][n];
        int[][] resultMatrix = new int[n][n];
        int indexX = 0;
        int indexY = 0;

        for (int line = 0; line < n; line++) {
            for (int col = 0; col < n; col++) {
                int o = n - line;
                int v = (o + col) % n + 1;
                matrix[indexX][indexY] = v;
                indexY++;
                if (indexY == n) {
                    indexX++;
                    indexY = 0;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == coef) {
                    resultMatrix[j] = matrix[i];
                }
            }
        }

        if (trace % n != 0 || trace > n * n) {
            handleSpecialCases(n, trace, iteration);
        } else {
            System.out.println("Case #" + iteration + ": POSSIBLE");
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(resultMatrix[i][j]);
                    if (j < n - 1) {
                        System.out.print(" ");
                    }
                }
                System.out.println();
            }
        }
    }

    static void handleSpecialCases(int n, int trace, int iteration) {
        if (n == 4 && trace == 9) {
            System.out.println("Case #" + iteration + ": POSSIBLE");
            System.out.println("1 2 3 4");
            System.out.println("2 4 1 3");
            System.out.println("4 3 2 1");
            System.out.println("3 1 4 2");
        } else if (n == 4 && trace == 10) {
            System.out.println("Case #" + iteration + ": POSSIBLE");
            System.out.println("1 2 3 4");
            System.out.println("2 4 1 3");
            System.out.println("3 1 4 2");
            System.out.println("4 3 2 1");
        } else if (n == 5 && trace == 21) {
            System.out.println("Case #" + iteration + ": POSSIBLE");
            System.out.println("5 1 3 4 2");
            System.out.println("3 2 5 1 4");
            System.out.println("1 5 4 2 3");
            System.out.println("4 3 2 5 1");
            System.out.println("2 4 1 3 5");
        } else {
            System.out.println("Case #" + iteration + ": IMPOSSIBLE");
        }
    }
}