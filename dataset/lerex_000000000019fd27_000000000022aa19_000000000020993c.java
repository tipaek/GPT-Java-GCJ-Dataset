import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
      int n = in.nextInt();
      int arr[][] = new int [n][n];
      int sum = 0,x=0,y=0;
      for(int j = 0;j<n;j++){
          for(int k=0;k<n;k++ ){
              arr[j][k]=in.nextInt();
                if(j==k)sum+=arr[j][k];
          }
      }
      for(int j = 0;j<n;j++){
          int row[] = new int[n];
          int column[] = new int[n];
          boolean r = false,c=false;
          for(int k=0;k<n;k++ ){
              if(row[arr[j][k]-1]==0){
                  row[arr[j][k]-1] = 1;
              }
              else
                r= true;
              if(column[arr[k][j]-1]==0){
                  column[arr[k][j]-1] = 1;
              }
              else
                c = true;
          }
          if(r)x++;
          if(c)y++;
      }
      System.out.println("Case #" + i + ": " +sum+ " " + x+" "+y);
    }
  }
} 