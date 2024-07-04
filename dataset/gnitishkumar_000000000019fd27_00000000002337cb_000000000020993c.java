/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/
import java.io.*;
import java.lang.*;
import java.util.*;
public class Main
{   
    static int trace(int a[][],int n)
    { int i,j,c=0;
     for(i=0;i<n;i++)
     c=c+a[i][i];
        return c;
    }
    static int rowc(int r,int a[][],int n)
    { HashSet<Integer> hs =new HashSet<>();
     for(int i=0;i<n;i++)
     hs.add(a[r][i]);
        return hs.size();
    }
    static int colc(int c,int a[][],int n)
    { HashSet<Integer> hs =new HashSet<>();
     for(int i=0;i<n;i++)
     hs.add(a[i][c]);
        return hs.size();
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
	      { if(n!=rowc(j,a,n))
	          q++;
	      }
	      for(j=0;j<n;j++)
	      {if(n!=colc(j,a,n))
	          r++;
	          
	      }
	        System.out.println("Case #"+i+": "+p+" "+q+" "+r);
	    }
		//System.out.println("Case #"+i+": "+p+" "+q+" "+r);
	}
}
