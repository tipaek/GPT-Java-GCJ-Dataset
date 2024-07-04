import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();

        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int size = scanner.nextInt();
            int[][] matrix = new int[size][size];

            // Read the matrix
            for (int row = 0; row < size; row++) {
                for (int col = 0; col < size; col++) {
                    matrix[row][col] = scanner.nextInt();
                }
            }

            int trace = 0;
            int repeatedRows = 0;
            int repeatedCols = 0;

            // Calculate trace and check for repeated elements in rows and columns
            for (int index = 0; index < size; index++) {
                trace += matrix[index][index];

                if (hasRepeatedElements(matrix[index])) {
                    repeatedRows++;
                }

                int[] column = new int[size];
                for (int row = 0; row < size; row++) {
                    column[row] = matrix[row][index];
                }

                if (hasRepeatedElements(column)) {
                    repeatedCols++;
                }
            }

            System.out.println("Case #" + testCase + ": " + trace + " " + repeatedRows + " " + repeatedCols);
        }
    }

    private static boolean hasRepeatedElements(int[] array) {
        Set<Integer> set = new HashSet<>();
        for (int value : array) {
            if (!set.add(value)) {
                return true;
            }
        }
        return false;
    }

    public static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner(String fileName) {
            try {
                br = new BufferedReader(new FileReader(fileName));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        public FastScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        private String nextToken() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(nextToken());
        }

        public long nextLong() {
            return Long.parseLong(nextToken());
        }

        public double nextDouble() {
            return Double.parseDouble(nextToken());
        }
    }
}