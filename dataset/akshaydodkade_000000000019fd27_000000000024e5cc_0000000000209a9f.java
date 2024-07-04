import java.util.*;

/**
 * Solution
 */
public class Solution {
  String digitString, resultString;

  String getParaString(String digit) {
    String result = "";
    for (int i = 0; i < Integer.parseInt(digit); i++) {
      result += "(";
    }
    result += digit;
    for (int i = 0; i < Integer.parseInt(digit); i++) {
      result += ")";
    }
    return result;
  }

  void addPara() {
    resultString = "";
    for (int i = 0; i < digitString.length(); i++) {
      resultString += getParaString(digitString.substring(i, (i + 1)));
    }
  }

  void cleanPara() {
    for (int i = 2; i < (resultString.length() - 2); i++) {
      if (resultString.substring(i, (i + 1)).equals(")") && resultString.substring((i + 1), (i + 2)).equals("(")) {
        resultString = resultString.substring(0, i) + "" + resultString.substring(i + 2, (resultString.length()));

        int key = i, counter = 0;
        while (resultString.substring(key, (key + 1)).equals("(")) {
          counter++;
          key++;
        }
        i = (i - counter) - 1;
      }
    }
  }

  public static void main(String[] args) {
    int t, T;

    Scanner sc = new Scanner(System.in);

    T = sc.nextInt();
    for (t = 1; t <= T; t++) {
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