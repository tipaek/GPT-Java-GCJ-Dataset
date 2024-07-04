import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.IntStream;

public class Solution {

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int testCasesCount = s.nextInt();

    String[] results = new String[testCasesCount];

    for (int i = 0; i < testCasesCount; i++) {
      int[][] matrix = getMatrix(s);

      if (matrix == null) {
        results[i] = "IMPOSSIBLE";
      } else {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("POSSIBLE\n");

        for (int[] rows : matrix) {
          for (int elements : rows) {
            stringBuilder.append(elements)
                .append(" ");
          }
          stringBuilder.append("\n");
        }
        results[i] = stringBuilder.toString();
      }
    }

    for (int i = 1; i <= testCasesCount; i++) {
      System.out.println(String.format("Case #%s: %s ", i, results[i - 1]));
    }
  }

  private static int[][] getMatrix(Scanner s) {
    int n = s.nextInt();
    int k = s.nextInt();

    int[][] matrix = buildInitialLatinSquare(n);

    Set<List<Integer>> traceTermsSet = new HashSet<>();

    for (List<Integer> traceTerm : getTerms(n, k, n)) {
      traceTerm.sort(Comparator.reverseOrder());
      traceTermsSet.add(traceTerm);
    }

    for (List<Integer> traceTerms : traceTermsSet) {
      int[][] permutedMatrix = getPermutedMatrix(traceTerms, matrix);
      if (permutedMatrix != null) {
        return permutedMatrix;
      }
    }

    return null;
  }

  // finds all possible terms for specified trace
  private static Set<List<Integer>> getTerms(int n, int k, int max) {
    Set<List<Integer>> traceTerms = new HashSet<>();
    for (int i = max; i > 0; i--) {
      if (k - i < n - 1 || k - i > n * n) {
        continue;
      }
      Set<List<Integer>> terms = new HashSet<>();
      if (k - i > 0) {
        terms.addAll(getTerms(n - 1, k - i, max));
      } else if (n == 1) {
        terms.add(new ArrayList<>());
      }
      for (List<Integer> innerTerm : terms) {
        innerTerm.add(i);
      }
      traceTerms.addAll(terms);
    }
    return traceTerms;
  }

  private static int[][] buildInitialLatinSquare(int n) {
    int[][] matrix = new int[n][n];

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (j > i) {
          matrix[i][j] = j - i;
        } else {
          matrix[i][j] = j - i + n;
        }
      }
    }

    return matrix;
  }

  private static int[][] getPermutedMatrix(List<Integer> traceTerms, int[][] sourceMatrix) {
    for (int i = 0; i < sourceMatrix.length; i++) {

      int position = -1;
      for (int j = i; j < traceTerms.size(); j++) {
        position = indexOf(sourceMatrix[i], traceTerms.get(j), i);
        if (position > -1) {
          permuteColumns(sourceMatrix, i, position);
          break;
        }
      }
      if (position < 0) {
        return null;
      }
    }
    return sourceMatrix;
  }

  private static int indexOf(int[] array, int elem, int start) {
    return IntStream.range(start, array.length)
        .filter(i -> array[i] == elem)
        .findFirst()
        .orElse(-1);
  }

  private static void permuteColumns(int[][] matrix, int firstColumn, int secondColumn) {
    for (int i = 0; i < matrix.length; i++) {
      int temp = matrix[i][firstColumn];
      matrix[i][firstColumn] = matrix[i][secondColumn];
      matrix[i][secondColumn] = temp;
    }
  }
}