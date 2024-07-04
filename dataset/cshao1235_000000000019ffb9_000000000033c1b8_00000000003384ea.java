import java.io.*;
import java.util.*;

public class Solution {
  static long[] simulate(long l, long r) {
    long[] ans = new long[3];

    long i = 1;
    while(true) {
      if (l >= r) {
        if (l < i) {
          break;
        }
        l -= i;
        i++;
      } else {
        if (r < i) {
          break;
        }
        r -= i;
        i++;
      }
    }

    ans[0] = i - 1;
    ans[1] = l;
    ans[2] = r;
    
    return ans;
  }
  
  static long part1(long d) {
    long a = (long) Math.sqrt(8 * d + 1);
    return (a - 1) / 2;
  }

  static long part2(long s1, long p) {
    double s = (double) s1;
    return (long) Math.floor((Math.sqrt(s * s + 4.0 * p) - s) / 2);
  }

  static long[] solve(long l, long r) {
    long[] ans = new long[3];

    long d = l - r;
    long s1 = 0;
    if (d > 0) {
      s1 = part1(d);
      l -= (s1 + 1) * s1 / 2;
    } else if (d < 0) {
      d = -1 * d;
      s1 = part1(d);
      r -= (s1 + 1) * s1 / 2;
    }
    ans[0] += s1;

    //System.out.println(s1);

    if (l >= r) {
      long li = part2(s1, l);
      long ri = part2(s1 + 1, r);

      //System.out.println(li + " " + ri);
      ans[0] += li + ri;
      l -= (li + s1) * li;
      r -= (ri + s1 + 1) * ri;
    } else {
      long li = part2(s1 + 1, l);
      long ri = part2(s1, r);

      //System.out.println(li + " " + ri);
      ans[0] += li + ri;
      l -= (li + s1 + 1) * li;
      r -= (ri + s1) * ri;
    }
    ans[1] = l;
    ans[2] = r;

    return ans;
  }
  public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(f.readLine());
		for(int num = 1; num <= t; num++) {
      StringTokenizer st = new StringTokenizer(f.readLine());
      long l = Long.parseLong(st.nextToken());
      long r = Long.parseLong(st.nextToken());

      long[] ans = solve(l, r);

      // System.out.println(Arrays.toString(simulate(l, r)));
      System.out.println("Case #" + num + ": " + ans[0] + " " + ans[1] + " " + ans[2]);
		}
		f.close();
	}
}