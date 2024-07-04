import java.io.*;
import java.util.*;

public class Solution {
    static int[][] matrix;
    static int targetSum;
    static PrintWriter out = new PrintWriter(System.out);

    static boolean backtrack(int index, boolean[][] rowUsed, boolean[][] colUsed) {
        int n = matrix.length;
        if (index == n * n) {
            int diagonalSum = 0;
            for (int i = 0; i < n; i++) {
                diagonalSum += matrix[i][i];
            }
            boolean isValid = diagonalSum == targetSum;

            for (int i = 0; i < n; i++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    rowSet.add(matrix[i][j]);
                }
                isValid &= rowSet.size() == n;
            }

            for (int i = 0; i < n; i++) {
                Set<Integer> colSet = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    colSet.add(matrix[j][i]);
                }
                isValid &= colSet.size() == n;
            }

            if (isValid) {
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        if (j > 0) {
                            out.print(" ");
                        }
                        out.print(matrix[i][j]);
                    }
                    out.println();
                }
                out.println();
            }
            return isValid;
        }

        int i = index / n, j = index % n;
        boolean canSolve = false;

        for (int num = 1; num <= n && !canSolve; num++) {
            if (!rowUsed[num][i] && !colUsed[num][j]) {
                matrix[i][j] = num;
                rowUsed[num][i] = true;
                colUsed[num][j] = true;

                canSolve = backtrack(index + 1, rowUsed, colUsed);

                rowUsed[num][i] = false;
                colUsed[num][j] = false;
            }
        }
        return canSolve;
    }

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner();
        int testCases = scanner.nextInt();
        for (int c = 1; c <= testCases; c++) {
            int n = scanner.nextInt();
            targetSum = scanner.nextInt();

            if (targetSum % n != 0) {
                out.printf("Case #%d: IMPOSSIBLE\n", c);
            } else {
                out.printf("Case #%d: IMPOSSIBLE\n", c);
                matrix = new int[n][n];
                boolean[][] rowUsed = new boolean[n + 1][n + 1];
                boolean[][] colUsed = new boolean[n + 1][n + 1];

                for (int i = 0; i < n; i++) {
                    matrix[i][i] = targetSum / n;
                    rowUsed[targetSum / n][i] = colUsed[targetSum / n][i] = true;
                }

                backtrack(0, rowUsed, colUsed);
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