import java.util.Scanner;

public class Solution {
  static class Interval {
    int lower;
    int upper;
    Interval(int l, int u) {
      this.lower = l;
      this.upper = u;
    }

    /**
     * @return the lower
     */
    public int getLower() {
      return lower;
    }

    /**
     * @return the upper
     */
    public int getUpper() {
      return upper;
    }
  }

  private static void handleTestCase(int index, Scanner scanner) {
    System.out.print("Case #" + index + ": ");
    int n = scanner.nextInt();
    int[] assign = new int[n];
    Interval[] intervals = new Interval[n];
    boolean isPossible = true;
    for (int i = 0; i < n; ++i) {
      int lower = scanner.nextInt();
      int upper = scanner.nextInt();
      intervals[i] = new Interval(lower, upper);
      assign[i] = 2;
      for (int j = 0; j < i; ++j) {
        // overlapping
        if (lower < intervals[j].getUpper() && intervals[j].getLower() < upper) {
          if (assign[i] == 2 && assign[j] == 2) {
            assign[i] = 0;
            assign[j] = 1;
          } else if (assign[i] == 2) {
            assign[i] = 1 - assign[j];
          } else if (assign[j] == 2) {
            assign[j] = 1- assign[i];
          } else if (assign[i] == assign[j]) {
            isPossible = false;
            break;
          }
        }
      }
      if (!isPossible) {
        break;
      }
    }
    if (!isPossible) {
      System.out.println("IMPOSSIBLE");
    } else {
      for (int i = 0; i < n; ++i) {
        switch (assign[i]) {
          case 0:
            System.out.print("C");
            break;
          case 1:
            System.out.print("J");
            break;
          case 2:
            System.out.print("C");
        }
      }
      System.out.println();
    }
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int testCount = scanner.nextInt();
    for (int i = 1; i <= testCount; ++i) {
      handleTestCase(i, scanner);
    }
  }
}