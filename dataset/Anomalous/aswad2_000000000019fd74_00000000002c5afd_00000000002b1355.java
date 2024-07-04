import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Solution {
    private long[][] matrix;
    private boolean[][] inMatrix;
    private int rows, cols;

    public void run() throws Exception {
        FastReader input = new FastReader();
        int testCases = input.nextInt();
        for (int testCase = 0; testCase < testCases; testCase++) {
            rows = input.nextInt();
            cols = input.nextInt();
            matrix = new long[rows][cols];
            inMatrix = new boolean[rows][cols];
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    matrix[i][j] = input.nextLong();
                    inMatrix[i][j] = true;
                }
            }
            int totalSum = 0;
            while (true) {
                int failCount = 0;
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < cols; j++) {
                        if (matrix[i][j] != -1) {
                            totalSum += matrix[i][j];
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

                            double average = count == 0 ? 0 : (double) sum / count;
                            if (matrix[i][j] < average) {
                                inMatrix[i][j] = false;
                                failCount++;
                            }
                        }
                    }
                }

                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < cols; j++) {
                        if (!inMatrix[i][j]) {
                            matrix[i][j] = -1;
                        }
                    }
                }

                if (failCount == 0) {
                    break;
                }
            }
            System.out.println("Case #" + (testCase + 1) + ": " + totalSum);
        }
    }

    private long searchUp(int i, int j) {
        for (int k = i - 1; k >= 0; k--) {
            if (matrix[k][j] != -1) {
                return matrix[k][j];
            }
        }
        return -1;
    }

    private long searchDown(int i, int j) {
        for (int k = i + 1; k < rows; k++) {
            if (matrix[k][j] != -1) {
                return matrix[k][j];
            }
        }
        return -1;
    }

    private long searchRight(int i, int j) {
        for (int k = j + 1; k < cols; k++) {
            if (matrix[i][k] != -1) {
                return matrix[i][k];
            }
        }
        return -1;
    }

    private long searchLeft(int i, int j) {
        for (int k = j - 1; k >= 0; k--) {
            if (matrix[i][k] != -1) {
                return matrix[i][k];
            }
        }
        return -1;
    }

    public static void main(String[] args) throws Exception {
        new Solution().run();
    }

    static class FastReader {
        private BufferedReader br;
        private StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public String next() {
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
}