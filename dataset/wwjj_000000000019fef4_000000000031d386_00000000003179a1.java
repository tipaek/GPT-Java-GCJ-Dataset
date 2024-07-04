import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        try (PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out))) {
            _Scanner sc = new _Scanner(System.in);

            int T = sc.nextInt();
            nextT:
            for (int t = 0; t < T; t++) {
                int u = sc.nextInt();

                int[] cntsOne = new int[30];
                int[] cnts = new int[30];
                Set<Character> seen = new HashSet<>();

                for (int i = 0; i < 10_000; i++) {
                    long qi = sc.nextLong();
                    String s = sc.next();

                    for (int j = 0; j < s.length(); j++) seen.add(s.charAt(j));

                    char head = s.charAt(0);
                    cnts[head - 'A']++;
                    cntsOne[head - 'A']++;
                }

                List<X> list = new ArrayList<>();
                for (int i = 0; i < cnts.length; i++) {
                    int cnt = cnts[i];
//                    System.out.println(String.format("%s: %,d", ((char) ('A' + i)), cnt));
                    if (cnt > 0) list.add(new X((char) ('A' + i), cnt));
                }

                list.sort(Comparator.comparing(x -> x.cnt));

                StringBuilder sb = new StringBuilder();
                if (list.size() == 10) {
                    sb.append(list.get(0).c);
                    for (int i = list.size() - 1; i > 0; i--) {
                        sb.append(list.get(i).c);
                    }

                } else {
                    for (X x : list) seen.remove(x.c);
                    sb.append(seen.iterator().next());
                    for (int i = list.size() - 1; i >= 0; i--) {
                        sb.append(list.get(i).c);
                    }
                }

                out.println(String.format("Case #%s: %s", t + 1, sb));

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
