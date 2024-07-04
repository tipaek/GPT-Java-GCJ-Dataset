import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.*;

public class Solution {

    private void getAns(InputReader in, PrintWriter out, long a, long b) {
        final long r = search(in, out);

        boolean isCenterLow = false;
        for (int i = 0; i < 20; i++) {
            print(out, r, -i);

            String ans = in.next();
            if (ans.equals("HIT")) {
                print(out, r + 1, -i);

                String sec = in.next();
                if (sec.equals("HIT")) {
                    isCenterLow = true;
                    break;
                }
            } else if (ans.equals("MISS")) {
                isCenterLow = false;
                break;
            } else {
                throw new IllegalStateException();
            }
        }

        if (isCenterLow) {
            long cur = r;
            long resX = r;
            long resY = 0;
            for (int i = 0; i < 60; i++) {
                print(out, cur, -i);
                String ans = in.next();

                if (ans.equals("MISS")) {
                    break;
                }

                while (ans.equals("HIT")) {
                    resX = cur;
                    resY = -i;

                    cur++;

                    print(out, cur, -i);
                    ans = in.next();
                }
            }

            print(out, resX - a, resY);
            String ans = in.next();

            if (!ans.equals("CENTER")) {
                throw new IllegalStateException();
            }
        } else {
            long cur = r;
            long resX = r;
            long resY = 0;
            for (int i = 0; i < 60; i++) {
                print(out, cur, i);
                String ans = in.next();

                if (ans.equals("MISS")) {
                    break;
                }

                while (ans.equals("HIT")) {
                    resX = cur;
                    resY = i;

                    cur++;

                    print(out, cur, i);
                    ans = in.next();
                }
            }

            print(out, resX - a, resY);
            String ans = in.next();

            if (!ans.equals("CENTER")) {
                throw new IllegalStateException();
            }
        }
    }

    private long search(InputReader in, PrintWriter out) {
        long lo = 0;
        long hi = 1_000_000_002;

        while (lo < hi) {
            long mid = (lo + hi + 1) / 2;

            if (ok(in, out, mid)) {
                lo = mid;
            } else {
                hi = mid - 1;
            }
        }

        return lo;
    }

    boolean ok(InputReader in, PrintWriter out, long cur) {
        print(out, cur, 0);

        String ans = in.next();
        if (ans.equals("HIT")) {
            return true;
        } else if (ans.equals("MISS")) {
            return false;
        } else {
            throw new IllegalStateException();
        }
    }

    private void print(PrintWriter out, long x, long y) {
        out.println(x + " " + y);
        out.flush();
    }


    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream, true);

        int testCount = in.nextInt();
        long a = in.nextLong();
        long b = in.nextLong();
        for (int i = 0; i < testCount; i++) {
            new Solution().getAns(in, out, a, b);
        }

        out.close();
    }

    static void write(PrintWriter out, String s) {
        out.println(s);
        out.flush();
    }

    static void writeTestCase(PrintWriter writer, int num, Object res) {
        writer.println(String.format("Case #%d: %s", num, res.toString()));
    }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream));
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

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public int[] nextIntArr(int n) {
            int[] arr = new int[n];
            for (int j = 0; j < arr.length; j++) {
                arr[j] = nextInt();
            }

            return arr;
        }

        public long[] nextLongArr(int n) {
            long[] arr = new long[n];
            for (int j = 0; j < arr.length; j++) {
                arr[j] = nextLong();
            }

            return arr;
        }

        public double[] nextDoubleArr(int n) {
            double[] arr = new double[n];
            for (int j = 0; j < arr.length; j++) {
                arr[j] = nextDouble();
            }

            return arr;
        }
    }
}