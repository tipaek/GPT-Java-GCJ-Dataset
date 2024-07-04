import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
      int n = in.nextInt(); //matrix size
      int m = (int) Math.sqrt(n);
      int[][] matrix = new int[m][m];
      fillMatrix(matrix, m, in);
      int[] res = calLatinSquares(matrix, m);
      System.out.println("Case #" + i + ": " + res[0] + " " + res[1] + " " + res[2]);
    }
  }
  
  public static int[] calLatinSquares(int[][] matrix, int size){
    int[] res = new int[3];
    Set<Integer> rowRep = new HashSet<Integer>(size);
    Set<Integer> colRep = new HashSet<Integer>(size);
    boolean skipRow, skipCol;
    for(int i = 0; i<size; i++){
        rowRep.clear();
        skipRow = false;
        
        colRep.clear();
        skipCol = false;
        
        for(int j=0; j<size; j++){
            if(!skipRow){
                if(!rowRep.add(matrix[i][j])){
                    res[1] += 1;
                    skipRow = true;
                }
            }
            if(!skipCol){
                if(!colRep.add(matrix[j][i])){
                    res[2] += 1;
                    skipCol = true;
                }
            }
            if(i == j) {
                res[0] += matrix[i][j];
            }
            
        }
    }
    return res;
  }
  public static void fillMatrix(int[][] matrix, int size, Scanner in){
    for(int i=0; i<size; i++){
        for(int j=0; j<size; j++){
            matrix[i][j] = in.nextInt();
        }
    }
  }
}