import java.io.*;
import java.util.StringTokenizer;

public class Vestigium {

    private static int checkRow(int[][] matrix, int row, int size) {
        boolean[] seen = new boolean[size + 1];
        for (int i = 0; i < size; i++) {
            if (seen[matrix[row][i]]) {
                return 1;
            }
            seen[matrix[row][i]] = true;
        }
        return 0;
    }

    private static int checkCol(int[][] matrix, int col, int size) {
        boolean[] seen = new boolean[size + 1];
        for (int i = 0; i < size; i++) {
            if (seen[matrix[i][col]]) {
                return 1;
            }
            seen[matrix[i][col]] = true;
        }
        return 0;
    }

    public static void main(String[] args) {
        Kattio io = new Kattio(System.in);
        int testCases = io.getInt();
        for (int t = 1; t <= testCases; t++) {
            int size = io.getInt();
            int[][] matrix = new int[size][size];

            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    matrix[i][j] = io.getInt();
                }
            }

            int rowDuplicates = 0;
            int colDuplicates = 0;
            int trace = 0;

            for (int i = 0; i < size; i++) {
                rowDuplicates += checkRow(matrix, i, size);
                colDuplicates += checkCol(matrix, i, size);
                trace += matrix[i][i];
            }

            System.out.printf("Case #%d: %d %d %d%n", t, trace, rowDuplicates, colDuplicates);
        }
    }

    private static class Kattio extends PrintWriter {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public Kattio(InputStream inputStream) {
            super(new BufferedOutputStream(System.out));
            reader = new BufferedReader(new InputStreamReader(inputStream));
        }

        public Kattio(InputStream inputStream, OutputStream outputStream) {
            super(new BufferedOutputStream(outputStream));
            reader = new BufferedReader(new InputStreamReader(inputStream));
        }

        public boolean hasMoreTokens() {
            return peekToken() != null;
        }

        public int getInt() {
            return Integer.parseInt(nextToken());
        }

        public double getDouble() {
            return Double.parseDouble(nextToken());
        }

        public long getLong() {
            return Long.parseLong(nextToken());
        }

        public String getWord() {
            return nextToken();
        }

        private String peekToken() {
            if (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    String line = reader.readLine();
                    if (line == null) {
                        return null;
                    }
                    tokenizer = new StringTokenizer(line);
                } catch (IOException e) {
                    return null;
                }
            }
            return tokenizer.nextToken();
        }

        private String nextToken() {
            String token = peekToken();
            if (token != null) {
                tokenizer.nextToken();
            }
            return token;
        }
    }
}