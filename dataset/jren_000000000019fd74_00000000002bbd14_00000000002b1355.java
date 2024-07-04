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
  
  static int n, m, k, p, r, c;
  static long ans;
  static boolean flag;
  static int[] a, b;
  static Node[][] map;

  static int[] par;
  static int[][] dp;

  static boolean[] isPrime;
  static int max = (int) 1e6;

  static void solve() throws Exception {
    r = in.nextInt();
    c = in.nextInt();
    map = new Node[r][c];
    for (int rr = 0; rr < r; rr++) {
      for (int cc = 0; cc < c; cc++) {
        map[rr][cc] = new Node(rr, cc, in.nextInt());
      }
    }

    for (int rr = 0; rr < r; rr++) {
      for (int cc = 0; cc < c; cc++) {
        Node cur = map[rr][cc];
        cur.up = (rr == 0 ? null : map[rr - 1][cc]);
        cur.down = ((rr == r - 1) ? null : map[rr + 1][cc]);
        cur.left = (cc == 0 ? null : map[rr][cc - 1]);
        cur.right = ((cc == c - 1) ? null : map[rr][cc + 1]);
      }
    }

    flag = false;
    ans = 0;

    while (!flag) {
      playRound();
      // out.println(ans);
    }

    out.println(ans);


  }

  static void playRound() {
    List<int[]> toDelete = new ArrayList<>();
    for (int rr = 0; rr < r; rr++) {
      for (int cc = 0; cc < c; cc++) {
        Node cur = map[rr][cc];
        if (cur == null) continue;
        ans += cur.s;

        int ngSum = (cur.up == null ? 0 : cur.up.s) + (cur.down == null ? 0 : cur.down.s) + (cur.left == null ? 0 : cur.left.s) + (cur.right == null ? 0 : cur.right.s);
        int num = (cur.up == null ? 0 : 1) + (cur.down == null ? 0 : 1) + (cur.left == null ? 0 : 1) + (cur.right == null ? 0 : 1);

        // not delete
        if (ngSum <= num * cur.s) {continue;}


        

        toDelete.add(new int[]{rr, cc});

        // out.println("deleting: " + "(" + rr + ", " + cc + ")" +  "with ngSum: " + ngSum + ", num: " + num);
        

      }
    }

    // out.println(count);

    if (toDelete.isEmpty()) flag = true;

    for (int[] d : toDelete) {
      // delete
      Node cur = map[d[0]][d[1]];
      if (cur.down != null) cur.down.up = cur.up;
      if (cur.up != null) cur.up.down = cur.down;
      if (cur.left != null) cur.left.right = cur.right;
      if (cur.right != null) cur.right.left = cur.left;
      map[d[0]][d[1]] = null;
    }
  }

  static class Node {
    int r, c, s;
    Node up, down, left, right;

    Node(int rr, int cc, int ss) {
      r = rr; c = cc; s = ss;
    }
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