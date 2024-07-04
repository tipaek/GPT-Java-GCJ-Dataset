import java.util.Collections;
import java.util.Scanner;

public class Solution {

  public static void main(String[] args) {
    Scanner read = new Scanner(System.in);

    int cases = read.nextInt();
    read.nextLine();

    for (int x = 0; x < cases; x++) {
      String s = read.nextLine();
      solve(x + 1, s);
    }
  }

  public static void solve(int test, String s) {
    StringBuilder result = new StringBuilder();

    for(char c : s.toCharArray()) {
      int n = Integer.parseInt(String.valueOf(c));

      String left = String.join("", Collections.nCopies(n, "("));
      String right = String.join("", Collections.nCopies(n, ")"));
      result.append(left).append(c).append(right);
    }
    String rf = result.toString();
    while (true) {
      String newStr = rf.replaceAll("\\)\\(", "");
      if (rf.equals(newStr)) {
        System.out.printf("Case #%s: %s\n", test, rf.toString());
        return;
      }
      rf = newStr;
    }

  }

}
