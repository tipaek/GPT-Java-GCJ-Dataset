import java.util.*;

public class Solution {

  private static String algo(String line) {
    int N = line.length();
    if (N==0) {
      return "";
    }
    if (N==1) {
      int n = Character.getNumericValue(line.charAt(0));
      String ans = "";
      for (int i = 0; i < n; i++) ans += "(";
      ans += line.charAt(0);
      for (int i = 0; i < n; i++) ans += ")";
      return ans;
    }
    int min = 10;
    for (int i = 0; i < N; i++) {
      int num = Character.getNumericValue(line.charAt(i));
      if (num == 0) {
        //recurse on left and right
        return algo(line.substring(0,i)) + "0" + algo(line.substring(i+1));
      }
      min = Integer.min(min, num);
    }
    // decrement everything by min
    String decrLine = "";
    for (int i = 0; i < N; i++) {
      int num = Character.getNumericValue(line.charAt(i));
      Integer tmp = num - min;
      decrLine += tmp.toString();
    }
    // recurse on new line
    decrLine = algo(decrLine);
    // increment everything by min
    String incrLine = "";
    for (int i = 0; i < decrLine.length(); i++) {
      if (decrLine.charAt(i) == '(' || decrLine.charAt(i) == ')') {
        incrLine += decrLine.charAt(i);
        continue;
      }
      int num = Character.getNumericValue(decrLine.charAt(i));
      Integer tmp = num+min;
      incrLine += tmp.toString();
    }
    // return line with min parens around it
    String frontParens = "";
    String backParens = "";
    for (int i = 0; i < min; i++) {
      frontParens += "(";
      backParens += ")";
    }
    return frontParens + incrLine + backParens;

  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int T = Integer.parseInt(sc.nextLine());
    for(int t = 0; t < T; t++) {
      String line = sc.nextLine();
      String ans = algo(line);
      System.out.println("Case " + (t+1) + ": " + ans);
    }
  }
}