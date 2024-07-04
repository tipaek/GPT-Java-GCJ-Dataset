import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine());
    int offset = t;
    while (t-- > 0) {
      String s = br.readLine();
      String result = surroundBinaryStringByParens(s);
      System.out.println("Case #" + (offset - t) + ": " + result);
    }
  }

  private static String surroundBinaryStringByParens(String s) {
        StringBuilder stringBuilder = new StringBuilder(), stringBuilder1 = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1' && stringBuilder.length() == 0) {
                stringBuilder.append('(');
                stringBuilder.append('1');
            } else if (s.charAt(i) == '1') {
                stringBuilder.append('1');
            } else if (s.charAt(i) == '0' && stringBuilder.length() > 0) {
                stringBuilder1.append(stringBuilder).append(')').append('0');
                stringBuilder.delete(0, stringBuilder.length());
            } else {
                stringBuilder1.append(s.charAt(i));
            }
        }
        if (stringBuilder.length() > 0) {
            stringBuilder1.append(stringBuilder).append(')');
        }
        return stringBuilder1.toString();
    }
}