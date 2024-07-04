import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        FastReader sc = new FastReader();
        
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            int n = sc.nextInt();
            int[][] arr = new int[n][n];
            int diagonalSum = 0;
            int rowCount = 0;
            int colCount = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = sc.nextInt();
                    if (i == j) {
                        diagonalSum += arr[i][j];
                    }
                }
            }

            for (int i = 0; i < n; i++) {
                Set<Integer> rowSet = new HashSet<>();
                Set<Integer> colSet = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    rowSet.add(arr[i][j]);
                    colSet.add(arr[j][i]);
                }
                if (rowSet.size() != n) {
                    rowCount++;
                }
                if (colSet.size() != n) {
                    colCount++;
                }
            }
            
            System.out.println("Case #" + t + ": " + diagonalSum + " " + rowCount + " " + colCount);
        }
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