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

            ArrayList<Pair> firstGroup = new ArrayList<>();
            ArrayList<Pair> secondGroup = new ArrayList<>();
            boolean isValid = true;

            for (Pair pair : pairs) {
                if (firstGroup.isEmpty()) {
                    firstGroup.add(pair);
                } else if (secondGroup.isEmpty()) {
                    secondGroup.add(pair);
                } else {
                    Pair lastInFirst = firstGroup.get(firstGroup.size() - 1);
                    Pair lastInSecond = secondGroup.get(secondGroup.size() - 1);

                    if (pair.intersects(lastInFirst) && pair.intersects(lastInSecond)) {
                        isValid = false;
                        break;
                    }

                    if (pair.intersects(lastInFirst)) {
                        secondGroup.add(pair);
                    } else {
                        firstGroup.add(pair);
                    }
                }
            }

            if (!isValid) {
                resultBuilder.append("Case #").append(t + 1).append(": IMPOSSIBLE\n");
            } else {
                int[] assignment = new int[numPairs];
                for (Pair p : firstGroup) {
                    assignment[p.index] = 'C';
                }
                for (Pair p : secondGroup) {
                    assignment[p.index] = 'J';
                }

                resultBuilder.append("Case #").append(t + 1).append(": ");
                for (int i : assignment) {
                    resultBuilder.append((char) i);
                }
                resultBuilder.append("\n");
            }
        }

        System.out.print(resultBuilder.toString());
    }

    static class Pair implements Comparable<Pair> {
        int start, end, index;

        public Pair(int start, int end, int index) {
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

        public boolean intersects(Pair other) {
            return !(this.end <= other.start || other.end <= this.start);
        }

        @Override
        public String toString() {
            return "(" + start + ", " + end + ")";
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
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isSpaceChar(c));
            return res.toString();
        }

        public String nextLine() {
            int c = read();
            while (isEndline(c)) {
                c = read();
            }
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isEndline(c));
            return res.toString();
        }
    }
}