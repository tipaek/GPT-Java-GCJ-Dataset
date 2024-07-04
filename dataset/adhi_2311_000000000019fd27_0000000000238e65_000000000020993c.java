import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();
    int k=1; // Scanner has functions to read ints, longs, strings, chars, etc.
    for (k = 1; k <= t; ++k) 
    {
      int n = in.nextInt();
      int arr[][]=new int[n][n];

      int trace=0,r=0,c=0;
      for(int i=0;i<n;i++)
      {
        Set<Integer> set1=new HashSet<Integer>();
        for(int j=0;j<n;j++)
        {
         arr[i][j]=in.nextInt();
         if(i==j)
            trace+=arr[i][j];
         set1.add(arr[i][j]);//checking row wise
         //set2.add(arr[j][i]);//checking column wise
        }
        if(set1.size()<n)
            r++;
        set1.clear();
      }
      for(int i=0;i<n;i++)
      {
        Set<Integer> set2=new HashSet<Integer>();
        for(int j=0;j<n;j++)
        {
            set2.add(arr[j][i]);
        }
        if(set2.size()<n)
            c++;
        set2.clear();
      }
      System.out.println("Case #" +k+ ": " + trace + " " + r + " " + c);
      
    }
  }


    }
  
