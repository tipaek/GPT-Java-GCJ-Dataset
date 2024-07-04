import java.util.*;
import java.io.*;
public class Solution 
{
  public static void main(String[] args) 
  {
    int i,j,k,r,c,a;
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    a=1;
    while(t-->0)
    {
      k=r=c=0;
      int n = in.nextInt();
      int m[][]=new int[n][n];
      for(i=0;i<n;i++)
      {
          HashSet<Integer> h=new HashSet<>();
          for(j=0;j<n;j++)
          {
              m[i][j]=in.nextInt();
              h.add(m[i][j]);
              if(i==j)
              {
                  k+=m[i][j];
              }
          }
          if(h.size()!=n)
          {
              r++;
          }
      }
      for(i=0;i<n;i++)
      {
          HashSet<Integer> h=new HashSet<>();
          for(j=0;j<n;j++)
          {
              h.add(m[j][i]);
          }
          if(h.size()!=n)
          {
              c++;
          }
      }
      System.out.println("Case #" + a++ + ": " + k+" "+r+" "+c);
    }
  }
}