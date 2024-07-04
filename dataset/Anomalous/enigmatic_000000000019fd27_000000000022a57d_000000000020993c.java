import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.HashSet;

public class Test {
    public static void main(String[] args) {
        new Thread(null, new Runnable() {
            public void run() {
                solve();
            }
        }, "1", 1 << 26).start();
    }

    static void solve() {
        FastReader fr = new FastReader();
        PrintWriter op = new PrintWriter(System.out);

        int t = fr.nextInt();
        for (int cs = 1; cs <= t; ++cs) {
            int n = fr.nextInt();
            int[][] matrix = new int[n][n];

            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n; ++j) {
                    matrix[i][j] = fr.nextInt();
                }
            }

            int trace = 0;
            for (int i = 0; i < n; ++i) {
                trace += matrix[i][i];
            }

            int rowRepeats = 0;
            int colRepeats = 0;

            for (int i = 0; i < n; ++i) {
                HashSet<Integer> rowSet = new HashSet<>();
                for (int j = 0; j < n; ++j) {
                    if (!rowSet.add(matrix[i][j])) {
                        ++rowRepeats;
                        break;
                    }
                }
            }

            for (int i = 0; i < n; ++i) {
                HashSet<Integer> colSet = new HashSet<>();
                for (int j = 0; j < n; ++j) {
                    if (!colSet.add(matrix[j][i])) {
                        ++colRepeats;
                        break;
                    }
                }
            }

            op.println("Case #" + cs + ": " + trace + " " + rowRepeats + " " + colRepeats);
        }

        op.flush();
        op.close();
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

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }
    }
}