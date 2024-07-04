import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

    static class InputReader {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

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

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }
    }

    private static final InputReader in = new InputReader(System.in);
    private static final PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int t = in.nextInt();
        for (int q = 1; q <= t; q++) {
            int n = in.nextInt();
            int d = in.nextInt();
            long[] arr = new long[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextLong();
            }
            Arrays.sort(arr);

            if (d == 2) {
                boolean hasDuplicate = false;
                for (int i = 0; i < n - 1; i++) {
                    if (arr[i] == arr[i + 1]) {
                        hasDuplicate = true;
                        break;
                    }
                }
                out.println("Case #" + q + ": " + (hasDuplicate ? 0 : 1));
            } else {
                boolean hasThree = false;
                boolean hasTwo = false;

                for (int i = 0; i < n - 2; i++) {
                    if (arr[i] == arr[i + 1] && arr[i + 1] == arr[i + 2]) {
                        hasThree = true;
                        break;
                    }
                }

                for (int i = 0; i < n - 1; i++) {
                    if (arr[i] == arr[i + 1] || Arrays.binarySearch(arr, 2 * arr[i]) >= 0) {
                        hasTwo = true;
                        break;
                    }
                }

                if (hasThree) {
                    out.println("Case #" + q + ": " + 0);
                } else if (hasTwo) {
                    out.println("Case #" + q + ": " + 1);
                } else {
                    out.println("Case #" + q + ": " + 2);
                }
            }
        }
        out.close();
    }
}