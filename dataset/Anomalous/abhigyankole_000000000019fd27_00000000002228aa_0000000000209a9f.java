import java.io.*;
import java.util.*;

public class NestingDepth {

    static final long MOD = 1000000007;
    static final int TEN_NINE = 1000000000;
    static long[][] dp;
    static List<List<Long>> listList;
    static List<Long> lolist;
    static List<Pair> plist;
    static List<Integer> inList;

    public static void main(String[] args) throws IOException {
        SReader sc = new SReader();
        StringBuilder sb = new StringBuilder();
        int t = sc.ni();
        while (t-- > 0) {
            StringBuilder sb2 = new StringBuilder();
            String s = sc.rl() + "0";
            int open = 0;
            for (int i = 0; i < s.length(); i++) {
                int digit = s.charAt(i) - '0';
                if (digit > open) {
                    sb2.append("(".repeat(digit - open));
                } else {
                    sb2.append(")".repeat(open - digit));
                }
                if (i != s.length() - 1) {
                    sb2.append(digit);
                }
                open = digit;
            }
            sb.append(sb2).append("\n");
        }
        System.out.println(sb.toString().trim());
    }

    public static void printMap(Map<?, ?> map) {
        for (Map.Entry<?, ?> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }

    static long gcd(long a, long b) {
        return (a == 0) ? b : gcd(b % a, a);
    }

    static long lcm(long a, long b) {
        return (a * b) / gcd(a, b);
    }

    static void bin(int n) {
        if (n > 1) bin(n / 2);
        System.out.print(n % 2);
    }

    static long power(long x, long y, long p) {
        long res = 1;
        x %= p;
        while (y > 0) {
            if ((y & 1) == 1) res = (res * x) % p;
            y >>= 1;
            x = (x * x) % p;
        }
        return res;
    }

    static int next(int[] a, int start) {
        for (int i = start + 1; i < a.length; i++) {
            if (a[i] != -1) return i;
        }
        return 0;
    }

    static long g(long a, long b) {
        return (b == 0) ? a : g(b, a % b);
    }

    public static boolean equal(List<Integer> a, List<Integer> b) {
        return a.size() == b.size() && a.equals(b);
    }

    static int binsFirstPos(List<Integer> list, int ele) {
        int pos1 = Collections.binarySearch(list, ele);
        if (pos1 > -1) {
            int pos2 = Collections.binarySearch(list, ele - 1);
            if (pos2 < 0) {
                return Math.abs(pos2) - 1;
            } else {
                for (int i = pos2; i <= pos1; i++) {
                    if (ele == list.get(i)) return i;
                }
            }
        }
        return pos1;
    }

    static class BFSElement {
        List<Integer> list;
        int leftSum;
        List<Integer> leftElements;

        BFSElement() {
            list = new ArrayList<>();
            leftElements = new ArrayList<>();
            leftSum = 0;
        }

        void initSum(int a) {
            leftSum = a;
        }
    }

    static class Trie {
        long a, b, c;

        Trie(long a, long b, long c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }

        Trie() {}

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Trie)) return false;
            Trie trie = (Trie) o;
            return a == trie.a && b == trie.b && c == trie.c;
        }

        @Override
        public int hashCode() {
            return Objects.hash(a, b, c);
        }
    }

    static class Pair {
        long a, b;

        Pair(long a, long b) {
            this.a = a;
            this.b = b;
        }

        Pair() {}

        void print() {
            System.out.println("a: " + a + " b: " + b);
        }

        Pair getReversePair() {
            return new Pair(b, a);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Pair)) return false;
            Pair pair = (Pair) o;
            return a == pair.a && b == pair.b;
        }

        @Override
        public int hashCode() {
            return Objects.hash(a, b);
        }
    }

    static class TrieComparator implements Comparator<Trie> {
        @Override
        public int compare(Trie c1, Trie c2) {
            return Long.compare(c1.c, c2.c);
        }
    }

    static class PairComparatorPos implements Comparator<Pair> {
        @Override
        public int compare(Pair c1, Pair c2) {
            return Long.compare(c1.a + c1.b, c2.a + c2.b);
        }
    }

    static class PairComparatorVal implements Comparator<Pair> {
        @Override
        public int compare(Pair c1, Pair c2) {
            return Long.compare(c1.b, c2.b);
        }
    }

    static class SReader {
        BufferedReader br;
        StringTokenizer st;

        SReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int ni() {
            return Integer.parseInt(next());
        }

        long nl() {
            return Long.parseLong(next());
        }

        double nd() {
            return Double.parseDouble(next());
        }

        String rl() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    static class SegmentTree {
        static final int MAX = 10000000;
        static long[] tree = new long[MAX];
        static long[] lazy = new long[MAX];
        static long[] tree2 = new long[MAX];
        static long[] lazy2 = new long[MAX];

        static void updateRangeUtil(int si, int ss, int se, int us, int ue, long diff) {
            if (lazy[si] != 0) {
                tree[si] += lazy[si];
                if (ss != se) {
                    lazy[si * 2 + 1] += lazy[si];
                    lazy[si * 2 + 2] += lazy[si];
                }
                lazy[si] = 0;
            }
            if (ss > se || ss > ue || se < us) return;
            if (ss >= us && se <= ue) {
                tree[si] += diff;
                if (ss != se) {
                    lazy[si * 2 + 1] += diff;
                    lazy[si * 2 + 2] += diff;
                }
                return;
            }
            int mid = (ss + se) / 2;
            updateRangeUtil(si * 2 + 1, ss, mid, us, ue, diff);
            updateRangeUtil(si * 2 + 2, mid + 1, se, us, ue, diff);
            tree[si] = Math.max(tree[si * 2 + 1], tree[si * 2 + 2]);
        }

        static void updateRangeUtil2(int si, int ss, int se, int us, int ue, long diff) {
            if (lazy2[si] != 0) {
                tree2[si] += lazy2[si];
                if (ss != se) {
                    lazy2[si * 2 + 1] += lazy2[si];
                    lazy2[si * 2 + 2] += lazy2[si];
                }
                lazy2[si] = 0;
            }
            if (ss > se || ss > ue || se < us) return;
            if (ss >= us && se <= ue) {
                tree2[si] += diff;
                if (ss != se) {
                    lazy2[si * 2 + 1] += diff;
                    lazy2[si * 2 + 2] += diff;
                }
                return;
            }
            int mid = (ss + se) / 2;
            updateRangeUtil2(si * 2 + 1, ss, mid, us, ue, diff);
            updateRangeUtil2(si * 2 + 2, mid + 1, se, us, ue, diff);
            tree2[si] = Math.min(tree2[si * 2 + 1], tree2[si * 2 + 2]);
        }

        static void updateRange(int n, int us, int ue, long diff) {
            updateRangeUtil(0, 0, n - 1, us, ue, diff);
            updateRangeUtil2(0, 0, n - 1, us, ue, diff);
        }

        static long getMaxUtil(int ss, int se, int qs, int qe, int si) {
            if (lazy[si] != 0) {
                tree[si] += lazy[si];
                if (ss != se) {
                    lazy[si * 2 + 1] += lazy[si];
                    lazy[si * 2 + 2] += lazy[si];
                }
                lazy[si] = 0;
            }
            if (ss > se || ss > qe || se < qs) return Long.MIN_VALUE;
            if (ss >= qs && se <= qe) return tree[si];
            int mid = (ss + se) / 2;
            return Math.max(getMaxUtil(ss, mid, qs, qe, 2 * si + 1),
                    getMaxUtil(mid + 1, se, qs, qe, 2 * si + 2));
        }

        static long getMinUtil(int ss, int se, int qs, int qe, int si) {
            if (lazy2[si] != 0) {
                tree2[si] += lazy2[si];
                if (ss != se) {
                    lazy2[si * 2 + 1] += lazy2[si];
                    lazy2[si * 2 + 2] += lazy2[si];
                }
                lazy2[si] = 0;
            }
            if (ss > se || ss > qe || se < qs) return Long.MAX_VALUE;
            if (ss >= qs && se <= qe) return tree2[si];
            int mid = (ss + se) / 2;
            return Math.min(getMinUtil(ss, mid, qs, qe, 2 * si + 1),
                    getMinUtil(mid + 1, se, qs, qe, 2 * si + 2));
        }

        static long getMax(int n, int qs, int qe) {
            return getMaxUtil(0, n - 1, qs, qe, 0);
        }

        static long getMin(int n, int qs, int qe) {
            return getMinUtil(0, n - 1, qs, qe, 0);
        }

        static void constructSTUtil(long[] arr, int ss, int se, int si) {
            if (ss > se) return;
            if (ss == se) {
                tree[si] = arr[ss];
                return;
            }
            int mid = (ss + se) / 2;
            constructSTUtil(arr, ss, mid, si * 2 + 1);
            constructSTUtil(arr, mid + 1, se, si * 2 + 2);
            tree[si] = Math.max(tree[si * 2 + 1], tree[si * 2 + 2]);
        }

        static void constructSTUtil2(long[] arr, int ss, int se, int si) {
            if (ss > se) return;
            if (ss == se) {
                tree2[si] = arr[ss];
                return;
            }
            int mid = (ss + se) / 2;
            constructSTUtil2(arr, ss, mid, si * 2 + 1);
            constructSTUtil2(arr, mid + 1, se, si * 2 + 2);
            tree2[si] = Math.min(tree2[si * 2 + 1], tree2[si * 2 + 2]);
        }

        static void constructST(long[] arr, int n) {
            constructSTUtil(arr, 0, n - 1, 0);
            constructSTUtil2(arr, 0, n - 1, 0);
        }
    }

    static class Reader {
        private static final int BUFFER_SIZE = 1 << 16;
        private final DataInputStream din;
        private final byte[] buffer;
        private int bufferPointer, bytesRead;

        public Reader() {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public Reader(String fileName) throws IOException {
            din = new DataInputStream(new FileInputStream(fileName));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public static void pr(Object s) {
            System.out.println(s);
        }

        public int ni() throws IOException {
            int ret = 0;
            byte c = read();
            while (c <= ' ') c = read();
            boolean neg = (c == '-');
            if (neg) c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            return neg ? -ret : ret;
        }

        public long nl() throws IOException {
            long ret = 0;
            byte c = read();
            while (c <= ' ') c = read();
            boolean neg = (c == '-');
            if (neg) c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            return neg ? -ret : ret;
        }

        public String rl() throws IOException {
            byte[] buf = new byte[1024];
            int cnt = 0, c;
            while ((c = read()) != -1) {
                if (c == '\n') break;
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }

        public double nd() throws IOException {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ') c = read();
            boolean neg = (c == '-');
            if (neg) c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            if (c == '.') {
                while ((c = read()) >= '0' && c <= '9') {
                    ret += (c - '0') / (div *= 10);
                }
            }
            return neg ? -ret : ret;
        }

        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1) buffer[0] = -1;
        }

        private byte read() throws IOException {
            if (bufferPointer == bytesRead) fillBuffer();
            return buffer[bufferPointer++];
        }

        public void close() throws IOException {
            if (din != null) din.close();
        }
    }
}