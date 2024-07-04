import java.io.*;

public class Solution {

    private int N;
    private int[][] M;
    private int K;

    private boolean[][] colFreq;
    private boolean[][] rowFreq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Solution solution = new Solution();
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; ++t) {
            String[] line = br.readLine().split(" ");
            int N = Integer.parseInt(line[0]);
            solution.K = Integer.parseInt(line[1]);
            solution.N = N;
            solution.M = new int[N][N];

            solution.rowFreq = new boolean[N][N + 1];
            solution.colFreq = new boolean[N][N + 1];

            if (solution.solve(0, 0, 0)) {
                System.out.println("Case #" + t + ": POSSIBLE");
                for (int i = 0; i < N; ++i) {
                    StringBuilder sb = new StringBuilder();
                    for (int j = 0; j < N; ++j) {
                        sb.append(solution.M[i][j]);
                        sb.append(' ');
                    }
                    System.out.println(sb.toString().trim());
                }
            } else {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
            }
        }
    }

    private boolean solve(int currentSum, int i, int j) {
        if (i == j && i == N && currentSum == K) {
            return true;
        } else if (i == j && i == N) {
            return false;
        } else if (currentSum >= K && (i < N || j < N)) {
            return false;
        }

        for (int a = 1; a <= N; ++a) {
            if (!rowFreq[i][a] && !colFreq[j][a]) {
                M[i][j] = a;
                rowFreq[i][a] = true;
                colFreq[j][a] = true;
                if (i == j) {
                    currentSum += a;
                    if (currentSum == K && i == N - 1) {
                        return true;
                    }
                }
                if (j < N - 1) {
                    if (solve(currentSum, i, j + 1)) {
                        return true;
                    }
                } else if (j == N - 1 && i < N - 1) {
                    if (solve(currentSum, i + 1, 0)) {
                        return true;
                    }
                }
                rowFreq[i][a] = false;
                colFreq[j][a] = false;
                if (i == j) {
                    currentSum -= a;
                }
            }
        }

        return false;
    }
}