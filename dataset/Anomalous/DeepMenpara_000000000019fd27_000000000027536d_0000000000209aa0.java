import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int t = sc.nextInt();
        for (int i = 1; i <= t; i++) {
            solve(sc, i);
        }
    }

    static void solve(FastReader sc, int testcase) {
        int n = sc.nextInt();
        int[][] array = new int[n][n];
        int k = sc.nextInt();

        if (calculate(array, n, k)) {
            System.out.println("Case #" + testcase + ": POSSIBLE");
            printArray(array);
        } else {
            System.out.println("Case #" + testcase + ": IMPOSSIBLE");
        }
    }

    static void printArray(int[][] array) {
        for (int[] row : array) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    static boolean isPossible(int[][] array, int x, int row, int col, int k) {
        int sum = x;
        for (int i = 0; i < array.length; i++) {
            if (array[i][col] == x || array[row][i] == x) {
                return false;
            }
            sum += array[i][i];
        }

        if (row == col && row == array.length - 1) {
            if (sum != k) {
                return false;
            }
        }
        if (row == col && sum > k) {
            return false;
        }

        return true;
    }

    static boolean calculate(int[][] array, int n, int k) {
        int row = -1, col = -1;
        boolean finished = true;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (array[i][j] == 0) {
                    row = i;
                    col = j;
                    finished = false;
                    break;
                }
            }
            if (!finished) {
                break;
            }
        }

        if (finished) {
            return true;
        }

        for (int i = 1; i <= n; i++) {
            if (isPossible(array, i, row, col, k)) {
                array[row][col] = i;
                if (calculate(array, n, k)) {
                    return true;
                } else {
                    array[row][col] = 0;
                }
            }
        }
        return false;
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