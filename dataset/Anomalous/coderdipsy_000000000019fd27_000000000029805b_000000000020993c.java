import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        MyScanner sc = new MyScanner();
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

        int T = sc.nextInt(); // number of test cases

        for (int i = 0; i < T; i++) {
            int n = sc.nextInt();
            int[][] matrix = new int[n][n];
            int rowRepeats = 0, colRepeats = 0;

            for (int j = 0; j < n; j++) {
                String[] line = sc.nextLine().trim().split("\\s+");
                Set<Integer> rowSet = new HashSet<>();
                for (int k = 0; k < n; k++) {
                    matrix[j][k] = Integer.parseInt(line[k]);
                    rowSet.add(matrix[j][k]);
                }
                if (rowSet.size() != n) {
                    rowRepeats++;
                }
            }

            for (int j = 0; j < n; j++) {
                Set<Integer> colSet = new HashSet<>();
                for (int k = 0; k < n; k++) {
                    colSet.add(matrix[k][j]);
                }
                if (colSet.size() != n) {
                    colRepeats++;
                }
            }

            int trace = 0;
            for (int l = 0; l < n; l++) {
                trace += matrix[l][l];
            }

            out.printf("Case #%d: %d %d %d%n", i + 1, trace, rowRepeats, colRepeats);
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