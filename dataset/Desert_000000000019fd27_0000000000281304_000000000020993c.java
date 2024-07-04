import java.io.*;
import java.util.*;

public class Solution {

    private String getAns(int[][] arr) {
        int resRows = 0;
        int resCols = 0;
        int diag = 0;

        for (int i = 0; i < arr.length; i++) {
            boolean[] used = new boolean[arr.length + 1];
            for (int j = 0; j < arr.length; j++) {
                final int val = arr[i][j];
                if (!used[val]) {
                    used[val] = true;
                } else {
                    resRows++;
                    break;
                }
            }
        }

        for (int i = 0; i < arr.length; i++) {
            boolean[] used = new boolean[arr.length + 1];
            for (int j = 0; j < arr.length; j++) {
                final int val = arr[j][i];
                if (!used[val]) {
                    used[val] = true;
                } else {
                    resCols++;
                    break;
                }
            }
        }

        for (int i = 0; i < arr.length; i++) {
            diag += arr[i][i];
        }

        return diag + " " + resRows + " " + resCols;
    }

    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;

        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        int testCount = in.nextInt();
        for (int i = 0; i < testCount; i++) {
            int n = in.nextInt();
            int[][] arr = new int[n][n];
            for (int j = 0; j < n; j++) {
                arr[j] = in.nextIntArr(n);
            }

            writeTestCase(out, i + 1, new Solution().getAns(arr));
        }

        out.close();
    }

    static void writeTestCase(PrintWriter writer, int num, Object res) {
        writer.println(String.format("Case #%d: %s", num, res.toString()));
    }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream));
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

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public int[] nextIntArr(int n) {
            int[] arr = new int[n];
            for (int j = 0; j < arr.length; j++) {
                arr[j] = nextInt();
            }

            return arr;
        }

        public long[] nextLongArr(int n) {
            long[] arr = new long[n];
            for (int j = 0; j < arr.length; j++) {
                arr[j] = nextLong();
            }

            return arr;
        }

        public double[] nextDoubleArr(int n) {
            double[] arr = new double[n];
            for (int j = 0; j < arr.length; j++) {
                arr[j] = nextDouble();
            }

            return arr;
        }
    }
}