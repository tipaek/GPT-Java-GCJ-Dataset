import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    static class FastReader {
        BufferedReader bf;
        StringTokenizer st;

        public FastReader() {
            bf = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(bf.readLine());
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

        String nextLine() throws IOException {
            return bf.readLine();
        }

        boolean ready() throws IOException {
            return bf.ready();
        }

        void close() throws IOException {
            bf.close();
        }
    }

    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
        Solution solution = new Solution();
        solution.solve(fr);
        fr.close();
    }

    class Pair implements Comparable<Pair> {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Pair other) {
            if (this.x == other.x) {
                return Integer.compare(this.y, other.y);
            }
            return Integer.compare(this.x, other.x);
        }

        @Override
        public String toString() {
            return "( " + x + " , " + y + " )";
        }
    }

    boolean match(int a, int b) {
        if ((a + b) % 2 == 0) return false;
        if (a == 0) return (b & (b + 1)) == 0;
        if (b == 0) return (a & (a + 1)) == 0;
        while (a > 0 || b > 0) {
            if (((a & 1) ^ (b & 1)) == 0) {
                return false;
            }
            a >>= 1;
            b >>= 1;
        }
        return true;
    }

    public void solve(FastReader fr) throws IOException {
        int t = fr.nextInt();
        for (int c = 1; c <= t; c++) {
            int tx = fr.nextInt();
            int ty = fr.nextInt();
            int x = Math.abs(tx);
            int y = Math.abs(ty);
            int nx = calculateNextPowerOfTwo(x);
            int ny = calculateNextPowerOfTwo(y);

            StringBuilder result = new StringBuilder();
            if (match(x, y)) {
                buildResult(result, tx, ty, x, y);
            } else if (match(x, ny)) {
                buildResult(result, tx, ty, x, ny);
            } else if (match(nx, y)) {
                buildResult(result, tx, ty, nx, y);
            } else if (match(nx, ny)) {
                buildResult(result, tx, ty, nx, ny);
            } else {
                result.append("IMPOSSIBLE");
            }

            System.out.println("Case #" + c + ": " + result);
        }
    }

    private int calculateNextPowerOfTwo(int value) {
        if (value == 0) return 0;
        int power = Integer.highestOneBit(value) << 1;
        return power | (power - value);
    }

    private void buildResult(StringBuilder result, int tx, int ty, int x, int y) {
        while (x > 0 || y > 0) {
            if ((x & 1) > 0) {
                result.append(tx < 0 ? "W" : "E");
            } else {
                result.append(ty < 0 ? "S" : "N");
            }
            x >>= 1;
            y >>= 1;
        }
    }
}