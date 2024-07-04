import java.util.Scanner;

public class Solution {
    private static boolean fill(int[][] m, boolean[][] rowSets, boolean[][] colSets, int r, int c) {
        int N = rowSets.length;

        if (r == N) return true;
        if (c == N) return fill(m, rowSets, colSets, r + 1, 0);
        if (r == c) return fill(m, rowSets, colSets, r, c + 1);

        boolean[] rowSet = rowSets[r];
        boolean[] colSet = colSets[c];

        for (int v = 1; v <= N; v += 1) {
            if (rowSet[v]) continue;
            if (colSet[v]) continue;

            rowSet[v] = true;
            colSet[v] = true;

            m[r][c] = v;
            if (fill(m, rowSets, colSets, r, c + 1)) return true;

            rowSet[v] = false;
            colSet[v] = false;
        }

        return false;
    }

    private static boolean findDiagonal(int[][] m, int K, int f, int i) {
        int N = m.length;

        if (K < 0) return false;

        if (i == N) {
            if (K != 0) return false;

            boolean[][] rowSets = new boolean[N][N + 1];
            boolean[][] colSets = new boolean[N][N + 1];

            for (int r = 0; r < N; r += 1) {
                rowSets[r][m[r][r]] = true;
                colSets[r][m[r][r]] = true;
            }

            return fill(m, rowSets, colSets, 0, 0);
        }

        for (int g = f; g <= N; g += 1) {
            m[i][i] = g;
            if (findDiagonal(m, K - g, g, i + 1)) return true;
        }

        return false;
    }

    private static String[] solve(int N, int K) {
        int[][] m = new int[N][N];

        if (!findDiagonal(m, K, 1, 0)) return new String[] {"IMPOSSIBLE"};

        String[] result = new String[N + 1];
        result[0] = "POSSIBLE";

        for (int r = 0; r < N; r += 1) {
            StringBuilder sb = new StringBuilder();

            for (int c = 0; c < N; c += 1) {
                sb.append(m[r][c]);
                if (c < N - 1) sb.append(' ');
            }
            result[r + 1] = sb.toString();
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int T = s.nextInt();

        for (int t = 1; t <= T; t += 1) {
            int N = s.nextInt();
            int K = s.nextInt();

            String[] result = solve(N, K);


            System.out.printf("Case #%d: %s\n", t, result[0]);
            for (int i = 1; i < result.length; i += 1) {
                System.out.println(result[i]);
            }
        }
    }
}
