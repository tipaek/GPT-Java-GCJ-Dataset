import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public Solution() {}

    public static int N, K;

    public static boolean enumerateDiag(int p, int[][] matrix) {
        if (p >= N) {
            int trace = 0;
            for (int i = 0; i < N; i++) {
                trace += matrix[i][i];
            }
            if (trace == K) {
                return enumerateRow(0, 0, matrix);
            }
            return false;
        }

        for (int i = 1; i <= N; i++) {
            matrix[p][p] = i;
            if (enumerateDiag(p + 1, matrix)) return true;
            matrix[p][p] = 0;
        }
        return false;
    }

    public static boolean enumerateRow(int r, int c, int[][] matrix) {
        if (c >= N) {
            return enumerateRow(r + 1, 0, matrix);
        } else if (r >= N) {
            return true;
        }

        if (r == c) {
            return enumerateRow(r, c + 1, matrix);
        }

        boolean[] dups = new boolean[N];
        for (int i = 0; i < N; i++) if (matrix[r][i] > 0) dups[matrix[r][i] - 1] = true;
        for (int i = 0; i < N; i++) if (matrix[i][c] > 0) dups[matrix[i][c] - 1] = true;

        for (int i = 1; i <= N; i++) {
            if (!dups[i - 1]) {
                matrix[r][c] = i;
                if (enumerateRow(r, c + 1, matrix)) return true;
                matrix[r][c] = 0;
            }
        }
        return false;
    }

    public static boolean solve(int t) {
        if (K >= N && K <= N * N) {
            int[][] matrix = new int[N][N];
            if (enumerateDiag(0, matrix)) {
                System.out.println("Case #" + t + ": POSSIBLE");
                for (int[] row : matrix) {
                    for (int cell : row) {
                        System.out.print(cell + " ");
                    }
                    System.out.println();
                }
                return true;
            }
        }
        System.out.println("Case #" + t + ": IMPOSSIBLE");
        return false;
    }

    public static boolean enumerateSimulation(int r, int c, int[][] matrix) {
        if (c >= N) {
            return enumerateSimulation(r + 1, 0, matrix);
        } else if (r >= N) {
            int trace = 0;
            for (int i = 0; i < N; i++) {
                trace += matrix[i][i];
            }
            return trace == K;
        }

        boolean[] dups = new boolean[N];
        for (int i = 0; i < N; i++) if (matrix[r][i] > 0) dups[matrix[r][i] - 1] = true;
        for (int i = 0; i < N; i++) if (matrix[i][c] > 0) dups[matrix[i][c] - 1] = true;

        for (int i = 1; i <= N; i++) {
            if (!dups[i - 1]) {
                matrix[r][c] = i;
                if (enumerateSimulation(r, c + 1, matrix)) return true;
                matrix[r][c] = 0;
            }
        }
        return false;
    }

    public static int DEBUG_TEST_CASE = 0;
    public static boolean SIMULATE_TEST_CASES = false;

    public static Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

    public static void main(String[] args) {
        int tmax;

        if (!SIMULATE_TEST_CASES) {
            tmax = in.nextInt();
            for (int t = 1; t <= tmax; ++t) {
                N = in.nextInt();
                K = in.nextInt();

                if (DEBUG_TEST_CASE <= 0 || t == DEBUG_TEST_CASE) {
                    solve(t);
                }
            }
        } else {
            // Simulating test cases
            tmax = 1;
            for (int t = 1; t <= tmax; ++t) {
                N = 3;
                for (int k = N; k <= N * N; k++) {
                    K = k;
                    System.out.println("k=" + k);
                    int[][] matrix = new int[N][N];
                    if (enumerateSimulation(0, 0, matrix)) {
                        System.out.println("Solve: N=" + N + " K=" + K);
                        for (int[] row : matrix) {
                            for (int cell : row) {
                                System.out.print(cell + " ");
                            }
                            System.out.println();
                        }
                        assert solve(t);
                    }
                }
            }
        }
    }
}