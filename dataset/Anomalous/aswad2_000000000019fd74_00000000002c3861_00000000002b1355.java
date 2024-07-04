import java.util.*;
import java.io.*;

public class Solution {
    private long[][] matrix;
    private boolean[][] included;
    private int rows, cols;

    public void run() throws Exception {
        FastReader reader = new FastReader();
        int testCases = reader.nextInt();
        
        for (int testCase = 0; testCase < testCases; testCase++) {
            rows = reader.nextInt();
            cols = reader.nextInt();
            matrix = new long[rows][cols];
            included = new boolean[rows][cols];
            
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    matrix[i][j] = reader.nextLong();
                    included[i][j] = true;
                }
            }
            
            int totalSum = 0;
            while (true) {
                int failedCount = 0;
                long currentSum = 0;
                
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < cols; j++) {
                        if (matrix[i][j] != -1) {
                            currentSum += matrix[i][j];
                            long up = searchUp(i, j);
                            long down = searchDown(i, j);
                            long right = searchRight(i, j);
                            long left = searchLeft(i, j);

                            long sum = 0;
                            int count = 0;

                            if (up != -1) {
                                sum += up;
                                count++;
                            }
                            if (down != -1) {
                                sum += down;
                                count++;
                            }
                            if (right != -1) {
                                sum += right;
                                count++;
                            }
                            if (left != -1) {
                                sum += left;
                                count++;
                            }

                            double average = (double) sum / count;
                            if (matrix[i][j] < average) {
                                included[i][j] = false;
                                failedCount++;
                            }
                        }
                    }
                }

                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < cols; j++) {
                        if (!included[i][j]) {
                            matrix[i][j] = -1;
                        }
                    }
                }

                if (failedCount == 0) break;
            }
            System.out.println("Case #" + (testCase + 1) + ": " + totalSum);
        }
    }

    private long searchUp(int i, int j) {
        for (int k = i - 1; k >= 0; k--) {
            if (matrix[k][j] != -1) return matrix[k][j];
        }
        return -1;
    }

    private long searchDown(int i, int j) {
        for (int k = i + 1; k < rows; k++) {
            if (matrix[k][j] != -1) return matrix[k][j];
        }
        return -1;
    }

    private long searchRight(int i, int j) {
        for (int k = j + 1; k < cols; k++) {
            if (matrix[i][k] != -1) return matrix[i][k];
        }
        return -1;
    }

    private long searchLeft(int i, int j) {
        for (int k = j - 1; k >= 0; k--) {
            if (matrix[i][k] != -1) return matrix[i][k];
        }
        return -1;
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