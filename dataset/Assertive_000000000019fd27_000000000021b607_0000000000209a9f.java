import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

  private Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

  private void solve() throws Exception {
    StringBuilder sb = new StringBuilder();
    String s = sc.next();
    char[] chars = s.toCharArray();
    int prev = 0;
    for (char c : chars) {
      int cur = c - 48;
      int diff = cur - prev;
      if (diff >=0) {
        for (int i = 0; i < diff; i++) {
          sb.append("(");
        }
      }
      else {
        for (int i = 0; i < diff * -1; i++) {
          sb.append(")");
        }
      }
      sb.append(cur);
      prev = cur;
    }
    for (int i = 0; i < prev; i++) {
      sb.append(")");
    }
    System.out.print(sb.toString());
  }

  private void run() throws Exception {
    int t = sc.nextInt();
    for (int i = 1; i <= t; i++) {
      System.out.print("Case #" + i + ": ");
      solve();
      System.out.println();
    }
    sc.close();
    System.out.close();
  }


  public static void main(String[] args) throws Exception {
    new Solution().run();
  }

}