/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution
{
	public static void main (String[] args) throws java.lang.Exception
	{
		   Scanner sc=new Scanner (System.in);
        int t=sc.nextInt();
        int r=1;
        while(t!=0)
        {
            int n=sc.nextInt();
            int a[]=new int[n];
            int b[]=new int[n];
            int c[]=new int[n];
            int d[]=new int[n];
            for(int i=0;i<n;i++)
            {
                a[i]=sc.nextInt();
                b[i]=sc.nextInt();
                c[i]=b[i];
            }
            
            Arrays.sort(b);
            for(int i=0;i<n;i++)
            {
              for(int j=0;j<n;j++)
              {
                  if(c[i]==b[j])
                  d[j]=a[i];
                  
              }
            }
            
            char m[]=new char[n];
            for(int i=0;i<n;i++)
            m[i]='X';
            m[0]='C';
            int i=0;
            int k=0;
            int count=0;
       for (int j = 1; j < n; j++) 
    { 
         if (d[j] >= b[i]) 
         { 
              m[j]='C'; 
              i = j; 
          }
          else
          {
              if(count!=1)
          {
              m[j]='J';
              count++;
              k=j;
          }
          else
          {
              if(d[j] >= b[k]) 
         { 
              m[j]='J'; 
              k= j; 
          }
          }
          
          
     } 
    }
     String s="";
     for(int l=0;l<n;l++)
     {
          if(m[l]=='X')
         {
            s="IMPOSSIBLE";
            break;
         }
         else
         s=s+m[l];
     }
     System.out.println("Case #"+r+":"+" "+s);
     r++;
     t--;
    } 
	}
}