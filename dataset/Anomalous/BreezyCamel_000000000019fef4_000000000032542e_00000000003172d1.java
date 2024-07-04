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
            int testCases = in.nextInt();
            for (int i = 1; i <= testCases; i++) {
                int slices = in.nextInt();
                int diners = in.nextInt();
                int result = diners - 1;

                Map<Float, Integer> sliceCount = new HashMap<>();
                for (int j = 0; j < slices; j++) {
                    float sliceSize = Float.parseFloat(in.next());
                    sliceCount.put(sliceSize, sliceCount.getOrDefault(sliceSize, 0) + 1);
                }

                float[][] sortedSlices = new float[sliceCount.size()][2];
                int index = 0;
                for (Map.Entry<Float, Integer> entry : sliceCount.entrySet()) {
                    sortedSlices[index][0] = entry.getKey();
                    sortedSlices[index][1] = entry.getValue();
                    index++;
                }

                Arrays.sort(sortedSlices, (a, b) -> Float.compare(b[1], a[1]));

                if (sortedSlices[0][1] >= diners) {
                    out.printf("Case %d: 0\n", i);
                    continue;
                }

                for (float[] slice : sortedSlices) {
                    float halfSlice = slice[0] / 2;
                    if (sliceCount.containsKey(halfSlice)) {
                        int combinedSlices = (int) (slice[1] * 2 + sliceCount.get(halfSlice));
                        if (combinedSlices >= diners) {
                            float requiredSlices = diners - sliceCount.get(halfSlice);
                            result = Math.min(result, (int) Math.ceil(requiredSlices / 2.0));
                        }
                    }
                }

                out.printf("Case %d: %d\n", i, result);
            }
        }
    }

    static class InputReader {
        private final InputStream stream;
        private final byte[] buffer = new byte[1 << 16];
        private int currentChar;
        private int numChars;

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
                result = result * 10 + c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return result * sign;
        }

        public String next() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            StringBuilder result = new StringBuilder();
            do {
                result.appendCodePoint(c);
                c = read();
            } while (!isSpaceChar(c));
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

        public void printf(String format, Object... args) {
            writer.printf(format, args);
        }

        public void close() {
            writer.close();
        }
    }
}