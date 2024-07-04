import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int caseNum = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int ks = 1; ks <= caseNum; ++ks) {
      System.out.println("Case #" + ks + ": " + solve(in));
    }
  }

  public static String solve(Scanner in) {
      
      String s = in.next();
      StringBuilder ans = new StringBuilder();
      LinkedList<Character> Q = new LinkedList<>();
      int i = 0;

      while (i < s.length()) {
          if ((Q.isEmpty() || Q.getLast() == '0') && s.charAt(i) == '1') {
              Q.add('(');
              Q.add('1');
          }
          else if (s.charAt(i) == '1') {
              Q.add('1');
          } else if (s.charAt(i) == '0' && Q.isEmpty()) {
            Q.add('0');
          } else if (s.charAt(i) == '0' && Q.getLast() == '0') {
              Q.add('0');
          } else if (s.charAt(i) == '0' && Q.getLast() == '1') {
              Q.add(')');
              Q.add('0');
          }
          i++;
      }

      if (!Q.isEmpty() && Q.getLast() == '1') Q.add(')');
      while (!Q.isEmpty()) ans.append(Q.poll());

      return ans.toString();
  }
}