import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int t = 0; t < T; t++) {
            int N = sc.nextInt();
            int K = sc.nextInt();

            if (K % N == 0) {
                System.out.println("Case #" + (t + 1) + ": POSSIBLE");
                K /= N;
                int[][] matrix = new int[N][N];

                matrix[0][0] = K;
                for (int i = 1; i < K; i++) {
                    matrix[0][i] = i;
                }
                for (int i = K; i < N; i++) {
                    matrix[0][i] = i + 1;
                }

                for (int i = 0; i < N - 1; i++) {
                    for (int j = 0; j < N; j++) {
                        int nextIndex = (j + 1) % N;
                        matrix[i + 1][nextIndex] = matrix[i][j];
                    }
                }

                for (int[] row : matrix) {
                    for (int val : row) {
                        System.out.print(val + " ");
                    }
                    System.out.println();
                }

            } else {
                System.out.println("Case #" + (t + 1) + ": IMPOSSIBLE");
            }
        }
        sc.close();
    }
}