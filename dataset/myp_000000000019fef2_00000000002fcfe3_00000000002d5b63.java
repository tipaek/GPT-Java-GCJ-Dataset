import java.util.*;
import java.io.*;

public class Solution {

  static int N = 1_000_000_000;
  static Scanner s = new Scanner(System.in);
  static int[][] pos = {{0, 0}, {-N / 2, -N / 2}, {-N / 2, N / 2}, {N / 2, -N / 2}, {N / 2, N / 2}};

  public static void main(String[] args) {
    int T = s.nextInt();
    int A = s.nextInt();
    int B = s.nextInt();
    s.nextLine();
    for (int t = 1; t <= T; t++) {
      boolean found = false;
      int x = 0, y = 0;
      for (int[] p : pos) {
        String result = guess(p[0], p[1]);
        if (result.equals("CENTER")) {
          found = true;
          break;
        } else if (result.equals("HIT")) {
          x = p[0];
          y = p[1];
          break;
        }
      }
      if (found) {
        continue;
      }

      int left = -N, right = x;
      while (left < right) {
        int mid = (left + right) / 2;
        String result = guess(mid, y);
        if (result.equals("CENTER")) {
          found = true;
          break;
        } else if (result.equals("HIT")) {
          right = mid;
        } else {
          left = mid + 1;
        }
      }
      if (found) {
        continue;
      }

      int lx = left;

      left = x;
      right = N;
      while (left < right) {
        int mid = (left + right + 1) / 2;
        String result = guess(mid, y);
        if (result.equals("CENTER")) {
          found = true;
          break;
        } else if (result.equals("HIT")) {
          left = mid;
        } else {
          right = mid - 1;
        }
      }
      if (found) {
        continue;
      }

      int mx = (lx + left) / 2;

      left = -N;
      right = y;
      while (left < right) {
        int mid = (left + right) / 2;
        String result = guess(mx, mid);
        if (result.equals("CENTER")) {
          found = true;
          break;
        } else if (result.equals("HIT")) {
          right = mid;
        } else {
          left = mid + 1;
        }
      }
      if (found) {
        continue;
      }
      int ly = left;

      left = y;
      right = N;
      while (left < right) {
        int mid = (left + right + 1) / 2;
        String result = guess(mx, mid);
        if (result.equals("CENTER")) {
          found = true;
          break;
        } else if (result.equals("HIT")) {
          left = mid;
        } else {
          right = mid - 1;
        }
      }
      if (found) {
        continue;
      }

      guess(mx, (ly + left) / 2);
    }
  }

  private static String guess(int x, int y) {
    System.out.println(x + " " + y);
    return s.nextLine();
  }
}
