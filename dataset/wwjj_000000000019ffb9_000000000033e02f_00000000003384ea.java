import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Random;

public class Solution {
    static PrintWriter out;
    public static void main(String[] args) throws IOException {
//        try (PrintWriter out1 = new PrintWriter(Files.newBufferedWriter(Paths.get("out.txt")))) {
//            _Scanner sc = new _Scanner(Files.newInputStream(Paths.get("in.txt")));
        try (PrintWriter out1 = new PrintWriter(new BufferedOutputStream(System.out))) {
            _Scanner sc = new _Scanner(System.in);

            out = out1;
            long limit = 10_000_000_000L;

            int t = sc.nextInt();
            for (int ti = 0; ti < t; ti++) {
                long l = sc.nextLong();
                long r = sc.nextLong();

                boolean swap = false;
                if (l < r) swap = true;

                long diff = Math.max(l, r) - Math.min(l, r);

                long a = 0;
                for (long step = limit; step > 0; step /= 2) {
                    while (a + step < limit && num(a + step) <= diff) a += step;
                }

                long initialCustomers = a;
//                out.println(String.format("initialCustomers = %,d", initialCustomers));
                long x = Math.max(l, r) - num(a);
                long y = Math.min(l, r);

                if (x == y && swap) swap = false;

//                out.println(String.format("x = %s", x));
//                out.println(String.format("y = %s", y));

                a = 0;
                for (long step = limit; step > 0; step /= 2) {
                    while (a + step < limit && num1(initialCustomers, a + step) <= x + y) a += step;
                }

                long totalCustomers = a;
//                out.println(String.format("totalCustomers = %,d", totalCustomers));
                long laterCustomers = totalCustomers - initialCustomers;
//                out.println(String.format("laterCustomers = %,d", laterCustomers));

                long maxCust = (laterCustomers + 1) / 2;
//                out.println(String.format("maxCust = %,d", maxCust));
                long minCust = laterCustomers / 2;
//                out.println(String.format("minCust = %,d", minCust));

                boolean flag = maxCust > minCust;
                while (true) {
                    if (num3(initialCustomers - 1, maxCust) <= x &&
                            num3(initialCustomers, minCust) <= y) {

                        long r1 = x - num3(initialCustomers - 1, maxCust);
                        long r2 = y - num3(initialCustomers, minCust);
                        out.println(String.format("Case #%s: %s %s %s",
                                                  ti + 1,
                                                  initialCustomers + maxCust + minCust,
                                                  swap ? r2 : r1,
                                                  swap ? r1 : r2));
                        break;
                    }

                    if (flag) {
                        maxCust--;
                    } else {
                        minCust--;
                    }
                    flag = !flag;
                }
            }

        }
    }

    private static long num3(long initialCustomers, long maxCust) {
        long ret = initialCustomers * maxCust + num4(maxCust + 1);
//        out.println(String.format("ret = %s", ret));
        return ret;
    }

    private static long num4(long num) {
        return num * (2 * (num - 1)) / 2;
    }

    private static long num(long customers) {
        return customers * (customers + 1) / 2;
    }

    private static long num1(long initialCustomers, long customers) {
        return num(customers) - num(initialCustomers);
    }


    private static void reverse(int[] vs) {
        for (int i = 0; i < vs.length / 2; i++) {
            swap(vs, i, vs.length - 1 - i);
        }
    }

    static class _Scanner {
        InputStream is;
        _Scanner(InputStream is) {
            this.is = is;
        }
        byte[] bb = new byte[1 << 15];
        int k, l;
        byte getc() {
            try {
                if (k >= l) {
                    k = 0;
                    l = is.read(bb);
                    if (l < 0) return -1;
                }
                return bb[k++];
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        byte skip() {
            byte b;
            while ((b = getc()) <= 32)
                ;
            return b;
        }

        int nextInt() {
            int n = 0;
            int sig = 1;
            for (byte b = skip(); b > 32; b = getc()) {
                if (b == '-') {
                    sig = -1;
                } else {
                    n = n * 10 + b - '0';
                }
            }
            return sig * n;
        }

        long nextLong() {
            long n = 0;
            long sig = 1;
            for (byte b = skip(); b > 32; b = getc()) {
                if (b == '-') {
                    sig = -1;
                } else {
                    n = n * 10 + b - '0';
                }
            }
            return sig * n;
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        public String next() {
            StringBuilder sb = new StringBuilder();
            for (int b = skip(); b > 32; b = getc()) {
                sb.append(((char) b));
            }
            return sb.toString();
        }
    }

    private static void shuffle(int[] ar) {
        Random rnd = new Random();
        shuffle(ar, rnd);
    }

    private static void shuffle(int[] ar, Random rnd) {
        for (int i = 0; i < ar.length; i++) {
            int j = i + rnd.nextInt(ar.length - i);
            swap(ar, i, j);
        }
    }

    private static void shuffle(Object[] ar) {
        Random rnd = new Random();
        for (int i = 0; i < ar.length; i++) {
            int j = i + rnd.nextInt(ar.length - i);
            swap(ar, i, j);
        }
    }

    private static void swap(int[] ar, int i, int j) {
        int t = ar[i];
        ar[i] = ar[j];
        ar[j] = t;
    }

    private static void swap(Object[] ar, int i, int j) {
        Object t = ar[i];
        ar[i] = ar[j];
        ar[j] = t;
    }

}
