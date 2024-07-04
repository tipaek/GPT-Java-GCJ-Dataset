
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
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
    return new Solver(input).solve();
  }

  static class Solver {

    private final Input input;
    private final int[][] points;
    private final Map<Integer, Integer> memo;

    Solver(Input input) {
      this.input = input;

      points = new int[input.M.length() + 1][2];
      points[0][0] = input.X;
      points[0][1] = input.Y;

      for (int i = 0, x = input.X, y = input.Y; i < input.M.length(); i++) {
        char c = input.M.charAt(i);
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
        points[i+1][0] = x;
        points[i+1][1] = y;
//        System.out.println(Arrays.toString(points[i+1]));
      }

      memo = new HashMap<>();
    }

    private String solve() {
      int solution = solve(0, 0, 0);
      return solution == Integer.MAX_VALUE ? "IMPOSSIBLE" : Integer.toString(solution);
    }

    private int solve(int x, int y, int index) {
      Integer key = key(x, y, index);
      if (memo.containsKey(key)) {
        return memo.get(key);
      }

      final Integer bestMove = findBestMove(x, y, index);
    //   memo.put(key, bestMove);
      return bestMove;
    }

    private Integer findBestMove(int x, int y, int index) {
      if (x == points[index][0] && y == points[index][1]) {
//        System.out.printf("%d %d %d\n", x, y, index);
        return 0;
      }

      if (index == input.M.length()) return Integer.MAX_VALUE;

      int[][] moves = {
        {0, 0},
        {0, 1},
        {0, -1},
        {1, 0},
        {-1, 0}
      };

      int min = Integer.MAX_VALUE;

      for (int[] move : moves) {
        int x2 = x + move[0];
        int y2 = y + move[1];
        min = Math.min(min, solve(x2, y2, index + 1));
      }

      return min == Integer.MAX_VALUE ? min : min + 1;
    }
  }
}
