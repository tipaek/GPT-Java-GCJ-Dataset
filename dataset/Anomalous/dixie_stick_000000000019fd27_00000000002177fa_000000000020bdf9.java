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
            int numQueries = scanner.nextInt();
            Query[] queries = new Query[numQueries];

            for (int i = 0; i < numQueries; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                queries[i] = new Query(start, end, i);
            }

            Arrays.sort(queries);

            int count = 0;
            int lastEndTimeC = -1;
            for (Query query : queries) {
                if (lastEndTimeC <= query.start) {
                    lastEndTimeC = query.end;
                    query.assignedTo = 'C';
                    count++;
                }
            }

            int lastEndTimeJ = -1;
            for (Query query : queries) {
                if (query.assignedTo == '?') {
                    if (lastEndTimeJ <= query.start) {
                        lastEndTimeJ = query.end;
                        query.assignedTo = 'J';
                        count++;
                    }
                }
            }

            result.append("Case #").append(t + 1).append(": ");
            if (count == numQueries) {
                char[] assignment = new char[numQueries];
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
            return Integer.compare(this.end, other.end);
        }

        @Override
        public String toString() {
            return "Query[" + start + ", " + end + ", " + index + "]";
        }
    }

    static class FastScanner {
        private final InputStream stream;
        private final byte[] buffer = new byte[1024];
        private int currentChar;
        private int charsRead;

        public FastScanner(InputStream stream) {
            this.stream = stream;
        }

        int read() {
            if (charsRead == -1) {
                throw new InputMismatchException();
            }
            if (currentChar >= charsRead) {
                currentChar = 0;
                try {
                    charsRead = stream.read(buffer);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (charsRead <= 0) {
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