import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        MyScanner sc = new MyScanner();
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

        int T = sc.nextInt(); // read input as integer

        for (int i = 0; i < T; i++) {
            int n = sc.nextInt();
            int[][] matrix = new int[n][n];
            int duplicateRows = 0, duplicateCols = 0;

            for (int row = 0; row < n; row++) {
                String[] line = sc.nextLine().trim().split("\\s+");
                Set<Integer> rowSet = new HashSet<>();
                for (int col = 0; col < n; col++) {
                    matrix[row][col] = Integer.parseInt(line[col]);
                    rowSet.add(matrix[row][col]);
                }
                if (rowSet.size() != n) {
                    duplicateRows++;
                }
            }

            for (int col = 0; col < n; col++) {
                Set<Integer> colSet = new HashSet<>();
                for (int row = 0; row < n; row++) {
                    colSet.add(matrix[row][col]);
                }
                if (colSet.size() != n) {
                    duplicateCols++;
                }
            }

            int trace = 0;
            for (int diag = 0; diag < n; diag++) {
                trace += matrix[diag][diag];
            }

            out.println("Case #" + (i + 1) + ": " + trace + " " + duplicateRows + " " + duplicateCols);
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