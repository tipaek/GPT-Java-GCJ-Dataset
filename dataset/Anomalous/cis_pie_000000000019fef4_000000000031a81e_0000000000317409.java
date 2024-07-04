import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
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
            if (this.x != p.x) {
                return this.x - p.x;
            } else {
                return this.y - p.y;
            }
        }

        @Override
        public int hashCode() {
            return (x + " " + y).hashCode();
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
        Map<Character, Pair> directions = new HashMap<>();
        directions.put('N', new Pair(0, 1));
        directions.put('S', new Pair(0, -1));
        directions.put('E', new Pair(1, 0));
        directions.put('W', new Pair(-1, 0));

        for (int z = 1; z <= t; ++z) {
            int ans = Integer.MAX_VALUE;
            int x = ni(), y = ni();
            char[] str = ns().toCharArray();

            Pair curr = new Pair(x, y);
            List<Pair> path = new ArrayList<>();
            path.add(curr);

            for (int i = 1; i <= str.length; ++i) {
                Pair prev = path.get(i - 1);
                Pair addent = directions.get(str[i - 1]);

                Pair next = new Pair(prev.x + addent.x, prev.y + addent.y);
                path.add(next);
            }

            for (int i = 1; i < path.size(); ++i) {
                Pair point = path.get(i);
                int time = Math.abs(point.x) + Math.abs(point.y);
                if (time <= i) {
                    ans = Math.min(ans, Math.max(i, time));
                }
            }

            if (ans == Integer.MAX_VALUE) {
                pn("Case #" + z + ": IMPOSSIBLE");
            } else {
                pn("Case #" + z + ": " + ans);
            }
        }
    }

    void print(Object o) {
        System.out.println(o);
        System.out.flush();
    }

    int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
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
            if (o.getClass() == ArrayList.class) {
                pn(i + " al: " + o);
                notfound = false;
            }
            if (o.getClass() == HashSet.class) {
                pn(i + " hs: " + o);
                notfound = false;
            }
            if (o.getClass() == TreeSet.class) {
                pn(i + " ts: " + o);
                notfound = false;
            }
            if (o.getClass() == TreeMap.class) {
                pn(i + " tm: " + o);
                notfound = false;
            }
            if (o.getClass() == HashMap.class) {
                pn(i + " hm: " + o);
                notfound = false;
            }
            if (o.getClass() == LinkedList.class) {
                pn(i + " ll: " + o);
                notfound = false;
            }
            if (o.getClass() == PriorityQueue.class) {
                pn(i + " pq: " + o);
                notfound = false;
            }
            if (o.getClass() == Pair.class) {
                pn(i + " pair: " + o);
                notfound = false;
            }
            if (notfound) {
                pn(i + " unknown: " + o);
            }
            i++;
        }
        pn("watch ends");
    }
}