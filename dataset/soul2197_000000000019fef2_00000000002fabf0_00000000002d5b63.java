import java.util.Scanner;

public class Solution {
  public static void main(String[] args) {
    final Scanner scanner = new Scanner(System.in);
    final int T = scanner.nextInt();
    final int A = scanner.nextInt();
    final int B = scanner.nextInt();

    final int R = A == B ? A : -1;
    if (R == -1) System.exit(0);

    for (int t = 1; t <= T; t++) {
      int guesses = 0;
      String lastResult = "";
      Integer left = null;
      int nextLeftGuess = -1000000000;
      Integer top = null;
      int nextTopGuess = -1000000000;
      while (guesses < 300 && !lastResult.equals("CENTER") && !lastResult.equals("WRONG")) {
        if (left == null) {
          System.out.println(String.format("%d %d", nextLeftGuess, 51));
          lastResult = scanner.next();
          if (lastResult.equals("HIT")) {
            left = nextLeftGuess;
          } else {
            nextLeftGuess++;
          }
        } else if (top == null) {
          System.out.println(String.format("%d %d", 51, nextTopGuess));
          lastResult = scanner.next();
          if (lastResult.equals("HIT")) {
            top = nextTopGuess;
          } else {
            nextTopGuess++;
          }
        } else {
          System.out.println(String.format("%d %d", left + R, top + R));
          lastResult = scanner.next();
        }
        guesses++;
      }

      if (!lastResult.equals("CENTER")) {
        System.exit(0);
      }
    }
  }
}
