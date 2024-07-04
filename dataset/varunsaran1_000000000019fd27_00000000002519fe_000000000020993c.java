
import java.util.*;
import java.io.*;

public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int num = in.nextInt(); // Number of Test Cases
    int caseNumber = 1 ;
    while (caseNumber <= num) {
      int matrixDimension = in.nextInt();
      int[][] arr = new int[matrixDimension][matrixDimension] ;
      
      for (int i = 0 ; i < matrixDimension ; i++) {
          for (int j = 0 ; j < matrixDimension ; j++) {
              arr[i][j] = in.nextInt() ;
          }
      }
      
      int traceNumber = 0 ;
      int repeatedRows = 0 ;
      int repeatedCols = 0 ;
      Set<Integer> repeatCheckSet ;
      
      //Calculate repeated rows
      for (int i = 0 ; i < matrixDimension ; i++) {
          repeatCheckSet = new HashSet<>() ;
          for (int j = 0 ; j < matrixDimension ; j++) {
              if (!repeatCheckSet.add(arr[i][j])) {
                  repeatedRows++ ;
                  break;
              }
          }
      }
      
      //Calculate repeated cols
      for (int i = 0 ; i < matrixDimension ; i++) {
          repeatCheckSet = new HashSet<>() ;
          for (int j = 0 ; j < matrixDimension ; j++) {
              if (!repeatCheckSet.add(arr[j][i])) {
                  repeatedCols++ ;
                  break;
              }
          }
      }
      
      //Calculate trace number
      for (int i = 0 ; i < matrixDimension ; i++) {
          traceNumber += arr[i][i] ;
      }
      
      System.out.println("Case #" + caseNumber + ": " + traceNumber + " " + repeatedRows + " " + repeatedCols);
      caseNumber++ ;
    }
  }
}
