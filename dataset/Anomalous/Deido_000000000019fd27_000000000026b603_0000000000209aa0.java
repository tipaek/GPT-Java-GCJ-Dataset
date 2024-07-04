import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        FastReader reader = new FastReader();
        int t = reader.nextInt();
        for (int tc = 1; tc <= t; tc++) {
            int n = reader.nextInt();
            int k = reader.nextInt();
            if (k < n) {
                System.out.println("Case #" + tc + ": IMPOSSIBLE");
                continue;
            }
            int[][] matrix = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = ((n - i + j) % n) + 1;
                }
            }
            k -= n;
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    int delta = matrix[i][j] + matrix[j][i] - matrix[i][i] - matrix[j][j];
                    if (delta <= 0 || delta > k) {
                        continue;
                    }
                    int[] temp = matrix[i];
                    matrix[i] = matrix[j];
                    matrix[j] = temp;
                    k -= delta;
                }
            }
            if (k > 0) {
                System.out.println("Case #" + tc + ": IMPOSSIBLE");
                continue;
            }
            StringBuilder result = new StringBuilder("Case #" + tc + ": POSSIBLE\n");
            for (int[] row : matrix) {
                for (int value : row) {
                    result.append(value).append(" ");
                }
                result.append("\n");
            }
            System.out.print(result);
        }
    }
}

class FastReader {
    private final BufferedReader br;
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

    public int[] nextIntArray(int n) {
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = nextInt();
        }
        return array;
    }

    public long[] nextLongArray(int n) {
        long[] array = new long[n];
        for (int i = 0; i < n; i++) {
            array[i] = nextLong();
        }
        return array;
    }

    public double[] nextDoubleArray(int n) {
        double[] array = new double[n];
        for (int i = 0; i < n; i++) {
            array[i] = nextDouble();
        }
        return array;
    }

    public String[] nextStringArray(int n) {
        String[] array = new String[n];
        for (int i = 0; i < n; i++) {
            array[i] = next();
        }
        return array;
    }
}