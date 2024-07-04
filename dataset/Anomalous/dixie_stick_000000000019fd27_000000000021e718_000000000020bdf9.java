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
                pairs[i] = new Pair(scanner.nextInt(), scanner.nextInt(), i);
            }

            Arrays.sort(pairs);

            ArrayList<Pair> firstList = new ArrayList<>();
            ArrayList<Pair> secondList = new ArrayList<>();
            boolean isValid = true;

            for (Pair currentPair : pairs) {
                if (firstList.isEmpty()) {
                    firstList.add(currentPair);
                } else if (secondList.isEmpty()) {
                    secondList.add(currentPair);
                } else {
                    Pair lastFirst = firstList.get(firstList.size() - 1);
                    Pair lastSecond = secondList.get(secondList.size() - 1);

                    if (currentPair.intersects(lastFirst) && currentPair.intersects(lastSecond)) {
                        isValid = false;
                        break;
                    }

                    if (currentPair.intersects(lastFirst)) {
                        secondList.add(currentPair);
                    } else {
                        firstList.add(currentPair);
                    }
                }
            }

            if (!isValid) {
                resultBuilder.append("Case #").append(t + 1).append(": IMPOSSIBLE\n");
            } else {
                int[] assignments = new int[numPairs];
                for (Pair p : firstList) {
                    assignments[p.index] = 'C';
                }
                for (Pair p : secondList) {
                    assignments[p.index] = 'J';
                }

                resultBuilder.append("Case #").append(t + 1).append(": ");
                for (int i : assignments) {
                    resultBuilder.append((char) i);
                }
                resultBuilder.append("\n");
            }
        }

        System.out.print(resultBuilder.toString());
    }

    public static class Pair implements Comparable<Pair> {
        int start, end, index;

        public Pair(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }

        @Override
        public int compareTo(Pair other) {
            if (this.start != other.start) {
                return this.start - other.start;
            }
            return this.end - other.end;
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

        private boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        private boolean isEndline(int c) {
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