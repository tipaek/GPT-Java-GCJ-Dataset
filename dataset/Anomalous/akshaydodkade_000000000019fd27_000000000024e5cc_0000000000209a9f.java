import java.util.Scanner;

/**
 * Solution
 */
public class Solution {
  private String digitString, resultString;

  private String getParaString(char digit) {
    int num = Character.getNumericValue(digit);
    StringBuilder result = new StringBuilder();
    result.append("(".repeat(num));
    result.append(digit);
    result.append(")".repeat(num));
    return result.toString();
  }

  private void addPara() {
    StringBuilder result = new StringBuilder();
    for (int i = 0; i < digitString.length(); i++) {
      result.append(getParaString(digitString.charAt(i)));
    }
    resultString = result.toString();
  }

  private void cleanPara() {
    StringBuilder result = new StringBuilder(resultString);
    for (int i = 2; i < result.length() - 2; i++) {
      if (result.charAt(i) == ')' && result.charAt(i + 1) == '(') {
        result.delete(i, i + 2);
        int key = i, counter = 0;
        while (key < result.length() && result.charAt(key) == '(') {
          counter++;
          key++;
        }
        i = (i - counter) - 1;
      }
    }
    resultString = result.toString();
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int T = sc.nextInt();
    for (int t = 1; t <= T; t++) {
      Solution obj = new Solution();

      // input
      obj.digitString = sc.next();

      obj.addPara();
      obj.cleanPara();

      // output
      System.out.println("Case #" + t + ": " + obj.resultString);
    }
  }
}