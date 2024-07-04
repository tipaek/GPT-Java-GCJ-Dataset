import java.util.*;
import java.io.*;

public class Solution {

    static InputReader in = new InputReader(System.in);
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int t = in.nextInt();
        for (int tc = 1; tc <= t; ++tc) {
            int n = in.nextInt();
            int[][] matrix = new int[n][n];
            int trace = 0, rowRepeats = 0, colRepeats = 0;

            for (int i = 0; i < n; i++) {
                boolean[] rowCheck = new boolean[n + 1];
                boolean rowHasRepeat = false;
                for (int j = 0; j < n; j++) {
                    int num = in.nextInt();
                    if (i == j) {
                        trace += num;
                    }
                    if (!rowHasRepeat) {
                        if (rowCheck[num]) {
                            rowHasRepeat = true;
                            rowRepeats++;
                        } else {
                            rowCheck[num] = true;
                        }
                    }
                    matrix[i][j] = num;
                }
            }

            for (int j = 0; j < n; j++) {
                boolean[] colCheck = new boolean[n + 1];
                boolean colHasRepeat = false;
                for (int i = 0; i < n; i++) {
                    int num = matrix[i][j];
                    if (!colHasRepeat) {
                        if (colCheck[num]) {
                            colHasRepeat = true;
                            colRepeats++;
                        } else {
                            colCheck[num] = true;
                        }
                    }
                }
            }

            out.printf("Case #%d: %d %d %d\n", tc, trace, rowRepeats, colRepeats);
        }
        closeResources();
    }

    public static void closeResources() {
        out.close();
        in.close();
        System.exit(0);
    }

    static class InputReader implements Iterator<String>, Closeable {
        private BufferedReader reader;
        private StringTokenizer tokenizer;
        private String currentToken;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream));
        }

        public boolean hasNext() {
            return peekToken() != null;
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public String next() {
            String token = peekToken();
            currentToken = null;
            return token;
        }

        public String nextLine() {
            peekToken();
            String line = tokenizer != null ? tokenizer.nextToken("").trim() : "";
            currentToken = null;
            tokenizer = null;
            return line;
        }

        public void close() {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private String peekToken() {
            if (currentToken == null) {
                try {
                    while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                        String line = reader.readLine();
                        if (line == null) {
                            return null;
                        }
                        tokenizer = new StringTokenizer(line);
                    }
                    currentToken = tokenizer.nextToken();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return currentToken;
        }
    }
}