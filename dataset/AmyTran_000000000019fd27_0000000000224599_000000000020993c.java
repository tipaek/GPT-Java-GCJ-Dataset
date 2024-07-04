import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        FastScanner sc = new FastScanner();

        int numberOfTest = sc.nextInt();
        int[][] matrix;
        int n = 0;


        for (int i = 0; i < numberOfTest; i++) {
            // Input
            n = sc.nextInt();
            matrix = new int[n][n];
            for (int r = 0; r < n; r++) {
                for (int c = 0; c < n; c++) {
                    matrix[r][c] = sc.nextInt();
                }
            }
            int k = 0; // Trace
            int r = 0; // Number of rows contain repeated elements
            int c = 0; // Number of columns contains repeated elements
            // Solve
            for (int diagonal = 0; diagonal < n; diagonal++) {
                k += matrix[diagonal][diagonal];
                boolean rowHasRepeatedElements = false, columnHasRepeatedElements = false;
                for (int j = 0; j < n - 1; j++) {
                    if (!rowHasRepeatedElements || !columnHasRepeatedElements) {
                        for (int m = j + 1; m < n; m++) {
                            if (matrix[diagonal][j] == matrix[diagonal][m] && !rowHasRepeatedElements) {
                                r++;
                                rowHasRepeatedElements = true;
                            }
                            if (matrix[j][diagonal] == matrix[m][diagonal] && !columnHasRepeatedElements) {
                                c++;
                                columnHasRepeatedElements = true;
                            }
                        }
                    }
                }
            }
            System.out.println("Case #" + (i + 1) + ": " + k + " " + r + " " + c);
        }
    }

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
