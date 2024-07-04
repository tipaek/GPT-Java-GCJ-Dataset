import java.util.*;
import java.io.*;

public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int numTestCases = Integer.parseInt(in.nextLine());
    for (int i = 1; i <= numTestCases; ++i) {
      char[] input = in.nextLine().toCharArray();

      String output = "";
      int nestDepth = 0;
      for (char c : input) {
        int value = Character.getNumericValue(c);
        if (value > nestDepth) {
          for (int j = value; j > nestDepth; --j) {
            output = output.concat("(");
          }
          output = output.concat(String.valueOf(c));
          nestDepth = value;
        } else if (value == nestDepth) {
          output = output.concat(String.valueOf(c));
        } else {
          for (int j = value; j < nestDepth; ++j) {
            output = output.concat(")");
          }
          output = output.concat(String.valueOf(c));
          nestDepth = value;
        }
      }
      for (int j = nestDepth; j > 0; --j) {
        output = output.concat(")");
      }
      System.out.println(String.format("Case #%d: %s", i, output));
    }
  }
}