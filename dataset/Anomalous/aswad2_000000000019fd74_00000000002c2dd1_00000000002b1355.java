import java.util.*;
import java.io.*;

public class Solution {
    private long[][] mat;
    private boolean[][] in;
    private int row, col;

    public void run() throws Exception {
        FastReader file = new FastReader();
        int times = file.nextInt();
        for (int asdf = 0; asdf < times; asdf++) {
            initializeMatrix(file);
            int totalSum = 0;
            while (true) {
                int countFail = processMatrix();
                totalSum += calculateTotalSum();
                if (countFail == 0) break;
                updateMatrix();
            }
            System.out.println("Case #" + (asdf + 1) + ": " + totalSum);
        }
    }

    private void initializeMatrix(FastReader file) throws IOException {
        row = file.nextInt();
        col = file.nextInt();
        mat = new long[row][col];
        in = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                mat[i][j] = file.nextLong();
                in[i][j] = true;
            }
        }
    }

    private int processMatrix() {
        int countFail = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (mat[i][j] != -1) {
                    long a = searchUp(i, j);
                    long b = searchDown(i, j);
                    long c = searchRight(i, j);
                    long d = searchLeft(i, j);

                    int count = 0;
                    long sum = 0;
                    if (a != -1) { sum += a; count++; }
                    if (b != -1) { sum += b; count++; }
                    if (c != -1) { sum += c; count++; }
                    if (d != -1) { sum += d; count++; }

                    double avg = (double) sum / count;
                    if (mat[i][j] < avg) {
                        in[i][j] = false;
                        countFail++;
                    }
                }
            }
        }
        return countFail;
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

    private void updateMatrix() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (!in[i][j]) {
                    mat[i][j] = -1;
                }
            }
        }
    }

    public long searchUp(int i, int j) {
        for (int k = i - 1; k >= 0; k--) {
            if (mat[k][j] != -1) return mat[k][j];
        }
        return -1;
    }

    public long searchDown(int i, int j) {
        for (int k = i + 1; k < row; k++) {
            if (mat[k][j] != -1) return mat[k][j];
        }
        return -1;
    }

    public long searchRight(int i, int j) {
        for (int k = j + 1; k < col; k++) {
            if (mat[i][k] != -1) return mat[i][k];
        }
        return -1;
    }

    public long searchLeft(int i, int j) {
        for (int k = j - 1; k >= 0; k--) {
            if (mat[i][k] != -1) return mat[i][k];
        }
        return -1;
    }

    public static void main(String[] args) throws Exception {
        new Solution().run();
    }

    static class Thing implements Comparable<Thing> {
        String t;

        public Thing(String t) {
            this.t = t;
        }

        @Override
        public int compareTo(Thing other) {
            return t.length() - other.t.length();
        }
    }

    static class Pair implements Comparable<Pair> {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Pair other) {
            return (x == other.x) ? y - other.y : x - other.x;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Pair other = (Pair) obj;
            return x == other.x && y == other.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
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