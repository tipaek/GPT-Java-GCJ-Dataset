import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int testCases = scanner.nextInt();
    for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
      int x = scanner.nextInt();
      int y = scanner.nextInt();
      String path = scanner.next();
      System.out.println("Case #" + caseNumber + ": " + findMinimumSteps(x, y, path));
    }
  }

  private static String findMinimumSteps(int x, int y, String path) {
    if (x == 0 && y == 0) {
      return "0";
    }

    for (int step = 0; step < path.length(); step++) {
      char direction = path.charAt(step);
      switch (direction) {
        case 'N':
          y++;
          break;
        case 'S':
          y--;
          break;
        case 'E':
          x++;
          break;
        case 'W':
          x--;
          break;
      }

      if (Math.abs(x) + Math.abs(y) <= step + 1) {
        return String.valueOf(step + 1);
      }
    }

    return "IMPOSSIBLE";
  }
}