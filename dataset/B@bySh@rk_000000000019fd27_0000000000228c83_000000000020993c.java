import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
      int n = in.nextInt();
      int[][]mat = new int[n][n];
      for(int r=0;r<n;r++){
          for(int c=0;c<n;c++)
            mat[r][c] = in.nextInt();
      }
      int[] output = checkMatrix(mat,n);
      System.out.println("Case #"+i+": " +output[0]+" "+output[1]+" "+output[2]);
    }
  }
  
  private static int[] checkMatrix(int[][]mat,int n){
      int t = 0;
      for(int i=0;i<n;i++){
          t += mat[i][i];
      }
      //check rows
      
      int rowCount = 0;
      for(int r=0;r<n;r++){
          HashSet<Integer> set = new HashSet<Integer>();
          for(int c=0;c<n;c++){
              if(set.contains(mat[r][c])){
                  rowCount++;
                  break;
              }else{
                  set.add(mat[r][c]);
              }
          }
      }
      
      int colCount = 0;
      for(int c=0;c<n;c++){
          HashSet<Integer> set = new HashSet<Integer>();
          for(int r=0;r<n;r++){
              if(set.contains(mat[r][c])){
                  colCount++;
                  break;
              }else{
                  set.add(mat[r][c]);
              }
          }
      }
      return new int[]{t,rowCount,colCount};
  }
}