import java.io.IOException;
import java.io.InputStream;
import java.util.InputMismatchException;

public class Solution {
    public static void main(String[] args) {
        try {
            new Solution();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Solution() throws IOException {
        CustomScanner sc = new CustomScanner(System.in);

        int numTasks = sc.nextInt();
        for (int task = 1; task <= numTasks; task++) {
            int k = sc.nextInt();
            int q = sc.nextInt();
            String s = sc.nextString();
            for (int i = 0; i < 3 * k; i++) {
                sc.nextInt();
            }
            int[] start = new int[q];
            int[] end = new int[q];
            for (int i = 0; i < q; i++) {
                start[i] = sc.nextInt() - 1;
            }
            for (int i = 0; i < q; i++) {
                end[i] = sc.nextInt() - 1;
            }
            int[] prefixSums = new int[k];
            int currentSum = 0;
            for (int i = 0; i < k; i++) {
                currentSum += (s.charAt(i) == '(') ? 1 : -1;
                prefixSums[i] = currentSum;
            }
            int total = 0;
            for (int i = 0; i < q; i++) {
                int diff = Math.abs(prefixSums[start[i]] - prefixSums[end[i]]);
                if (start[i] != end[i] && diff == 0) {
                    diff += 2;
                }
                total += diff;
            }

            System.out.println("Case #" + task + ": " + total);
        }

        sc.close();
    }

    static class CustomScanner {
        private InputStream stream;
        private byte[] buffer = new byte[1024];
        private int curChar;
        private int numChars;

        public CustomScanner(InputStream stream) {
            this.stream = stream;
        }

        private int read() throws IOException {
            if (numChars == -1) {
                throw new InputMismatchException();
            }
            if (curChar >= numChars) {
                curChar = 0;
                numChars = stream.read(buffer);
                if (numChars <= 0) {
                    return -1;
                }
            }
            return buffer[curChar++];
        }

        public String nextString() throws IOException {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isSpaceChar(c));
            return res.toString();
        }

        public int nextInt() throws IOException {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            int res = 0;
            do {
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                res = res * 10 + (c - '0');
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        private boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public void close() throws IOException {
            stream.close();
        }
    }
}