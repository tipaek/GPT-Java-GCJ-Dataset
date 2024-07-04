import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author EDGE
 */
public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        FastReader in = new FastReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskCodeJamA solver = new TaskCodeJamA();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskCodeJamA {
        public void solve(int testNumber, FastReader in, PrintWriter out) {
            int t = in.nextInt();
            int k = 1;
            while (t-- > 0) {
            /*int n = in.nextInt();
            long diag_sum = 0;
            long ans = computeXOR(n);
            long[] mat = new long[n];
            long ans_row = 0;
            long ans_col = 0;
            long temp[] = new long[n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    temp[j] = in.nextLong();

                    if(i==j)diag_sum+=temp[j];
                }

                long te = temp[0];
                for (int j = 01; j < n; j++) {
                    te=te^temp[j];
                }
                if(te!=ans)ans_row++;
                if(i==0)
                {
                    for (int j = 0; j < n; j++) {
                        mat[j]=temp[j];
                    }
                }
                else
                {
                    for (int j = 0; j < n; j++) {
                        mat[j]^=temp[j];
                    }
                }
            }

            for (int i = 0; i < n; i++) {
                if(mat[i]!=ans)
                    ans_col++;
            }
            out.println(ans);*/
                long ans_row = 0, ans_col = 0;
                int n = in.nextInt();
                long[][] mat = in.nextLongMatrix(n, n);
                HashSet<Long> hs = new HashSet<>();
                for (int i = 0; i < n; i++) {

                    for (int j = 0; j < n; j++) {
                        if (hs.contains(mat[i][j])) {
                            ans_row++;
                            break;
                        } else
                            hs.add(mat[i][j]);
                    }
                    hs.clear();
                    for (int j = 0; j < n; j++) {
                        if (hs.contains(mat[j][i])) {
                            ans_col++;
                            break;
                        } else
                            hs.add(mat[j][i]);
                    }
                    hs.clear();
                }
                long diag_sum = 0;
                for (int i = 0; i < n; i++) {
                    diag_sum += mat[i][i];
                }
                out.println("Case #" + k + ": " + diag_sum + " " + ans_row + " " + ans_col);
                out.flush();
                k++;

            }
        }

    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader(InputStream inputStream) {
            br = new BufferedReader(new
                    InputStreamReader(inputStream));
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

