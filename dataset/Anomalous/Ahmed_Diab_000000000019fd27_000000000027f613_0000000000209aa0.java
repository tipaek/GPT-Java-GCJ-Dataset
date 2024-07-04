import java.io.*;
import java.util.*;

public class Solution {
    static int[][] mat;
    static int K;
    static StringBuilder sb = new StringBuilder();
    static PrintWriter out = new PrintWriter(System.out);

    static boolean backtrack(int idx, boolean[][] row, boolean[][] col) {
        if (idx == mat.length * mat.length) {
            int n = mat.length;
            int sum = 0;

            for (int i = 0; i < n; i++) {
                sum += mat[i][i];
            }

            boolean can = (sum == K);

            for (int i = 0; i < n; i++) {
                Set<Integer> set = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    set.add(mat[i][j]);
                }
                can &= (set.size() == n);
            }

            for (int i = 0; i < n; i++) {
                Set<Integer> set = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    set.add(mat[j][i]);
                }
                can &= (set.size() == n);
            }

            if (can) {
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        if (j > 0) sb.append(" ");
                        sb.append(mat[i][j]);
                    }
                    sb.append("\n");
                }
                sb.append("\n");
            }
            return can;
        }

        int i = idx / mat.length, j = idx % mat.length;
        boolean can = false;

        for (int num = 1; num <= mat.length && !can; num++) {
            if (!row[num][i] && !col[num][j]) {
                mat[i][j] = num;
                row[num][i] = true;
                col[num][j] = true;
                can = backtrack(idx + 1, row, col);
                row[num][i] = false;
                col[num][j] = false;
            }
        }
        return can;
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner();
        int TC = sc.nextInt();

        for (int c = 1; c <= TC; c++) {
            int N = sc.nextInt();
            K = sc.nextInt();

            mat = new int[N][N];
            boolean[][] row = new boolean[N + 1][N + 1];
            boolean[][] col = new boolean[N + 1][N + 1];
            sb = new StringBuilder();

            boolean can = backtrack(0, row, col);

            if (can) {
                out.printf("Case #%d: POSSIBLE\n", c);
                out.print(sb);
            } else {
                out.printf("Case #%d: IMPOSSIBLE\n", c);
            }
        }

        out.flush();
        out.close();
    }

    static class Scanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String next() throws Exception {
            while (st == null || !st.hasMoreTokens()) {
                st = new StringTokenizer(br.readLine());
            }
            return st.nextToken();
        }

        int nextInt() throws Exception {
            return Integer.parseInt(next());
        }

        long nextLong() throws Exception {
            return Long.parseLong(next());
        }

        double nextDouble() throws Exception {
            return Double.parseDouble(next());
        }
    }
}