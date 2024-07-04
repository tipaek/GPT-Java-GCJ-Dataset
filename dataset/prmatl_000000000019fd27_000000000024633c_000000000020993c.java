import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;


public class Solution {
  public static void main(String[] args) throws Exception {
    try {
      Solution solution = new Solution();
//      solution.executeBatch("src/codejam2020/vestigium/Solution.txt");
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
    int n = scanner.nextInt();
    int[][] values = new int[n][n];
    for (int y = 0; y < n; ++y)
      for (int x = 0; x < n; ++x)
        values[y][x] = scanner.nextInt();

    int diag = 0;
    for (int y = 0; y < n; ++y)
      diag += values[y][y];

    int[] rc = new int[n];

    int r = 0;
    for (int y = 0; y < n; ++y) {
      for (int x = 0; x < n; ++x)
        rc[x] = values[y][x];
      Arrays.sort(rc);
      for (int x = 0; x < n - 1; ++x)
        if (rc[x] == rc[x + 1]) {
          ++r;
          break;
        }
    }

    int c = 0;
    for (int x = 0; x < n; ++x) {
      for (int y = 0; y < n; ++y)
        rc[y] = values[y][x];
      Arrays.sort(rc);
      for (int y = 0; y < n - 1; ++y)
        if (rc[y] == rc[y + 1]) {
          ++c;
          break;
        }
    }

    System.out.printf(Locale.ENGLISH,
        "Case #%d: %d %d %d\n", testCase, diag, r, c);
  }
}
