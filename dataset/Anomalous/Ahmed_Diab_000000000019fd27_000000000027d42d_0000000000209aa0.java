import java.io.*;
import java.util.*;

public class Solution {
    static int[][] matrix;
    static int K;
    static PrintWriter out = new PrintWriter(System.out);

    static boolean backtrack(int idx, boolean[][] row, boolean[][] col) {
        int n = matrix.length;
        if (idx == n * n) {
            int sum = 0;
            for (int i = 0; i < n; i++)
                sum += matrix[i][i];
            boolean isValid = sum == K;

            for (int i = 0; i < n && isValid; i++) {
                Set<Integer> set = new HashSet<>();
                for (int j = 0; j < n; j++)
                    set.add(matrix[i][j]);
                isValid &= set.size() == n;
            }

            for (int j = 0; j < n && isValid; j++) {
                Set<Integer> set = new HashSet<>();
                for (int i = 0; i < n; i++)
                    set.add(matrix[i][j]);
                isValid &= set.size() == n;
            }

            if (isValid) {
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        if (j > 0) out.print(" ");
                        out.print(matrix[i][j]);
                    }
                    out.println();
                }
                out.println();
            }
            return isValid;
        }

        int i = idx / n, j = idx % n;
        for (int num = 1; num <= n; num++) {
            if (!row[num][i] && !col[num][j]) {
                matrix[i][j] = num;
                row[num][i] = true;
                col[num][j] = true;
                if (backtrack(idx + 1, row, col)) return true;
                row[num][i] = false;
                col[num][j] = false;
            }
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner();
        int testCaseCount = sc.nextInt();
        for (int c = 1; c <= testCaseCount; c++) {
            int N = sc.nextInt();
            K = sc.nextInt();

            if (K % N != 0) {
                out.printf("Case #%d: IMPOSSIBLE\n", c);
            } else {
                out.printf("Case #%d: POSSIBLE\n", c);
                matrix = new int[N][N];
                for (int i = 0; i < N; i++)
                    matrix[i][i] = K / N;
                backtrack(0, new boolean[N + 1][N + 1], new boolean[N + 1][N + 1]);
            }
        }
        out.flush();
        out.close();
    }

    static class Scanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String next() throws Exception {
            while (st == null || !st.hasMoreTokens())
                st = new StringTokenizer(br.readLine());
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