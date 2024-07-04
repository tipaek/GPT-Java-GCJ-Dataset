import java.util.*;
import java.io.*;

public class Solution {
    public void run() throws Exception {
        FastReader input = new FastReader();
        int testCases = input.nextInt();
        for (int testCase = 0; testCase < testCases; testCase++) {
            int n = input.nextInt();
            int[][] matrix = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = input.nextInt();
                }
            }
            int trace = 0;
            for (int i = 0; i < n; i++) {
                trace += matrix[i][i];
            }
            int duplicateRows = 0, duplicateCols = 0;
            for (int i = 0; i < n; i++) {
                Set<Integer> rowSet = new HashSet<>();
                Set<Integer> colSet = new HashSet<>();
                boolean rowHasDuplicate = false, colHasDuplicate = false;
                for (int j = 0; j < n; j++) {
                    if (!rowHasDuplicate && !rowSet.add(matrix[i][j])) {
                        rowHasDuplicate = true;
                        duplicateRows++;
                    }
                    if (!colHasDuplicate && !colSet.add(matrix[j][i])) {
                        colHasDuplicate = true;
                        duplicateCols++;
                    }
                }
            }
            System.out.println("Case #" + (testCase + 1) + ": " + trace + " " + duplicateRows + " " + duplicateCols);
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