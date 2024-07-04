
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

class Solution {

  static MyScanner scanner = new MyScanner();
  static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
  static final int MOD = 1000000007;
  static final boolean oj = System.getProperty("ONLINE_JUDGE") != null;

  private static void process(int tid) {
    long x = scanner.nextLong();
    long y = scanner.nextLong();
    long xa = Math.abs(x), ya = Math.abs(y);
    String res = dfs(xa, ya);
    if(res == null) {
      out.printf("Case #%d: IMPOSSIBLE\n", tid);
      return;
    }
    StringBuilder r = new StringBuilder();
    for(int i=0; i<res.length(); i++) {
      if(res.charAt(i) == 'W' || res.charAt(i) == 'E') {
        if(x >= 0) r.append(res.charAt(i));
        else r.append(res.charAt(i) == 'E' ? 'W' : 'E');
      } else {
        if(y >= 0) r.append(res.charAt(i));
        else r.append(res.charAt(i) == 'N' ? 'S' : 'N');
      }
    }
    out.printf("Case #%d: %s\n", tid, r.toString());
  }

  private static String dfs(long xa, long ya) {
    if(xa == 0 && ya == 0) return "";
    if((xa%2 == 0 && ya%2 == 0) || (xa%2 == 1 && ya%2 == 1)) return null;
    if(xa%2 == 1) {
      String c1 = dfs((xa-1)/2, ya/2);
      if(c1 != null) return "E" + c1;
      String c2 = dfs((xa+1)/2, ya/2);
      if(c2 != null) return "W" + c2;
      return null;
    } else {
      String c1 = dfs(xa/2, (ya-1)/2);
      if(c1 != null) return "N" + c1;
      String c2 = dfs((xa)/2, (ya+1)/2);
      if(c2 != null) return "S" + c2;
      return null;
    }
  }

  public static void main(String[] args) {
    int t = scanner.nextInt();
    for(int i=0; i<t; i++) {
      process(i+1);
    }
    out.close();
  }

  public static void print(Object o) {
    if (!oj) {
      out.println(o);
    }
  }

  //Find the GCD of two numbers
  public static long gcd(long a, long b) {
    if (a < b)
      return gcd(b, a);
    if (b == 0)
      return a;
    else
      return gcd(b, a % b);
  }

  //Fast exponentiation (x^y mod m)
  public static long power(long x, long y, long m) {
    if (y < 0)
      return 0L;
    long ans = 1;
    x %= m;
    while (y > 0) {
      if (y % 2 == 1)
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
        return a[1] - b[1]; //ascending order
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

    String nextLine() {
      String str = "";
      try {
        str = br.readLine();
      } catch (IOException e) {
        e.printStackTrace();
      }
      return str;
    }
  }

  static class Pair<K, V> {

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
      if (this == o)
        return true;
      if (o instanceof Pair) {
        Pair pair = (Pair) o;
        return Objects.equals(key, pair.key) && Objects.equals(value, pair.value);
      }
      return false;
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
      return (a == null ? 0 : a.hashCode()) * 13 + (b == null ? 0 : b.hashCode()) * 41 + (c == null ? 0
          : c.hashCode());
    }

    @Override
    public boolean equals(Object o) {
      if (this == o)
        return true;
      if (o instanceof Triple) {
        Triple triple = (Triple) o;
        return Objects.equals(a, triple.a) && Objects.equals(b, triple.b) && Objects.equals(c, triple.c);
      }
      return false;
    }
  }
}
