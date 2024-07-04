import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int caseCount = Integer.parseInt(in.nextLine());
    for (int caseNumber = 1; caseNumber <= caseCount; caseNumber++) {
      int openBraces = 0;
      String caseLine = in.nextLine();
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < caseLine.length(); i++) {
        int digit = Character.getNumericValue(caseLine.charAt(i));
        if (openBraces < digit) {
          while (openBraces != digit) {
            sb.append("(");
            openBraces++;
          }
        } else if (openBraces > digit) {
          while (openBraces != digit) {
            sb.append(")");
            openBraces--;
          }
        }
        sb.append(digit);
      }
      while (openBraces > 0) {
        sb.append(")");
        openBraces--;
      }
      System.out.println("Case #" + caseNumber + ": " + sb.toString());
    }
  }
}