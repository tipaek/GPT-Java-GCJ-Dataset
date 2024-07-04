import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
  private static void calc(String S, int caseNo) {
    int depth = 0;
    StringBuffer _S = new StringBuffer();

    for (Character character : S.toCharArray()) {
      int c = Character.digit(character, 10);

      if (depth < c) {
        while (depth < c) {
          _S.append("(");
          depth++;
        }
      } else if (depth > c) {
        while (depth > c) {
          _S.append(")");
          depth--;
        }
      }
      _S.append(character);
    }

    while (depth > 0) {
      _S.append(")");
      depth--;
    }

    System.out.println("Case #" + caseNo + ": " + _S.toString());
  }


  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
      int T = Integer.parseInt(br.readLine());

      for (int input = 1; input <= T; input++) {
        String S = br.readLine();
        calc(S, input);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
