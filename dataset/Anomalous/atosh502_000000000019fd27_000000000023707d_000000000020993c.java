import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    public static void resetArray(boolean[] array, int length) {
        for (int i = 0; i < length; ++i) {
            array[i] = false;
        }
    }

    public static boolean isArrayComplete(boolean[] array, int length) {
        for (int i = 0; i < length; ++i) {
            if (!array[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        FastReader input = new FastReader();
        int testCases = input.nextInt();
        int size;
        int[][] matrix = new int[100][100];
        boolean[] presence = new boolean[100];
        
        for (int t = 1; t <= testCases; ++t) {
            size = input.nextInt();

            for (int i = 0; i < size; ++i) {
                for (int j = 0; j < size; ++j) {
                    matrix[i][j] = input.nextInt();
                }
            }

            int trace = 0;
            for (int i = 0; i < size; ++i) {
                trace += matrix[i][i];
            }

            int duplicateRows = 0, duplicateCols = 0;

            for (int i = 0; i < size; ++i) {
                for (int j = 0; j < size; ++j) {
                    presence[matrix[i][j] - 1] = true;
                }
                if (!isArrayComplete(presence, size)) {
                    duplicateRows++;
                }
                resetArray(presence, size);
            }

            for (int i = 0; i < size; ++i) {
                for (int j = 0; j < size; ++j) {
                    presence[matrix[j][i] - 1] = true;
                }
                if (!isArrayComplete(presence, size)) {
                    duplicateCols++;
                }
                resetArray(presence, size);
            }

            System.out.println("Case #" + t + ": " + trace + " " + duplicateRows + " " + duplicateCols);
        }
    }

    static class FastReader {
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