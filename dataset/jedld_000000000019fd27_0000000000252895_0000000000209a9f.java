import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
      String s = in.next();
      String result = solution(s);
      System.out.println("Case #" + i + ": " + result);
    }
  }

  private static String solution(String input) {
    StringBuilder outputStr = new StringBuilder();
    int currentDepth = 0;
    for (int i = 0; i < input.length(); i++) {
      int a = input.charAt(i) - '0';
      if (a == currentDepth) {
        outputStr.append(a);
      } else if (a > currentDepth) {
        int pAdd = a - currentDepth;
        for (int j = 0; j < pAdd; j++) {
          outputStr.append("(");
        }
        outputStr.append(a);
        currentDepth += pAdd;
      } else {
        int pSub  = currentDepth - a;
        for(int j = 0; j < pSub; j++) {
            outputStr.append(")");
        }
        outputStr.append(a);
        currentDepth -= pSub;
      }
    }

    if (currentDepth > 0) {
        for (int i = 0; i < currentDepth; i++) {
            outputStr.append(")");
        }
    }

    return outputStr.toString();
  }
}
