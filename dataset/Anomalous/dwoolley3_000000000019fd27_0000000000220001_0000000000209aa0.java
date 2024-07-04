import java.io.*;
import java.math.*;
import java.util.*;

public class Solution {
    FastReader in;
    PrintWriter out;

    public static void main(String[] args) {
        new Solution().run();
    }

    void run() {
        in = new FastReader(System.in);
        out = new PrintWriter(System.out);
        solve();
        out.close();
    }

    void solve() {
        int T = in.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            int n = in.nextInt();
            int k = in.nextInt();
            String IMPOSSIBLE = "IMPOSSIBLE";
            String POSSIBLE = "POSSIBLE";

            if (n == 2) {
                handleCase(tc, k, new int[][]{{1, 2}, {2, 1}}, new int[][]{{2, 1}, {1, 2}}, IMPOSSIBLE, POSSIBLE);
            } else if (n == 3) {
                handleCase(tc, k, new int[][]{{1, 3, 2}, {2, 1, 3}, {3, 2, 1}}, 
                                new int[][]{{2, 3, 1}, {1, 2, 3}, {3, 1, 2}}, 
                                new int[][]{{3, 2, 1}, {1, 3, 2}, {2, 1, 3}}, IMPOSSIBLE, POSSIBLE);
            } else if (n == 4) {
                handleCase(tc, k, new int[][]{{1, 2, 3, 4}, {4, 1, 2, 3}, {3, 4, 1, 2}, {2, 3, 4, 1}}, 
                                new int[][]{{2, 3, 4, 1}, {1, 2, 3, 4}, {4, 1, 2, 3}, {3, 4, 1, 2}}, 
                                new int[][]{{3, 4, 1, 2}, {2, 3, 4, 1}, {1, 2, 3, 4}, {4, 1, 2, 3}}, 
                                new int[][]{{4, 1, 2, 3}, {3, 4, 1, 2}, {2, 3, 4, 1}, {1, 2, 3, 4}}, IMPOSSIBLE, POSSIBLE);
            } else if (n == 5) {
                handleCase(tc, k, new int[][]{{1, 2, 3, 4, 5}, {5, 1, 2, 3, 4}, {4, 5, 1, 2, 3}, {3, 4, 5, 1, 2}, {2, 3, 4, 5, 1}}, 
                                new int[][]{{2, 3, 4, 5, 1}, {1, 2, 3, 4, 5}, {5, 1, 2, 3, 4}, {4, 5, 1, 2, 3}, {3, 4, 5, 1, 2}}, 
                                new int[][]{{3, 4, 5, 1, 2}, {2, 3, 4, 5, 1}, {1, 2, 3, 4, 5}, {5, 1, 2, 3, 4}, {4, 5, 1, 2, 3}}, 
                                new int[][]{{4, 5, 1, 2, 3}, {3, 4, 5, 1, 2}, {2, 3, 4, 5, 1}, {1, 2, 3, 4, 5}, {5, 1, 2, 3, 4}}, 
                                new int[][]{{5, 1, 2, 3, 4}, {4, 5, 1, 2, 3}, {3, 4, 5, 1, 2}, {2, 3, 4, 5, 1}, {1, 2, 3, 4, 5}}, IMPOSSIBLE, POSSIBLE);
            } else {
                out.println("Case #" + tc + ": " + IMPOSSIBLE);
            }
        }
    }

    void handleCase(int tc, int k, int[][]... matrices) {
        String IMPOSSIBLE = "IMPOSSIBLE";
        String POSSIBLE = "POSSIBLE";
        boolean found = false;
        for (int[][] matrix : matrices) {
            if (Arrays.stream(matrix).flatMapToInt(Arrays::stream).sum() == k) {
                out.println("Case #" + tc + ": " + POSSIBLE);
                for (int[] row : matrix) {
                    out.println(Arrays.toString(row).replaceAll("[\\[\\],]", ""));
                }
                found = true;
                break;
            }
        }
        if (!found) {
            out.println("Case #" + tc + ": " + IMPOSSIBLE);
        }
    }

    class FastReader {
        BufferedReader br;
        StringTokenizer tokenizer;

        public FastReader(InputStream stream) {
            br = new BufferedReader(new InputStreamReader(stream));
        }

        public FastReader(File file) {
            try {
                br = new BufferedReader(new FileReader(file));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        String nextLine() {
            try {
                return br.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
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

        BigInteger nextBigInteger() {
            return new BigInteger(next());
        }

        BigDecimal nextBigDecimal() {
            return new BigDecimal(next());
        }
    }
}