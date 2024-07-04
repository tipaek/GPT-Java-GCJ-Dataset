import java.io.*;
import java.util.*;

public class Solution implements Runnable {

    @Override
    public void run() {
        try (InputReader in = new InputReader(System.in); PrintWriter w = new PrintWriter(System.out)) {
            int t = in.nextInt();
            for (int i = 1; i <= t; i++) {
                int N = in.nextInt();
                int D = in.nextInt();
                long[] arr = new long[N];
                for (int j = 0; j < N; j++) {
                    arr[j] = in.nextLong();
                }
                processCase(N, D, arr, i, w);
            }
        }
    }

    private static void processCase(int N, int D, long[] arr, int t, PrintWriter w) {
        int result = D - 1;
        Map<Long, Integer> frequencyMap = new HashMap<>();
        for (long num : arr) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        if (D == 2) {
            for (int count : frequencyMap.values()) {
                if (count >= 2) {
                    w.println("Case #" + t + ": " + 0);
                    return;
                }
            }
        } else {
            for (int count : frequencyMap.values()) {
                if (count >= 3) {
                    w.println("Case #" + t + ": " + 0);
                    return;
                }
                if (count >= 2 && N >= 3) {
                    w.println("Case #" + t + ": " + 1);
                    return;
                }
            }
            for (int i = 0; i < N; i++) {
                for (int j = i + 1; j < N; j++) {
                    if (arr[i] == arr[j] * 2 || arr[j] == arr[i] * 2) {
                        w.println("Case #" + t + ": " + 1);
                        return;
                    }
                }
            }
        }
        w.println("Case #" + t + ": " + result);
    }

    static class InputReader implements Closeable {
        private final InputStream stream;
        private final byte[] buffer = new byte[1024];
        private int currentChar;
        private int numChars;
        private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        private int read() {
            if (numChars == -1) {
                throw new InputMismatchException();
            }
            if (currentChar >= numChars) {
                currentChar = 0;
                try {
                    numChars = stream.read(buffer);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0) {
                    return -1;
                }
            }
            return buffer[currentChar++];
        }

        public String nextLine() {
            try {
                return reader.readLine();
            } catch (IOException e) {
                throw new UncheckedIOException(e);
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

        @Override
        public void close() throws IOException {
            reader.close();
        }
    }

    public static void main(String[] args) {
        new Thread(null, new Solution(), "Main", 1 << 27).start();
    }
}