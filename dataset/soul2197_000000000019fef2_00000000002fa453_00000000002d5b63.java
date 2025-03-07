import java.util.Scanner;

public class Solution2 {
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
      while (guesses < 300 && !lastResult.equals("CORRECT")) {
        if (left == null) {
          System.out.println(String.format("%d %d", nextLeftGuess, 0));
          lastResult = scanner.next();
          if (lastResult.equals("HIT")) {
            left = nextLeftGuess;
          } else {
            nextLeftGuess++;
          }
        } else if (top == null) {
          System.out.println(String.format("%d %d", 0, nextTopGuess));
          lastResult = scanner.next();
          if (lastResult.equals("HIT")) {
            top = nextTopGuess;
          } else {
            nextTopGuess++;
          }
        } else {
          System.out.println(String.format("%d %d", left + R, top + R));
        }
        guesses++;
      }

      if (!lastResult.equals("CORRECT")) {
        System.exit(0);
      }
    }
  }
}
