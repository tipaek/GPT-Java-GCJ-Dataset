import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int tests = in.nextInt();  
    for (int i = 1; i <= tests; ++i) {
      String s = in.next();
     
      int startIndex = 0;
      int openBraces = 0;
      StringBuilder sb = new StringBuilder();
      while (startIndex < s.length()) {
          char ch = s.charAt(startIndex);
          int val = ch - '0';
          while (openBraces < val) {
              sb.append('(');
              openBraces++;
          }
          
          while (openBraces > val) {
              sb.append(')');
              openBraces--;
          }
          
          sb.append(ch);
          while (startIndex + 1 < s.length() && s.charAt(startIndex + 1) == ch) {
              startIndex++;
              sb.append(ch);
          }
          startIndex++;
      }
      
      while (openBraces > 0) {
          sb.append(')');
          openBraces--;
      }
      
      
      System.out.println("Case #" + i + ": " + sb.toString());
    }
  }
}