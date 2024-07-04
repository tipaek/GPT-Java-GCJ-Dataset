import java.io.*;
import java.util.*;

class Project extends Solution
{
    void solve()
    {
        int x = ri(), y = ri();
        pln(slow(x, y));
        //pln(fast(x, y));
    }
    String fast(int x, int y)
    {
        String a = fhelper(x, y, false), b = fhelper(y, x, true);
        if(a.equals("IMPOSSIBLE")) return b;
        if(b.equals("IMPOSSIBLE")) return a;
        return a.length() < b.length()? a: b;
    }
    String fhelper(int main, int dec, boolean rev)
    {
        char[] t = rev? new char[]{'N', 'S', 'E', 'W'}: b;
        boolean neg = main < 0;
        main = Math.abs(main);
        int[] bits = new int[32];
        ArrayList<Integer> things = new ArrayList<>();
        char[] res = new char[32];
        int rec = 0;
        for(int i = 0; i <= 31; i++)
        {
            bits[i] = main >> i & 1;
            if(bits[i] == 0) things.add(i);
            else
            {
                res[i] = neg? t[1]: t[0];
                rec = i;
            }
        }
        boolean found = false;
        int best = things.size();
        for(int i = 0; i < 1 << things.size(); i++)
        {
            char[] cres = new char[32];
            int sm = 0;
            for(int j = 0; j < best; j++)
            {
                if(sm == dec && things.get(j) >= rec)
                {
                    best = j;
                    break;
                }
                if((i >> j & 1) == 0)
                {
                    sm += 1 << things.get(j);
                    cres[things.get(j)] = t[2];
                }
                else
                {
                    sm -= 1 << things.get(j);
                    cres[things.get(j)] = t[3];
                }
            }
            if(sm != dec) continue;
            found = true;
            for(int j = 0; j < 32; j++)
            {
                if(cres[j] != 0)
                    res[j] = cres[j];
            }
        }

        return "IMPOSSIBLE";
    }
    char[] b = {'E', 'W', 'N', 'S'};
    String slow(int x, int y)
    {
        String res = "";
        int bst = INF;
        for(int i = 0; i < 1 << 16; i++) // 10 digits most
        {
            String cres = "";
            int xpos = 0, ypos = 0;
            for(int j = 0; j < 8; j++)
            {
                int move = (i >> (j << 1)) & 3;
                if(move == 0) xpos += 1 << j;
                if(move == 1) xpos -= 1 << j;
                if(move == 2) ypos += 1 << j;
                if(move == 3) ypos -= 1 << j;
                cres += b[move];
                if(xpos == x && ypos == y && j < bst)
                {
                    bst = j;
                    res = cres;
                    break;
                }
            }
        }
        return bst == INF? "IMPOSSIBLE": res;
    }
    void setup()
    {
        int T = ri();
        for(int i = 1; i <= T; i++)
        {
            ps("Case #" + i + ":");
            solve();
        }
    }
}

public class Solution
{
    /* General functions */
    public static void setFile(String in, String out) { setIn(in); setOut(out); }
    public static void setIn(String in) { try { System.setIn(new FileInputStream(in));  } catch(FileNotFoundException e) {} }
    public static void setOut(String out) { try { new File(out).createNewFile(); System.setOut(new PrintStream(new FileOutputStream(out)));  } catch(IOException e) {} }
    private static byte[] buf = new byte[1024];
    private static int curChar, numChars;
    public static Iterable<Integer> range(final int a, final int b, final int c) { return () -> new Iterator<Integer>() { private int current = a, upto = b, inc = c; public boolean hasNext() { return current < upto; } public Integer next() { int c = current; current += inc; return c; }}; }
    public static Iterable<Integer> range(final int a, final int b) { return range(a, b, 1); }
    public static Iterable<Integer> range(final int a) { return range(0, a, 1); }
    public static final int MOD = (int) 1e9 + 7, INF = Integer.MAX_VALUE;
    public static final long INFL = Long.MAX_VALUE;
    public static <T>void p(T s){ System.out.print(s);}
    public static <T>void ps(T... s){ for(T t: s) {System.out.print(t); System.out.print(' ');}}
    public static <T>void pln(T s){ System.out.println(s);}
    public static void pln(){ System.out.println();}
    public static <T>void print(T s){ System.out.print(s);}
    public static <T>void prints(T... s){ for(T t: s) {System.out.print(t); System.out.print(' ');}}
    public static <T>void println(T s){ System.out.println(s);}
    public static void println(){ System.out.println();}
    public static int rng(int s) { return pi(s * Math.random()); }
    public static int rng(int st, int en) { return st + pi((en - st) * Math.random()); }
    public static int read(){try{if (curChar >= numChars){curChar = 0;numChars = System.in.read(buf);}if (numChars == -1)return numChars;return buf[curChar++];}catch(IOException e){throw new Error("Failed to read from IO.");}}
    public static char readChar() {int c = read(); while(space(c)) c = read(); return (char) c; }
    public static int readInt() { int c = read(), sgn = 1;while (space(c))  c = read();if (c == '-')  {sgn = -1;c = read();}int res = 0;do {res = (res << 1) + (res << 3);res += c - '0';c = read();}while (!space(c));return res * sgn;}
    public static int[] readArray(int size) { int[] ret = new int[size]; for(int i = 0; i < size; i++) ret[i] = readInt(); return ret; }
    public static String readString(){int c = read();while (space(c))c = read();StringBuilder res = new StringBuilder();do{res.appendCodePoint(c);c = read();}while (!space(c));return res.toString();}
    public static String readLine(){int c = read();StringBuilder res = new StringBuilder();do{res.appendCodePoint(c);c = read();}while (c != '\n');return res.toString();}
    public static double readDouble(){int c = read(), sgn = 1;while (space(c))c = read();if (c == '-'){sgn = -1;c = read();}double res = 0;while (!space(c) && c != '.'){if (c == 'e' || c == 'E')return res * pow(10, readInt());res *= 10;res += c - '0';c = read();}if (c == '.'){c = read();double m = 1;while (!space(c)){if (c == 'e' || c == 'E')return res * pow(10, readInt());m /= 10;res += (c - '0') * m;c = read();}}return res * sgn;}
    public static long readLong(){int c = read(), sgn = 1;while (space(c))c = read();if (c == '-'){sgn = -1;c = read();}long res = 0;do{res = (res << 1) + (res << 3);res += c - '0';c = read();}while (!space(c));return res * sgn;}
    public static char rc() {int c = read(); while(space(c)) c = read(); return (char) c; }
    public static int ri() { int c = read(), sgn = 1;while (space(c))  c = read();if (c == '-')  {sgn = -1;c = read();}int res = 0;do {res = (res << 1) + (res << 3);res += c - '0';c = read();}while (!space(c));return res * sgn;}
    public static int[] ria(int size) { int[] ret = new int[size]; for(int i = 0; i < size; i++) ret[i] = readInt(); return ret; }
    public static String rs(){int c = read();while (space(c))c = read();StringBuilder res = new StringBuilder();do{res.appendCodePoint(c);c = read();}while (!space(c));return res.toString();}
    public static String rln(){int c = read();StringBuilder res = new StringBuilder();do{res.appendCodePoint(c);c = read();}while (c != '\n');return res.toString();}
    public static double rd(){int c = read(), sgn = 1;while (space(c))c = read();if (c == '-'){sgn = -1;c = read();}double res = 0;while (!space(c) && c != '.'){if (c == 'e' || c == 'E')return res * pow(10, readInt());res *= 10;res += c - '0';c = read();}if (c == '.'){c = read();double m = 1;while (!space(c)){if (c == 'e' || c == 'E')return res * pow(10, readInt());m /= 10;res += (c - '0') * m;c = read();}}return res * sgn;}
    public static long rl(){int c = read(), sgn = 1;while (space(c))c = read();if (c == '-'){sgn = -1;c = read();}long res = 0;do{res = (res << 1) + (res << 3);res += c - '0';c = read();}while (!space(c));return res * sgn;}
    private static boolean space(int c) { return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;}
    public static long pow(long x, long y, int m) {long res = 1;x = x % m;  while(y > 0) { if((y & 1) > 0) res = (res * x) % m; y = y >> 1; x = (x * x) % m;   } return res; }
    public static int pow(int x, int y, int m) {int res = 1;x = x % m;  while(y > 0) { if((y & 1) > 0) res = (res * x) % m; y = y >> 1; x = (x * x) % m;   } return res; }
    public static int pow(int x, int y) {int res = 1;  while(y > 0) { if((y & 1) > 0) res = (res * x); y = y >> 1; x = (x * x);   } return res; }
    public static int parseInt(String s) { return Integer.parseInt(s); }
    public static int parseInt(double d) { return (int) d; }
    public static int[] parseInt(String[] s) { int[] ret = new int[s.length]; for(int i = 0; i < s.length; i++) ret[i] = pi(s[i]); return ret; }
    public static int pi(String s) { return Integer.parseInt(s); }
    public static int pi(double d) { return (int) d; }
    public static int[] pi(String[] s) { int[] ret = new int[s.length]; for(int i = 0; i < s.length; i++) ret[i] = pi(s[i]); return ret; }
    public static <T>String str(T t) { return String.valueOf(t); }
    public static void main(String[] args) { new Project().setup(); }
    public static int gcd(int a, int b) { return b == 0? a: gcd(b, a % b); }
    public static int gcd(int... a) { int res = a[0]; for(int i = 1; i < a.length; i++) res = gcd(res, a[i]); return res; }
    public static int min(int... a) { int res = Integer.MAX_VALUE; for(int i: a) res = Math.min(res, i); return res; }
    public static int max(int... a) { int res = Integer.MIN_VALUE; for(int i: a) res = Math.max(res, i); return res; }
    public static long min(long... a) { long res = Long.MAX_VALUE; for(long i: a) res = Math.min(res, i); return res; }
    public static long max(long... a) { long res = Long.MIN_VALUE; for(long i: a) res = Math.max(res, i); return res; }
    public static double min(double... a) { double res = Double.MAX_VALUE; for(double i: a) res = Math.min(res, i); return res; }
    public static double max(double... a) { double res = -Double.MAX_VALUE; for(double i: a) res = Math.max(res, i); return res; }
    public static int[] tokens(String s) { return pi(s.split(" ")); }
    public static boolean pb(int x) { return x > 0; }
    public static int choose(int n, int k) { int res = 1; for(int i = 1; i <= k; i++) res *= (n - i + 1); for(int i = 1; i <= k; i++) res /= i; return res; }
    public static String getIn(int batch, int testCase) { return batch + "-" + testCase + "-in.txt"; }
    public static String getOut(int batch, int testCase) { return batch + "-" + testCase + "-out.txt"; }
    public static class IntList
    {
        protected int[] a;
        protected int size, realsize;
        public IntList() { a = new int[0]; size = 0; realsize = 0; }
        public void add(int i) { if(size == 0) { a = new int[]{i}; size++; realsize++; } else { size++; if(size > realsize) { realsize <<= 1; int[] arr = new int[realsize]; System.arraycopy(a, 0, arr, 0, size - 1); a = arr; } a[size - 1] = i; } }
        public void remove() { if(size == 0) throw new ArrayIndexOutOfBoundsException(-1); a[--size] = 0; } public int get(int i) { if(i >= size) throw new ArrayIndexOutOfBoundsException(i); return a[i]; }
        public int size() { return size; }
        public void clear() { a = new int[0]; size = 0; realsize = 0; }
        public void set(int i, int v) { if(i >= size) throw new ArrayIndexOutOfBoundsException(i); a[i] = v; }
        public int[] asArray() { int[] foo = new int[size]; System.arraycopy(a, 0, foo, 0, size); return foo; }
    }
    public static class BIT
    {
        protected long[] a;
        protected int n;
        private int LSB(int x) { if(x <= 0) throw new Error(x + ""); return x & -x; }
        public BIT(int n) { a = new long[this.n = ++n]; }
        public void update(int index, long value) { for(int i = index; i < n; i += LSB(i)) a[i] += value; }
        public long sum(int index) {long ret = 0; for(int i = index; i > 0; i -= LSB(i)) ret += a[i]; return ret; }
        public int size() { return n; }
    }
    public static class RMQ
    {
        protected int[] t, d;
        protected int n, h;
        public RMQ(int N) { N++; n = 1; while(n < N) { n <<= 1; h++; } t = new int[n << 1]; d = new int[n];}
        void apply(int p, int value) {t[p] += value;if (p < n) d[p] += value;}
        private void pushup(int p) {while (p > 1){ p >>= 1; t[p] = max(t[p<<1], t[p<<1|1]) + d[p];}}
        private void pushdown(int p) {for (int s = h; s > 0; --s) {int i = p >> s;if (d[i] != 0) {apply(i<<1, d[i]);apply(i<<1|1, d[i]);d[i] = 0;}}}
        public void update(int l, int r, int value) {l += n; r += n;int l0 = l, r0 = r;for (; l < r; l >>= 1, r >>= 1) {if ((l&1)>0) apply(l++, value);if ((r&1)>0) apply(--r, value);}pushup(l0);pushup(r0 - 1);}
        public int query(int l, int r) {l += n; r += n;pushdown(l);pushdown(r - 1);int res = -INF;for (; l < r; l >>= 1, r >>= 1) {if ((l&1)>0) res = max(res, t[l++]);if ((r&1)>0) res = max(t[--r], res);}return res;}
    }
    public static class DisjointSet
    {
        protected int[] DS;
        public DisjointSet(int n) { DS = new int[n + 1]; for(int i = 0; i <= n; i++) DS[i] = i; }
        public int root(int n) { return DS[n] = (n == DS[n]? n: root(DS[n])); }
        public boolean connected(int x, int y) { return root(x) == root(y); }
        public boolean union(int x, int y) { int rootx = root(x), rooty = root(y); if(rootx == rooty) return false; DS[rootx] = rooty; return true; }
    }
    public static class Pointer<T> implements Comparable<T>
    {
        private T val;
        public T get() { return val; }
        public void set(T t) { val = t; }
        public int compareTo(T t) { Comparable<T> e = (Comparable<T>) val; return e.compareTo(t); }
    }
    public static class Data
    {
        public Data(int val)
        {

        }
    }
    public static class Lazy
    {

    }
    public static class SegTree
    {
        int N, H;
        Data[] t;
        Lazy[] d;
        // TO IMPLEMENT
        Data merge(Data l, Data r) { return null; }
        Data applyLazy(Data val, Lazy lz) { return null; }
        Lazy mergeLazy(Lazy src, Lazy add) { return null; }
        Data defaultData = null;
        Lazy defaultLazy = null;
        // END
        private static int find(int N) { int i; for(i = 1; i < N; i <<= 1); return i; }
        SegTree(int MAXN)
        {
            int N = find(MAXN);
            t = new Data[N << 1];
            d = new Lazy[N];
        }
        void init(int[] baseArray, int len)
        {
            N = find(len);
            H = 0;
            for(int i = 1; i <= N; i <<= 1) H++;
            for(int i = 0; i < N; i++)
            {
                if(i < len) t[N + i] = new Data(baseArray[i]); else t[N + i] = defaultData;
                d[i] = defaultLazy;
            }
            for(int i = N; i --> 0;)
                t[i] = merge(t[i << 1], t[i << 1 | 1]);
        }
        void apply(int idx, Lazy lz)
        {
            t[idx] = applyLazy(t[idx], lz);
            if(idx < N) d[idx] = mergeLazy(d[idx], lz);
        }
        void pushup(int idx)
        {
            while(idx > 1)
            {
                idx >>= 1;
                t[idx] = applyLazy(merge(t[idx << 1], t[idx << 1 | 1]), d[idx]);
            }
        }
        void pushdown(int idx)
        {
            for(int s = H; s > 0; s--)
            {
                int i = idx >> s;
                if(d[i] != defaultLazy)
                {
                    apply(i << 1, d[i]);
                    apply(i << 1 | 1, d[i]);
                    d[i] = defaultLazy;
                }
            }
        }
        void update(int l, int r, Lazy lz)
        {
            if(l > r) return;
            int l0 = l += N - 1, r0 = r += N - 1;
            pushdown(l); pushdown(r);
            for(; l <= r; l >>= 1, r >>= 1)
            {
                if((l & 1) != 0) apply(l++, lz);
                if((r & 1) == 0) apply(r--, lz);
            }
            pushup(l0); pushup(r0);
        }
        Data query(int l, int r)
        {
            if(l > r) return defaultData;
            pushdown(l += N - 1); pushdown(r += N - 1);
            Data resl = defaultData, resr = defaultData;
            for (; l <= r; l >>= 1, r >>= 1)
            {
                if((l & 1) != 0) resl = merge(resl, t[l++]);
                if((r & 1) == 0) resr = merge(t[r--], resr);
            }
            return merge(resl, resr);
        }
    }
}