import java.io.*;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) {
        FastScanner sc = new FastScanner();

        int numberOfTest = sc.nextInt();
        int[][] matrix = new int[100][100];

        for (int i = 0; i < numberOfTest; i++) {
            int n = sc.nextInt();
            solve(matrix, n, i);
        }

        /*int [][]a = { { 2, 2, 2, 2 },
                { 2, 1, 4, 3 },
                { 3, 4, 1, 2 },
                { 4, 3, 2, 1 } };
        int n = 4;

        solve(a, 4, 1);*/
    }

    private static void solve(int[][] matrix, int n, int testLevel) {
        int k = 0; // Trace
        int dupRow = 0; // Number of rows contain repeated elements
        int dupCol = 0; // Number of columns contains repeated elements

        for (int r = 0; r < n; r++) {
            k = k + matrix[r][r];

            if (isDuplicated_NSquare(matrix[r], n)) {
                dupRow++;
            }

            if (isDuplicated_NSquare(matrix[r], n)) {
                dupCol++;
            }
        }

        System.out.println("Case #" + testLevel + ": " + k + " " + dupRow + " " + dupCol);
    }

    static boolean isDuplicated_NSquare(final int[] arr, final int n) {
        for (int col = 0; col < n; col++) {
            for (int i = col + 1; i < n; i++) {
                if (i != col && arr[i] == arr[col]) {
                    return true;
                }
            }
        }

        return false;
    }

    static boolean isDuplicatedVertical_NSquare(final int[][] arr2d, final int col, final int n) {
        for (int row = 0; row < n; row++) {
            for (int i = row + 1; i < n; i++) {
                if (i != row && arr2d[row][col] == arr2d[row][col]) {
                    return true;
                }
            }
        }

        return false;
    }

    /*static boolean duplicatesTwo(final int[] arr) {
        final int MAXZIP = 99999;

        BitSet b = new BitSet(MAXZIP + 1);
        b.set(0, MAXZIP, false);
        for (int item : arr) {
            if (!b.get(item)) {
                b.set(item, true);
            } else
                return true;
        }
        return false;
    }*/

    /*static boolean duplicatesOne(final int[] arr) {
        final int MAXZIP = 99999;
        boolean[] bitmap = new boolean[MAXZIP + 1];
        java.util.Arrays.fill(bitmap, false);
        for (int item : arr) {
            if (!(bitmap[item] ^= true))
                return true;
        }
        return false;
    }*/

    public static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner(String s) {
            try {
                br = new BufferedReader(new FileReader(s));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        public FastScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String nextToken() {
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
            return Integer.parseInt(nextToken());
        }

        long nextLong() {
            return Long.parseLong(nextToken());
        }

        double nextDouble() {
            return Double.parseDouble(nextToken());
        }
    }
}
