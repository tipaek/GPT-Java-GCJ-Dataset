import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        FastReader scanner = new FastReader();
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();

            if (k % n == 0) {
                System.out.println("Case #" + t + ": POSSIBLE");
                int diag = k / n;
                int[] arr = new int[n];
                for (int i = 0; i < n; i++) {
                    arr[i] = (diag + i) % n + 1;
                }
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        System.out.print(arr[(j - i + n) % n] + " ");
                    }
                    System.out.println();
                }
            } else if (n % 2 == 0 && k == (n * (n + 1)) / 2) {
                Integer[][] matrix = new Integer[n][n];
                HashSet<Integer>[] rows = new HashSet[n];
                HashSet<Integer>[] cols = new HashSet[n];
                for (int i = 0; i < n; i++) {
                    matrix[i][i] = i + 1;
                    rows[i] = new HashSet<>();
                    cols[i] = new HashSet<>();
                    rows[i].add(i + 1);
                    cols[i].add(i + 1);
                }

                boolean result = fillMatrix(matrix, n, rows, cols, 0, 1);
                if (result) {
                    System.out.println("Case #" + t + ": POSSIBLE");
                    for (int[] row : matrix) {
                        for (int val : row) {
                            System.out.print(val + " ");
                        }
                        System.out.println();
                    }
                } else {
                    System.out.println("Case #" + t + ": IMPOSSIBLE");
                }
            } else {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
            }
        }
    }

    private static boolean fillMatrix(Integer[][] matrix, int n, HashSet<Integer>[] rows, HashSet<Integer>[] cols, int cr, int cc) {
        if (matrix[cr][cc] != null) {
            if (cc < n - 1) {
                cc++;
            } else if (cr < n - 1) {
                cr++;
                cc = 0;
            } else {
                return true;
            }
        }

        for (int i = 1; i <= n; i++) {
            if (rows[cr].contains(i) || cols[cc].contains(i)) {
                continue;
            }
            rows[cr].add(i);
            cols[cc].add(i);
            matrix[cr][cc] = i;

            int nextRow = (cc == n - 1) ? cr + 1 : cr;
            int nextCol = (cc == n - 1) ? 0 : cc + 1;
            if (fillMatrix(matrix, n, rows, cols, nextRow, nextCol)) {
                return true;
            }

            matrix[cr][cc] = null;
            rows[cr].remove(i);
            cols[cc].remove(i);
        }
        return false;
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}