import java.io.*;
import java.util.*;

public class Solution implements Runnable {

    @Override
    public void run() {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int testCases = in.nextInt();
        
        for (int i = 1; i <= testCases; i++) {
            int N = in.nextInt();
            int D = in.nextInt();
            long[] arr = new long[N];
            for (int j = 0; j < N; j++) {
                arr[j] = in.nextLong();
            }
            processCase(N, D, arr, i, out);
        }
        out.flush();
        out.close();
    }

    private static void processCase(int N, int D, long[] arr, int caseNumber, PrintWriter out) {
        int result = D - 1;
        Map<Long, Integer> frequencyMap = new HashMap<>();
        for (long num : arr) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        if (D == 2) {
            for (int count : frequencyMap.values()) {
                if (count >= 2) {
                    out.println("Case #" + caseNumber + ": " + 0);
                    return;
                }
            }
        } else {
            for (Map.Entry<Long, Integer> entry : frequencyMap.entrySet()) {
                long key = entry.getKey();
                int count = entry.getValue();
                if (count >= 3) {
                    out.println("Case #" + caseNumber + ": " + 0);
                    return;
                }
                if (count >= 2) {
                    for (long num : arr) {
                        if (num > key) {
                            out.println("Case #" + caseNumber + ": " + 1);
                            return;
                        }
                    }
                }
            }

            for (int i = 0; i < arr.length; i++) {
                for (int j = i + 1; j < arr.length; j++) {
                    if (arr[i] == 2 * arr[j] || arr[j] == 2 * arr[i]) {
                        out.println("Case #" + caseNumber + ": " + 1);
                        return;
                    }
                }
            }
        }

        out.println("Case #" + caseNumber + ": " + result);
    }

    static class InputReader {
        private final InputStream stream;
        private final byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        private int read() {
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
                return reader.readLine();
            } catch (IOException e) {
                throw new InputMismatchException();
            }
        }

        public int nextInt() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sign = 1;
            if (c == '-') {
                sign = -1;
                c = read();
            }
            int result = 0;
            do {
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                result = result * 10 + (c - '0');
                c = read();
            } while (!isSpaceChar(c));
            return result * sign;
        }

        public long nextLong() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sign = 1;
            if (c == '-') {
                sign = -1;
                c = read();
            }
            long result = 0;
            do {
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                result = result * 10 + (c - '0');
                c = read();
            } while (!isSpaceChar(c));
            return result * sign;
        }

        public boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }
    }

    public static void main(String[] args) {
        new Thread(null, new Solution(), "Main", 1 << 27).start();
    }
}