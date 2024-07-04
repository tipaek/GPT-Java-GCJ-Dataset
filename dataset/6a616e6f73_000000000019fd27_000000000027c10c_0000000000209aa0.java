
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Solution {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int T = scanner.nextInt();
    for (int t = 0; t < T; t++) {
      int N = scanner.nextInt();
      int K = scanner.nextInt();

      int[][] m = solve(N, K);
      System.out.println(String.format("Case #%d: %s", t + 1, m == null ? "IMPOSSIBLE" : "POSSIBLE"));
      if (m != null) {
        Stream.of(m).forEach(row -> {
          System.out.println(IntStream.of(row).mapToObj(Integer::toString).collect(Collectors.joining(" ")));
        });
      }
    }
  }

  private static int[][] solve(int N, int K) {
    List<int[]> rowPermutations = rowPermutations(N);

    Iterator<int[][]> it = new Iterator<int[][]>() {
      final int[][] m = new int[N][N];
      final int[] perms = new int[N];
      boolean stop = false;

      {
        int rowIndex = 0;
        OUTER:
        while (true) {
          for (; perms[rowIndex] < rowPermutations.size(); perms[rowIndex]++) {
            m[rowIndex] = rowPermutations.get(perms[rowIndex]);
            if (isUniqueCols(m, rowIndex)) {
              rowIndex++;
              if (rowIndex == N) break OUTER;
            }
          }

          perms[rowIndex] = 0;
          rowIndex--;

          if (rowIndex >= 0) {
            perms[rowIndex]++;
          } else {
            stop = true;
          }
        }
      }

      @Override
      public boolean hasNext() {
        return !stop;
      }

      @Override
      public int[][] next() {
        int[][] ret = m.clone();

        int rowIndex = perms.length - 1;
        while (true) {
          for (; perms[rowIndex] < rowPermutations.size(); perms[rowIndex]++) {
            m[rowIndex] = rowPermutations.get(perms[rowIndex]);
            if (isUniqueCols(m, rowIndex)) {
              perms[rowIndex]++;
              rowIndex++;
              if (rowIndex == N) return ret;
            }
          }

          perms[rowIndex] = 0;
          rowIndex--;

          if (rowIndex >= 0) {
            perms[rowIndex]++;
          } else {
            break;
          }
        }

        stop = true;
        return ret;
      }

      private boolean isUniqueCols(int[][] m, int lastRow) {
        for (int col = 0; col < N; col++) {
          boolean[] seen = new boolean[N + 1];
          for (int row = 0; row <= lastRow; row++) {
            if (seen[m[row][col]]) return false;
            seen[m[row][col]] = true;
          }
        }
        return true;
      }
    };

    while (it.hasNext()) {
      int[][] m = it.next();
      if (trace(m) == K) {
        return m;
      }
    }

    return null;
  }

  private static void printMatrix(int[][] m) {
    Stream.of(m).forEach(row -> System.out.println(Arrays.toString(row)));
    System.out.println();
  }

  private static List<int[]> rowPermutations(int N) {
    int[] row = new int[N];
    List<int[]> rowPermutations = new ArrayList<>();
    rowPermutations(N, rowPermutations, row, 0);
    return rowPermutations;
  }

  private static void rowPermutations(int N, List<int[]> acc, int[] row, int index) {
    if (index == N) {
      acc.add(row.clone());
      return;
    }

    OUTER:
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < index; j++) {
        if (row[j] == i + 1) continue OUTER;
      }
      row[index] = i + 1;
      rowPermutations(N, acc, row, index + 1);
    }
  }

  private static int trace(int[][] m) {
    int sum = 0;
    for (int i = 0; i < m.length; i++) {
      sum += m[i][i];
    }
    return sum;
  }
}
