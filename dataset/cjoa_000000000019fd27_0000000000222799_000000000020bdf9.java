import java.io.*;
import java.util.*;

class Interval implements Comparable<Interval> {
   public int id, startTime, endTime;
   public Interval(int id, int s, int e) {
      this.id = id;
      this.startTime = s;
      this.endTime = e;
   }
   public int compareTo(Interval other) {
      return startTime - other.startTime;
   }
}

public class Solution // implements Runnable
{
   public static void main (String[] args) throws IOException {
      (new Solution()).run();
   // new Thread(null, new untitled(), "", 1l * 50 * 1024 * 1024).start();
   }
   
   BufferedReader in;
   PrintWriter out;
   StringTokenizer st = new StringTokenizer("");

   void run() throws IOException {
      try {
         in = new BufferedReader(new FileReader("input.txt"));
         out = new PrintWriter("output.txt");
      } catch (Exception e) {
         in = new BufferedReader(new InputStreamReader(System.in));
         out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
      }

      solve();

      out.close();
   }

   void solve() throws IOException {
      cached = new int[1001][1001];
      memo = new boolean[1001][1001];
      path = new char[1001][1001];

      int TC = nextInt();
      for (tc = 1; tc <= TC; ++tc) {
         N = nextInt();
         intervals = new Interval[N+1];
         for (int i = 1; i <= N; ++i) {
            int s = nextInt();
            int t = nextInt();
            intervals[i] = new Interval(i-1, s, t);
         }
         intervals[0] = new Interval(0, 0, 0);
         Arrays.sort(intervals);
         if (go(1, 0, 0)) {
            char[] res = new char[N];
            for (int n = 1, c = 0, j = 0; n <= N; ++n) {
               res[ intervals[n].id ] = path[c][j];
               assert path[c][j] == 'C' || path[c][j] == 'J';
               if (path[c][j] == 'C')
                  c = n;
               else
                  j = n;
            }
            out.printf("Case #%d: %s\n", tc, new String(res));
         }
         else
            out.printf("Case #%d: IMPOSSIBLE\n", tc);
      }
   }
   
   int tc, N;
   Interval[] intervals;

   int[][] cached;
   boolean[][] memo;
   char[][] path;
   boolean go(int n, int c, int j) {
      if (n > N)
         return true;
      if (cached[c][j] != tc) {
         cached[c][j] = tc;
         if (intervals[n].startTime >= intervals[c].endTime) {
            if (go(n+1, n, j)) {
               path[c][j] = 'C';
               return memo[c][j] = true;
            }
         }
         if (intervals[n].startTime >= intervals[j].endTime) {
            if (go(n+1, c, n)) {
               path[c][j] = 'J';
               return memo[c][j] = true;
            }
         }
      }
      return memo[c][j] = false;
   }

   // get next token
   String next() throws IOException {
      while (!st.hasMoreTokens())
         st = new StringTokenizer(in.readLine());
      return st.nextToken();
   }

   // get next int
   int nextInt() throws IOException {
      return Integer.parseInt(next());
   }
}

