/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Solution
{
	public static void main (String[] args) throws java.lang.Exception
	{
		 Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int k = 1; k <= t; ++k) {
          int n = in.nextInt();
          int a[][]=new int[n][n];
          int trace=0;
          
          for(int i=0;i<n;i++)
              for(int j=0;j<n;j++)
          {
              a[i][j]=in.nextInt();
              if(i==j)
                  trace=trace+a[i][j];
              
          }
          int cr=0,cc=0;
          for(int i=0;i<n;i++)
          {
              Set<Integer> r=new HashSet<Integer>();
              for(int j=0;j<n;j++)
                 {
                      int p= a[i][j];
                      r.add(p);
                 }
              if(n!=r.size())
              cr++;
              r.removeAll(r);
          }
          for(int j=0;j<n;j++)
          {
              Set<Integer> r=new HashSet<Integer>();
              for(int i=0;i<n;i++)
                 {
                      int p= a[i][j];
                      r.add(p);
                 }
              if(n!=r.size())
              cc++;
              r.removeAll(r);
          }
            System.out.println(trace);
          System.out.println("Case #" + k + ": "+trace+" "+(cr) + " " + (cc));
        }
	}
}