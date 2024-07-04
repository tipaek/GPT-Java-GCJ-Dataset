import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        solve();
    }

    private static void solve() {
        try (Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int t = in.nextInt();
            for (int i = 1; i <= t; ++i) {
                int n = in.nextInt();
                int[][] matrix = readMatrix(in, n, n);
                int[] result = calculateResults(n, matrix);
                System.out.println("Case #" + i + ": " + formatResult(result));
            }
        }
    }

    private static int[] calculateResults(int n, int[][] matrix) {
        int trace = 0;
        for (int i = 0; i < n; i++) {
            trace += matrix[i][i];
        }

        int rowRepeats = 0;
        int colRepeats = 0;
        Set<Integer> uniqueValues = new HashSet<>();

        for (int i = 0; i < n; i++) {
            uniqueValues.clear();
            for (int j = 0; j < n; j++) {
                if (!uniqueValues.add(matrix[i][j])) {
                    rowRepeats++;
                    break;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            uniqueValues.clear();
            for (int j = 0; j < n; j++) {
                if (!uniqueValues.add(matrix[j][i])) {
                    colRepeats++;
                    break;
                }
            }
        }

        return new int[]{trace, rowRepeats, colRepeats};
    }

    private static int[][] readMatrix(Scanner in, int rows, int cols) {
        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = in.nextInt();
            }
        }
        return matrix;
    }

    private static String formatResult(int[] results) {
        return Arrays.stream(results)
                     .mapToObj(String::valueOf)
                     .collect(Collectors.joining(" "));
    }

    static final long MOD = 1_000_000_007;

    static long add(long a, long b) {
        long result = a + b;
        if (result < 0) {
            result += MOD;
        }
        return result % MOD;
    }

    static long multiply(long a, long b) {
        return (a * b) % MOD;
    }

    static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    static class FastScanner implements Closeable {
        private BufferedReader br;
        private StringTokenizer st;

        FastScanner(File file) {
            try {
                br = new BufferedReader(new FileReader(file));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
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

        @Override
        public void close() throws IOException {
            br.close();
        }
    }
}