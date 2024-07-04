
import java.util.Random;
import java.util.Scanner;

public class Solution {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    // scanner = example();
//    scanner = bigTest();

    int T = scanner.nextInt();
    for (int t = 0; t < T; t++) {
      Input input = Input.fromScanner(scanner);
      printCase(t, solve(input));
    }
  }

  private static Scanner example() {
    return new Scanner("7\n" +
      "4 4 SSSS\n" +
      "3 0 SNSS\n" +
      "2 10 NSNNSN\n" +
      "0 1 S\n" +
      "2 7 SSSSSSSS\n" +
      "3 2 SSSW\n" +
      "4 0 NESW");
  }

  private static Scanner bigTest() {
    Random random = new Random();

    StringBuilder sb = new StringBuilder();
    int T = 100;
    int A = 255;
    int maxLength = 500;

    char newline = '\n';
    sb.append(T).append(newline);
    for (int t = 0; t < T; t++) {
      sb.append(A).append(newline);
      for (int i = 0; i < A; i++) {
        int length = 1 + random.nextInt(maxLength);
        // TODO
      }
    }

    return new Scanner(sb.toString());
  }

  private static class Input {
    private final int X;
    private final int Y;
    private final String M;

    public Input(int X, int Y, String M) {
      this.X = X;
      this.Y = Y;
      this.M = M;
    }

    public static Input fromScanner(Scanner scanner) {
      int X = scanner.nextInt();
      int Y = scanner.nextInt();
      String M = scanner.next();
      return new Input(X, Y, M);
    }
  }

  private static void printCase(int t, String s) {
    System.out.println(String.format("Case #%d: %s", t + 1, s));
  }

  private static int key(int x, int y, int index) {
    return (x + 1000 * y) * 1000 + index;
  }

  private static String solve(Input input) {
    for (int index = 0, x = input.X, y = input.Y; index < input.M.length(); index++) {
      char c = input.M.charAt(index);
      switch (c) {
        case 'N':
          y++;
          break;
        case 'S':
          y--;
          break;
        case 'W':
          x--;
          break;
        case 'E':
          x++;
          break;
      }

      int d = Math.abs(x) + Math.abs(y);
      if (d <= index+1) return Integer.toString(index + 1);
    }

    return "IMPOSSIBLE";
  }
}
