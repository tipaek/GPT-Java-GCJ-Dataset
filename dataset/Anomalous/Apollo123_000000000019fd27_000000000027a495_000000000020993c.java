import java.io.*;
import java.util.StringTokenizer;

public class Vestigium {

    public static void main(String[] args) {
        FastInput scan = new FastInput(System.in);
        int T = scan.nextInt();
        for (int t = 1; t <= T; t++) {
            int N = scan.nextInt();
            int[][] matrix = new int[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    matrix[i][j] = scan.nextInt();
                }
            }

            int rowDuplicates = 0;
            int colDuplicates = 0;
            int trace = 0;

            for (int i = 0; i < N; i++) {
                rowDuplicates += hasDuplicates(matrix[i]);
                colDuplicates += hasDuplicates(getColumn(matrix, i));
                trace += matrix[i][i];
            }
            System.out.printf("Case #%d: %d %d %d%n", t, trace, rowDuplicates, colDuplicates);
        }
    }

    private static int hasDuplicates(int[] array) {
        boolean[] presence = new boolean[array.length + 1];
        for (int value : array) {
            if (presence[value]) {
                return 1;
            }
            presence[value] = true;
        }
        return 0;
    }

    private static int[] getColumn(int[][] matrix, int col) {
        int[] column = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            column[i] = matrix[i][col];
        }
        return column;
    }

    private static class FastInput {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public FastInput(InputStream input) {
            reader = new BufferedReader(new InputStreamReader(input));
        }

        public int nextInt() {
            return Integer.parseInt(nextToken());
        }

        private String nextToken() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }
    }
}