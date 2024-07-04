import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.InputMismatchException;

public class Solution {

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int testCases = scanner.nextInt();
        StringBuilder result = new StringBuilder();

        for (int t = 0; t < testCases; t++) {
            int queryCount = scanner.nextInt();
            Query[] queries = new Query[queryCount];

            for (int i = 0; i < queryCount; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                queries[i] = new Query(start, end, i);
            }

            Arrays.sort(queries);

            int assignedCount = 0;
            int lastEndTimeC = -1;
            for (Query query : queries) {
                if (lastEndTimeC <= query.start) {
                    lastEndTimeC = query.end;
                    query.assignedTo = 'C';
                    assignedCount++;
                }
            }

            int lastEndTimeJ = -1;
            for (Query query : queries) {
                if (query.assignedTo == '?') {
                    if (lastEndTimeJ <= query.start) {
                        lastEndTimeJ = query.end;
                        query.assignedTo = 'J';
                        assignedCount++;
                    }
                }
            }

            result.append("Case #").append(t + 1).append(": ");
            if (assignedCount == queryCount) {
                char[] assignment = new char[queryCount];
                for (Query query : queries) {
                    assignment[query.index] = query.assignedTo;
                }
                result.append(assignment);
            } else {
                result.append("IMPOSSIBLE");
            }
            result.append("\n");
        }

        System.out.print(result);
    }

    static class Query implements Comparable<Query> {
        int start, end, index;
        char assignedTo;

        public Query(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
            this.assignedTo = '?';
        }

        @Override
        public int compareTo(Query other) {
            if (this.end != other.end) {
                return this.end - other.end;
            }
            return this.start - other.start;
        }

        @Override
        public String toString() {
            return "Query[start=" + start + ", end=" + end + ", index=" + index + "]";
        }
    }

    static class FastScanner {
        private final InputStream stream;
        private final byte[] buffer = new byte[1024];
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