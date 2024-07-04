import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = scan.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
      int n = scan.nextInt();
      int[][] arr=new int[n][n];
      for(int j=0;j<n;j++){
          for(int k=0;k<n;k++){
              arr[j][k]=scan.nextInt();
          }
      }
      int row=0;
      int col=0;
      for(int j=0;j<n;j++){
          int[] ar=new int[n];
          for(int k=0;k<n;k++){
              if(ar[arr[j][k] -1] ==1){
                  row++;
                  break;
              }else{
                  ar[arr[j][k] -1]++;
              }
          }
      }
      for(int j=0;j<n;j++){
          int[] ar=new int[n];
          for(int k=0;k<n;k++){
              if(ar[arr[k][j] -1] ==1){
                  col++;
                  break;
              }else{
                  ar[arr[k][j] -1]++;
              }
          }
      }
      int trace=0;
      for(int j=0;j<n;j++){
          trace+=arr[j][j];
      }
      
      System.out.println("Case #" + i + ": " + trace + " " + row + " " + col);
    }
  }
}