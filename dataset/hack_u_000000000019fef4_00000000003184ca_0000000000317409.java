
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;
import java.util.Random;
import java.util.StringTokenizer;

public class Solution {

  static MyScanner scanner = new MyScanner();
  static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
  static final int MOD = 1000000007;
  static final boolean oj = System.getProperty("ONLINE_JUDGE") != null;
  static final int[][] d4 = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
  static final int[][] d8 = new int[][]{{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
  static final int N = 0;

  private static void solve(int tid) {
    int x = scanner.nextInt();
    int y = scanner.nextInt();
    String s = scanner.next();
    if(x == 0 && y == 0) {
      out.printf("Case #%d: %d\n", tid, 0);
      return;
    }
    for(int i=0; i<s.length(); i++) {
      if(s.charAt(i) == 'S') y--;
      else if(s.charAt(i) == 'N') y++;
      else if(s.charAt(i) == 'E') x++;
      else x--;
      if(Math.abs(x) + Math.abs(y) <= i+1) {
        out.printf("Case #%d: %d\n", tid, i+1);
        return;
      }
    }
    out.printf("Case #%d: IMPOSSIBLE\n", tid);
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
