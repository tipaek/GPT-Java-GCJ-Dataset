import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        OutputWriter out = new OutputWriter(outputStream);
        Solver solver = new Solver();
        solver.solve(in, out);
        out.close();
    }

    static class Solver {
        public void solve(InputReader in, OutputWriter out) {
            int t = in.nextInt();
            for (int i = 1; i <= t; i++) {
                int slices = in.nextInt();
                int diners = in.nextInt();
                int ans = diners - 1;
                Map<Float, Integer> hash = new HashMap<>();
                
                for (int j = 0; j < slices; j++) {
                    float cur = Float.parseFloat(in.next());
                    hash.put(cur, hash.getOrDefault(cur, 0) + 1);
                }
                
                float[][] order = new float[hash.size()][2];
                int index = 0;
                for (Map.Entry<Float, Integer> entry : hash.entrySet()) {
                    order[index][0] = entry.getKey();
                    order[index][1] = entry.getValue();
                    index++;
                }
                
                Arrays.sort(order, (a, b) -> Float.compare(b[1], a[1]));
                
                if (order[0][1] >= diners) {
                    out.printf("Case %d: 0\n", i);
                    continue;
                }
                
                for (float[] entry : order) {
                    float piece = entry[0] / 2;
                    if (hash.containsKey(piece)) {
                        if (entry[1] * 2 + hash.get(piece) >= diners) {
                            float cal = diners - hash.get(piece);
                            ans = Math.min(ans, (int) Math.ceil(cal / 2));
                        }
                    }
                }
                
                out.printf("Case %d: %d\n", i, ans);
            }
        }
    }

    static class InputReader {
        private InputStream stream;
        private byte[] buf = new byte[1 << 16];
        private int curChar;
        private int numChars;

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
                res = res * 10 + c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public String next() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            StringBuilder result = new StringBuilder();
            result.appendCodePoint(c);
            while (!isSpaceChar(c = read())) {
                result.appendCodePoint(c);
            }
            return result.toString();
        }

        private static boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }
    }

    static class OutputWriter {
        private final PrintWriter writer;

        public OutputWriter(OutputStream outputStream) {
            writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
        }

        public void printf(String format, Object... objects) {
            writer.printf(format, objects);
        }

        public void close() {
            writer.close();
        }
    }
}