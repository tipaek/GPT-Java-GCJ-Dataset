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
                handleCase(tc, k, 2, new int[][]{
                        {1, 2},
                        {2, 1},
                        {2, 1},
                        {1, 2}
                }, new int[]{2, 4});
            } else if (n == 3) {
                handleCase(tc, k, 3, new int[][]{
                        {1, 3, 2},
                        {2, 1, 3},
                        {3, 2, 1},
                        {2, 3, 1},
                        {1, 2, 3},
                        {3, 1, 2},
                        {3, 2, 1},
                        {1, 3, 2},
                        {2, 1, 3}
                }, new int[]{3, 6, 9});
            } else if (n == 4) {
                handleCase(tc, k, 4, new int[][]{
                        {1, 2, 3, 4},
                        {4, 1, 2, 3},
                        {3, 4, 1, 2},
                        {2, 3, 4, 1},
                        {2, 3, 4, 1},
                        {1, 2, 3, 4},
                        {4, 1, 2, 3},
                        {3, 4, 1, 2},
                        {3, 4, 1, 2},
                        {2, 3, 4, 1},
                        {1, 2, 3, 4},
                        {4, 1, 2, 3},
                        {4, 1, 2, 3},
                        {3, 4, 1, 2},
                        {2, 3, 4, 1},
                        {1, 2, 3, 4},
                        {1, 2, 4, 3},
                        {2, 1, 3, 4},
                        {4, 3, 2, 1},
                        {3, 4, 1, 2},
                        {1, 4, 3, 2},
                        {4, 1, 2, 3},
                        {2, 3, 4, 1},
                        {3, 2, 1, 4},
                        {3, 4, 1, 2},
                        {4, 3, 2, 1},
                        {1, 2, 4, 3},
                        {2, 1, 3, 4},
                        {1, 2, 3, 4},
                        {3, 1, 4, 2},
                        {4, 3, 2, 1},
                        {2, 4, 1, 3},
                        {2, 4, 1, 3},
                        {1, 2, 3, 4},
                        {3, 1, 4, 2},
                        {4, 3, 2, 1},
                        {4, 3, 2, 1},
                        {2, 4, 1, 3},
                        {1, 2, 3, 4},
                        {3, 1, 4, 2},
                        {3, 1, 4, 2},
                        {4, 3, 2, 1},
                        {2, 4, 1, 3},
                        {1, 2, 3, 4}
                }, new int[]{4, 6, 7, 8, 9, 10, 11, 12, 13, 14, 16});
            } else if (n == 5) {
                handleCase(tc, k, 5, new int[][]{
                        {1, 2, 3, 4, 5},
                        {5, 1, 2, 3, 4},
                        {4, 5, 1, 2, 3},
                        {3, 4, 5, 1, 2},
                        {2, 3, 4, 5, 1},
                        {2, 3, 4, 5, 1},
                        {1, 2, 3, 4, 5},
                        {5, 1, 2, 3, 4},
                        {4, 5, 1, 2, 3},
                        {3, 4, 5, 1, 2},
                        {3, 4, 5, 1, 2},
                        {2, 3, 4, 5, 1},
                        {1, 2, 3, 4, 5},
                        {5, 1, 2, 3, 4},
                        {4, 5, 1, 2, 3},
                        {4, 5, 1, 2, 3},
                        {3, 4, 5, 1, 2},
                        {2, 3, 4, 5, 1},
                        {1, 2, 3, 4, 5},
                        {5, 1, 2, 3, 4},
                        {1, 2, 3, 4, 5},
                        {4, 1, 2, 5, 3},
                        {2, 5, 1, 3, 4},
                        {3, 4, 5, 2, 1},
                        {5, 3, 4, 1, 2},
                        {2, 3, 4, 5, 1},
                        {1, 2, 5, 3, 4},
                        {5, 1, 3, 4, 2},
                        {4, 5, 2, 1, 3},
                        {3, 4, 1, 2, 5},
                        {3, 4, 5, 1, 2},
                        {2, 5, 3, 4, 1},
                        {1, 3, 4, 2, 5},
                        {5, 2, 1, 3, 4},
                        {4, 1, 2, 5, 3},
                        {4, 5, 1, 2, 3},
                        {5, 3, 4, 1, 2},
                        {3, 4, 2, 5, 1},
                        {2, 1, 3, 4, 5},
                        {1, 2, 5, 3, 4},
                        {1, 3, 2, 4, 5},
                        {4, 1, 3, 5, 2},
                        {3, 5, 1, 2, 4},
                        {2, 4, 5, 3, 1},
                        {5, 2, 4, 1, 3},
                        {1, 4, 2, 3, 5},
                        {3, 1, 4, 5, 2},
                        {4, 5, 1, 2, 3},
                        {2, 3, 5, 4, 1},
                        {5, 2, 3, 1, 4},
                        {5, 2, 3, 1, 4},
                        {1, 4, 2, 3, 5},
                        {3, 1, 4, 5, 2},
                        {4, 5, 1, 2, 3},
                        {2, 3, 5, 4, 1},
                        {3, 1, 4, 5, 2},
                        {4, 5, 1, 2, 3},
                        {2, 3, 5, 4, 1},
                        {5, 2, 3, 1, 4},
                        {1, 4, 2, 3, 5},
                        {5, 4, 2, 3, 1},
                        {3, 5, 4, 1, 2},
                        {4, 1, 5, 2, 3},
                        {2, 3, 1, 4, 5},
                        {1, 2, 3, 5, 4},
                        {2, 5, 1, 4, 3},
                        {1, 2, 5, 3, 4},
                        {3, 4, 2, 5, 1},
                        {5, 3, 4, 1, 2},
                        {4, 1, 3, 2, 5},
                        {5, 3, 2, 4, 1},
                        {4, 5, 3, 1, 2},
                        {3, 1, 5, 2, 4},
                        {2, 4, 1, 3, 5},
                        {1, 2, 4, 5, 3},
                        {2, 1, 3, 4, 5},
                        {4, 2, 1, 5, 3},
                        {1, 5, 2, 3, 4},
                        {3, 4, 5, 1, 2},
                        {5, 3, 4, 2, 1},
                        {4, 5, 3, 2, 1},
                        {2, 4, 5, 1, 3},
                        {5, 1, 4, 3, 2},
                        {3, 2, 1, 5, 4},
                        {1, 3, 2, 4, 5}
                }, new int[]{5, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 25});
            } else {
                out.println("Case #" + tc + ": " + IMPOSSIBLE);
            }
        }
    }

    void handleCase(int tc, int k, int n, int[][] arrangements, int[] validSums) {
        String IMPOSSIBLE = "IMPOSSIBLE";
        String POSSIBLE = "POSSIBLE";
        boolean found = false;

        for (int i = 0; i < validSums.length; i++) {
            if (k == validSums[i]) {
                out.println("Case #" + tc + ": " + POSSIBLE);
                for (int j = 0; j < n; j++) {
                    for (int l = 0; l < n; l++) {
                        out.print(arrangements[i * n + j][l] + " ");
                    }
                    out.println();
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
            tokenizer = null;
        }

        public FastReader(File f) {
            try {
                br = new BufferedReader(new FileReader(f));
                tokenizer = null;
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        private String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public String nextLine() {
            try {
                return br.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
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

        public BigInteger nextBigInteger() {
            return new BigInteger(next());
        }

        public BigDecimal nextBigDecimal() {
            return new BigDecimal(next());
        }
    }
}