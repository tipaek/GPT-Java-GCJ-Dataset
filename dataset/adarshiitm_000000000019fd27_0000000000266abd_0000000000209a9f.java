import java.util.*;
import java.io.*;

public class Solution {

  public static void main(String args[]) throws FileNotFoundException {
    Scanner input = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int T = input.nextInt();
    for (int ks = 1; ks <= T; ks++) {
      String str = input.next();
      System.out.println("Case #" + ks + ": " + nestingDepth(str));
    }
  }

  private static String nestingDepth(String str) {
    StringBuilder stringBuilder = new StringBuilder();
    int open = 0;
    for (int i = 0; i < str.length(); i++) {
      int v = str.charAt(i) - '0';
      if (v < open) {
        while (open > v) {
          stringBuilder.append(')');
          open--;
        }
      } else if (v > open) {
        while (open < v) {
          stringBuilder.append('(');
          open++;
        }
      }
      stringBuilder.append(str.charAt(i));
    }

    while (open > 0) {
      stringBuilder.append(')');
      open--;
    }

    return stringBuilder.toString();
  }

}