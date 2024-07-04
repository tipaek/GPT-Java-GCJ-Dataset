import java.io.*;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        FastReader in = new FastReader(inputStream);
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));

        new Solver().solve(in, out);
        out.close();
    }

    static class Solver {

        public void solve(FastReader in, PrintWriter out) {
            int T = in.nextInt();
            for (int caseNum = 1; caseNum <= T; caseNum++) {
                String s = in.next();
                StringBuilder result = new StringBuilder();
                int depth = 0;

                for (char ch : s.toCharArray()) {
                    int digit = ch - '0';
                    while (depth < digit) {
                        result.append('(');
                        depth++;
                    }
                    while (depth > digit) {
                        result.append(')');
                        depth--;
                    }
                    result.append(ch);
                }
                while (depth > 0) {
                    result.append(')');
                    depth--;
                }

                out.printf("Case #%d: %s%n", caseNum, result.toString());
            }
        }
    }

    static class FastReader {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public FastReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream));
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

        public void readIntArrays(int[]... arrays) {
            for (int i = 0; i < arrays[0].length; i++) {
                for (int[] array : arrays) {
                    array[i] = nextInt();
                }
            }
        }

        public void readMatrix(int rows, int columns, int[][] matrix) {
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    matrix[i][j] = nextInt();
                }
            }
        }
    }
}