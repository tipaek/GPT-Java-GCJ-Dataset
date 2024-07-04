import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;

public class Solution {

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int testCases = scanner.nextInt();
        StringBuilder resultBuilder = new StringBuilder();

        for (int t = 0; t < testCases; t++) {
            int numPairs = scanner.nextInt();
            Pair[] pairs = new Pair[numPairs];

            for (int i = 0; i < numPairs; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                pairs[i] = new Pair(start, end, i);
            }

            Arrays.sort(pairs);
            boolean[] assigned = new boolean[numPairs];
            ArrayList<Pair> firstGroup = new ArrayList<>();
            ArrayList<Pair> secondGroup = new ArrayList<>();
            int lastEndTime = -1;

            for (Pair pair : pairs) {
                if (lastEndTime <= pair.start) {
                    lastEndTime = pair.end;
                    assigned[pair.index] = true;
                    firstGroup.add(pair);
                }
            }

            lastEndTime = -1;
            for (Pair pair : pairs) {
                if (!assigned[pair.index] && lastEndTime <= pair.start) {
                    lastEndTime = pair.end;
                    assigned[pair.index] = true;
                    secondGroup.add(pair);
                }
            }

            if (firstGroup.size() + secondGroup.size() != numPairs) {
                resultBuilder.append("Case #").append(t + 1).append(": IMPOSSIBLE\n");
            } else {
                resultBuilder.append("Case #").append(t + 1).append(": ");
                char[] assignment = new char[numPairs];
                for (Pair pair : firstGroup) {
                    assignment[pair.index] = 'C';
                }
                for (Pair pair : secondGroup) {
                    assignment[pair.index] = 'J';
                }
                resultBuilder.append(assignment).append("\n");
            }
        }

        System.out.print(resultBuilder.toString());
    }

    static class Pair implements Comparable<Pair> {
        int start, end, index;

        Pair(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }

        @Override
        public int compareTo(Pair other) {
            if (this.end != other.end) {
                return this.end - other.end;
            }
            return this.start - other.start;
        }
    }

    static class FastScanner {
        private InputStream stream;
        private byte[] buffer = new byte[1024];
        private int currentChar;
        private int numChars;

        FastScanner(InputStream stream) {
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

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
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

        public String nextLine() {
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