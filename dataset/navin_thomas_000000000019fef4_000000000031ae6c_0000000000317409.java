import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

class Solution {

  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();
    for (int testCaseNumber = 1; testCaseNumber <= t; ++testCaseNumber) {
      int x = in.nextInt();
      int y = in.nextInt();
      String catPath = in.next();
      int i;
      boolean flag = false;
      for (i = 0; i < catPath.length(); i++) {
        char ch = catPath.charAt(i);
        if (ch == 'N') {
          y++;
        } else if (ch == 'E') {
          x++;
        } else if (ch == 'S') {
          y--;
        } else {
          x--;
        }
        if (Math.abs(x) + Math.abs(y) <= i + 1) {
          flag = true;
          break;
        }
      }
      if (flag) {
        System.out.println("Case #" + testCaseNumber + ": " + (i + 1));
      } else {
        System.out.println("Case #" + testCaseNumber + ": " + "IMPOSSIBLE");
      }
    }
  }
}