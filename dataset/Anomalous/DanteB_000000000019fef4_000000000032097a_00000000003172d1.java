import java.util.*;
import java.io.*;

public class Solution {

    static InputReader in = new InputReader(System.in);
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int testCases = in.nextInt();
        for (int tc = 1; tc <= testCases; ++tc) {
            int n = in.nextInt();
            int d = in.nextInt();
            long[] array = new long[n];
            for (int i = 0; i < n; i++) {
                array[i] = in.nextLong();
            }
            Arrays.sort(array);
            if (d == 2) {
                if (processCaseD2(array, tc)) {
                    continue;
                }
            } else {
                if (processOtherCases(array, tc)) {
                    continue;
                }
            }
        }
        finish();
    }

    private static boolean processCaseD2(long[] array, int tc) {
        long last = -1;
        for (long value : array) {
            if (value == last) {
                out.printf("Case #%d: %d\n", tc, 0);
                return true;
            } else {
                last = value;
            }
        }
        out.printf("Case #%d: %d\n", tc, 1);
        return false;
    }

    private static boolean processOtherCases(long[] array, int tc) {
        long last = -1;
        boolean candidate = false;
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] == last) {
                if (array[i + 1] == last) {
                    out.printf("Case #%d: %d\n", tc, 0);
                    return true;
                } else {
                    candidate = true;
                }
            }
            last = array[i];
        }
        if (candidate) {
            out.printf("Case #%d: %d\n", tc, 1);
            return true;
        }
        for (int i = 0; i < array.length - 1; i++) {
            long twice = 2 * array[i];
            if (Arrays.binarySearch(array, twice) > 0) {
                out.printf("Case #%d: %d\n", tc, 1);
                return true;
            }
        }
        out.printf("Case #%d: %d\n", tc, 2);
        return false;
    }

    public static void finish() {
        out.close();
        in.close();
        System.exit(0);
    }

    static class InputReader implements Iterator<String>, Closeable {
        private BufferedReader reader;
        private StringTokenizer tokenizer;
        private String currentToken;

        public InputReader(InputStream input) {
            reader = new BufferedReader(new InputStreamReader(input));
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
            String result = peekToken();
            currentToken = null;
            return result;
        }

        public String nextLine() {
            peekToken();
            String result = tokenizer == null ? null : tokenizer.nextToken("\n");
            currentToken = null;
            tokenizer = null;
            return result;
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