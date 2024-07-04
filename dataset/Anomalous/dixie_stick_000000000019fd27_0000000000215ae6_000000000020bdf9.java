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

            boolean[] assigned = new boolean[numQueries];
            int count = 0;
            int lastTimeC = -1;
            int lastTimeJ = -1;

            for (int i = 0; i < numQueries; i++) {
                Query query = queries[i];
                if (lastTimeC <= query.start) {
                    assigned[i] = true;
                    query.assignedTo = 'C';
                    lastTimeC = query.end;
                    count++;
                }
            }

            for (int i = 0; i < numQueries; i++) {
                if (!assigned[i]) {
                    Query query = queries[i];
                    if (lastTimeJ <= query.start) {
                        assigned[i] = true;
                        query.assignedTo = 'J';
                        lastTimeJ = query.end;
                        count++;
                    }
                }
            }

            result.append("Case #").append(t + 1).append(": ");
            if (count == numQueries) {
                char[] assignment = new char[numQueries];
                for (int i = 0; i < numQueries; i++) {
                    assignment[queries[i].index] = queries[i].assignedTo;
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
        private InputStream stream;
        private byte[] buffer = new byte[1024];
        private int currentChar;
        private int numChars;

        public FastScanner(InputStream stream) {
            this.stream = stream;
        }

        private int read() {
            if (numChars == -1) throw new InputMismatchException();
            if (currentChar >= numChars) {
                currentChar = 0;
                try {
                    numChars = stream.read(buffer);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0) return -1;
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
            while (isSpaceChar(c)) c = read();
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isSpaceChar(c));
            return res.toString();
        }

        public String nextLine() {
            int c = read();
            while (isEndline(c)) c = read();
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isEndline(c));
            return res.toString();
        }
    }
}