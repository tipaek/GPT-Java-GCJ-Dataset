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

            int trace = 0, rowRepeat = 0, colRepeat = 0;
            HashSet<Integer> hs = new HashSet<>();

            // Calculate trace
            for (int i = 0; i < n; ++i) {
                trace += matrix[i][i];
            }

            // Check for row repetitions
            for (int i = 0; i < n; ++i) {
                hs.clear();
                for (int j = 0; j < n; ++j) {
                    if (hs.contains(matrix[i][j])) {
                        rowRepeat++;
                        break;
                    }
                    hs.add(matrix[i][j]);
                }
            }

            // Check for column repetitions
            for (int i = 0; i < n; ++i) {
                hs.clear();
                for (int j = 0; j < n; ++j) {
                    if (hs.contains(matrix[j][i])) {
                        colRepeat++;
                        break;
                    }
                    hs.add(matrix[j][i]);
                }
            }

            op.println("Case #" + cs + ": " + trace + " " + rowRepeat + " " + colRepeat);
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