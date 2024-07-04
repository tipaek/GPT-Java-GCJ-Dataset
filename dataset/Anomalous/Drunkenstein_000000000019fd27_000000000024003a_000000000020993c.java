import java.io.*;
import java.util.*;

public class Solution {
    private static InputStream inputStream;
    private static PrintWriter out;
    private static InputReader in;
    private static int test;

    private static void solve() throws Exception {
        out.println("0 0 0");
        // The following code is commented out intentionally as per the original code
        /*
        int n = in.nextInt();
        int[][] arrRows = new int[n][n];
        int[][] arrCols = new int[n][n];

        int trace = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int next = in.nextInt() - 1;
                arrRows[i][next]++;
                arrCols[next][j]++;
                if (i == j) {
                    trace += next + 1;
                }
            }
        }

        int distRows = 0;
        int distCols = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arrRows[i][j] != 1) {
                    distRows++;
                    break;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arrCols[j][i] != 1) {
                    distCols++;
                    break;
                }
            }
        }

        out.println(trace + " " + distRows + " " + distCols);
        */
    }

    private static void printCase() {
        out.print("Case #" + test + ": ");
    }

    public static void main(String[] args) {
        try {
            inputStream = System.in;
            out = new PrintWriter(System.out);
            in = new InputReader(inputStream);

            int tests = in.nextInt();
            for (test = 1; test <= tests; test++) {
                printCase();
                solve();
            }
            out.close();
        } catch (Throwable e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    private static class InputReader {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    String str = reader.readLine();
                    if (str == null) {
                        return "";
                    } else {
                        tokenizer = new StringTokenizer(str);
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }
    }
}