import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.*;

public class Solution {

    private static final int MAXN = 5000;
    private static final String NO = "NO";
    private static final String YES = "YES";
    private static final long MOD = 1000000007L;
    private InputStream is;
    private PrintWriter out;
    private String INPUT = "";

    void solve() {
        int Q = ni();
        for (int q = 1; q <= Q; q++) {
            int U = ni();
            Map<Character, Integer> singleDigitFreq = new HashMap<>();
            Map<Character, Integer> multiDigitFreq = new HashMap<>();
            for (int i = 0; i < 10000; i++) {
                int n = ni();
                char[] digits = ns().toCharArray();
                Map<Character, Integer> targetMap = digits.length > 1 ? multiDigitFreq : singleDigitFreq;
                for (char digit : digits) {
                    targetMap.put(digit, targetMap.getOrDefault(digit, 0) + 1);
                }
            }

            List<Map.Entry<Character, Integer>> sortedMultiDigitFreq = sortByValue(multiDigitFreq);

            char[] answer = new char[10];
            int index = 1;
            for (int i = sortedMultiDigitFreq.size() - 1; i >= 0; i--) {
                char key = sortedMultiDigitFreq.get(i).getKey();
                if (singleDigitFreq.containsKey(key)) {
                    answer[index++] = key;
                } else {
                    answer[0] = key;
                }
            }
            out.println("Case #" + q + ": " + new String(answer));
        }
    }

    public static <K, V extends Comparable<? super V>> List<Map.Entry<K, V>> sortByValue(Map<K, V> map) {
        List<Map.Entry<K, V>> list = new ArrayList<>(map.entrySet());
        list.sort(Map.Entry.comparingByValue());
        return list;
    }

    long power(long a, long b) {
        long result = 1;
        long base = a;
        while (b > 0) {
            if (b % 2 != 0) {
                result = (result * base) % MOD;
            }
            base = (base * base) % MOD;
            b /= 2;
        }
        return result % MOD;
    }

    private long gcd(long a, long b) {
        while (a != 0) {
            long temp = b % a;
            b = a;
            a = temp;
        }
        return b;
    }

    void run() throws Exception {
        is = INPUT.isEmpty() ? System.in : new ByteArrayInputStream(INPUT.getBytes());
        out = new PrintWriter(System.out);

        long startTime = System.currentTimeMillis();
        solve();
        out.flush();
        if (!INPUT.isEmpty()) {
            tr(System.currentTimeMillis() - startTime + "ms");
        }
    }

    public static void main(String[] args) throws Exception {
        new Solution().run();
    }

    private byte[] inbuf = new byte[1024];
    private int lenbuf = 0, ptrbuf = 0;

    private int readByte() {
        if (lenbuf == -1) throw new InputMismatchException();
        if (ptrbuf >= lenbuf) {
            ptrbuf = 0;
            try {
                lenbuf = is.read(inbuf);
            } catch (IOException e) {
                throw new InputMismatchException();
            }
            if (lenbuf <= 0) return -1;
        }
        return inbuf[ptrbuf++];
    }

    private boolean isSpaceChar(int c) {
        return !(c >= 33 && c <= 126);
    }

    private int skip() {
        int b;
        while ((b = readByte()) != -1 && isSpaceChar(b)) ;
        return b;
    }

    private double nd() {
        return Double.parseDouble(ns());
    }

    private char nc() {
        return (char) skip();
    }

    private String ns() {
        int b = skip();
        StringBuilder sb = new StringBuilder();
        while (!isSpaceChar(b)) {
            sb.appendCodePoint(b);
            b = readByte();
        }
        return sb.toString();
    }

    private char[] ns(int n) {
        char[] buf = new char[n];
        int b = skip(), p = 0;
        while (p < n) {
            if (!isSpaceChar(b)) buf[p++] = (char) b;
            b = readByte();
        }
        return p == n ? buf : Arrays.copyOf(buf, p);
    }

    private char[][] nm(int n, int m) {
        char[][] map = new char[n][];
        for (int i = 0; i < n; i++) {
            map[i] = ns(m);
        }
        return map;
    }

    private int[] na(int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = ni();
        }
        return a;
    }

    private List<Integer> na2(int n) {
        List<Integer> a = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            a.add(ni());
        }
        return a;
    }

    private int[][] na(int n, int m) {
        int[][] a = new int[n][];
        for (int i = 0; i < n; i++) {
            a[i] = na(m);
        }
        return a;
    }

    private int ni() {
        int num = 0, b;
        boolean minus = false;
        while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-')) ;
        if (b == '-') {
            minus = true;
            b = readByte();
        }

        while (true) {
            if (b >= '0' && b <= '9') {
                num = num * 10 + (b - '0');
            } else {
                return minus ? -num : num;
            }
            b = readByte();
        }
    }

    private long[] nl(int n) {
        long[] a = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = nl();
        }
        return a;
    }

    private long nl() {
        long num = 0;
        int b;
        boolean minus = false;
        while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-')) ;
        if (b == '-') {
            minus = true;
            b = readByte();
        }

        while (true) {
            if (b >= '0' && b <= '9') {
                num = num * 10 + (b - '0');
            } else {
                return minus ? -num : num;
            }
            b = readByte();
        }
    }

    private static void tr(Object... o) {
        System.out.println(Arrays.deepToString(o));
    }
}