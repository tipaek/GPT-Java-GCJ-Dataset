import java.util.Scanner;

public class Solution {

  private static class Pair {

    int x;
    int y;

    public Pair(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int t = scanner.nextInt();
    int t1 = t;
    while (t-- > 0) {
      int cx, cy;
      cx = scanner.nextInt();
      cy = scanner.nextInt();
      String path = scanner.next();
      int dist = Math.abs(cx) + Math.abs(cy);
      if (dist == 0) {
        System.out.println(0);
      }
      int i;
      for (i = 0; i < path.length(); i++) {
        if (path.charAt(i) == 'N') {
          cy++;
        } else if (path.charAt(i) == 'S') {
          cy--;
        } else if (path.charAt(i) == 'W') {
          cx--;
        } else if (path.charAt(i) == 'E') {
          cx++;
        }
        dist = Math.abs(cx) + Math.abs(cy);
        //System.out.println(dist);
        if (dist <= (i+1)) {
          System.out.println("Case #"+ (t1-t) + ": " + (i+1));
          break;
        }
      }
      if (i == path.length()) {
        System.out.println("Case #"+ (t1-t) + ": IMPOSSIBLE");
      }
    }
  }
}
