import java.util.*;
import java.io.*;

public class Solution {
    private int[][] mat;
    private boolean[][] in;
    private int row, col;

    public void run() throws Exception {
        FastReader file = new FastReader();
        int testCases = file.nextInt();
        for (int testCase = 1; testCase <= testCases; testCase++) {
            row = file.nextInt();
            col = file.nextInt();
            mat = new int[row][col];
            in = new boolean[row][col];
            initializeMatrix(file);
            int totalSum = 0;
            while (true) {
                int countFail = 0;
                totalSum += calculateTotalSum();
                countFail = updateMatrix();
                if (countFail == 0) break;
            }
            System.out.println("Case #" + testCase + ": " + totalSum);
        }
    }

    private void initializeMatrix(FastReader file) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                mat[i][j] = file.nextInt();
                in[i][j] = true;
            }
        }
    }

    private int calculateTotalSum() {
        int totalSum = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (mat[i][j] != -1) {
                    totalSum += mat[i][j];
                }
            }
        }
        return totalSum;
    }

    private int updateMatrix() {
        int countFail = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (mat[i][j] != -1) {
                    int[] neighbors = getNeighbors(i, j);
                    double average = calculateAverage(neighbors);
                    if (mat[i][j] < average) {
                        in[i][j] = false;
                        countFail++;
                    }
                }
            }
        }
        applyUpdates();
        return countFail;
    }

    private int[] getNeighbors(int i, int j) {
        return new int[]{
                searchUp(i, j),
                searchDown(i, j),
                searchRight(i, j),
                searchLeft(i, j)
        };
    }

    private double calculateAverage(int[] neighbors) {
        int sum = 0, count = 0;
        for (int neighbor : neighbors) {
            if (neighbor != -1) {
                sum += neighbor;
                count++;
            }
        }
        return (double) sum / count;
    }

    private void applyUpdates() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (!in[i][j]) {
                    mat[i][j] = -1;
                }
            }
        }
    }

    private int searchUp(int i, int j) {
        for (int k = i - 1; k >= 0; k--) {
            if (mat[k][j] != -1) return mat[k][j];
        }
        return -1;
    }

    private int searchDown(int i, int j) {
        for (int k = i + 1; k < row; k++) {
            if (mat[k][j] != -1) return mat[k][j];
        }
        return -1;
    }

    private int searchRight(int i, int j) {
        for (int k = j + 1; k < col; k++) {
            if (mat[i][k] != -1) return mat[i][k];
        }
        return -1;
    }

    private int searchLeft(int i, int j) {
        for (int k = j - 1; k >= 0; k--) {
            if (mat[i][k] != -1) return mat[i][k];
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