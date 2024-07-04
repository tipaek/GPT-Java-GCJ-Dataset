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
            int e[]=new int[n];
            for(int i=0;i<n;i++)
            {
                a[i]=sc.nextInt();
                b[i]=sc.nextInt();
                c[i]=b[i];
                e[i]=b[i];
            }
            
            Arrays.sort(b);
            Arrays.sort(e);
            for(int i=0;i<n;i++)
            {
              for(int j=0;j<n;j++)
              {
                  if(c[i]==e[j])
                  
                  {d[j]=a[i];
                  e[j]=-2;
                  }
                  
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
              d[j]=-1;
          }
         
    }
    d[0]=-1;
    for(int y=0;y<n;y++)
    {
        if(d[y]!=-1)
        {
        	m[y]='J';
        k=y;
        break;}
    }
      for (int j = k+1; j < n; j++) 
    { 
         if (d[j] >= b[k]&&d[k]!=-1) 
         { 
              m[j]='J'; 
              k= j; 
              d[j]=-1;
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