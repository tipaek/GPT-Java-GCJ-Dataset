import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

class Solution {

    static class FastReader {
        private BufferedReader br;
        private StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        private String next() {
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
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int tcs = sc.nextInt();

        for (int p = 0; p < tcs; p++) {
            int n = sc.nextInt();
            int[][] matrix = new int[n][n];
            int rowDuplicate = 0;
            int trace = 0;

            for (int i = 0; i < n; i++) {
                HashMap<Integer, Integer> rowMap = new HashMap<>();
                boolean hasRowDuplicate = false;

                for (int j = 0; j < n; j++) {
                    matrix[i][j] = sc.nextInt();

                    if (rowMap.containsKey(matrix[i][j])) {
                        hasRowDuplicate = true;
                    } else {
                        rowMap.put(matrix[i][j], 1);
                    }

                    if (i == j) {
                        trace += matrix[i][j];
                    }
                }

                if (hasRowDuplicate) {
                    rowDuplicate++;
                }
            }

            int colDuplicate = 0;

            for (int i = 0; i < n; i++) {
                HashMap<Integer, Integer> colMap = new HashMap<>();
                boolean hasColDuplicate = false;

                for (int j = 0; j < n; j++) {
                    if (colMap.containsKey(matrix[j][i])) {
                        hasColDuplicate = true;
                        break;
                    } else {
                        colMap.put(matrix[j][i], 1);
                    }
                }

                if (hasColDuplicate) {
                    colDuplicate++;
                }
            }

            System.out.println("Case #" + (p + 1) + ": " + trace + " " + rowDuplicate + " " + colDuplicate);
        }
    }
}