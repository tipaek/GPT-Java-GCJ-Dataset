import java.io.*;
import java.util.*;

public class Solution2 implements Runnable {

    @Override
    public void run() {
        InputReader in = new InputReader(System.in);
        PrintWriter w = new PrintWriter(System.out);
        int t = (int) in.nextLong();
        for (int i = 1; i <= t; i++) {
            int N = (int) in.nextLong();
            int D = (int) in.nextLong();
            long[] arr = new long[N];
            for (int j = 0; j < N; j++) {
                arr[j] = in.nextLong();
            }
            processTestCase(N, D, arr, i, w);
        }
        w.flush();
        w.close();
    }

    private static void processTestCase(int N, int D, long[] arr, int t, PrintWriter w) {
        int result = D - 1;
        Map<Long, Integer> frequencyMap = new HashMap<>();
        for (long num : arr) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        if (D == 2) {
            if (N == 1) {
                w.println("Case #" + t + ": " + 1);
                return;
            }
            for (int count : frequencyMap.values()) {
                if (count >= 2) {
                    w.println("Case #" + t + ": " + 0);
                    return;
                }
            }
        } else {
            if (N == 1) {
                w.println("Case #" + t + ": " + 2);
                return;
            }
            for (int count : frequencyMap.values()) {
                if (count >= 3) {
                    w.println("Case #" + t + ": " + 0);
                    return;
                }
            }
            for (int i = 0; i < arr.length; i++) {
                for (int j = i + 1; j < arr.length; j++) {
                    if (arr[i] == arr[j] * 2 || arr[j] == arr[i] * 2) {
                        w.println("Case #" + t + ": " + 1);
                        return;
                    }
                }
            }
        }
        w.println("Case #" + t + ": " + result);
    }

    static class InputReader {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private SpaceCharFilter filter;
        private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public int read() {
            if (numChars == -1) {
                throw new InputMismatchException();
            }
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0) {
                    return -1;
                }
            }
            return buf[curChar++];
        }

        public String nextLine() {
            try {
                return br.readLine();
            } catch (IOException e) {
                throw new InputMismatchException();
            }
        }

        public int nextInt() {
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

        public long nextLong() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            long res = 0;
            do {
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                res = res * 10 + (c - '0');
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public boolean isSpaceChar(int c) {
            return filter != null ? filter.isSpaceChar(c) : c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public interface SpaceCharFilter {
            boolean isSpaceChar(int ch);
        }
    }

    public static void main(String[] args) throws Exception {
        new Thread(null, new Solution2(), "Main", 1 << 27).start();
    }
}