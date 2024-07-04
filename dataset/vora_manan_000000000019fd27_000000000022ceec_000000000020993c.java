import java.util.*;
import java.lang.*;
import java.io.*;
 

class Solution
{
	public static void main (String[] args) throws java.lang.Exception
	{
  Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
     int s=1;  
        while(t!=0)
        {
             int r=0,c=0,sum=0;
            int n=sc.nextInt();
            int a[][]=new int[n][n];
            for(int i=0;i<n;i++)
            {
 
                for(int j=0;j<n;j++)
                {
                    a[i][j]=sc.nextInt();
 
                }
        }
 
         for(int i=0;i<n;i++)
         {
             HashSet<Integer> h = new HashSet<Integer>();
             for(int j=0;j<n;j++){
             h.add(a[i][j]);
             if(i==j)
             sum=sum+a[i][j];
             }
 
         if(h.size()!=n)
         r++;
        }
          for(int i=0;i<n;i++)
         {
             HashSet<Integer> m = new HashSet<Integer>();
             for(int j=0;j<n;j++)
             m.add(a[j][i]);
 
         if(m.size()!=n)
         c++;
        }
 
        System.out.println("Case"+" "+"#"+s+":"+" "+sum+" "+r+" "+c);
        s++;
        t--;
        }
	}
}