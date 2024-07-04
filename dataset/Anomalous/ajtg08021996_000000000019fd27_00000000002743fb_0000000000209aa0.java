import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        for (int t = 1; t <= T; t++) {
            int N = scanner.nextInt();
            int K = scanner.nextInt();

            if (K % N == 0) {
                System.out.println("Case #" + t + ": POSSIBLE");
                K /= N;
                int[][] matrix = new int[N][N];

                matrix[0][0] = K;
                for (int i = 1; i < N; i++) {
                    matrix[0][i] = (K + i) % N == 0 ? N : (K + i) % N;
                }

                for (int i = 1; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        matrix[i][(j + 1) % N] = matrix[i - 1][j];
                    }
                }

                for (int[] row : matrix) {
                    for (int value : row) {
                        System.out.print(value + " ");
                    }
                    System.out.println();
                }

            } else {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
            }
        }
    }
}