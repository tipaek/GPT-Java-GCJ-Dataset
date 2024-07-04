import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Comparator;
import java.util.InputMismatchException;

public class Solution {
    private static class InputReader {
        private InputStream stream;
        private byte[] buffer = new byte[1024];
        private int currentChar;
        private int numChars;
        private SpaceCharFilter filter;

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

        public int readInt() {
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

        public String readString() {
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

        public double readDouble() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sign = 1;
            if (c == '-') {
                sign = -1;
                c = read();
            }
            double result = 0;
            while (!isSpaceChar(c) && c != '.') {
                if (c == 'e' || c == 'E') {
                    return result * Math.pow(10, readInt());
                }
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                result = result * 10 + (c - '0');
                c = read();
            }
            if (c == '.') {
                c = read();
                double factor = 1;
                while (!isSpaceChar(c)) {
                    if (c == 'e' || c == 'E') {
                        return result * Math.pow(10, readInt());
                    }
                    if (c < '0' || c > '9') {
                        throw new InputMismatchException();
                    }
                    factor /= 10;
                    result += (c - '0') * factor;
                    c = read();
                }
            }
            return result * sign;
        }

        public long readLong() {
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

        private boolean isSpaceChar(int c) {
            if (filter != null) {
                return filter.isSpaceChar(c);
            }
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public String next() {
            return readString();
        }

        public interface SpaceCharFilter {
            boolean isSpaceChar(int ch);
        }
    }

    public static class Interval {
        int start, end, id;
        char owner;

        Interval(int start, int end, int id) {
            this.start = start;
            this.end = end;
            this.id = id;
        }

        @Override
        public String toString() {
            return "(" + start + "," + end + ")";
        }
    }

    public static void main(String[] args) {
        InputReader input = new InputReader(System.in);
        StringBuilder output = new StringBuilder();
        int testCases = input.readInt();
        for (int i = 0; i < testCases; i++) {
            int n = input.readInt();
            Interval[] intervals = new Interval[n];
            StringBuilder answer = new StringBuilder();
            for (int j = 0; j < n; j++) {
                intervals[j] = new Interval(input.readInt(), input.readInt(), j);
                answer.append('A');
            }
            Arrays.sort(intervals, Comparator.comparingInt(o -> o.start));
            int cFreeAt = -1;
            int jFreeAt = -1;
            boolean impossible = false;
            for (Interval interval : intervals) {
                if (cFreeAt <= interval.start) {
                    cFreeAt = interval.end;
                    interval.owner = 'C';
                    answer.setCharAt(interval.id, 'C');
                } else if (jFreeAt <= interval.start) {
                    jFreeAt = interval.end;
                    interval.owner = 'J';
                    answer.setCharAt(interval.id, 'J');
                } else {
                    impossible = true;
                    break;
                }
            }
            if (impossible) {
                answer = new StringBuilder("IMPOSSIBLE");
            }
            output.append("Case #").append(i + 1).append(": ").append(answer).append('\n');
        }
        output.deleteCharAt(output.length() - 1);
        System.out.println(output);
    }
}