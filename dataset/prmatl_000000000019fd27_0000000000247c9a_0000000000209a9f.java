import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Locale;
import java.util.Scanner;


public class Solution {
  public static void main(String[] args) throws Exception {
    try {
      Solution solution = new Solution();
//      solution.executeBatch("src/codejam2020/nestingDepth/Solution.txt");
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
    String s = scanner.next();

    int l = 0;
    StringBuilder p = new StringBuilder();
    for (int i = 0; i < s.length(); ++i) {
      char c = s.charAt(i);
      int d = c - '0';
      while (d > l) {
        p.append('(');
        ++l;
      }
      while (d < l) {
        p.append(')');
        --l;
      }
      p.append(c);
    }
    while (l > 0) {
      p.append(')');
      --l;
    }

    System.out.printf(Locale.ENGLISH,
        "Case #%d: %s\n", testCase, p.toString());
  }
}
