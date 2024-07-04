import java.io.*;
import java.util.*;

public class Solution {
    static int[][] mat;
    static int K;
    static PrintWriter out = new PrintWriter(System.out);

    static boolean backtrack(int idx, boolean[][] row, boolean[][] col) {
        int n = mat.length;
        if (idx == n * n) {
            if (isValidSolution(n)) {
                printMatrix(n);
                return true;
            }
            return false;
        }
        int i = idx / n, j = idx % n;
        for (int num = 1; num <= n; num++) {
            if (!row[num][i] && !col[num][j]) {
                mat[i][j] = num;
                row[num][i] = true;
                col[num][j] = true;
                if (backtrack(idx + 1, row, col)) {
                    return true;
                }
                row[num][i] = false;
                col[num][j] = false;
            }
        }
        return false;
    }

    static boolean isValidSolution(int n) {
        for (int i = 0; i < n; i++) {
            if (mat[i][i] != K / n) return false;
        }
        for (int i = 0; i < n; i++) {
            if (!isUnique(mat[i])) return false;
        }
        for (int j = 0; j < n; j++) {
            int[] col = new int[n];
            for (int i = 0; i < n; i++) {
                col[i] = mat[i][j];
            }
            if (!isUnique(col)) return false;
        }
        return true;
    }

    static boolean isUnique(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int num : arr) {
            if (!set.add(num)) return false;
        }
        return true;
    }

    static void printMatrix(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j > 0) out.print(" ");
                out.print(mat[i][j]);
            }
            out.println();
        }
        out.println();
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int TC = sc.nextInt();
        for (int c = 1; c <= TC; c++) {
            int N = sc.nextInt();
            K = sc.nextInt();
            if (K % N != 0) {
                out.printf("Case #%d: IMPOSSIBLE\n", c);
            } else {
                out.printf("Case #%d: POSSIBLE\n", c);
                mat = new int[N][N];
                boolean[][] row = new boolean[N + 1][N + 1];
                boolean[][] col = new boolean[N + 1][N + 1];
                backtrack(0, row, col);
            }
        }
        out.flush();
        out.close();
    }

    static class Scanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String next() throws IOException {
            while (st == null || !st.hasMoreTokens())
                st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }
    }
}