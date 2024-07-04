/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/
import java.io.*;
import java.lang.*;
import java.util.*;
public class Solution
{   
    static int trace(int a[][],int n)
    { int i,j,c=0;
     for(i=0;i<n;i++)
     c=c+a[i][i];
        return c;
    }
    static int rowcheck(int r,int a[][],int n)
    { HashSet<Integer> h =new HashSet<>();
     for(int i=0;i<n;i++)
     h.add(a[r][i]);
        return h.size();
    }
    static int colcheck(int c,int a[][],int n)
    { HashSet<Integer> h =new HashSet<>();
     for(int i=0;i<n;i++)
     h.add(a[i][c]);
        return h.size();
    }
    
	public static void main(String[] args) {
	    Scanner sc=new Scanner(System.in);
	    int i,j,k,n,m,p=0,q=0,r=0,c=0,s,t;
	    t=sc.nextInt();
	    for(i=0;i<t;i++)
	    { n=sc.nextInt();
	     q=0;r=0;
	     int a[][]=new int[n][n];
	      for(j=0;j<n;j++)
	      { for(k=0;k<n;k++)
	          a[j][k]=sc.nextInt();
	      }
	      p=trace(a,n);
	      for(j=0;j<n;j++)
	      { if(n!=rowcheck(j,a,n))
	          q++;
	      }
	      for(j=0;j<n;j++)
	      {if(n!=colcheck(j,a,n))
	          r++;
	          
	      }
	        System.out.println("Case #"+(i+1)+": "+p+" "+q+" "+r);
	    }
		//System.out.println("Case #"+i+": "+p+" "+q+" "+r);
	}
}
