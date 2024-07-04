import java.io.*;
import java.math.*;
import java.util.*;

public class Solution {
    private FastReader in;
    private PrintWriter out;

    public static void main(String[] args) {
        new Solution().run();
    }

    private void run() {
        in = new FastReader(System.in);
        out = new PrintWriter(System.out);
        solve();
        out.close();
    }

    private void solve() {
        int T = in.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            int n = in.nextInt();
            int k = in.nextInt();
            String result = getResult(n, k);
            out.println("Case #" + tc + ": " + result);
        }
    }

    private String getResult(int n, int k) {
        final String IMPOSSIBLE = "IMPOSSIBLE";
        final String POSSIBLE = "POSSIBLE";
        StringBuilder sb = new StringBuilder();

        if (n == 2) {
            if (k == 2) {
                sb.append(POSSIBLE).append("\n1 2\n2 1");
            } else if (k == 4) {
                sb.append(POSSIBLE).append("\n2 1\n1 2");
            } else {
                return IMPOSSIBLE;
            }
        } else if (n == 3) {
            if (k == 3) {
                sb.append(POSSIBLE).append("\n1 3 2\n2 1 3\n3 2 1");
            } else if (k == 6) {
                sb.append(POSSIBLE).append("\n2 3 1\n1 2 3\n3 1 2");
            } else if (k == 9) {
                sb.append(POSSIBLE).append("\n3 2 1\n1 3 2\n2 1 3");
            } else {
                return IMPOSSIBLE;
            }
        } else if (n == 4) {
            switch (k) {
                case 4:
                    sb.append(POSSIBLE).append("\n1 2 3 4\n4 1 2 3\n3 4 1 2\n2 3 4 1");
                    break;
                case 8:
                    sb.append(POSSIBLE).append("\n2 3 4 1\n1 2 3 4\n4 1 2 3\n3 4 1 2");
                    break;
                case 12:
                    sb.append(POSSIBLE).append("\n3 4 1 2\n2 3 4 1\n1 2 3 4\n4 1 2 3");
                    break;
                case 16:
                    sb.append(POSSIBLE).append("\n4 1 2 3\n3 4 1 2\n2 3 4 1\n1 2 3 4");
                    break;
                case 6:
                    sb.append(POSSIBLE).append("\n1 2 4 3\n2 1 3 4\n4 3 2 1\n3 4 1 2");
                    break;
                case 10:
                    sb.append(POSSIBLE).append("\n1 4 3 2\n4 1 2 3\n2 3 4 1\n3 2 1 4");
                    break;
                case 14:
                    sb.append(POSSIBLE).append("\n3 4 1 2\n4 3 2 1\n1 2 4 3\n2 1 3 4");
                    break;
                case 7:
                    sb.append(POSSIBLE).append("\n1 2 3 4\n3 1 4 2\n4 3 2 1\n2 4 1 3");
                    break;
                case 9:
                    sb.append(POSSIBLE).append("\n2 4 1 3\n1 2 3 4\n3 1 4 2\n4 3 2 1");
                    break;
                case 13:
                    sb.append(POSSIBLE).append("\n4 3 2 1\n2 4 1 3\n1 2 3 4\n3 1 4 2");
                    break;
                case 11:
                    sb.append(POSSIBLE).append("\n3 1 4 2\n4 3 2 1\n2 4 1 3\n1 2 3 4");
                    break;
                default:
                    return IMPOSSIBLE;
            }
        } else if (n == 5) {
            switch (k) {
                case 5:
                    sb.append(POSSIBLE).append("\n1 2 3 4 5\n5 1 2 3 4\n4 5 1 2 3\n3 4 5 1 2\n2 3 4 5 1");
                    break;
                case 10:
                    sb.append(POSSIBLE).append("\n2 3 4 5 1\n1 2 3 4 5\n5 1 2 3 4\n4 5 1 2 3\n3 4 5 1 2");
                    break;
                case 15:
                    sb.append(POSSIBLE).append("\n3 4 5 1 2\n2 3 4 5 1\n1 2 3 4 5\n5 1 2 3 4\n4 5 1 2 3");
                    break;
                case 20:
                    sb.append(POSSIBLE).append("\n4 5 1 2 3\n3 4 5 1 2\n2 3 4 5 1\n1 2 3 4 5\n5 1 2 3 4");
                    break;
                case 25:
                    sb.append(POSSIBLE).append("\n5 1 2 3 4\n4 5 1 2 3\n3 4 5 1 2\n2 3 4 5 1\n1 2 3 4 5");
                    break;
                case 7:
                    sb.append(POSSIBLE).append("\n1 2 3 4 5\n4 1 2 5 3\n2 5 1 3 4\n3 4 5 2 1\n5 3 4 1 2");
                    break;
                case 13:
                    sb.append(POSSIBLE).append("\n2 3 4 5 1\n1 2 5 3 4\n5 1 3 4 2\n4 5 2 1 3\n3 4 1 2 5");
                    break;
                case 18:
                    sb.append(POSSIBLE).append("\n3 4 5 1 2\n2 5 3 4 1\n1 3 4 2 5\n5 2 1 3 4\n4 1 2 5 3");
                    break;
                case 17:
                    sb.append(POSSIBLE).append("\n4 5 1 2 3\n5 3 4 1 2\n3 4 2 5 1\n2 1 3 4 5\n1 2 5 3 4");
                    break;
                case 9:
                    sb.append(POSSIBLE).append("\n1 3 2 4 5\n4 1 3 5 2\n3 5 1 2 4\n2 4 5 3 1\n5 2 4 1 3");
                    break;
                case 14:
                    sb.append(POSSIBLE).append("\n5 2 4 1 3\n1 3 2 4 5\n4 1 3 5 2\n3 5 1 2 4\n2 4 5 3 1");
                    break;
                case 11:
                    sb.append(POSSIBLE).append("\n1 4 2 3 5\n3 1 4 5 2\n4 5 1 2 3\n2 3 5 4 1\n5 2 3 1 4");
                    break;
                case 16:
                    sb.append(POSSIBLE).append("\n5 2 3 1 4\n1 4 2 3 5\n3 1 4 5 2\n4 5 1 2 3\n2 3 5 4 1");
                    break;
                case 19:
                    sb.append(POSSIBLE).append("\n3 1 4 5 2\n4 5 1 2 3\n2 3 5 4 1\n5 2 3 1 4\n1 4 2 3 5");
                    break;
                case 23:
                    sb.append(POSSIBLE).append("\n5 4 2 3 1\n3 5 4 1 2\n4 1 5 2 3\n2 3 1 4 5\n1 2 3 5 4");
                    break;
                case 12:
                    sb.append(POSSIBLE).append("\n2 3 1 4 5\n1 2 3 5 4\n5 4 2 3 1\n3 5 4 1 2\n4 1 5 2 3");
                    break;
                case 21:
                    sb.append(POSSIBLE).append("\n5 3 2 4 1\n4 5 3 1 2\n3 1 5 2 4\n2 4 1 3 5\n1 2 4 5 3");
                    break;
                case 8:
                    sb.append(POSSIBLE).append("\n2 1 3 4 5\n4 2 1 5 3\n1 5 2 3 4\n3 4 5 1 2\n5 3 4 2 1");
                    break;
                case 22:
                    sb.append(POSSIBLE).append("\n4 5 3 2 1\n2 4 5 1 3\n5 1 4 3 2\n3 2 1 5 4\n1 3 2 4 5");
                    break;
                default:
                    return IMPOSSIBLE;
            }
        } else {
            return IMPOSSIBLE;
        }
        return sb.toString();
    }

    private class FastReader {
        private BufferedReader br;
        private StringTokenizer tokenizer;

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