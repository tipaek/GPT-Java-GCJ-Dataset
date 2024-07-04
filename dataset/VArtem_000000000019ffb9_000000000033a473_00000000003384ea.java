import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        FastScanner in = new FastScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        IncrementalHouseOfPancakes solver = new IncrementalHouseOfPancakes();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class IncrementalHouseOfPancakes {
        public void solve(int testNumber, FastScanner in, PrintWriter out) {
            out.printf("Case #%d: ", testNumber);
            long l = in.nextLong(), r = in.nextLong();

            long n = 0;
            {
                long left = 0, right = (long) 2e9;
                while (left < right - 1) {
                    long mid = (left + right) / 2;
                    long sum = sum(1, mid, 1);
                    if (Math.max(l, r) - sum < Math.min(l, r)) {
                        right = mid;
                    } else {
                        left = mid;
                    }
                }

                n += left;
                if (l >= r) {
                    l -= sum(1, left, 1);
                } else {
                    r -= sum(1, left, 1);
                }
            }

            {
                long left = 0, right = (long) 2e9;
                while (left < right - 1) {
                    long mid = (left + right) / 2;
                    long smallerSum = sum(n + 2, mid, 2);
                    if (Math.min(l, r) >= smallerSum) {
                        left = mid;
                    } else {
                        right = mid;
                    }
                }

                long largerSum = sum(n + 1, left, 2);
                long smallerSum = sum(n + 2, left, 2);
                n += 2 * left;
                if (l >= r) {
                    l -= largerSum;
                    r -= smallerSum;
                } else {
                    r -= largerSum;
                    l -= smallerSum;
                }
            }

            while (true) {
                if (l >= r) {
                    if (l >= n + 1) {
                        l -= n + 1;
                        n++;
                    } else {
                        break;
                    }
                } else {
                    if (r >= n + 1) {
                        r -= n + 1;
                        n++;
                    } else {
                        break;
                    }
                }
            }
            out.println(n + " " + l + " " + r);
        }

        long sum(long start, long count, long step) {
            return (start + start + (count - 1) * step) * count / 2;
        }

    }

    static class FastScanner {
        public BufferedReader br;
        public StringTokenizer st;

        public FastScanner(InputStream in) {
            br = new BufferedReader(new InputStreamReader(in));
        }

        public FastScanner(String fileName) {
            try {
                br = new BufferedReader(new FileReader(fileName));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        public String next() {
            while (st == null || !st.hasMoreElements()) {
                String line = null;
                try {
                    line = br.readLine();
                } catch (IOException e) {
                }
                st = new StringTokenizer(line);
            }
            return st.nextToken();
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

    }
}

