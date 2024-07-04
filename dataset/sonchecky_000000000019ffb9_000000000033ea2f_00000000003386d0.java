import java.util.*;
import java.io.*;
public class Solution {
  static int [] x;
  static int [] y;
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();
    for (int i = 1; i <= t; i ++) {
      int n = in.nextInt(); // number of holes
      x = new int[n];
      y = new int[n];
      for (int j = 0; j < n; j ++) {
        x[j] = in.nextInt();
        y[j] = in.nextInt();
      }
      int maxHoles;
      if (n <= 4)
        maxHoles = n;
      else {
        maxHoles = 4;
        for (int a = 0; a < n-3; a ++)
          for (int b = a+1; b < n-2; b ++)
            for (int c = b+1; c < n-1; c ++)
              for (int d = c+1; d < n; d ++) 
                if (isParallel(a,b,c,d) || isParallel(a,c,b,d) || isParallel(a,d,b,c)) maxHoles = Math.min(n,6);
        // for n = 7, need 3 parallel lines or 2 3-long parallel lines
        if (n == 7)
          for (int a = 0; a < n; a ++)
            for (int b = 0; b < n; b ++)
              for (int c = 0; c < n; c ++)
                for (int d = 0; d < n; d ++)
                  for (int e = 0; e < n; e ++)
                    for (int f = 0; f < n; f ++) 
                      if ((a != b && a != c && a != d && a != e && a != f
                          && b != c && b != d && b != e && b != f
                          && c != d && c != e & c != f
                          && d != e && d != f
                          && e != f) && 
                          (isParallel(a,b,c,d) && isParallel(a,b,e,f) ||
                            isParallel(a,b,b,c) && isParallel(d,e,e,f) && isParallel(a,b,d,e)))
                        maxHoles = 7;
      }
      System.out.println("Case #" + i + ": " + maxHoles);
    }
  }
  // determine if lines n1-n2 and n3-n4 are parallel
  public static boolean isParallel(int n1, int n2, int n3, int n4) {
    long dx1, dy1, dx2, dy2;
    dx1 = x[n2]-x[n1];
    dy1 = y[n2]-y[n1];
    dx2 = x[n4]-x[n3];
    dy2 = y[n4]-y[n3];
    return (dx2 * dy1 == dx1 * dy2);
  }
}
