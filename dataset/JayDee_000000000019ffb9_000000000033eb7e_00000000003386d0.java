import java.util.*; 
import java.io.*;

public class Solution {
  static boolean debug = false;
  static long OFFSET = 2_100_000_000;
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in); 

    int numT = in.nextInt();
    for(int t=0; t<numT; t++) {
      int n = in.nextInt();

      long[] x = new long[n];
      long[] y = new long[n];
      for(int i=0; i<n; i++) {
        x[i] = in.nextLong();
        y[i] = in.nextLong(); 
      }

      // Go through every angle
      long ans = 0;
      HashSet<Long> seen = new HashSet<>();
      for(int from=0; from<n; from++) {
        for (int to=0; to<n; to++) {
          if(from == to) continue; 

          long a = y[to] - y[from]; 
          long b = x[to] - x[from];

          if(a < 0) {
            a = -a;
            b = -b;
          }

          // divide by gcd oops
          long gcd = gcd(a, Math.abs(b));
          a /= gcd;
          b /= gcd;

          if(a == 0) b = 1;
          if(b == 0) a = 1; // forgot about vert/horiz

          
          long angle = a*OFFSET + b;
          if(seen.contains(angle)) continue;
          seen.add(angle); 
          if(debug) System.out.printf("from=%d to=%d, a=%d b=%d\n", from, to, a, b);

          // Find out how many are on this angle
          // So to do so, put every point on a line at that angle,
          // get frequency of each line
          // Going to describe every line with c
          // ax + by = c  // laziness lol
          HashMap<Long, Long> freqs = new HashMap<>();
          for(int i=0; i<n; i++) {
            long val = a*x[i] + b*y[i]; 
            freqs.putIfAbsent(val, 0l);
            freqs.put(val, freqs.get(val) + 1);
          }

          long curAns = 0;
          boolean haveHangingOdd = false;
          for(Map.Entry elem : freqs.entrySet()) {
            long freq = (long)elem.getValue(); 
            if(debug) System.out.printf("(%d, %d) ", (long)elem.getKey(), freq);
            if(freq%2 == 1) {
              if(freq > 1) {
                if(haveHangingOdd) {
                  // Add one from the previous
                  curAns++;

                  haveHangingOdd = false;
                } else {
                  // This forms a hanging odd.
                  haveHangingOdd = true;
                }
              }
              // Always add the even pairs in a line
              curAns += freq-1;
            } else {
              curAns += freq;
            }

            
          }
          if(debug) System.out.println();

          if (curAns > ans) ans = curAns; 

        }
      }

      // add the entry and exit point
      if(ans < n) ans++;
      if(ans < n) ans++;

      System.out.printf("Case #%d: %d\n", (t+1), ans);

    }
  }

  static long gcd(long a, long b) { return b == 0 ? a : gcd(b, a%b); }

  static class FS {
    public BufferedReader in;
    public StringTokenizer token;
    public FS(InputStream stream) {
      in = new BufferedReader(new InputStreamReader(stream));
    }
    public String next() {
      if(token == null || !token.hasMoreElements()) {
        try {
          token = new StringTokenizer(in.readLine()); 
        } catch (Exception e) {} 
        return next();
      }
      return token.nextToken();
    }
    public long nextLong() {
      return Long.parseLong(next());
    }
  }

}
/* 

So... I'm going to assume every hole is a wormhole, no reason not to make it

I'm kinda confused. Why don't we "just" do n^2 to find all the direction vectors,
  then "just" choose the one that has the greatest frequency

I suppose the problems may be a few things. What if there are 3 in a line?
  As in sample case 3 (Which is awesome that they gave us that, thanks)

Another problem is the possibility of double counting with 3 in a row.
It may be more optimal for something else

If 2 in a row, you can connect them
If 3 in a row, can merge two 3s in a row, and treat outside as inner.


n <= 100
n^2 definitely works
n^3 should work

n^2 different angles
  Then for each angle:
    Check how many are co-linear on that angle (easier said than done)
    Could make a bunch of lines and throw each point into that line's frequency
    Rep each line as the c value in ax + by + c = 0
    Thus we use that in a hashmap

    Then iterate through the hash map, taking all even ones
    if there are odd ones > 1, then we match those up, else take them-1
    So do a frequency lolol meme.


Test Cases:

5
2
0 0
5 5
3
0 0
5 5
5 0
5
0 0
5 5
5 0
3 2
2 4
7
0 0
1 1
2 1
3 1
8 2
11 2
14 2
1
-1000000000 1000000000

Case #1: 2
Case #2: 3
Case #3: 4
Case #4: 7
Case #5: 1


1
7
0 0
1 1
2 1
3 1
8 2
11 2
14 2

Case #1: 7



1
5
0 0
5 5
5 0
3 2
2 4

Case #1: 4


*/