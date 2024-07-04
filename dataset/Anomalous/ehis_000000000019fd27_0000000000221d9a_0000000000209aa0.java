import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int T = input.nextInt();
        for (int ks = 1; ks <= T; ks++) {
            int N = input.nextInt();
            int K = input.nextInt();
            System.out.println(calculateMatrix(N, K, ks));
        }
    }

    static String calculateMatrix(int n, int trace, int iteration) {
        if (trace % n != 0) {
            return "Case #" + iteration + ": IMPOSSIBLE";
        }

        int coef = trace / n;
        int[][] matrix = new int[n][n];
        int[][] resultMatrix = new int[n][n];
        int indexX = 0, indexY = 0;

        for (int line = 0; line < n; line++) {
            for (int col = 0; col < n; col++) {
                int value = (n - line + col) % n + 1;
                matrix[indexX][indexY] = value;
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

        StringBuilder result = new StringBuilder("Case #" + iteration + ": POSSIBLE\n");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result.append(resultMatrix[i][j]);
                if (j < n - 1) {
                    result.append(" ");
                }
            }
            if (i < n - 1) {
                result.append("\n");
            }
        }

        return result.toString();
    }
}