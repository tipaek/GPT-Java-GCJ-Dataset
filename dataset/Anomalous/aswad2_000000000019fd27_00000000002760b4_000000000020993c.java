import java.util.*;
import java.io.*;

public class Vestigium {

    public void run() throws Exception {
        FastReader reader = new FastReader();
        int testCases = reader.nextInt();
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = reader.nextInt();
            int[][] matrix = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = reader.nextInt();
                }
            }
            
            int trace = calculateTrace(matrix, n);
            int duplicateRows = countDuplicateRows(matrix, n);
            int duplicateColumns = countDuplicateColumns(matrix, n);
            
            System.out.println("Case #" + testCase + ": " + trace + " " + duplicateRows + " " + duplicateColumns);
        }
    }

    private int calculateTrace(int[][] matrix, int n) {
        int trace = 0;
        for (int i = 0; i < n; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private int countDuplicateRows(int[][] matrix, int n) {
        int duplicateRows = 0;
        for (int i = 0; i < n; i++) {
            Set<Integer> rowSet = new HashSet<>();
            for (int j = 0; j < n; j++) {
                if (!rowSet.add(matrix[i][j])) {
                    duplicateRows++;
                    break;
                }
            }
        }
        return duplicateRows;
    }

    private int countDuplicateColumns(int[][] matrix, int n) {
        int duplicateColumns = 0;
        for (int j = 0; j < n; j++) {
            Set<Integer> columnSet = new HashSet<>();
            for (int i = 0; i < n; i++) {
                if (!columnSet.add(matrix[i][j])) {
                    duplicateColumns++;
                    break;
                }
            }
        }
        return duplicateColumns;
    }

    public static void main(String[] args) throws Exception {
        new Vestigium().run();
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