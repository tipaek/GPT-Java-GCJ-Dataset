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
  
  static int m, k, count, p;
  static boolean flag;
  static int[] a, b;
  static int[][] map, matrix;

  static int[] par;
  static int[][] dp;

  static boolean[] isPrime;
  static int max = (int) 1e6;

  static void solve() throws Exception {
    int n = in.nextInt();
    List<String> front = new ArrayList<>();
    List<String> end = new ArrayList<>();

    List<String> mid = new ArrayList<>();
    // String[] ps = new String[n];
    for (int i = 0; i < n; i++) {
      String cur = in.next();

      int first_idx = cur.indexOf("*");

      int last_idx = cur.lastIndexOf("*");

      int idx = -1;
      if (first_idx == last_idx) {
        idx = first_idx;
        if (idx == 0) {front.add(cur);}
        else if (idx == cur.length() - 1) {end.add(cur);}
        else {
          end.add(cur.substring(0, idx + 1));
          front.add(cur.substring(idx));
        }
      }

      else {
        if (first_idx > 0) {end.add(cur.substring(0, first_idx + 1));}
        if (last_idx < cur.length() - 1) {front.add(cur.substring(idx));}

        StringBuilder sb = new StringBuilder();
        for (int j = first_idx; j < last_idx; j++) {
          if (cur.charAt(j) != '*') {sb.append(cur.charAt(j));}
        }

        mid.add(sb.toString());
      }

      
    }

    // System.out.println(front);
    // System.out.println(end);


    String f = starAtFront(convert(front));
    String e = starAtEnd(convert(end));

    if (f == null || e == null) {out.println("*"); return;}
    out.print(e); 

    for (String s : mid) {
      out.print(s);
    }

    out.println(f);



    
    

    
  }

  static String[] convert(List<String> l) {
    String[] sa = new String[l.size()];
    for (int i = 0; i < sa.length; i++) {
      sa[i] = l.get(i);
    }
    return sa;
  }


  static String starAtEnd(String[] ps) {

    if (ps.length == 0) return "";
    // out.println(ps.length);
    int n = ps.length;
    int[] pp = new int[n];
    int maxLen = 0, maxIdx = -1;
    for (int i = 0; i < n; i++) {
      pp[i] = 0;
      if (ps[i].length() > maxLen) {maxLen = ps[i].length(); maxIdx = i;}
    }

    if (valid2(pp, ps, maxIdx)) {

      // System.out.println(ps[maxIdx].substring(0, ps[maxIdx].length() - 1));

      return (ps[maxIdx].substring(0, ps[maxIdx].length() - 1));
    } else {

      // System.out.println("null");

      return null;
    }
  }

  static boolean valid2(int[] pp, String[] ps, int idx) {
    int n = ps.length;

    while (pp[idx] < ps[idx].length() - 1) {
      char c = ps[idx].charAt(pp[idx]);
      for (int i = 0; i < n; i++) {
        if (pp[i] == ps[i].length() - 1) continue;
        
        if (ps[i].charAt(pp[i]) != c) {return false;}
        pp[i]++;
      }
    }
    return true;
  }



  static String starAtFront(String[] ps) {
    if (ps.length == 0) return "";
    int n = ps.length;

    int[] pp = new int[n];
    int maxLen = 0, maxIdx = -1;
    for (int i = 0; i < n; i++) {
      pp[i] = ps[i].length() - 1;
      if (ps[i].length() > maxLen) {maxLen = ps[i].length(); maxIdx = i;}
    }

    if (valid(pp, ps, maxIdx)) {


      // System.out.println(ps[maxIdx].substring(1));


      return (ps[maxIdx].substring(1));
    } else {

      // System.out.println("null");

      return null;
    }
  }

  static boolean valid(int[] pp, String[] ps, int idx) {
    int n = ps.length;

    while (pp[idx] > 0) {
      char c = ps[idx].charAt(pp[idx]);
      for (int i = 0; i < n; i++) {
        if (pp[i] == 0) continue;
        
        if (ps[i].charAt(pp[i]) != c) {return false;}
        pp[i]--;
      }
    }
    return true;
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