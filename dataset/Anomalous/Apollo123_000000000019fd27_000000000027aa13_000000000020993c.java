import java.io.*;
import java.util.StringTokenizer;

public class Solution {

    static int checkRow(int[][] matrix, int row, int size) {
        boolean[] seen = new boolean[size + 1];
        for (int i = 0; i < size; i++) {
            if (seen[matrix[row][i]]) {
                return 1;
            }
            seen[matrix[row][i]] = true;
        }
        return 0;
    }

    static int checkCol(int[][] matrix, int col, int size) {
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
        FastReader input = new FastReader(System.in);
        int testCases = input.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int size = input.nextInt();
            int[][] matrix = new int[size][size];

            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    matrix[i][j] = input.nextInt();
                }
            }

            int rowIssues = 0;
            int colIssues = 0;
            int trace = 0;

            for (int i = 0; i < size; i++) {
                rowIssues += checkRow(matrix, i, size);
                colIssues += checkCol(matrix, i, size);
                trace += matrix[i][i];
            }

            System.out.printf("Case #%d: %d %d %d%n", t, trace, rowIssues, colIssues);
        }
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader(InputStream input) {
            br = new BufferedReader(new InputStreamReader(input));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}