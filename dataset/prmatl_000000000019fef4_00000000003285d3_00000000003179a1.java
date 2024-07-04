import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Locale;
import java.util.Scanner;


public class Solution {
  public static void main(String[] args) throws Exception {
    try {
      Solution solution = new Solution();
//      solution.executeBatch("src/codejam2020_1c/overrandomized/Solution.txt");
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
    int u = scanner.nextInt();
//    System.err.printf("u=%d\n", u);
    int[] qs = new int[10000];
    String[] rs = new String[10000];
    for (int i = 0; i < 10000; ++i) {
      qs[i] = scanner.nextInt();
      rs[i] = scanner.next();
    }
//    for (int i = 0; i < 10000; ++i)
//      System.err.printf("qs=%d, rs=%s\n", qs[i], rs[i]);

    int[][] letters = new int[u][26];
    for (int i = 0; i < 10000; ++i) {
      String r = rs[i];
      int skip = u - r.length();
      for (int j = 0; j < r.length(); ++j)
        ++letters[skip + j][r.charAt(j) - 'A'];
    }

//    for (int i = 0; i < u; ++i) {
//      for (int j = 0; j < 26; ++j)
//        System.err.printf("%d ", letters[i][j]);
//      System.err.println();
//    }

    String code = "";
    for (int i = 0; i < 26; ++i)
      if ((letters[0][i] == 0) && (letters[1][i] != 0)) {
        code += (char) ('A' + i);
        break;
      }

    int max = 10000;
    for (int i = 1; i < 10; ++i) {
      int min = 0;
      int letter = 0;
      for (int j = 0; j < 26; ++j) {
        int count = letters[0][j];
        if ((count < max) && (count > min)) {
          min = count;
          letter = j;
        }
      }
      code += (char) ('A' + letter);
      max = min;
    }

    System.out.printf(Locale.ENGLISH,
          "Case #%d: %s\n", testCase, code);
  }
}
