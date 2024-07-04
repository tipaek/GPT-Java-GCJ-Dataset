import java.util.*;
import java.io.*;

public class Vestigium {
    public void run() throws Exception {
        FastReader file = new FastReader();
        int testCases = file.nextInt();
        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int n = file.nextInt();
            int[][] matrix = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = file.nextInt();
                }
            }
            int trace = 0;
            for (int i = 0; i < n; i++) {
                trace += matrix[i][i];
            }
            int rowRepeats = 0, colRepeats = 0;
            for (int i = 0; i < n; i++) {
                if (hasDuplicates(matrix[i])) {
                    rowRepeats++;
                }
                if (hasDuplicates(getColumn(matrix, i))) {
                    colRepeats++;
                }
            }
            System.out.println("Case #" + caseNum + ": " + trace + " " + rowRepeats + " " + colRepeats);
        }
    }

    private boolean hasDuplicates(int[] array) {
        Set<Integer> seen = new HashSet<>();
        for (int num : array) {
            if (!seen.add(num)) {
                return true;
            }
        }
        return false;
    }

    private int[] getColumn(int[][] matrix, int colIndex) {
        int[] column = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            column[i] = matrix[i][colIndex];
        }
        return column;
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