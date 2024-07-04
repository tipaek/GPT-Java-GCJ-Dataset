import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
  private static void handleTestCase(int index, Scanner scanner) {
    System.out.print("Case #" + index + ": ");
    int n = scanner.nextInt();
    int trace = 0, rowCount = 0, colCount = 0;
    boolean[] isRepeatRow = new boolean[n];
    boolean[] isRepeatCol = new boolean[n];
    Map<Integer, Map<Integer, Boolean>> rowMap = new HashMap<>();
    Map<Integer, Map<Integer, Boolean>> colMap = new HashMap<>();
    for (int i = 0; i < n; ++i) {
      rowMap.put(i, new HashMap<>());
      colMap.put(i, new HashMap<>());
      isRepeatRow[i] = false;
      isRepeatCol[i] = false;
    }

    for (int i = 0; i < n; ++i) {
      for (int j = 0; j < n; ++j) {
        int val = scanner.nextInt();
        if (i == j) {
          trace += val;
        }
        if (rowMap.get(i).get(val) != null) {
          if (!isRepeatRow[i]) {
            rowCount++;
            isRepeatRow[i] = true;
          }
        } else {
          rowMap.get(i).put(val, true);
        }

        if (colMap.get(j).get(val) != null) {
          if (!isRepeatCol[j]) {
            colCount++;
            isRepeatCol[j]= true;
          }
        } else {
          colMap.get(j).put(val, true);
        }
      }
    }

    System.out.println(trace + " " + rowCount + " " + colCount);
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int testCount = scanner.nextInt();
    for (int i = 1; i <= testCount; ++i) {
      handleTestCase(i, scanner);
    }
    scanner.close();
  }
}