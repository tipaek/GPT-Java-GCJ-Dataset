import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int testCases = sc.nextInt();
        for (int test = 0; test < testCases; test++) {
            int n = sc.nextInt();
            int[][] matrix = new int[n][n];
            int diagonalSum = 0;
            int uniqueRows = 0;
            int uniqueCols = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = sc.nextInt();
                    if (i == j) {
                        diagonalSum += matrix[i][j];
                    }
                }
                if (hasDuplicate(matrix[i])) {
                    uniqueRows++;
                }
            }

            for (int j = 0; j < n; j++) {
                int[] column = new int[n];
                for (int i = 0; i < n; i++) {
                    column[i] = matrix[i][j];
                }
                if (hasDuplicate(column)) {
                    uniqueCols++;
                }
            }

            System.out.println("Case #" + (test + 1) + ": " + diagonalSum + " " + uniqueRows + " " + uniqueCols);
        }
    }

    private static boolean hasDuplicate(int[] array) {
        HashSet<Integer> set = new HashSet<>();
        for (int element : array) {
            if (!set.add(element)) {
                return true;
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
            while (st == null || !st.hasMoreTokens()) {
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