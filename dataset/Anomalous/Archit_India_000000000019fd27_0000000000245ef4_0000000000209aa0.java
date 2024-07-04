import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 1; i <= t; i++) {
            int N = sc.nextInt();
            int K = sc.nextInt();
            int[][] M = new int[N][N];

            // Fill the matrix M
            for (int j = 0; j < N; j++) {
                int c = j;
                for (int k = 0; k < N; k++) {
                    M[j][k] = c + 1;
                    c = (c + 1) % N;
                }
            }

            // Calculate the trace of the matrix
            int trace = 0;
            for (int j = 0; j < N; j++) {
                trace += M[j][j];
            }

            String ans = "IMPOSSIBLE";
            outerLoop:
            for (int j = 0; j < N - 1; j++) {
                for (int k = j + 1; k < N; k++) {
                    int tr = trace - M[j][j] - M[k][k] + M[j][k] + M[k][j];
                    if (tr == K) {
                        ans = "POSSIBLE";
                        break outerLoop;
                    }
                }
            }

            System.out.println("Case #" + i + ": " + ans);
        }
    }
}