import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        FastScanner sc = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);

        int T = sc.nextInt();
        int testCase = 1;
        while (T-- > 0) {
            int N = sc.nextInt();
            Interval[] intervals = new Interval[N];
            for (int i = 0; i < N; i++) {
                intervals[i] = new Interval(i, sc.nextInt(), sc.nextInt());
            }
            Arrays.sort(intervals);

            Deque<Interval> C = new ArrayDeque<>();
            Deque<Interval> J = new ArrayDeque<>();
            C.add(new Interval(-1, 0, 0));
            J.add(new Interval(-1, 0, 0));

            boolean possible = true;
            for (Interval interval : intervals) {
                if (interval.start >= C.getLast().end) {
                    C.addLast(interval);
                } else if (interval.start >= J.getLast().end) {
                    J.addLast(interval);
                } else {
                    possible = false;
                    break;
                }
            }

            if (possible) {
                char[] result = new char[N];
                C.removeFirst();
                J.removeFirst();
                for (Interval interval : C) {
                    result[interval.index] = 'C';
                }
                for (Interval interval : J) {
                    result[interval.index] = 'J';
                }
                out.printf("Case #%d: %s\n", testCase++, new String(result));
            } else {
                out.printf("Case #%d: IMPOSSIBLE\n", testCase++);
            }
        }
        out.close();
    }

    static class Interval implements Comparable<Interval> {
        int index, start, end;

        public Interval(int index, int start, int end) {
            this.index = index;
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Interval other) {
            if (this.start != other.start) {
                return this.start - other.start;
            }
            return other.end - this.end;
        }
    }

    static class FastScanner {
        private final int BUFFER_SIZE = 1 << 16;
        private final char NULL_CHAR = (char) 0;
        private byte[] buffer = new byte[BUFFER_SIZE];
        private int bufferId = 0, bufferSize = 0;
        private char currentChar = NULL_CHAR;
        private double count = 1;
        private BufferedInputStream in;

        public FastScanner() {
            in = new BufferedInputStream(System.in, BUFFER_SIZE);
        }

        public FastScanner(String fileName) {
            try {
                in = new BufferedInputStream(new FileInputStream(new File(fileName)), BUFFER_SIZE);
            } catch (Exception e) {
                in = new BufferedInputStream(System.in, BUFFER_SIZE);
            }
        }

        private char getChar() {
            while (bufferId == bufferSize) {
                try {
                    bufferSize = in.read(buffer);
                } catch (Exception e) {
                    return NULL_CHAR;
                }
                if (bufferSize == -1) return NULL_CHAR;
                bufferId = 0;
            }
            return (char) buffer[bufferId++];
        }

        public int nextInt() {
            return (int) nextLong();
        }

        public long nextLong() {
            count = 1;
            boolean negative = false;
            if (currentChar == NULL_CHAR) currentChar = getChar();
            while (currentChar < '0' || currentChar > '9') {
                if (currentChar == '-') negative = true;
                currentChar = getChar();
            }
            long result = 0;
            while (currentChar >= '0' && currentChar <= '9') {
                result = (result << 3) + (result << 1) + currentChar - '0';
                count *= 10;
                currentChar = getChar();
            }
            return negative ? -result : result;
        }

        public String next() {
            StringBuilder result = new StringBuilder();
            while (currentChar <= 32) currentChar = getChar();
            while (currentChar > 32) {
                result.append(currentChar);
                currentChar = getChar();
            }
            return result.toString();
        }

        public String nextLine() {
            StringBuilder result = new StringBuilder();
            while (currentChar <= 32) currentChar = getChar();
            while (currentChar != '\n') {
                result.append(currentChar);
                currentChar = getChar();
            }
            return result.toString();
        }

        public boolean hasNext() {
            if (currentChar > 32) return true;
            while (true) {
                currentChar = getChar();
                if (currentChar == NULL_CHAR) return false;
                else if (currentChar > 32) return true;
            }
        }
    }
}