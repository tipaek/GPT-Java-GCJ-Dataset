import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int test = 1; test <= t; ++test) {
      int n = in.nextInt();
      int arr[][]=new int[n][n];
      int trace=0;
      for(int i=0;i<n;i++)
      {
          for(int j=0;j<n;j++)
          {
              arr[i][j]=in.nextInt();
              if(i==j) trace+=arr[i][j];
          }
      }
      int row=0,column=0;
      for(int i=0;i<n;i++)
      {
          HashSet<Integer> set = new HashSet<>();
          for(int j=0;j<n;j++)
          {
              if(set.contains(arr[i][j])) {row++;break;}
              else set.add(arr[i][j]);
          }
      }
      for(int j=0;j<n;j++)
      {
          HashSet<Integer> set = new HashSet<>();
          for(int i=0;i<n;i++)
          {
              if(set.contains(arr[i][j])) {column++;break;}
              else set.add(arr[i][j]);
          }
      }
      
      System.out.println("Case #" + test + ": " + trace + " " + row+" "+column);
    }
  }
}