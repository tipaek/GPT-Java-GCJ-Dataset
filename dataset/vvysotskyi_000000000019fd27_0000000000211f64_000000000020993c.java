import java.util.BitSet;
import java.util.Scanner;

public class Solution {
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int testCasesCount = s.nextInt();

    int[][] results = new int[testCasesCount][];

    for (int i = 0; i < testCasesCount; i++) {
      results[i] = calculateTrace(s);
    }

    for (int i = 1; i <= testCasesCount; i++) {
      System.out.println(String.format("Case #%s: %s %s %s", i, results[i - 1][0], results[i - 1][1], results[i - 1][2]));
    }
  }

  public static int[] calculateTrace(Scanner s) {
    int n = s.nextInt();

    BitSet[] rows = new BitSet[n];
    BitSet[] cols = new BitSet[n];

    BitSet all = new BitSet(n);

    for (int i = 0; i < n; i++) {
      rows[i] = new BitSet(n);
      cols[i] = new BitSet(n);
      all.set(i + 1);
    }

    int trace = 0;

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        int elem = s.nextInt();
        rows[i].set(elem);
        cols[j].set(elem);

        if (i == j) {
          trace +=elem;
        }
      }
    }

    int rowsWithDuplicates = 0;
    int columnsWithDuplicates = 0;

    for (int i = 0; i < n; i++) {
      if (!rows[i].equals(all)) {
        rowsWithDuplicates++;
      }
      if (!cols[i].equals(all)) {
        columnsWithDuplicates++;
      }
    }

    return new int[]{trace, rowsWithDuplicates, columnsWithDuplicates};
  }
}