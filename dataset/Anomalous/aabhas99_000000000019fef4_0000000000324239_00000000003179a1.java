import java.io.*;
import java.util.*;
import java.math.*;

public class Solution {
    static final long MOD = 1000000007L;
    static final int MAX_INT = Integer.MAX_VALUE;
    static final int MIN_INT = Integer.MIN_VALUE;
    static final long MAX_LONG = Long.MAX_VALUE;
    static final long MIN_LONG = Long.MIN_VALUE;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int t = i();
        int ind = 0;

        while (t-- > 0) {
            ind++;
            int u = i();
            HashMap<Character, Long> h = new HashMap<>(9);
            HashSet<Character> c = new HashSet<>();
            HashSet<Character> a = new HashSet<>();
            char[] r = new char[10];
            String[][] ar = new String[10000][2];

            for (int x = 0; x < 10000; x++) {
                long i = l();
                String s = s();
                ar[x][0] = String.valueOf(i);
                ar[x][1] = s;
                if (s.length() == 1) {
                    c.add(s.charAt(0));
                    a.add(s.charAt(0));
                    h.put(s.charAt(0), h.getOrDefault(s.charAt(0), i));
                } else {
                    c.add(s.charAt(0));
                    c.add(s.charAt(1));
                }
            }

            char aa = ' ';
            for (char cc : c) {
                if (!a.contains(cc)) {
                    aa = cc;
                    break;
                }
            }

            for (int x = 0; x < 10000; x++) {
                if (ar[x][1].indexOf(aa) != -1) {
                    long k = Long.parseLong(ar[x][0]) / 10L;
                    h.put(ar[x][1].charAt(0), Math.min(h.getOrDefault(ar[x][1].charAt(0), k), k));
                } else if (ar[x][1].length() == 2 && ar[x][1].charAt(0) == ar[x][1].charAt(0)) {
                    long k = Long.parseLong(ar[x][0]) / 10L;
                    h.put(ar[x][1].charAt(0), Math.min(h.getOrDefault(ar[x][1].charAt(0), k), k));
                }
            }

            r[0] = aa;
            for (char v : h.keySet()) {
                r[(int) (long) h.get(v)] = v;
            }

            StringBuilder ss = new StringBuilder();
            for (int x = 0; x < 10; x++) {
                ss.append(r[x]);
            }

            pl("Case #" + ind + ": " + ss.toString());
        }
    }

    static int max(int a, int b) {
        return Math.max(a, b);
    }

    static int min(int a, int b) {
        return Math.min(a, b);
    }

    static long max(long a, long b) {
        return Math.max(a, b);
    }

    static long min(long a, long b) {
        return Math.min(a, b);
    }

    static long div(long a, long b, long m) {
        long r = 1L;
        a %= m;
        while (b > 0) {
            if ((b & 1) == 1) r = (r * a) % m;
            b >>= 1;
            a = (a * a) % m;
        }
        return r;
    }

    static int i() throws IOException {
        if (!st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
        return Integer.parseInt(st.nextToken());
    }

    static long l() throws IOException {
        if (!st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
        return Long.parseLong(st.nextToken());
    }

    static String s() throws IOException {
        if (!st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
        return st.nextToken();
    }

    static void pl(Object p) {
        System.out.println(p);
    }

    static void pl(String p) {
        System.out.println(p);
    }
}