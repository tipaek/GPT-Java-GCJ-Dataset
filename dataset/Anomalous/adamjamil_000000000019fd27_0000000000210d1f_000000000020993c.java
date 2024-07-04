import java.io.*;
import java.util.*;

public class Solution implements Runnable {
    private boolean multiple = true;
    private int caseNum = 1;
    private StringBuilder ANS = new StringBuilder();
    private BufferedReader in;
    private FastScanner sc;
    private PrintWriter out;
    private static Throwable uncaught;

    public static void main(String[] args) throws Throwable {
        Thread thread = new Thread(null, new Solution(), "", (1 << 26));
        thread.start();
        thread.join();
        if (Solution.uncaught != null) {
            throw Solution.uncaught;
        }
    }

    @Override
    public void run() {
        try {
            in = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);
            sc = new FastScanner(in);
            if (multiple) {
                int q = sc.nextInt();
                for (int i = 0; i < q; i++) solve();
            } else {
                solve();
            }
            System.out.print(ANS);
        } catch (Throwable uncaught) {
            Solution.uncaught = uncaught;
        } finally {
            out.close();
        }
    }

    private void solve() throws Exception {
        int n = sc.nextInt();
        long[][] matrix = new long[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextLong();
            }
        }

        int rowDuplicates = countDuplicateRows(matrix, n);
        int colDuplicates = countDuplicateCols(matrix, n);
        long diagonalSum = calculateDiagonalSum(matrix, n);

        ANS.append("Case #").append(caseNum).append(": ")
           .append(diagonalSum).append(" ")
           .append(rowDuplicates).append(" ")
           .append(colDuplicates).append('\n');
        caseNum++;
    }

    private int countDuplicateRows(long[][] matrix, int n) {
        int rowDuplicates = 0;
        for (int i = 0; i < n; i++) {
            Set<Long> values = new HashSet<>();
            for (int j = 0; j < n; j++) {
                values.add(matrix[i][j]);
            }
            if (values.size() < n) rowDuplicates++;
        }
        return rowDuplicates;
    }

    private int countDuplicateCols(long[][] matrix, int n) {
        int colDuplicates = 0;
        for (int i = 0; i < n; i++) {
            Set<Long> values = new HashSet<>();
            for (int j = 0; j < n; j++) {
                values.add(matrix[j][i]);
            }
            if (values.size() < n) colDuplicates++;
        }
        return colDuplicates;
    }

    private long calculateDiagonalSum(long[][] matrix, int n) {
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += matrix[i][i];
        }
        return sum;
    }

    private class FastScanner {
        private BufferedReader in;
        private StringTokenizer st;

        public FastScanner(BufferedReader in) {
            this.in = in;
        }

        public String nextToken() throws Exception {
            while (st == null || !st.hasMoreTokens()) {
                st = new StringTokenizer(in.readLine());
            }
            return st.nextToken();
        }

        public int nextInt() throws Exception {
            return Integer.parseInt(nextToken());
        }

        public long nextLong() throws Exception {
            return Long.parseLong(nextToken());
        }
    }
}