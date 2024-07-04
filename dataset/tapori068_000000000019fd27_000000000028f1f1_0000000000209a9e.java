import java.util.Scanner;

public class Solution {
  private static void ask(int bit) {
    System.out.println(bit);
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    int b = in.nextInt();
    for (int i = 1; i <= t; ++i) {
      StringBuffer result = new StringBuffer();
      for (int j = 0; j<b; j++) {
        ask(j+1);
        String temp = in.next();
        result.append(temp);
      }
      System.out.println(result);
      String ignore = in.next();
      if (!ignore.equals("Y")) {
        break;
      }
    }
  }

}
