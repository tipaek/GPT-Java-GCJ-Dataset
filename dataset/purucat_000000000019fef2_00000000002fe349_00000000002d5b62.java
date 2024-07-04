import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
  public static void main(String[] args) {
    Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int T = sc.nextInt();
    for (int t = 1; t <= T; t++) {
      int x = sc.nextInt(), y = sc.nextInt();
      boolean sX = x < 0, sY = y < 0;
      x = Math.abs(x);
      y = Math.abs(y);
      if (x % 2 == 1 && y % 2 == 1) {
        System.out.println("Case #" + t +": IMPOSSIBLE");
        continue;
      }
      StringBuilder sb = new StringBuilder();
      int st = 1;
      if (x != 0 && y % 2 == 1) {
        sb.append('S');
        while (st * 2 <= y) {
          sb.append("E");
          st *= 2;
        }
        sb.append("N");
        swap(sb, sX, sY);
      } else if (x % 2 == 1 && y != 0){
        sb.append('W');
        while (st * 2 <= y) {
          sb.append("N");
          st *= 2;
        }
        sb.append("E");
        swap(sb, sX, sY);
      } else if (x == 0 || y == 0) {
        int s = 1;
        sb.append('E');
        while (s < Math.max(x,y)) {
          sb.append("E");
          st *= 2;
          s += st;
        }
        if (x == 0) {
          for (int i = 0; i < sb.length(); i++) {
            sb.setCharAt(i, 'N');
          }
        }
        swap(sb, sX, sY);
      }
      System.out.println("Case #" + t + ": " + sb.toString());
    }
  }

  private static void swap(StringBuilder sb, boolean x, boolean y) {
    if (!x && !y) return;
    for (int i = 0; i < sb.length(); i++) {
      char c = sb.charAt(i);
      if (x) {
        if (c == 'E') {
          sb.setCharAt(i, 'W');
        }
        if (c == 'W') {
          sb.setCharAt(i, 'E');
        }
      }

      if (y) {
        if (c == 'S') {
          sb.setCharAt(i, 'N');
        }
        if (c == 'N') {
          sb.setCharAt(i, 'S');
        }
      }
    }
  }
}
