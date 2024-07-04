import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    in.nextLine();
    for(int i = 1; i <= t; ++i) {
      String input = in.nextLine();
      String res = solve(input);
      res += addRight(input.charAt(input.length()-1) - '0');
      System.out.println("Case #" + i + ": " + res);
    }
  }


  static String solve(String input) {

    char[] ic = input.toCharArray();
    String res = "";
    for(int i = 0; i < ic.length; i++){
      if(i == 0) {
       res = res + addLeft(ic[i] - '0') + ic[i];
       continue;
      }

      int cur = ic[i]-'0', pre = ic[i-1]-'0';
      if(pre > cur) {
        res += addRight(pre - cur);
        res += ic[i];
      }
      if(pre == cur) {
        res += cur;
        continue;
      }
      if(pre < cur) {
        res += addLeft(cur - pre);
        res += ic[i];
      }
    }

    return res;
  }

  static String addLeft(int i) {
    String res = "";
    while(i > 0) {
      res += "(";
      i--;
    }
    return res;
  }

  static String addRight(int i) {
    String res = "";
    while(i > 0) {
      res += ")";
      i--;
    }
    return res;
  }
}