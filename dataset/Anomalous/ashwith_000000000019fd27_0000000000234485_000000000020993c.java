import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args) throws Exception {
        MyScanner scanner = new MyScanner();
        PrintWriter out = new PrintWriter(System.out);
        int t = scanner.nextInt();
        int caseNumber = 1;

        while (t > 0) {
            int n = scanner.nextInt();
            long[][] matrix = new long[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextLong();
                }
            }

            long[] result = analyzeMatrix(matrix);
            out.println("Case #" + caseNumber + ": " + result[0] + " " + result[1] + " " + result[2]);
            caseNumber++;
            t--;
            out.flush();
        }
    }

    static class MyScanner {
        private BufferedReader br;
        private StringTokenizer st;

        public MyScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public String next() {
            try {
                while (st == null || !st.hasMoreTokens()) {
                    st = new StringTokenizer(br.readLine());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return st.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }
    }

    static long[] analyzeMatrix(long[][] matrix) {
        int n = matrix.length;
        long[] result = new long[3];
        result[0] = calculateDiagonalSum(matrix, n);
        result[1] = countDuplicateRows(matrix, n);
        result[2] = countDuplicateColumns(matrix, n);
        return result;
    }

    static long calculateDiagonalSum(long[][] matrix, int n) {
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += matrix[i][i];
        }
        return sum;
    }

    static int countDuplicateRows(long[][] matrix, int n) {
        int duplicateRows = 0;

        for (int i = 0; i < n; i++) {
            Set<Long> rowSet = new HashSet<>();
            boolean hasDuplicate = false;

            for (int j = 0; j < n; j++) {
                if (!rowSet.add(matrix[i][j])) {
                    hasDuplicate = true;
                    break;
                }
            }

            if (hasDuplicate) {
                duplicateRows++;
            }
        }

        return duplicateRows;
    }

    static int countDuplicateColumns(long[][] matrix, int n) {
        int duplicateColumns = 0;

        for (int i = 0; i < n; i++) {
            Set<Long> colSet = new HashSet<>();
            boolean hasDuplicate = false;

            for (int j = 0; j < n; j++) {
                if (!colSet.add(matrix[j][i])) {
                    hasDuplicate = true;
                    break;
                }
            }

            if (hasDuplicate) {
                duplicateColumns++;
            }
        }

        return duplicateColumns;
    }
}