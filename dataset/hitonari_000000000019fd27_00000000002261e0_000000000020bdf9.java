import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {
  private static void handleTestCase(int index, Scanner scanner) {
    System.out.print("Case #" + index + ": ");
    int n = scanner.nextInt();
    int[] assign = new int[n];
    Interval[] intervals = new Interval[n];
    Integer[] indices = new Integer[n];

    for (int i = 0; i < n; ++i) {
      int lower = scanner.nextInt();
      int upper = scanner.nextInt();
      intervals[i] = new Interval(lower, upper);
      indices[i] = i;
    }

    Arrays.sort(indices, new Comparator<Integer>() {
      public int compare(Integer a1, Integer a2) {
        return intervals[a1].compareTo(intervals[a2]);
      }
    });

    boolean isPossible = true;
    for (int i = 0; i <n ; ++i) {
      int idxI = indices[i];
      assign[idxI] = 2;
      for (int j = 0; j < i; ++j) {
        int idxJ = indices[j];
        // overlapping
        if (intervals[idxI].getLower() < intervals[idxJ].getUpper() && intervals[idxJ].getLower() < intervals[idxI].getUpper()) {
          if (assign[idxI] == 2 && assign[idxJ] == 2) {
            assign[idxI] = 0;
            assign[idxJ] = 1;
          } else if (assign[idxI] == 2) {
            assign[idxI] = 1 - assign[idxJ];
          } else if (assign[idxJ] == 2) {
            assign[idxJ] = 1 - assign[idxI];
          } else if (assign[idxI] == assign[idxJ]) {
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

class Interval implements Comparable<Interval> {
  int lower;
  int upper;
  Interval(int l, int u) {
    this.lower = l;
    this.upper = u;
  }

  public int getLower() {
    return lower;
  }

  public int getUpper() {
    return upper;
  }

  @Override
  public int compareTo(Interval o) {
    if (this.lower < o.getLower()) {
      return -1;
    } else if (this.lower > o.getLower()) {
      return 1;
    }
    return this.upper - o.getUpper();
  }
}