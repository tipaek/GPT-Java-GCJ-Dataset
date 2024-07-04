import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) {

        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int tests = in.nextInt();
        for (int testNumber = 1; testNumber <= tests; ++testNumber) {
            int n = in.nextInt();
            int[][] matrix = new int[n][n];
            int trace = 0;
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n; ++j) {
                    matrix[i][j] = in.nextInt();
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                }
            }
            int repeatedRows = 0;
            for (int i = 0; i < n; ++i) {
                Set<Integer> numbers = new HashSet<>();
                for (int j = 0; j < n; ++j) {
                    numbers.add(matrix[i][j]);
                }
                if (numbers.size() < n) {
                    repeatedRows++;
                }
            }
            int repeatedColumns = 0;
            for (int j = 0; j < n; ++j) {
                Set<Integer> numbers = new HashSet<>();
                for (int i = 0; i < n; ++i) {
                    numbers.add(matrix[i][j]);
                }
                if (numbers.size() < n) {
                    repeatedColumns++;
                }
            }
            out.printf("Case #%d: %d %d %d\n", testNumber, trace, repeatedRows, repeatedColumns);
        }
        out.close();

    }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }
        public long nextLong() {
            return Long.parseLong(next());
        }


    }
}
