import java.util.*;
import java.io.*;

public class Solution {
    public static class Interval implements Comparable<Interval> {
        int start;
        int end;
        int index;
        char assignedTo;

        public Interval(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
            this.assignedTo = 'A';
        }

        @Override
        public int compareTo(Interval other) {
            return Integer.compare(this.start, other.start);
        }
    }

    public static void main(String[] args) throws IOException {
        FastReader reader = new FastReader(System.in);
        int testCases = reader.nextInt();
        StringBuilder result = new StringBuilder();

        for (int t = 1; t <= testCases; t++) {
            int n = reader.nextInt();
            Interval[] intervals = new Interval[n];

            for (int i = 0; i < n; i++) {
                intervals[i] = new Interval(reader.nextInt(), reader.nextInt(), i);
            }

            Arrays.sort(intervals);
            boolean isPossible = true;
            for (int i = 0; i < n; i++) {
                int cameronCount = 0;
                int jamieCount = 0;
                for (int j = 0; j < i; j++) {
                    if (intervals[j].end > intervals[i].start) {
                        if (intervals[j].assignedTo == 'C') {
                            cameronCount++;
                        } else {
                            jamieCount++;
                        }
                    }
                }
                if (cameronCount != 0 && jamieCount != 0) {
                    isPossible = false;
                    break;
                } else {
                    intervals[i].assignedTo = (cameronCount == 0) ? 'C' : 'J';
                }
            }

            StringBuilder temp = new StringBuilder(n);
            if (!isPossible) {
                temp.append("IMPOSSIBLE");
            } else {
                for (int i = 0; i < n; i++) {
                    temp.append('A');
                }
                for (int i = 0; i < n; i++) {
                    temp.setCharAt(intervals[i].index, intervals[i].assignedTo);
                }
            }
            result.append("Case #").append(t).append(": ").append(temp).append("\n");
        }

        System.out.print(result);
    }
}

class FastReader {
    private InputStream stream;
    private byte[] buffer = new byte[1024];
    private int currentChar;
    private int numChars;

    public FastReader(InputStream stream) {
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

    private int peek() {
        if (numChars == -1) {
            return -1;
        }
        if (currentChar >= numChars) {
            currentChar = 0;
            try {
                numChars = stream.read(buffer);
            } catch (IOException e) {
                return -1;
            }
            if (numChars <= 0) {
                return -1;
            }
        }
        return buffer[currentChar];
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

    private boolean isSpaceChar(int c) {
        return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
    }
}