
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class Solution {
  public static Scanner scanner = new Scanner(System.in);
  public static PrintStream out = System.out;
  boolean possible;
  int[][] oneSquare;

  public static void main(String[] args) throws IOException {

    int testCases = scanner.nextInt();
    for (int i = 1; i <= testCases; i++) {
      int n = scanner.nextInt();
      int k = scanner.nextInt();

      Solution sol = new Solution();
      sol.solve(n, k);
      out.printf("Case #%d: %s\n", i, sol.answer());
      if (sol.possible) {
        sol.printSquare(out);
      }
//      int[] resp = solve(matrix);
//      out.printf("Case #%d: %d %d %d\n", i, resp[0], resp[1], resp[2]);
    }

  }

  private void printSquare(PrintStream out2) {
    printSquare(out, this.oneSquare);

  }

  public static void printSquare(PrintStream out2, int[][] square) {
    for (int i = 0; i < square.length; i++) {
      String line = Arrays.stream(square[i]).mapToObj(e -> String.valueOf(e)).collect(Collectors.joining(" "));
      out2.println(line);
    }

  }

  private String answer() {

    return this.possible ? "POSSIBLE" : "IMPOSSIBLE";
  }

  // brutus

  public ArrayList<int[][]> squareCollect;
  private boolean firstOnly = true;

  public void solve(int n, int k) {
    possible = false;

    List<int[]> perms = permuteRow(n);

    Consumer<int[]> checkSquare = (int[] d) -> {
      int[][] matrix = new int[n][n];
      squareCollect = new ArrayList<int[][]>();
      this.squarePerm(n, 0, matrix, d, perms, squareCollect);
    };
    Set<int[]> collect = fillDiag(n, k, checkSquare);

    if (collect.isEmpty()) {
      possible = false;
      return;
    }

  }

  public static List<int[]> permuteRow(int n) {
    int[] permBase = new int[n];
    for (int i = 0; i < n; i++) {
      permBase[i] = i + 1;
    }

    List<int[]> perms = new ArrayList<int[]>();
    permute(0, permBase, perms);
    return perms;
  }

  public void squarePerm(int n, int r, int[][] square, int[] diag, List<int[]> perms, List<int[][]> squareCollect) {

    for (int[] perm : perms) {
      if (perm[r] == diag[r]) {
        square[r] = perm;

        if (r == n - 1) {
          validateSquare(square, squareCollect);
        } else {
          if (validRow(square, r)) {
            squarePerm(n, r + 1, square, diag, perms, squareCollect);
          }
        }

        if (possible && firstOnly) {
          break;
        }
      }
    }

  }

  private boolean validRow(int[][] square, int row) {

    int[] used = new int[square.length];

    for (int c = 0; c < square.length; c++) {
      Arrays.fill(used, 0);
      for (int r = 0; r <= row; r++) {
        int v = square[r][c] - 1;
        if (used[v] > 0) {
          return false;
        } else {
          used[v] = 1;
        }
      }
    }
    return true;
  }

  public void validateSquare(int[][] square, List<int[][]> squareCollect) {
    if (columnsAreLatin(square)) {
      squareCollect.add(Arrays.copyOf(square, square.length));
      // System.err.println("latin square found!");
      possible = true;
      oneSquare = fullCopy(square);

    }

  }

  private int[][] fullCopy(int[][] matrix) {
    int[][] matrix2 = new int[matrix.length][matrix.length];
    for (int i = 0; i < matrix.length; i++) {
      matrix2[i] = Arrays.copyOf(matrix[i], matrix[i].length);

    }
    return matrix2;
  }

  public static boolean columnsAreLatin(int[][] square) {
    int[] used = new int[square.length];

    for (int c = 0; c < square.length; c++) {
      Arrays.fill(used, 0);
      for (int r = 0; r < square.length; r++) {
        int v = square[r][c] - 1;
        if (used[v] > 0) {
          return false;
        } else {
          used[v] = 1;
        }
      }
    }
    return true;
  }

  public Set<int[]> fillDiag(int n, int k, Consumer<int[]> checkSquare) {
    int[] diag = new int[n];

    Set<int[]> collect = new HashSet<int[]>();
    fillDiagRec(diag, n, 0, collect, k, checkSquare);
    return collect;
  }

  public void fillDiagRec(int[] diag, int n, int pos, Set<int[]> collect, int k, Consumer<int[]> checkSquare) {
    for (int i = 0; i < n; i++) {
      diag[pos] = i;
      if (pos == diag.length - 1) {
        // System.err.println("brutus 2.fill diag rec " + Arrays.toString(diag));
        int arraySum = Arrays.stream(diag).sum() + n;
        if (arraySum == k) {
          int[] cosa = Arrays.stream(diag).map(e -> e + 1).sorted().toArray();
          checkSquare.accept(cosa);
          collect.add(cosa);
        }

      } else {
        fillDiagRec(diag, n, pos + 1, collect, k, checkSquare);
      }
      if (possible && firstOnly) {
        break;
      }
    }
  }

  public static void permute(int start, int[] input, List<int[]> collect) {
    if (start == input.length) {
      // System.out.println(input);
      collect.add(Arrays.copyOf(input, input.length));
      return;
    }
    for (int i = start; i < input.length; i++) {
      // swapping
      int temp = input[i];
      input[i] = input[start];
      input[start] = temp;
      // swap(input[i], input[start]);

      permute(start + 1, input, collect);
      // swap(input[i],input[start]);

      int temp2 = input[i];
      input[i] = input[start];
      input[start] = temp2;
    }
  }
}