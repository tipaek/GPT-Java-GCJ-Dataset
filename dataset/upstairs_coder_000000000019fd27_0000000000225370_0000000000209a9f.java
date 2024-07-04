import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    // Scanner sc = new Scanner(new File("input.txt"));
    int T = sc.nextInt();    
    int c = 0, count = 0;
    while (T-- > 0) {
      String S = sc.next();
      StringBuffer sb = new StringBuffer();
      count = S.charAt(0) - '0';
      while (count-- > 0) sb.append("(");
      for (int i = 0; i < S.length()-1; ++i) {
        sb.append(S.charAt(i));
        count = S.charAt(i) - S.charAt(i+1);
        if (count < 0) {
          count *= -1;
          while (count-- > 0) sb.append("(");
        } else while (count-- > 0) sb.append(")");
      }
      sb.append(S.charAt(S.length()-1));
      count = S.charAt(S.length()-1) - '0';
      while (count-- > 0) sb.append(")");
      System.out.printf("Case #%d: %s\n", ++c, sb.toString());
    }
  }
}