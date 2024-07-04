import java.util.Scanner;

public class Solution {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int T = Integer.parseInt(sc.nextLine());

    for (int i = 0; i < T; ++i) {
      String str = sc.nextLine();
      String ans = solve(str);
      System.out.println("Case #" + (i + 1) + ": " + ans);
    }
  }

  private static String solve(String str) {
    int len = str.length();
    StringBuilder ans = new StringBuilder();
    int cVal = Integer.parseInt(str.charAt(0) + "");
    int pVal = 0;
    for (int j = 0; j < cVal; j++) {
      ans.append("(");
    }
    ans.append(str.charAt(0));
    for (int i = 1; i < len; i++) {
      cVal = Integer.parseInt(str.charAt(i) + "");
      pVal = Integer.parseInt(str.charAt(i - 1) + "");
      if (cVal > pVal) {
        for (int j = 0; j < cVal - pVal; ++j) {
          ans.append("(");
        }
        ans.append(str.charAt(i));
      } else if (cVal < pVal) {
        for (int j = 0; j < pVal - cVal; ++j) {
          ans.append(")");
        }
        ans.append(str.charAt(i));
      } else {
        ans.append(str.charAt(i));
      }
    }
    while (cVal != 0) {
      ans.append(")");
      cVal--;
    }
    return ans.toString();
  }
}
