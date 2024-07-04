import java.util.Scanner;

public class Solution {

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int testCasesCount = s.nextInt();

    String[] results = new String[testCasesCount];

    for (int i = 0; i < testCasesCount; i++) {
      results[i] = calculateMinutes(s);
    }

    for (int i = 1; i <= testCasesCount; i++) {
      System.out.println(String.format("Case #%s: %s ", i, results[i - 1]));
    }
  }

  private static String calculateMinutes(Scanner s) {
    int x = s.nextInt();
    int y = s.nextInt();

    char[] path = s.next().toCharArray();

    int minutes = 0;

    if (x * x + y * y <= minutes * minutes) {
      return String.valueOf(minutes);
    }

    while (minutes < path.length) {
      switch (path[minutes]) {
        case 'N':
          y++;
          break;
        case 'E':
          x++;
          break;
        case 'S':
          y--;
          break;
        case 'W':
          x--;
          break;
      }
      minutes++;
      if (Math.abs(x) + Math.abs(y) <= minutes) {
        return String.valueOf(minutes);
      }
    }

    return "IMPOSSIBLE";
  }
}