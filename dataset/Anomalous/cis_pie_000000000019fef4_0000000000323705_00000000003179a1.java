import java.io.*;
import java.util.*;

public class Solution {
    InputStream is;
    PrintWriter out;
    String INPUT = "";

    static class Pair implements Comparable<Pair> {
        int x, y;

        Pair(int i, int j) {
            x = i;
            y = j;
        }

        @Override
        public int compareTo(Pair p) {
            if (this.x != p.x) return this.x - p.x;
            return this.y - p.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        @Override
        public String toString() {
            return x + " " + y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return x == pair.x && y == pair.y;
        }
    }

    void solve() throws Exception {
        int t = ni();
        for (int z = 1; z <= t; ++z) {
            int u = ni();
            int q = 100 * 100;
            Set<Character> cc = new HashSet<>();
            Map<String, Long> hm = new HashMap<>();
            for (int i = 0; i < q; ++i) {
                long n = nl();
                String x = ns();
                for (char c : x.toCharArray()) cc.add(c);

                hm.put(x, hm.containsKey(x) ? Math.min(hm.get(x), n) : n);
            }

            List<Character> curr = new ArrayList<>(cc);
            int[] pp = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

            if (isValidPermutation(curr, hm, pp)) {
                printResult(z, curr);
            } else {
                while (nextPermutation(pp)) {
                    if (isValidPermutation(curr, hm, pp)) {
                        printResult(z, curr, pp);
                        break;
                    }
                }
            }
        }
    }

    private boolean isValidPermutation(List<Character> curr, Map<String, Long> hm, int[] pp) {
        for (String x : hm.keySet()) {
            StringBuilder sb = new StringBuilder();
            for (char y : x.toCharArray()) {
                sb.append(curr.indexOf(y));
            }
            if (Long.parseLong(sb.toString()) > hm.get(x)) {
                return false;
            }
        }
        return true;
    }

    private void printResult(int z, List<Character> curr) {
        StringBuilder fa = new StringBuilder();
        for (char x : curr) fa.append(x);
        pn("Case #" + z + ": " + fa);
    }

    private void printResult(int z, List<Character> curr, int[] pp) {
        StringBuilder fa = new StringBuilder();
        for (int y : pp) fa.append(curr.get(y));
        pn("Case #" + z + ": " + fa);
    }

    boolean nextPermutation(int[] p) {
        for (int a = p.length - 2; a >= 0; --a) {
            if (p[a] < p[a + 1]) {
                for (int b = p.length - 1; ; --b) {
                    if (p[b] > p[a]) {
                        int t = p[a];
                        p[a] = p[b];
                        p[b] = t;
                        for (++a, b = p.length - 1; a < b; ++a, --b) {
                            t = p[a];
                            p[a] = p[b];
                            p[b] = t;
                        }
                        return true;
                    }
                }
            }
        }
        return false;
    }

    void print(Object o) {
        System.out.println(o);
        System.out.flush();
    }

    void run() throws Exception {
        is = INPUT.isEmpty() ? System.in : new ByteArrayInputStream(INPUT.getBytes());
        out = new PrintWriter(System.out);
        long s = System.currentTimeMillis();
        solve();
        out.flush();
        if (!INPUT.isEmpty()) tr(System.currentTimeMillis() - s + "ms");
    }

    public static void main(String[] args) throws Exception {
        new Solution().run();
    }

    private void pn(Object o) {
        out.println(o);
    }

    private void p(Object o) {
        out.print(o);
    }

    private byte[] inbuf = new byte[1024];
    public int lenbuf = 0, ptrbuf = 0;

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
        while (p < n && !isSpaceChar(b)) {
            buf[p++] = (char) b;
            b = readByte();
        }
        return n == p ? buf : Arrays.copyOf(buf, p);
    }

    private char[][] nm(int n, int m) {
        char[][] map = new char[n][];
        for (int i = 0; i < n; i++) map[i] = ns(m);
        return map;
    }

    private int[] na(int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = ni();
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

    private void tr(Object... o) {
        if (INPUT.length() > 0) System.out.println(Arrays.deepToString(o));
    }

    void watch(Object... a) throws Exception {
        int i = 1;
        pn("watch starts :");
        for (Object o : a) {
            boolean notfound = true;
            if (o.getClass().isArray()) {
                String type = o.getClass().getName();
                print("type is " + type);
                switch (type) {
                    case "[I":
                        pn(i + " " + Arrays.toString((int[]) o));
                        break;
                    case "[[I":
                        pn(i + " " + Arrays.deepToString((int[][]) o));
                        break;
                    case "[J":
                        pn(i + " " + Arrays.toString((long[]) o));
                        break;
                    case "[[J":
                        pn(i + " " + Arrays.deepToString((long[][]) o));
                        break;
                    case "[D":
                        pn(i + " " + Arrays.toString((double[]) o));
                        break;
                    case "[[D":
                        pn(i + " " + Arrays.deepToString((double[][]) o));
                        break;
                    case "[Ljava.lang.String":
                        pn(i + " " + Arrays.toString((String[]) o));
                        break;
                    case "[[Ljava.lang.String":
                        pn(i + " " + Arrays.deepToString((String[][]) o));
                        break;
                    case "[C":
                        pn(i + " " + Arrays.toString((char[]) o));
                        break;
                    case "[[C":
                        pn(i + " " + Arrays.deepToString((char[][]) o));
                        break;
                    default:
                        pn(i + " type not identified");
                        break;
                }
                notfound = false;
            }
            if (o instanceof ArrayList) {
                pn(i + " al: " + o);
                notfound = false;
            }
            if (o instanceof HashSet) {
                pn(i + " hs: " + o);
                notfound = false;
            }
            if (o instanceof TreeSet) {
                pn(i + " ts: " + o);
                notfound = false;
            }
            if (o instanceof TreeMap) {
                pn(i + " tm: " + o);
                notfound = false;
            }
            if (o instanceof HashMap) {
                pn(i + " hm: " + o);
                notfound = false;
            }
            if (o instanceof LinkedList) {
                pn(i + " ll: " + o);
                notfound = false;
            }
            if (o instanceof PriorityQueue) {
                pn(i + " pq : " + o);
                notfound = false;
            }
            if (o instanceof Pair) {
                pn(i + " pq : " + o);
                notfound = false;
            }
            if (notfound) {
                pn(i + " unknown: " + o);
            }
            i++;
        }
        pn("watch ends ");
    }
}