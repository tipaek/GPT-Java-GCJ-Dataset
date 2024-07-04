import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int numberOfCases = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.

    for(int k = 1; k <= numberOfCases; k ++) {
      int matrixSize = in.nextInt();
      in.nextLine();
      int[][] matrix = sanitizeInput(matrixSize, in);
      int rowDup = 0;
      int colDup = 0;
      int diagSum = 0;
      HashSet<String> rowHS = new HashSet<>();
      HashSet<String> colHS = new HashSet<>();
      boolean once1 = false;
      HashSet<Integer> colCount = new HashSet<>();

      for(int i = 0; i < matrix.length; i++) {

        for(int j = 0; j < matrix[0].length; j++) {
          String s2 = "c:"+j+", val:"+matrix[i][j];
          String s1 = "r:"+i+", val:"+matrix[i][j];

          if(colHS.contains(s2) && !colCount.contains(j)) {
            colDup++;
            colCount.add(j);
          } else {
            colHS.add(s2);
          }

          if(rowHS.contains(s1) && !once1) {
            rowDup++;
            once1 = true;
          } else {
            rowHS.add(s1);
          }

          if(i == j) {
            diagSum += matrix[i][j];
          }

        }
        once1 = false;

      }


    System.out.println("Case #" + k + ": " + diagSum + " " + rowDup + " " + colDup);
    }

    }

  public static int[][] sanitizeInput(int matrixSize, Scanner in) {
    int[][] matrix = new int[matrixSize][matrixSize];
    for(int i = 0; i < matrix.length; i++) {
      String[] row = in.nextLine().split(" ");
      for(int j = 0; j < matrix[0].length; j++) {
        matrix[i][j] = Integer.parseInt(row[j]);
      }
    }
    return matrix;
  }

}
