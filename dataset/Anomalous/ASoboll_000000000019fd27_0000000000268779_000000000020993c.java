import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));

        Solver solver = new Solver();
        solver.solve(in, out);
        out.close();
    }

    static class Solver {

        private static final int MAX_SIZE = 100;

        public void solve(InputReader in, PrintWriter out) {
            int[][] matrix = new int[MAX_SIZE][MAX_SIZE];

            int testCases = in.readInt();
            for (int caseNum = 1; caseNum <= testCases; caseNum++) {
                int size = in.readInt();
                in.readMatrix(size, size, matrix);

                int trace = 0;
                int rowDuplicates = 0;
                int colDuplicates = 0;

                for (int i = 0; i < size; i++) {
                    trace += matrix[i][i];
                    if (!hasDistinctElements(matrix, size, i, 0, 0, 1)) rowDuplicates++;
                    if (!hasDistinctElements(matrix, size, 0, 1, i, 0)) colDuplicates++;
                }

                out.printf("Case #%d: %d %d %d%n", caseNum, trace, rowDuplicates, colDuplicates);
            }
        }

        private boolean hasDistinctElements(int[][] matrix, int size, int startX, int stepX, int startY, int stepY) {
            boolean[] seen = new boolean[size + 1];
            for (int i = 0; i < size; i++) {
                int value = matrix[startX][startY];
                if (seen[value]) return false;
                seen[value] = true;
                startX += stepX;
                startY += stepY;
            }
            return true;
        }
    }

    static class InputReader {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream));
        }

        private String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int readInt() {
            return Integer.parseInt(next());
        }

        public long readLong() {
            return Long.parseLong(next());
        }

        public void readMatrix(int rows, int columns, int[][] matrix) {
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    matrix[i][j] = readInt();
                }
            }
        }
    }
}