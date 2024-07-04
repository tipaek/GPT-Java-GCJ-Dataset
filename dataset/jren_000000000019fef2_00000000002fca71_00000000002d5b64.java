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
  
  static int n, m, k, count, p;
  static boolean flag;
  static int[] a, b;

  // static int[][] dp;

  static boolean[] isPrime;
  static int max = (int) 1e6;
  static List<String> ans;


  static void solve() throws Exception {
    int r = in.nextInt();
    int s = in.nextInt();

    ans = new ArrayList<>();

    move(r, s);

    out.println(ans.size());
    for (String ss : ans) {
      out.println(ss);
    }

    

  }

  static void move(int r, int s) {
    if (r == 1) {return;}
    int rr = r, ss = s;
    for (int i = 0; i < s - 1; i++) {
      ans.add((r * (s - 1) - i) + " " + (r - 1));
    }
    move(r - 1, s);
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

} 