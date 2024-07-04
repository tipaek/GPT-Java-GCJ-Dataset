import java.util.*;
import java.io.*;
public class Solution {
  static Map<String, String> parenthesisMap = new HashMap<>();

  public static void main(String[] args) {
    generateParenthesisMap();
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
    in.nextLine();
    for (int i = 1; i <= t; ++i) {
      String s = in.nextLine();
      String result = calculateNestingDepth(s);
      System.out.println("Case #" + i + ": " + result);
    }
  }

  private static void generateParenthesisMap() {
    for (int i = 0; i <= 9; i++) {
      String leftName = "L"+i;
      String rightName = "R"+i;
      String leftParam = "";
      String rightParam = "";
      for (int j = 1; j <=i ; j++) {
        leftParam += "(";
        rightParam += ")";
      }
      parenthesisMap.put(leftName, leftParam);
      parenthesisMap.put(rightName, rightParam);
    }
  }

  private static String calculateNestingDepth(String str) {
    StringBuilder sb = new StringBuilder();
    String[] strArr = str.split("");
    int[] intArr = new int[strArr.length];
    int N = intArr.length;
    for (int i = 0; i<N; i++) {
      intArr[i] = Integer.parseInt(strArr[i]);
    }
    String[] parenthesisArr = new String[N+1];
    int unMatched = intArr[0];
    parenthesisArr[0] = parenthesisMap.get("L" + intArr[0]);
    sb.append(parenthesisArr[0]);
    sb.append(strArr[0]);
    String optName = "";
    for (int i=1; i < N; i++) {
      int diff = intArr[i] - intArr[i-1];
      if (diff < 0) {
        optName = "R";
      } else {
        optName = "L";
      }
      diff = Math.abs(diff);
      String parenthesisKey = optName + diff;
      parenthesisArr[i] = parenthesisMap.get(parenthesisKey);
      sb.append(parenthesisMap.get(parenthesisKey));
      sb.append(strArr[i]);
    }
    parenthesisArr[N] = parenthesisMap.get("R" + intArr[N-1]);
    sb.append(parenthesisMap.get("R" + intArr[N-1]));
    return sb.toString();
  }

}