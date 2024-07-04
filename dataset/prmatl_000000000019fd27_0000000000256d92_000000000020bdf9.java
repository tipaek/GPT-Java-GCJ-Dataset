import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Locale;
import java.util.Scanner;


public class Solution {
  public static void main(String[] args) throws Exception {
    try {
      Solution solution = new Solution();
//      solution.executeBatch("src/codejam2020/parenting/Solution.txt");
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
    int[] s = new int[n];
    int[] e = new int[n];
    for (int i = 0; i < n; ++i) {
      s[i] = scanner.nextInt();
      e[i] = scanner.nextInt();
    }

    Integer[] o = new Integer[n];
    for (int i = 0; i < n; ++i)
      o[i] = i;
    Arrays.sort(o, new Comparator<Integer>() {
      @Override
      public int compare(Integer o1, Integer o2) {
        return s[o1] == s[o2] ? e[o1] - e[o2] : s[o1] - s[o2];
      }
    });
//    for (int i = 0; i < n; ++i)
//      System.err.printf("%d %d\n", s[o[i]], e[o[i]]);

    int[] l = new int[n];
    int e1 = 0;
    int e2 = 0;
    for (int i = 0; i < n; ++i) {
      int s0 = s[o[i]];
      int e0 = e[o[i]];
//      System.err.printf("%d %d %d %d\n", e1, e2, s0, e0);
      if (s0 >= e1) {
        e1 = e0;
        l[o[i]] = 0;
      }
      else if (s0 >= e2) {
        e2 = e0;
        l[o[i]] = 1;
      }
      else {
        System.out.printf(Locale.ENGLISH,
        "Case #%d: IMPOSSIBLE\n", testCase);
        return;
      }
    }

    StringBuilder out = new StringBuilder(n);
    for (int i = 0; i < n; ++i)
      out.append(l[i] == 0 ? 'C' : 'J');

    System.out.printf(Locale.ENGLISH,
        "Case #%d: %s\n", testCase, out.toString());
  }
}
