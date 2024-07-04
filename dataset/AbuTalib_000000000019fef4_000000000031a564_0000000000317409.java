import java.util.*;
import java.io.*;

class Solution {
  public static void main(final String[] args) {
    final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int rr = in.nextInt();
    in.nextLine();
    for (int t = 1; t <= rr; t++) {
      System.out.print("Case #" + t + ": ");
      int x = in.nextInt();
      int y = in.nextInt();
      char[] path = in.next().toCharArray();
      in.nextLine();
      boolean broke = true;
      for (int i = 0; i < path.length; i++) {
        if (path[i] == 'N')
          y++;
        else if (path[i] == 'S')
          y--;
        else if (path[i] == 'E')
          x++;
        else
          x--;
        if (Math.abs(x) + Math.abs(y) <= i + 1) {
          broke = false;
          System.out.println(i + 1);
          break;
        }
      }
      if (broke)
        System.out.println("IMPOSSIBLE");
    }
  }
}