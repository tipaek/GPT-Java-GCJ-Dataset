import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) {
        Vestigium solver = new Vestigium();

        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        int t = in.nextInt();
        for (int i = 1; i <= t; i++) {
            solver.solve(i, in, out);
        }
        out.close();
    }

    static class Vestigium {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt();
            int[][] matrix = readMatrix(in, n);
            boolean[][] rowCheck = new boolean[n][n + 1];
            boolean[][] colCheck = new boolean[n][n + 1];
            int trace = 0, rowRepeats = 0, colRepeats = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                    int value = matrix[i][j];
                    if (rowCheck[i][value] && !rowCheck[i][0]) {
                        rowRepeats++;
                        rowCheck[i][0] = true;
                    }
                    if (colCheck[j][value] && !colCheck[j][0]) {
                        colRepeats++;
                        colCheck[j][0] = true;
                    }
                    rowCheck[i][value] = true;
                    colCheck[j][value] = true;
                }
            }

            out.printf("Case #%d: %d %d %d\n", testNumber, trace, rowRepeats, colRepeats);
        }

        private int[][] readMatrix(InputReader in, int n) {
            int[][] matrix = new int[n][n];
            for (int i = 0; i < n; i++) {
                matrix[i] = in.readArray(n);
            }
            return matrix;
        }
    }

    static class InputReader {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
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

        public int[] readArray(int n) {
            int[] array = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = nextInt();
            }
            return array;
        }
    }
}