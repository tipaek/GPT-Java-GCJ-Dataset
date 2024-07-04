import java.util.*;
import java.io.*;

public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
      int n = in.nextInt();
      int[][] arr = new int[n][n];
      int trace=0;
      int index_trace=0;
      int r=0;
      int c=0;
      for (int j=0; j<n*n; ++j){
          int y = in.nextInt();
          if (j==index_trace){
              trace+=y;
              index_trace+=(n+1);
          }
          if (j==n-1){
              r+=1;
              c=0;
          }
          arr[r][c]=y;
          c+=1;
      }
      int row=0;
      int column=0;
      boolean[][] rep = new boolean[2][n];
      for (int j=0; j<n; ++j){
          for (int k=0; k<n; ++k){
              int check = arr[j][k];
              for (int l=0; l<n; ++l){
                if (check == arr[j][l] && k!=l && rep[1][j]!=true){
                    row+=1;
                    rep[1][j]=true;
                }
                if (check == arr[l][k] && l=!j && rep[2][k]!=true){
                    column+=1;
                    rep[2][k]=true;
                }
                if (rep[1][j] && rep[2][k]){
                    break;
                }
              }
              if(row=n && column==n){
                  break;
              }
          }
      }
    System.out.println("Case #" + i + ": " + trace + " " + row + " " + column);
    }
  }
}