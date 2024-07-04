import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int numOfCases = in.nextInt();
    for (int i = 1; i <= numOfCases; i++) {
      String str = in.next();
      solution(i, str);
    }
  }

  private static void solution(int numberOfCase, String input) {
    StringBuilder sb = new StringBuilder();

    int numberOfOpen = 0;

    for (char c : input.toCharArray()) {
      int num = c - '0';
      if (numberOfOpen < num) {
        while (numberOfOpen != num) {
          sb.append('(');
          numberOfOpen++;
        }
        sb.append(c);
      } else if (numberOfOpen > num) {
        while (numberOfOpen != num) {
          sb.append(')');
          numberOfOpen--;
        }
        sb.append(c);
      } else {
        sb.append(c);
      }

    }

    while (numberOfOpen != 0) {
      sb.append(')');
      numberOfOpen--;
    }

    System.out.println("Case #" + numberOfCase + ": " + sb.toString());
  }
}
