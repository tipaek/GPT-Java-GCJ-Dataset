import java.util.*;
import java.io.*;
import java.math.BigInteger;

 
class Solution implements Runnable {
  static Scanner in; 
  // static FastReader in;
  static PrintWriter out;
  static int[][] dirs8 = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {-1, -1}, {-1, 1}, {1, -1}};
  static int[][] dirs = {{0, -1}, {1, 0}, {0, +1}, {-1, 0}};
 
  static int[][] E;
  // static List<int[]>[] adj;
  // static List<Integer>[] adj;
  static int[][] adj;
  static int[] vis;
 
  static long INFL = (long) 1e15 + 7;
  static int INF = (int) 1e7 + 9;
  static int mod = 998244353;
  
  static int n, m, k, count;
  static boolean flag;
  static int[] a, b;
  static int[][] map, matrix;

  static int[] par;
  static int[][] dp;

  static boolean[] isPrime;
  static int max = (int) 1e6;

  static void solve() throws Exception {
    String s = in.next();
    StringBuilder sb = f(new StringBuilder(s));
    int cur = 0;
    for (int i = 0; i < sb.length(); i++) {
      if (sb.charAt(i) == '0') {
        sb.setCharAt(i, s.charAt(cur++));
      }
    }
    out.println(sb);
  }

  static StringBuilder f(StringBuilder s) {
    // System.out.println(s);
    // if s.equals("0")
    boolean az = true;

    Deque<Integer> zeros = new ArrayDeque<>();

    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) != '0') {az = false;}
      if (s.charAt(i) == '0') {zeros.add(i);}
    }
    if (az) return s;

    StringBuilder sb = new StringBuilder();

    if (zeros.isEmpty()) {
      
      sb.append('(');
      StringBuilder nextsb = new StringBuilder();
      for (int i = 0; i < s.length(); i++) {
        nextsb.append((char) (s.charAt(i) - 1));
      }
      sb.append(f(nextsb));
      sb.append(')');

      return sb;

      // return sb.toString();
    }

    else {
      zeros.addFirst(-1);
      zeros.add(s.length());

      while (zeros.size() > 1) {
        int left = zeros.removeFirst() + 1;
        int right = zeros.peekFirst();
        if (left < right) {
          sb.append(f(new StringBuilder(s.substring(left, right))));
        }
        if (right < s.length()) {sb.append('0');}
      }
    }
    return sb;
  }

 



  
  

  
  public static void main(String[] args) throws Exception {
 
    in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    // in = new FastReader();
    out = new PrintWriter(System.out);
 
    int numOfTests = in.nextInt();
    for (int caseNum = 1; caseNum <= numOfTests; caseNum++) {
      out.print("Case #" + caseNum + ": ");

      // Thread t = new Thread(null, new Solution(), "Solution", 1 << 28);
      // t.start();
      // t.join();
      solve();
    }
 
    // // Thread t = new Thread(null, new Solution(), "Solution", 1 << 28);
    // // t.start();
    // // t.join();
    // solve();
 
    out.flush();
    out.close();
  }
 
  @Override
  public void run() {
    try {
      solve();
    } catch (Exception e) {
      e.printStackTrace(); 
    }
  }
 
  static class FastReader {
    public BufferedReader br; 
    StringTokenizer st; 
    public FastReader() {br = new BufferedReader(new InputStreamReader(System.in));} 
    String next() { 
      while (st == null || !st.hasMoreElements()) { 
          try {st = new StringTokenizer(br.readLine());} 
          catch (IOException e) {e.printStackTrace();} 
      } 
      return st.nextToken(); 
    } 
    int nextInt() {return Integer.parseInt(next());} 
    long nextLong() {return Long.parseLong(next());} 
    double nextDouble() {return Double.parseDouble(next());} 
    String nextLine() {
      String str = ""; 
        try {str = br.readLine();} 
        catch (IOException e) {e.printStackTrace();} 
        return str; 
    }
  }

  static void as(boolean result) throws Exception {
    if (!result) {
      throw new Exception();
    }
  }

  static int modInverse(int a, int m) { 
    int m0 = m; 
    int y = 0, x = 1; 
    if (m == 1) {return 0;} 
    while (a > 1) { 
      // q is quotient 
      int q = a / m; 
      int t = m; 
      // m is remainder now, process 
      // same as Euclid's algo 
      m = a % m; 
      a = t; 
      t = y; 
      // Update x and y 
      y = x - q * y; 
      x = t; 
    } 
    // Make x positive 
    if (x < 0) 
      x += m0; 
    return x; 
  }
} 