

import java.util.*;

import java.io.*;
import java.math.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Solution
{
  public static void main (String[] args) throws IOException
  {
    Scanner in = new Scanner(System.in);
    int t = Integer.parseInt(in.nextLine());
    for(int i = 1; i <= t; i++)
    {
      String tmp = in.nextLine();
      String[] a = tmp.split(" ");
      int x = Integer.parseInt(a[0]);
      int y = Integer.parseInt(a[1]);
      if (Math.abs(x + y)%2 == 0) {
        System.out.println("Case #" + i +": IMPOSSIBLE");
      } else {
        boolean isXChet = x%2 == 0;
        int p = 0;
        int xs = 0, ys =0;
        StringBuilder res = new StringBuilder();
        while (true) {
          int idx = (int)Math.pow(2, p);
          if (p == 0) {
            // if X is not chetnyi
            if (!isXChet) {
              if (x == 3) {
                if (y == 0) {
                  res.append("EE"); // W || E
                  break;
                }
                xs = -1;
              } else if (x == -3) {
                if (y == 0) {
                  res.append("WW"); // W || E
                  break;
                }
                xs = 1;
              } else {
                xs = x%2; // -1 || 1
              }
              res.append(xs == 1 ? "E" : "W"); // W || E
              // y is not chetnyi
            } else {
              if (y == 3) {
                if (x == 0) {
                  res.append("NN"); // W || E
                  break;
                }
                ys = -1;
              } else if (y == -3) {
                if (x == 0) {
                  res.append("SS"); // W || E
                  break;
                }
                ys = 1;
              } else {
                ys = x%2; // -1 || 1
              }
              res.append(ys == 1 ? "N" : "S"); // W || E
            }
          } else {
            boolean flag = false;
            if (xs != x) {
              if (xs + idx == x) {
                res.append("E"); // W || E
                xs += idx;
                flag = true;
              } else if (xs - idx == x) {
                flag = true;
                xs -= idx;
                res.append("W"); // W || E
              }
              //xs = xs +
            } else if (ys != y) {
              if (ys + idx == y) {
                flag = true;
                ys += idx;
                res.append("N"); // W || E
              } else if (ys - idx == y) {
                flag = true;
                ys -= idx;
                res.append("S"); // W || E
              }
            }
            if (!flag) {
              if (xs != x) {
                if (x < 0) {
                  xs -= idx;
                  res.append("W"); // W || E
                } else {
                  xs += idx;
                  res.append("E"); // W || E
                }
              }
            } else {
              if (y < 0) {
                ys -= idx;
                res.append("S"); // W || E
              } else {
                ys += idx;
                res.append("N"); // W || E
              }
            }
          }
          if (xs == x && ys == y) {
            break;
          }
          p++;
        }
        System.out.println("Case #" + i +": " + res.toString());
      }

    }
  }

}