import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        Reader in = new Reader();
        PrintWriter out = new PrintWriter(System.out);
        
        int T = in.nextInt();
        for (int t = 1; t <= T; t++) {
            int N = in.nextInt();
            int[][] M = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    M[i][j] = in.nextInt();
                }
            }

            int trace = calculateTrace(M, N);
            int row = countDuplicateRows(M, N);
            int col = countDuplicateColumns(M, N);

            out.printf("Case #%d: %d %d %d%n", t, trace, row, col);
        }
        
        in.close();
        out.close();
    }

    private static int calculateTrace(int[][] M, int N) {
        int trace = 0;
        for (int i = 0; i < N; i++) {
            trace += M[i][i];
        }
        return trace;
    }

    private static int countDuplicateRows(int[][] M, int N) {
        int row = 0;
        for (int i = 0; i < N; i++) {
            Set<Integer> set = new HashSet<>();
            for (int j = 0; j < N; j++) {
                set.add(M[i][j]);
            }
            if (set.size() != N) {
                row++;
            }
        }
        return row;
    }

    private static int countDuplicateColumns(int[][] M, int N) {
        int col = 0;
        for (int j = 0; j < N; j++) {
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < N; i++) {
                set.add(M[i][j]);
            }
            if (set.size() != N) {
                col++;
            }
        }
        return col;
    }

    static class Reader {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        Reader() {
            reader = new BufferedReader(new InputStreamReader(System.in));
            tokenizer = new StringTokenizer("");
        }

        String next() throws IOException {
            while (!tokenizer.hasMoreTokens()) {
                tokenizer = new StringTokenizer(reader.readLine());
            }
            return tokenizer.nextToken();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        String nextLine() throws IOException {
            return reader.readLine();
        }

        void close() throws IOException {
            reader.close();
        }
    }
}