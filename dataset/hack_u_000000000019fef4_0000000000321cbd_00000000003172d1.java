
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.Objects;
import java.util.Random;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Solution {

  static MyScanner scanner = new MyScanner();
  static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
  static final int MOD = 1000000007;
  static final boolean oj = System.getProperty("ONLINE_JUDGE") != null;
  static final int[][] d4 = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
  static final int[][] d8 = new int[][]{{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
  static final int N = 0;


  private static int for2(TreeMap<Long, Integer> tm) {
    for(int v : tm.values()) {
      if(v >= 2) return 0;
    }
    return 1;
  }

  private static int for3(TreeMap<Long, Integer> tm) {
    long ts = -1;
    for(Map.Entry<Long, Integer> e : tm.entrySet()) {
      if(e.getValue() >= 3) return 0;
      if(e.getValue() == 2 && ts == -1) {
        ts = e.getKey();
      }
    }
    if(ts != -1) {
      long v = tm.lastKey();
      if(v > ts) return 1;
    }
    for(long k : tm.keySet()) {
      if(tm.containsKey(2*k)) return 1;
    }
    return 2;
  }

  private static void solve(int tid) {
    int n = scanner.nextInt();
    int d = scanner.nextInt();
    if(n == 1) {
      scanner.nextLong();
      out.printf("Case #%d: %d\n", tid, d-1);
      return;
    }
    TreeMap<Long, Integer> tm = new TreeMap<>();
    for(int i=0; i<n; i++) {
      long cv = scanner.nextLong();
      tm.put(cv, tm.getOrDefault(cv, 0) + 1);
    }
//    for(int i=0; i<d-1; i++) {
//      if(isp(tm, i, d)) {
//        out.printf("Case #%d: %d\n", tid, i);
//        return;
//      }
//    }
    int ans = d-1;
    if(d == 2) ans = for2(tm);
    if(d == 3) ans = for3(tm);
    out.printf("Case #%d: %d\n", tid, ans);
  }

  private static boolean isp(TreeMap<Long, Integer> tm, int k, int d) {
    return false;
  }

  public static void main(String[] args) {
    int tc = scanner.nextInt();
    for(int t=1; t<=tc; t++) {
      solve(t);
    }
    out.close();
  }

  public static void print(Object o) {
    if(!oj) {
      out.println(o);
    }
  }

  //Find the GCD of two numbers
  public static long gcd(long a, long b) {
    if (a < b) return gcd(b,a);
    if (b == 0)
      return a;
    else
      return gcd(b,a%b);
  }

  private static long[] fac = new long[N+1];
  private static long[] invfac = new long[N+1];

  private static long fac(int n){
    if(n == 0) return fac[0] = 1;
    else if(fac[n] > 0) return fac[n];
    else return fac[n] = n * fac(n-1) % MOD;
  }

  private static long invfac(int n){
    if(invfac[n] > 0) return invfac[n];
    else return invfac[n] = inv(fac[n]);
  }

  private static long choose(int n, int k){
    return fac(n) * invfac(k) % MOD * invfac(n-k) % MOD;
  }

  private static long inv(long a){
    return (gcdex(a, MOD).key + MOD) % MOD;
  }

  private static Pair<Long, Long> gcdex(long a, long b){
    if(b > a) return gcdex(b, a).invert();
    else if(b == 0) return new Pair<>(1L, 0L);
    else{
      Pair<Long, Long> p = gcdex(b, a % b);
      return new Pair<>(p.key, p.key - p.value*(a/b));
    }
  }

  //Fast exponentiation (x^y mod m)
  public static long power(long x, long y, long m) {
    if (y < 0) return 0L;
    long ans = 1;
    x %= m;
    while (y > 0) {
      if(y % 2 == 1)
        ans = (ans * x) % m;
      y /= 2;
      x = (x * x) % m;
    }
    return ans;
  }

  public static int[] shuffle(int[] array) {
    Random rgen = new Random();
    for (int i = 0; i < array.length; i++) {
      int randomPosition = rgen.nextInt(array.length);
      int temp = array[i];
      array[i] = array[randomPosition];
      array[randomPosition] = temp;
    }
    return array;
  }

  public static long[] shuffle(long[] array) {
    Random rgen = new Random();
    for (int i = 0; i < array.length; i++) {
      int randomPosition = rgen.nextInt(array.length);
      long temp = array[i];
      array[i] = array[randomPosition];
      array[randomPosition] = temp;
    }
    return array;
  }

  public static int[][] shuffle(int[][] array) {
    Random rgen = new Random();
    for (int i = 0; i < array.length; i++) {
      int randomPosition = rgen.nextInt(array.length);
      int[] temp = array[i];
      array[i] = array[randomPosition];
      array[randomPosition] = temp;
    }
    return array;
  }

  public static int[][] sort(int[][] array) {
    //Sort an array (immune to quicksort TLE)

    Arrays.sort(array, new Comparator<int[]>() {
      @Override
      public int compare(int[] a, int[] b) {
        return a[1]-b[1]; //ascending order
      }
    });
    return array;
  }

  public static long[][] sort(long[][] array) {
    //Sort an array (immune to quicksort TLE)
    Random rgen = new Random();
    for (int i = 0; i < array.length; i++) {
      int randomPosition = rgen.nextInt(array.length);
      long[] temp = array[i];
      array[i] = array[randomPosition];
      array[randomPosition] = temp;
    }
    Arrays.sort(array, new Comparator<long[]>() {
      @Override
      public int compare(long[] a, long[] b) {
        if (a[0] < b[0])
          return -1;
        else if (a[0] > b[0])
          return 1;
        else
          return 0;
      }
    });
    return array;
  }

  static class MyScanner {
    private BufferedReader br;
    private StringTokenizer st;

    MyScanner() {
//      try {
//        br = new BufferedReader(new InputStreamReader(new FileInputStream(new File("/tmp/s.txt"))));
//      } catch (FileNotFoundException e) {
//        e.printStackTrace();
//      }
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

    int nextInt() {
      return Integer.parseInt(next());
    }

    long nextLong() {
      return Long.parseLong(next());
    }

    double nextDouble() {
      return Double.parseDouble(next());
    }

    String nextLine(){
      String str = "";
      try {
        str = br.readLine();
      } catch (IOException e) {
        e.printStackTrace();
      }
      return str;
    }
  }

  static class Pair<K,V> {

    public K key;
    public V value;

    public Pair(K key, V value) {
      this.key = key;
      this.value = value;
    }

    @Override
    public String toString() {
      return key + ":" + value;
    }

    @Override
    public int hashCode() {
      return key.hashCode() * 13 + (value == null ? 0 : value.hashCode());
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o instanceof Pair) {
        Pair pair = (Pair) o;
        return Objects.equals(key, pair.key) && Objects.equals(value, pair.value);
      }
      return false;
    }

    public Pair<V, K> invert() {
      return new Pair<>(value, key);
    }
  }

  static class Triple<A, B, C> {
    public A a;
    public B b;
    public C c;

    public Triple(A a, B b, C c) {
      this.a = a;
      this.b = b;
      this.c = c;
    }

    @Override
    public String toString() {
      return a + ":" + b + ":" + c;
    }

    @Override
    public int hashCode() {
      return (a == null ? 0 : a.hashCode()) * 13 + (b == null ? 0 : b.hashCode()) * 41 + (c == null ? 0 : c.hashCode());
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o instanceof Triple) {
        Triple triple = (Triple) o;
        return Objects.equals(a, triple.a) && Objects.equals(b, triple.b) && Objects.equals(c, triple.c);
      }
      return false;
    }
  }
}
