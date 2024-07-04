import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Solution
 */
public class Solution {
  static class FastReader {
    BufferedReader br;
    StringTokenizer st;

    public FastReader() {
      br = new BufferedReader(new InputStreamReader(System.in));
    }

    String next() {
      while (st == null || !st.hasMoreElements()) {
        try {
          st = new StringTokenizer(br.readLine());
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
      return st.nextToken();
    }

    int nextInt() {
      return Integer.parseInt(next());
    }

    long nextLong() {
      return Long.parseLong(next());
    }

    double nextDouble() {
      return Double.parseDouble(next());
    }

    String nextLine() {
      String str = "";
      try {
        str = br.readLine();
      } catch (IOException e) {
        e.printStackTrace();
      }
      return str;
    }
  }

  String digitString, resultString;

  String getParaString(String digit) {
    String result = "", openBrackets = "", closeBrackets = "";
    for (int i = 0; i < Integer.parseInt(digit); i++) {
      openBrackets += "(";
      closeBrackets += ")";
    }
    result = openBrackets + "" + digit + "" + closeBrackets;
    return result;
  }

  void calSolution() {
    resultString = "";
    for (int i = 0; i < digitString.length(); i++) {
      resultString += getParaString(digitString.substring(i, (i + 1)));
    }

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

    FastReader sc = new FastReader();

    T = sc.nextInt();
    for (t = 1; t <= T; t++) {
      Solution obj = new Solution();

      // input
      obj.digitString = sc.next();

      obj.calSolution();

      // output
      System.out.println("Case #" + t + ": " + obj.resultString);
    }
  }
}