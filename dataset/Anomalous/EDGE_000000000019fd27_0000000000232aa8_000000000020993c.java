import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        FastReader in = new FastReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Task solver = new Task();
        solver.solve(in, out);
        out.close();
    }

    static class Task {
        public void solve(FastReader in, PrintWriter out) {
            int t = in.nextInt();
            for (int k = 1; k <= t; k++) {
                int n = in.nextInt();
                long[][] mat = in.nextLongMatrix(n, n);
                long ansRow = 0, ansCol = 0;
                HashSet<Long> hs = new HashSet<>();

                // Check for duplicate elements in rows and columns
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        if (hs.contains(mat[i][j])) {
                            ansRow++;
                            break;
                        } else {
                            hs.add(mat[i][j]);
                        }
                    }
                    hs.clear();
                    for (int j = 0; j < n; j++) {
                        if (hs.contains(mat[j][i])) {
                            ansCol++;
                            break;
                        } else {
                            hs.add(mat[j][i]);
                        }
                    }
                    hs.clear();
                }

                // Calculate the sum of the diagonal elements
                long diagSum = 0;
                for (int i = 0; i < n; i++) {
                    diagSum += mat[i][i];
                }

                out.println("Case #" + k + ": " + diagSum + " " + ansRow + " " + ansCol);
                out.flush();
            }
        }
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader(InputStream inputStream) {
            br = new BufferedReader(new InputStreamReader(inputStream));
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

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public long[][] nextLongMatrix(int n, int m) {
            long[][] matrix = new long[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    matrix[i][j] = nextLong();
                }
            }
            return matrix;
        }
    }
}