import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.InputMismatchException;

public class Solution {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int n = scanner.nextInt();
            Interval[] intervals = new Interval[n];
            
            for (int i = 0; i < n; i++) {
                intervals[i] = new Interval(scanner.nextInt(), scanner.nextInt(), i);
            }
            
            Arrays.sort(intervals);
            boolean[] assignment = new boolean[n];
            assignment[intervals[0].id] = true;
            
            ArrayList<Interval> conflictingIntervals = new ArrayList<>();
            int endTime = intervals[0].endTime;
            
            for (int i = 1; i < n; i++) {
                if (intervals[i].startTime >= endTime) {
                    assignment[intervals[i].id] = true;
                    endTime = intervals[i].endTime;
                } else {
                    conflictingIntervals.add(intervals[i]);
                }
            }
            
            boolean impossible = false;
            Collections.sort(conflictingIntervals);
            
            for (int i = 1; i < conflictingIntervals.size(); i++) {
                if (conflictingIntervals.get(i).startTime < conflictingIntervals.get(i - 1).endTime) {
                    impossible = true;
                }
            }
            
            StringBuilder result = new StringBuilder();
            if (impossible) {
                result.append("IMPOSSIBLE");
            } else {
                for (int i = 0; i < n; i++) {
                    result.append(assignment[i] ? "C" : "J");
                }
            }
            
            System.out.printf("Case #%d: %s%n", caseNum, result.toString());
        }
    }

    static class Interval implements Comparable<Interval> {
        int startTime, endTime, id;

        public Interval(int startTime, int endTime, int id) {
            this.startTime = startTime;
            this.endTime = endTime;
            this.id = id;
        }

        @Override
        public int compareTo(Interval other) {
            return this.startTime - other.startTime;
        }

        @Override
        public String toString() {
            return String.format("Interval{startTime=%d, endTime=%d, id=%d}", startTime, endTime, id);
        }
    }

    static class FastScanner {
        private InputStream stream;
        private byte[] buffer = new byte[1024];
        private int currentChar;
        private int numChars;

        public FastScanner(InputStream stream) {
            this.stream = stream;
        }

        int read() {
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

        boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        boolean isEndline(int c) {
            return c == '\n' || c == '\r' || c == -1;
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String next() {
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

        String nextLine() {
            int c = read();
            while (isEndline(c)) {
                c = read();
            }
            StringBuilder result = new StringBuilder();
            do {
                result.appendCodePoint(c);
                c = read();
            } while (!isEndline(c));
            return result.toString();
        }
    }
}