import java.util.*;
import java.io.*;

public class Solution {
    public void run() throws Exception {
        FastReader reader = new FastReader();
        int testCases = reader.nextInt();
        for (int t = 0; t < testCases; t++) {
            int n = reader.nextInt();
            int[][] matrix = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = reader.nextInt();
                }
            }

            int diagonalSum = 0;
            for (int i = 0; i < n; i++) {
                diagonalSum += matrix[i][i];
            }

            int duplicateRows = 0, duplicateCols = 0;
            for (int i = 0; i < n; i++) {
                boolean rowDuplicate = false, colDuplicate = false;
                Set<Integer> rowSet = new HashSet<>();
                Set<Integer> colSet = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    if (!rowDuplicate && rowSet.contains(matrix[i][j])) {
                        rowDuplicate = true;
                        duplicateRows++;
                    } else {
                        rowSet.add(matrix[i][j]);
                    }

                    if (!colDuplicate && colSet.contains(matrix[j][i])) {
                        colDuplicate = true;
                        duplicateCols++;
                    } else {
                        colSet.add(matrix[j][i]);
                    }
                }
            }

            System.out.println("Case #" + (t + 1) + ": " + diagonalSum + " " + duplicateRows + " " + duplicateCols);
        }
    }

    public static void main(String[] args) throws Exception {
        new Solution().run();
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