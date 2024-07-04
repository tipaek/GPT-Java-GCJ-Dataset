import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = Integer.parseInt(in.nextLine());
    for (int c = 1; c <= t; ++c) {
      int d = 0;
      String s = in.nextLine();
      StringBuffer result = new StringBuffer();
      for (char ch : s.toCharArray()) {
        int expectedD = Integer.parseInt(ch + "");
        while (expectedD > d) {
          d++;
          result.append("(");
        }
        while (expectedD < d) {
          d--;
          result.append(")");
        }
        result.append(ch);
      }

      while (d > 0) {
        d--;
        result.append(")");
      }
      System.out.println(String.format("Case #%d: %s", c, result.toString()));
    }
  }
}