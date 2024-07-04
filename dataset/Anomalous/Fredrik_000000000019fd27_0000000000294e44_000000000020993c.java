import java.util.*;
import java.io.*;

public class Solution {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int testCases = scanner.nextInt();

    for (int caseNum = 1; caseNum <= testCases; caseNum++) {
      int matrixSize = scanner.nextInt();
      scanner.nextLine(); // consume the rest of the line

      int diagonalSum = 0;
      int duplicateRows = 0;
      int duplicateCols = 0;

      Set<Integer>[] rowSets = new Set[matrixSize];
      Set<Integer>[] colSets = new Set[matrixSize];
      for (int i = 0; i < matrixSize; i++) {
        rowSets[i] = new HashSet<>();
        colSets[i] = new HashSet<>();
      }

      for (int row = 0; row < matrixSize; row++) {
        String[] values = scanner.nextLine().trim().split(" ");
        for (int col = 0; col < matrixSize; col++) {
          int num = Integer.parseInt(values[col]);
          rowSets[row].add(num);
          colSets[col].add(num);

          if (row == col) {
            diagonalSum += num;
          }
        }
      }

      for (Set<Integer> rowSet : rowSets) {
        if (rowSet.size() < matrixSize) duplicateRows++;
      }

      for (Set<Integer> colSet : colSets) {
        if (colSet.size() < matrixSize) duplicateCols++;
      }

      System.out.println("Case #" + caseNum + ": " + diagonalSum + " " + duplicateRows + " " + duplicateCols);
    }
  }
}