import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
      int numberOfTestCase = sc.nextInt();
      for (int i = 0; i < numberOfTestCase; i++) {
        int matrixSize = sc.nextInt();
        int trace = 0;
        Map<Integer, Set<Integer>> rowNumber = new HashMap<>();
        Map<Integer, Set<Integer>> columnNumber = new HashMap<>();
        for (int row = 0; row < matrixSize; row++) {
          for (int column = 0; column < matrixSize; column++) {
            int cell = sc.nextInt();
            if (row == column) {
              trace += cell;
            }
            rowNumber.computeIfAbsent(row, k -> new HashSet<>()).add(cell);
            columnNumber.computeIfAbsent(column, k -> new HashSet<>()).add(cell);
          }
        }
        int rowWithRepetition = repeatedValues(rowNumber, matrixSize);
        int columnWithRepetition = repeatedValues(columnNumber, matrixSize);
        System.out.println(String.format("Case #%d: %d %d %d", (i + 1), trace, rowWithRepetition, columnWithRepetition));
      }
    }
  }

  private static int repeatedValues(Map<Integer, Set<Integer>> descriptor, int expectedNumberOfDistinctElement) {
    return (int) descriptor.values().stream().filter(values -> values.size() != expectedNumberOfDistinctElement).count();
  }
}