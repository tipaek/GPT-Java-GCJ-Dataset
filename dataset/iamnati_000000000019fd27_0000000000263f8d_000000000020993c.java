
import java.util.*;
import java.io.*;

 class Result {
    int trace;
    int numRepeatedCols;
    int numRepeatedRows;
 }
 public class Vestigium {
    
    
    private static boolean duplicateFound(Map<Integer, Set<Integer>> duplicateMap, int index, int targetValue) {
         if (!duplicateMap.containsKey(index)) {
            duplicateMap.put(index, new HashSet<>());
         }
         
         boolean result = duplicateMap.get(index).contains(targetValue);
         duplicateMap.get(index).add(targetValue);
         return result;
    
    }
    
    public static void main(String[] args) {

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); 
        for (int i = 1; i <= t; ++i) {
          int n = in.nextInt();
          in.nextLine();
          int[][] matrix = new int[n][n];
          for (int j = 0; j < n; j++) {
              String[] line = in.nextLine().split(" ");
              for (int k = 0; k < line.length; k++) {
                  matrix[j][k] = Integer.parseInt(line[k]);
              }
          }
          Result r = matrixStats(matrix);
          System.out.println("Case #" + i + ": " + (r.trace) + " " + (r.numRepeatedRows) + " " + (r.numRepeatedCols));
        }
    
    }


    public static Result matrixStats(int[][] matrix) {
        Map<Integer, Set<Integer>> rowDuplicateCount = new HashMap<>();
        Map<Integer, Set<Integer>> columnDuplicateCount = new HashMap<>();
        Result result = new Result();
        
        Set<Integer> duplicateRows = new HashSet<>();
        Set<Integer> duplicateCols = new HashSet<>();
    
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                int currValue = matrix[row][col];
                
                if (row == col) { // cell is part of diagonal
                    result.trace += currValue;
                }
                
                if (duplicateFound(rowDuplicateCount, row, currValue) &&
                    !duplicateRows.contains(row)) {
                    result.numRepeatedRows += 1;
                    duplicateRows.add(row);
                }
                
                if (duplicateFound(columnDuplicateCount, col, currValue) &&
                    !duplicateCols.contains(col)) {
                    result.numRepeatedCols += 1;
                    duplicateCols.add(col);
                }
                
            }
        }
        return result;
    
    }
 
 }


 




