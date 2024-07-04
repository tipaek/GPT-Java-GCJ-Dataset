import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Locale;
import java.util.Scanner;


public class Solution {
  public static void main(String[] args) throws Exception {
    try {
      Solution solution = new Solution();
//      solution.executeBatch("src/codejam2020_1c/overexcitedFan/Solution.txt");
      solution.executeBatch(System.in);
    }
    catch (Exception exception) {
      System.out.println(exception.getMessage());
      exception.printStackTrace();
      throw exception;
    }
  }

  private void executeBatch(String filename) throws Exception {
    executeBatch(new FileInputStream(filename));
  }

  private void executeBatch(InputStream in) throws Exception {
    Scanner scanner = new Scanner(in);
    int testCases = scanner.nextInt();
    for (int testCase = 1; testCase <= testCases; ++testCase)
      execute(testCase, scanner);
  }

  private void execute(int testCase, Scanner scanner) {
    int x = scanner.nextInt();
    int y = scanner.nextInt();
    String moves = scanner.next();

    int time = -1;
    for (int i = 0; i < moves.length(); ++i) {
      switch (moves.charAt(i)) {
        case 'N':
          ++y;
          break;
        case 'S':
          --y;
          break;
        case 'E':
          ++x;
          break;
        case 'W':
          --x;
          break;
      }
      int x0 = x >= 0 ? x : -x;
      int y0 = y >= 0 ? y : -y;
//      System.err.printf("x=%d, y=%d, x0=%d, y0=%d\n", x, y, x0, y0);
      if (x0 + y0 <= 1 + i) {
        time = i + 1;
        break;
      }
    }

    if (time == -1)
      System.out.printf(Locale.ENGLISH,
          "Case #%d: IMPOSSIBLE\n", testCase);
    else
      System.out.printf(Locale.ENGLISH,
          "Case #%d: %d\n", testCase, time);
  }
}
