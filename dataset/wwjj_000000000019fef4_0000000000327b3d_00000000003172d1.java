import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Solution {

    public static void main(String[] args) {
        try (PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out))) {
            _Scanner sc = new _Scanner(System.in);

            int T = sc.nextInt();
            nextT:
            for (int t = 0; t < T; t++) {

                int n = sc.nextInt();
                int d = sc.nextInt();

                List<Long> ss = new ArrayList<>();
                Map<Long, Integer> freqs = new HashMap<>();
                for (int i = 0; i < n; i++) {
                    long cur = sc.nextLong();
                    if (!freqs.containsKey(cur)) ss.add(cur);
                    freqs.merge(cur, 1, Integer::sum);
                }
                Collections.sort(ss);

                int min = d - 1;
                for (int i = 0; i < ss.size(); i++) {
                    long slice = ss.get(i);

                    int[] dp = new int[d + 1];
                    Arrays.fill(dp, Integer.MAX_VALUE / 2);

                    Integer cnt = Math.min(freqs.get(slice), d);
                    dp[cnt] = 0;

                    for (int j = i + 1; j < ss.size(); j++) {
                        long s = ss.get(j);
                        boolean even = s % slice == 0;
                        long num = s / slice;

                        for (int k = cnt + 1; k < dp.length; k++) {
                            for (int l = 1; l <= Math.min(num, 60); l++) if (k - l >= cnt) {
                                dp[k] = Math.min(dp[k], dp[k - l] + l + (l == num && even ? -1 : 0));
                            }
                        }
                    }

                    min = Math.min(min, dp[d]);
                }

                out.println(String.format("Case #%s: %s", t + 1, min));

            }
        }
    }

    private static class X {
    	char c;
    	int cnt;

        public X(char c, int cnt) {
            this.c = c;
            this.cnt = cnt;
        }
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
