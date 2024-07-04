import java.util.*;
import java.io.*;

public class Solution {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int testCases = scanner.nextInt();
    
    for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
      int n = scanner.nextInt();
      int[][] matrix = new int[n][n];
      
      for (int row = 0; row < n; row++) {
        for (int col = 0; col < n; col++) {
          matrix[row][col] = scanner.nextInt();
        }
      }
      
      int[] results = analyzeMatrix(matrix, n);
      System.out.printf("Case #%d: %d %d %d%n", caseNumber, results[0], results[1], results[2]);
    }
  }
  
  private static int[] analyzeMatrix(int[][] matrix, int size) {
    int trace = 0;
    for (int i = 0; i < size; i++) {
      trace += matrix[i][i];
    }
    
    int duplicateRows = 0;
    for (int row = 0; row < size; row++) {
      Set<Integer> rowSet = new HashSet<>();
      for (int col = 0; col < size; col++) {
        if (!rowSet.add(matrix[row][col])) {
          duplicateRows++;
          break;
        }
      }
    }
    
    int duplicateCols = 0;
    for (int col = 0; col < size; col++) {
      Set<Integer> colSet = new HashSet<>();
      for (int row = 0; row < size; row++) {
        if (!colSet.add(matrix[row][col])) {
          duplicateCols++;
          break;
        }
      }
    }
    
    return new int[]{trace, duplicateRows, duplicateCols};
  }
}