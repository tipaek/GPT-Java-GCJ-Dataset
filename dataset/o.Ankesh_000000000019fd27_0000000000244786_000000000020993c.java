
import java.util.*;
import java.lang.*;
import java.io.*;
import java.io.DataInputStream; 
import java.io.FileInputStream; 
import java.io.IOException; 
import java.io.InputStreamReader; 
import java.util.Scanner; 
import java.util.StringTokenizer; 
  class Codechef
{
      
	public static void main (String[] args)throws java.lang.Exception
	{
		Scanner sc=new Scanner(System.in);
		 int t=sc.nextInt();
		 StringBuilder sb=new StringBuilder();
		 		
		 for(int l=1;l<=t;l++)
		 {
			 int n=sc.nextInt();
			 int sum=0;
			 int A[][]=new int[n][n];
			     for(int i=0;i<n;i++)
				 for(int j=0;j<n;j++)
				 {
					 A[i][j]=sc.nextInt();
					 if(i==j)
						 sum+=A[i][j];
				 }
				 int r=0;
				 int c=0;
				 
				 for(int i=0;i<n;i++)
				 {
					 int x[]=new int[n];
					for(int j=0;j<n;j++)
					{
						x[A[i][j]-1]=1;
					}
						Arrays.sort(x);
						if(x[0]==0)
							r++;
					
				 }
				 for(int i=0;i<n;i++)
				 {
					 int y[]=new int[n];
					for(int j=0;j<n;j++)
					{
						y[A[j][i]-1]=1;
					}
						Arrays.sort(y);
						if(y[0]==0)
							c++;
				 }
				 System.out.println("Case #"+l+": "+sum+" "+r+" "+c);
				 
	}
	}
}