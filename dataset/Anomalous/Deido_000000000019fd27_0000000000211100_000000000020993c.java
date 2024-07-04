import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        FastReader reader = new FastReader();
        int t = reader.nextInt();
        for (int tc = 1; tc <= t; tc++) {
            int n = reader.nextInt();
            int[][] matrix = new int[n][n];
            for (int i = 0; i < n; i++) {
                matrix[i] = reader.nextIntArray(n);
            }

            int trace = 0, rowRepeats = 0, colRepeats = 0;
            for (int i = 0; i < n; i++) {
                trace += matrix[i][i];
            }

            for (int i = 0; i < n; i++) {
                if (hasDuplicates(matrix[i])) {
                    rowRepeats++;
                }
            }

            for (int j = 0; j < n; j++) {
                int[] column = new int[n];
                for (int i = 0; i < n; i++) {
                    column[i] = matrix[i][j];
                }
                if (hasDuplicates(column)) {
                    colRepeats++;
                }
            }

            System.out.println("Case #" + tc + ": " + trace + " " + rowRepeats + " " + colRepeats);
        }
    }

    private static boolean hasDuplicates(int[] array) {
        boolean[] seen = new boolean[array.length + 1];
        for (int value : array) {
            if (seen[value]) {
                return true;
            }
            seen[value] = true;
        }
        return false;
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        FastReader() {
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

        int[] nextIntArray(int n) {
            int[] array = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = nextInt();
            }
            return array;
        }
    }
}