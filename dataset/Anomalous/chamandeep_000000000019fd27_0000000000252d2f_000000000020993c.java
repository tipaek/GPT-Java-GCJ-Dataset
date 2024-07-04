import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    public static boolean hasDuplicateInRow(int[][] matrix, int row) {
        boolean[] seen = new boolean[101];
        for (int value : matrix[row]) {
            if (seen[value]) return true;
            seen[value] = true;
        }
        return false;
    }

    public static boolean hasDuplicateInColumn(int[][] matrix, int column) {
        boolean[] seen = new boolean[101];
        for (int[] row : matrix) {
            if (seen[row[column]]) return true;
            seen[row[column]] = true;
        }
        return false;
    }

    public static void main(String[] args) {
        FastReader reader = new FastReader();
        int testCases = reader.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int n = reader.nextInt();
            int[][] matrix = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = reader.nextInt();
                }
            }

            int trace = 0;
            int duplicateRows = 0;
            int duplicateColumns = 0;

            for (int i = 0; i < n; i++) {
                trace += matrix[i][i];
                if (hasDuplicateInRow(matrix, i)) duplicateRows++;
                if (hasDuplicateInColumn(matrix, i)) duplicateColumns++;
            }

            System.out.println("Case #" + t + ": " + trace + " " + duplicateRows + " " + duplicateColumns);
        }
    }

    public static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
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