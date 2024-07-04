import java.io.*;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        IncrementalHouseOfPancakes solver = new IncrementalHouseOfPancakes();
        int testCount = in.nextInt();
        for (int i = 1; i <= testCount; i++) {
            solver.solve(i, in, out);
        }
        out.close();
    }

    static class IncrementalHouseOfPancakes {

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            long l = in.nextLong();
            long r = in.nextLong();
            long max = Math.max(l, r);
            long min = Math.min(l, r);

            long low = 1;
            long high = (long) 2e9;
            while (low < high) {
                long mid = (low + high + 1) / 2;
                if (max - sum(mid) >= 0 && max - sum(mid) >= min) {
                    low = mid;
                } else {
                    high = mid - 1;
                }
            }

            long count = low;
            if (r > l) {
                r -= sum(count);
            } else {
                l -= sum(count);
            }

            long num = 0;
            while (Math.max(l, r) >= count + 1) {
                num++;
                boolean rFirst = r > l;

                if (Math.min(l, r) < count + 2) {
                    if (rFirst) {
                        r -= count + 1;
                    } else {
                        l -= count + 1;
                    }
                    count++;
                    break;
                }

                low = 1;
                high = ((long) 2e9 - count) / 2;
                while (low < high) {
                    long mid = (low + high + 1) / 2;
                    long m = count + mid * 2;
                    long f = sum2(count + 1, m % 2 == (count + 1) % 2 ? m : m - 1);
                    long s = sum2(count + 2, m % 2 == (count + 2) % 2 ? m : m - 1);
                    boolean good = rFirst ? r - f >= 0 && l - s >= 0 && r - f > l - s : r - s >= 0 && l - f >= 0 && l - f > r - s;
                    if (good) {
                        low = mid;
                    } else {
                        high = mid - 1;
                    }
                }

                long m = count + low * 2;
                long f = sum2(count + 1, m % 2 == (count + 1) % 2 ? m : m - 1);
                long s = sum2(count + 2, m % 2 == (count + 2) % 2 ? m : m - 1);
                if (rFirst) {
                    r -= f;
                    l -= s;
                } else {
                    r -= s;
                    l -= f;
                }
                count += low * 2;
            }

            out.printf("Case #%d: %d %d %d%n", testNumber, count, l, r);
        }

        static long sum2(long from, long to) {
            long count = (to - from) / 2 + 1;
            return from * count + sum(count - 1) * 2;
        }

        static long sum(long n) {
            return (1 + n) * n / 2;
        }
    }

    static class InputReader {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }
    }
}