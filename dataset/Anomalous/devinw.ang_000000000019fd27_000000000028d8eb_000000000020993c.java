import java.io.*;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        FastReader sc = new FastReader();
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int t = sc.nextInt();
        for (int i = 1; i <= t; i++) {
            int n = sc.nextInt();
            int[][] matrix = new int[n][n];
            for (int k = 0; k < n; k++) {
                for (int j = 0; j < n; j++) {
                    matrix[k][j] = sc.nextInt();
                }
            }
            out.println("case #" + i + ": " + calculateTrace(matrix) + " " + countDuplicateRows(matrix) + " " + countDuplicateColumns(matrix));
        }
        out.close();
    }

    public static int calculateTrace(int[][] matrix) {
        int trace = 0;
        for (int i = 0; i < matrix.length; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    public static int countDuplicateRows(int[][] matrix) {
        int duplicateRows = 0;
        for (int[] row : matrix) {
            int[] sortedRow = row.clone();
            Arrays.sort(sortedRow);
            if (hasDuplicates(sortedRow)) {
                duplicateRows++;
            }
        }
        return duplicateRows;
    }

    public static int countDuplicateColumns(int[][] matrix) {
        int duplicateColumns = 0;
        for (int j = 0; j < matrix.length; j++) {
            int[] column = new int[matrix.length];
            for (int i = 0; i < matrix.length; i++) {
                column[i] = matrix[i][j];
            }
            Arrays.sort(column);
            if (hasDuplicates(column)) {
                duplicateColumns++;
            }
        }
        return duplicateColumns;
    }

    public static boolean hasDuplicates(int[] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[i] == array[i - 1]) {
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

        public FastReader(String s) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(new File(s)));
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