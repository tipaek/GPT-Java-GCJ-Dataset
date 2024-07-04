import java.io.*;
import java.util.*;

public class CodeJam {
    public static void main(String[] args) throws IOException {
        MyScanner sc = new MyScanner();
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

        int T = sc.nextInt();  // number of test cases

        for (int i = 1; i <= T; i++) {
            int n = sc.nextInt();
            int[][] matrix = new int[n][n];
            int trace = 0, rowDuplicates = 0, colDuplicates = 0;

            for (int r = 0; r < n; r++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int c = 0; c < n; c++) {
                    matrix[r][c] = sc.nextInt();
                    if (r == c) {
                        trace += matrix[r][c];
                    }
                    rowSet.add(matrix[r][c]);
                }
                if (rowSet.size() < n) {
                    rowDuplicates++;
                }
            }

            for (int c = 0; c < n; c++) {
                Set<Integer> colSet = new HashSet<>();
                for (int r = 0; r < n; r++) {
                    colSet.add(matrix[r][c]);
                }
                if (colSet.size() < n) {
                    colDuplicates++;
                }
            }

            out.printf("Case #%d: %d %d %d%n", i, trace, rowDuplicates, colDuplicates);
        }

        out.close();
    }

    public static class MyScanner {
        BufferedReader br;
        StringTokenizer st;

        public MyScanner() {
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