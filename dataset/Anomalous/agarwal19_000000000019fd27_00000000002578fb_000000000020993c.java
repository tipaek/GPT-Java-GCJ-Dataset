import java.util.*;
import java.io.*;

public class Solution {

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

    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int T = sc.nextInt();
        for (int p = 1; p <= T; p++) {
            int n = sc.nextInt();
            int[][] matrix = new int[n][n];
            int rowRepeats = 0, colRepeats = 0, diagonalSum = 0;

            for (int i = 0; i < n; i++) {
                Set<Integer> rowSet = new HashSet<>();
                boolean rowFlag = false;
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = sc.nextInt();
                    if (!rowSet.add(matrix[i][j])) {
                        rowFlag = true;
                    }
                    if (i == j) {
                        diagonalSum += matrix[i][j];
                    }
                }
                if (rowFlag) {
                    rowRepeats++;
                }
            }

            for (int j = 0; j < n; j++) {
                Set<Integer> colSet = new HashSet<>();
                boolean colFlag = false;
                for (int i = 0; i < n; i++) {
                    if (!colSet.add(matrix[i][j])) {
                        colFlag = true;
                    }
                }
                if (colFlag) {
                    colRepeats++;
                }
            }

            System.out.println("Case #" + p + ": " + diagonalSum + " " + rowRepeats + " " + colRepeats);
        }
    }
}