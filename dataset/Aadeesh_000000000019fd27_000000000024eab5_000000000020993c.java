import java.util.*;
import java.io.*;
 public class Solution
{
  public static void main(String[] args) 
  {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();
     // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int j = 1; j <= t; j++)
    {
      int N = in.nextInt();
      int arr[][]=new int[N][N];
      int trace=0;
      int r=0,c=0;
      for(int i=0;i<N;i++)
      {
          Set<Integer> set=new HashSet<>();
          for(int k=0;k<N;k++)
          {
              arr[i][k]=in.nextInt();
              set.add(arr[i][k]);
              if(i==k)
              trace+=arr[i][k];
          }
          if(set.size()<N)
          r++;
      }
      for(int k=0;k<N;k++)
      {
          Set<Integer> set1=new HashSet<>();
          for(int i=0;i<N;i++)
          {
              
              set1.add(arr[i][k]);
             
          }
          if(set1.size()<N)
          c++;
      }
      
      
      System.out.println("Case #" + j + ": " + (trace) + " " + r+ " " + (c));
    }
  }
}