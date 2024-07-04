import java.io.*;
import java.util.*;

class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new FileReader("testing1.in"));
    PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("testing1.out")));

    int numCases = Integer.parseInt(reader.readLine());

    for (int caseNum = 1; caseNum <= numCases; caseNum++) {
      String input = reader.readLine();
      StringBuilder result = new StringBuilder();
      int openBrackets = 0;

      for (char c : input.toCharArray()) {
        int digit = Character.getNumericValue(c);
        while (openBrackets < digit) {
          result.append('(');
          openBrackets++;
        }
        while (openBrackets > digit) {
          result.append(')');
          openBrackets--;
        }
        result.append(c);
      }

      while (openBrackets > 0) {
        result.append(')');
        openBrackets--;
      }

      writer.printf("Case #%d: %s\n", caseNum, result.toString());
    }

    reader.close();
    writer.close();
  }
}