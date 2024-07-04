import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.InputMismatchException;

public class Solution {

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int testCases = scanner.nextInt();
        StringBuilder resultBuilder = new StringBuilder();
        
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
            int lastC = -1, lastJ = -1;
            
            for (Query query : queries) {
                if (lastC <= query.start) {
                    assigned[query.index] = true;
                    query.assignedTo = 'C';
                    lastC = query.end;
                }
            }
            
            for (Query query : queries) {
                if (!assigned[query.index] && lastJ <= query.start) {
                    assigned[query.index] = true;
                    query.assignedTo = 'J';
                    lastJ = query.end;
                }
            }
            
            boolean isValid = Arrays.stream(queries).allMatch(q -> q.assignedTo != '?');
            resultBuilder.append("Case #").append(t + 1).append(": ");
            
            if (isValid) {
                char[] assignment = new char[numQueries];
                for (Query query : queries) {
                    assignment[query.index] = query.assignedTo;
                }
                resultBuilder.append(assignment);
            } else {
                resultBuilder.append("IMPOSSIBLE");
            }
            resultBuilder.append("\n");
        }
        
        System.out.print(resultBuilder);
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
    }

    static class FastScanner {
        private InputStream stream;
        private byte[] buffer = new byte[1024];
        private int currentChar, numberOfChars;

        public FastScanner(InputStream stream) {
            this.stream = stream;
        }

        int read() {
            if (numberOfChars == -1) {
                throw new InputMismatchException();
            }
            if (currentChar >= numberOfChars) {
                currentChar = 0;
                try {
                    numberOfChars = stream.read(buffer);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numberOfChars <= 0) {
                    return -1;
                }
            }
            return buffer[currentChar++];
        }

        boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
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
    }
}