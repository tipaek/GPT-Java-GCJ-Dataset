import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        FastReader in = new FastReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        CodeJam solver = new CodeJam();
        solver.solve(in, out);
        out.close();
    }

    static class CodeJam {
        public void solve(FastReader sc, PrintWriter out) {
            int T = sc.nextInt();
            for (int t = 1; t <= T; ++t) {
                int n = sc.nextInt();
                int[][] matrix = new int[n][n];
                int trace = 0;

                for (int i = 0; i < n; ++i) {
                    for (int j = 0; j < n; ++j) {
                        matrix[i][j] = sc.nextInt();
                        if (i == j) {
                            trace += matrix[i][j];
                        }
                    }
                }

                int duplicateRows = 0;
                int duplicateCols = 0;

                for (int i = 0; i < n; ++i) {
                    Set<Integer> rowSet = new HashSet<>();
                    for (int j = 0; j < n; ++j) {
                        if (!rowSet.add(matrix[i][j])) {
                            duplicateRows++;
                            break;
                        }
                    }
                }

                for (int j = 0; j < n; ++j) {
                    Set<Integer> colSet = new HashSet<>();
                    for (int i = 0; i < n; ++i) {
                        if (!colSet.add(matrix[i][j])) {
                            duplicateCols++;
                            break;
                        }
                    }
                }

                out.printf("Case #%d: %d %d %d%n", t, trace, duplicateRows, duplicateCols);
            }
        }
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader(InputStream stream) {
            br = new BufferedReader(new InputStreamReader(stream), 32768);
            st = null;
        }

        public String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }
    }
}