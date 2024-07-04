import java.util.*;
import java.io.*;
class Project extends DefaultTemplate
{
    class Window 
    {
        int l, r;
        public Window(int a, int b) { l = a; r = b; }
        public boolean touches(Window other) { return other.l > l && other.l < r || other.r > l && other.r < r; }
    }
    Window[] w;
    boolean[] ans;
    boolean[] vis;
    int N;
    void setup()
    {
        int T = ri();
        for(int t = 1; t <= T; t++)
        {
            N = ri();
            boolean flag = true;
            w = new Window[N];
            ans = new boolean[N];
            vis = new boolean[N];
            for(int i = 0; i < N; i++)
                w[i] = new Window(ri(), ri());
            for(int i = 0; i < N && flag; i++) if(!dfs(i, -1)) { pln("IMPOSSIBLE"); flag = false; }
            if(!flag) continue;
            for(int i = 0; i < N; i++) p(ans[i]? "J": "C");
            pln();
        }
    }
    boolean dfs(int u, int v)
    {
        if(vis[u])
        {
            if(v != -1 && ans[u] == ans[v]) return false;
            else return true;
        }
        if(v != -1) ans[u] = !ans[v];
        vis[u] = true;
        for(int i = 0; i < N; i++) if(w[u].touches(w[i])) if(!dfs(i, u)) return false;
        return true;
    }
    
}

class DefaultTemplate
{
    private static byte[] buf = new byte[1 << 16];
    private static int curChar, numChars;
    public static <T>void p(T s){ System.out.print(s);}
    public static <T>void ps(char c, T... s){ for(T t: s) {System.out.print(t); System.out.print(c);}}
    public static void ps(int[] s) {for(int t: s) {System.out.print(t); System.out.print(' ');}}
    public static void ps(long[] s) {for(long t: s) {System.out.print(t); System.out.print(' ');}}
    public static void ps(double[] s) {for(double t: s) {System.out.print(t); System.out.print(' ');}}
    public static <T>void ps(T... s){ for(T t: s) {System.out.print(t); System.out.print(' ');}}
    public static <T>void psln(T... s){ for(T t: s) {System.out.print(t); System.out.print(' ');} System.out.println("");}
    public static int[] arr(int... s) { return s; }
    public static void ps(char c, int[] s) {for(int t: s) {System.out.print(t); System.out.print(c);}}
    public static void ps(char c, long[] s) {for(long t: s) {System.out.print(t); System.out.print(c);}}
    public static void ps(char c, double[] s) {for(double t: s) {System.out.print(t); System.out.print(c);}}
    public static <T>void pln(T s){ System.out.println(s);}
    public static void pln(){ System.out.println();}
    public static <T>void print(T s){ System.out.print(s);}
    public static <T>void prints(T... s){ for(T t: s) {System.out.print(t); System.out.print(' ');}}
    public static <T>void println(T s){ System.out.println(s);}
    public static void println(){ System.out.println();}
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
    public static int[] ria(int size) { int[] ret = new int[size]; for(int i = 0; i < size; i++) ret[i] = (int) ri(); return ret; }
    public static String rs(){int c = read();while (space(c))c = read();StringBuilder res = new StringBuilder();do{res.appendCodePoint(c);c = read();}while (!space(c));return res.toString();}
    public static String rln(){int c = read();StringBuilder res = new StringBuilder();do{res.appendCodePoint(c);c = read();}while (c != '\n');return res.toString();}
    public static double rd(){int c = read(), sgn = 1;while (space(c))c = read();if (c == '-'){sgn = -1;c = read();}double res = 0;while (!space(c) && c != '.'){if (c == 'e' || c == 'E')return res * pow(10, readInt());res *= 10;res += c - '0';c = read();}if (c == '.'){c = read();double m = 1;while (!space(c)){if (c == 'e' || c == 'E')return res * pow(10, readInt());m /= 10;res += (c - '0') * m;c = read();}}return res * sgn;}
    public static long rl(){int c = read(), sgn = 1;while (space(c))c = read();if (c == '-'){sgn = -1;c = read();}long res = 0;do{res = (res << 1) + (res << 3);res += c - '0';c = read();}while (!space(c));return res * sgn;}
    private static boolean space(int c) { return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;}
    private static int pow(int x, int y) {int res = 1;  while(y > 0) { if((y & 1) > 0) res = (res * x); y = y >> 1; x = (x * x);   } return res; }
    public static void setFile(String in, String out) { setIn(in); setOut(out); }
    public static void setIn(String in) { try { System.setIn(new FileInputStream(in));  } catch(FileNotFoundException e) {} }
    public static void setOut(String out) { try { new File(out).createNewFile(); System.setOut(new PrintStream(new FileOutputStream(out)));  } catch(IOException e) {} }
    public static final int MOD = (int) 1e9 + 7;
    public static final int INF = Integer.MAX_VALUE;
    public static final long INFL = Long.MAX_VALUE;
    public static int[] sort(int[] s) { Arrays.sort(s); return s; }
    public static long[] sort(long[] s) { Arrays.sort(s); return s; }
    public static double[] sort(double[] s) { Arrays.sort(s); return s; }
    public static int rng(int s) { return pi(s * Math.random()); }
    public static int rng(int st, int en) { return st + pi((en - st) * Math.random()); }
    public static int[] rng(int[] s) { for(int i = 0; i < s.length; i++) swap(s, i, (int) (Math.random() * s.length)); return s; }
    public static long[] rng(long[] s) { for(int i = 0; i < s.length; i++) swap(s, i, (int) (Math.random() * s.length)); return s;  }
    public static double[] rng(double[] s) { for(int i = 0; i < s.length; i++) swap(s, i, (int) (Math.random() * s.length)); return s;  }
    public static void swap(int[] s, int a, int b) { int tmp = s[a]; s[a] = s[b]; s[b] = tmp; }
    public static void swap(long[] s, int a, int b) { long tmp = s[a]; s[a] = s[b]; s[b] = tmp; }
    public static void swap(double[] s, int a, int b) { double tmp = s[a]; s[a] = s[b]; s[b] = tmp; }
    public static long pow(long x, long y, int m) {long res = 1;x = x % m;  while(y > 0) { if((y & 1) > 0) res = (res * x) % m; y = y >> 1; x = (x * x) % m;   } return res; }
    public static int pow(int x, int y, int m) {int res = 1;x = x % m;  while(y > 0) { if((y & 1) > 0) res = (res * x) % m; y = y >> 1; x = (x * x) % m;   } return res; }
    public static int parseInt(String s) { return Integer.parseInt(s); }
    public static int parseInt(double d) { return (int) d; }
    public static int[] parseInt(String[] s) { int[] ret = new int[s.length]; for(int i = 0; i < s.length; i++) ret[i] = pi(s[i]); return ret; }
    public static int pi(String s) { return Integer.parseInt(s); }
    public static int pi(double d) { return (int) d; }
    public static int[] arr(int x) { return new int[x]; }
    public static int[] pi(String[] s) { int[] ret = new int[s.length]; for(int i = 0; i < s.length; i++) ret[i] = pi(s[i]); return ret; }
    public static <T>String str(T t) { return String.valueOf(t); }
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
        protected HashMap<Integer, Integer> a;
        protected final int n;
        private static int LSB(int x) { return x & -x; }
        public BIT(int n, boolean fill) { a = new HashMap<>(); this.n = ++n; if(fill) for(int i = 1; i < n; i++) { a.put(i, i & -i); } }
        public void update(int index, int value) { for(int i = index; i < n; i += LSB(i)) { Integer x = a.get(i); a.put(i, value + (x == null? 0: x)); } }
        public int sum(int index) { if(index == 0) return 0; int ret = 0; for(int i = index; i > 0; i -= LSB(i)) { Integer x = a.get(i); ret += x == null? 0: x; } return ret; }
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
}

public class Solution extends DefaultTemplate {  public static void main(String[] args) { new Project().setup(); }  }