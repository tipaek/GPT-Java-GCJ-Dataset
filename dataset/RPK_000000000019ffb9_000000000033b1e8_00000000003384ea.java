import java.util.*;
import java.io.*;
public class Solution {
  public static long calc(long b, long c) {
    return (long) Math.floor((Math.sqrt(b * b + 4 * c) - b) / 2.0);
  }
  
  public static void work(long[] a) {
    long nl = calc(a[2] - 1, a[0]);
    long nr = calc(a[2], a[1]);
    a[0] -= nl * nl + (a[2] - 1) * nl;
    a[1] -= nr * nr + a[2] * nr;
    a[2] += nl + nr;
    System.out.println((a[2] - 1) + " " + a[0] + " " + a[1]);
  }
  
  public static void solve(Scanner in) {
    long[] res = new long[3];
    res[0] = in.nextLong();
    res[1] = in.nextLong();
    long diff = Math.abs(res[0] - res[1]);
    res[2] = calc(1, 2 * diff);
    long s = (res[2] + 1) * res[2] / 2;
    ++res[2];
    if(res[0] >= res[1]) {
      res[0] -= s;
    } else {
      res[1] -= s;
      if(res[0] < res[1]) {
        if(res[1] < res[2]) {
          System.out.println((res[2] - 1) + " " + res[0] + " " + res[1]);
          return;
        }
        res[1] -= res[2];
        ++res[2];
      }
    }
    work(res);
  }
    
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();
    for (int i = 1; i <= t; ++i) {
      System.out.print("Case #" + i + ": ");
      solve(in);
    }
  }
}