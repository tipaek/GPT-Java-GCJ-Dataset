import java.util.*;
import java.io.*;

class Solution {
  public static void main(final String[] args) {
    final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    final int rr = in.nextInt();
    for (int r = 1; r <= rr; r++) {
      System.out.print("Case #" + r + ": ");
      int x = in.nextInt();
      int y = in.nextInt();
      final long sum = x + y;
      final long posSum = Math.abs(x) + Math.abs(y);
      if (sum % 2 == 0)
        System.out.println("IMPOSSIBLE");
      else if (posSum == 1) {
        if (x == 1)
          System.out.println("E");
        else if (x == -1)
          System.out.println("W");
        if (y == 1)
          System.out.println("N");
        else if (y == -1)
          System.out.println("S");
      } else {
        long b = 0;
        long temp = 1;
        while (temp < posSum) {
          b++;
          temp *= 2;
        }
        final long total = (long) Math.pow(2, b) - 1;
        long d = total - sum;
        d /= 2;
        for (int i = 0; i < b; i++) {
          long value = (long) Math.pow(2, i);
          if ((d & value) != 0)
            value *= -1;
          value /= Math.abs(value);
          if (x % 2 != 0) {
            if (value < 0)
              System.out.print("W");
            else
              System.out.print("E");
            x -= value;
          } else {
            if (value < 0)
              System.out.print("S");
            else
              System.out.print("N");
            y -= value;
          }
          x /= 2;
          y /= 2;
        }
        System.out.println();
      }
    }
  }
}