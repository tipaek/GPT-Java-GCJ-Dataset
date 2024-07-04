import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Task solver = new Task();
        int t = in.nextInt();
        solver.solve(t, in, out);
        out.close();
    }

    static class Task {
        public void solve(int testNumber, InputReader in, PrintWriter out) throws IOException {
            for (int t = 1; t <= testNumber ; t++) {
                int n = in.nextInt();
                int[][] time = new int[n][2];
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < 2; j++) {
                        time[i][j] = in.nextInt();
                    }
                }
                StringBuilder builder = new StringBuilder();
                builder.append("C");
                int cstart = time[0][0];
                int cend = time[0][1];
                int jstart = -1;
                int jend = -1;

                for (int i = 1; i < n; i++) {
                    int startC = time[i][0];
                    int endC = time[i][1];

                    if (startC >= cend || endC <= cstart) {
                        builder.append("C");
                        cstart = startC;
                        cend = endC;
                    }else if (startC >= jend || endC <= jstart || jstart == -1) {
                        builder.append("J");
                        jstart = startC;
                        jend = endC;
                    }
                }
                String ans = builder.toString();
                if (ans.length() != n) {
                    ans = "IMPOSSIBLE";
                }
                out.println("Case #" + t + ": " + ans);
            }
        }
    }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public char nextChar() {
            return next().charAt(0);
        }

        public String nextLine() throws IOException {
            return reader.readLine().trim();
        }
    }
}
