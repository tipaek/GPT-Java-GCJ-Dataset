import java.io.BufferedInputStream;
import java.io.PrintStream;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedInputStream(System.in));
    PrintStream out = System.out;
    int T = in.nextInt();
    char[] S;
    StringBuilder parenthesizedS;
    int i, j, depth, digit;
    for (int t = 1; t <= T; t++) {
      S = in.next().toCharArray();
      parenthesizedS = new StringBuilder();
      i = -1;
      depth = 0;
      while (++i < S.length) {
        digit = S[i] - 48;
        for (j = 0; j < depth - digit; j++) {
          parenthesizedS.append(")");
        }
        for (j = 0; j < digit - depth; j++) {
          parenthesizedS.append("(");
        }
        depth = digit;
        parenthesizedS.append(digit);
      }
      for (j = 0; j < depth; j++) {
        parenthesizedS.append(")");
      }
      out.println("Case #" + t + ": " + parenthesizedS);
    }
  }
}