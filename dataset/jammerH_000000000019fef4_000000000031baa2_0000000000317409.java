import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;


/**
 * Template
 */
public class Solution {
  public static void main(String[] args) throws FileNotFoundException {
    InputStream inputStream = System.in;
    // String file = "/Users/hshankar/learn/codejam2020/src/com/company/test";
    // InputStream inputStream = new FileInputStream(file);
    Scanner in =
        new Scanner(new BufferedReader(new InputStreamReader(inputStream)));
    int t = in.nextInt();
    for (int i = 1; i <= t; ++i) {
      System.out.print("Case #" + i + ": ");
      int x = in.nextInt();
      int y = in.nextInt();
      int dist = x+y;
      int min = Integer.MAX_VALUE;
      String s = in.nextLine().substring(1);
      if (dist == 0) {
        System.out.println("0");
        return;
      }
      int xc=x,yc = y;
      for (int j=1;j<=s.length();++j) {
        char c = s.charAt(j-1);
        if (c == 'N')  yc++;
        else if (c == 'E')  xc++;
        else if (c == 'S')  yc--;
        else if (c == 'W')  xc--;
        dist = Math.abs(xc) + Math.abs(yc);
        if (j >= dist) {
          min = Math.min(j, min);
        }
      }
      if (min == Integer.MAX_VALUE) {
        System.out.println("IMPOSSIBLE");
      } else {
        System.out.println(min);
      }
    }
  }
}