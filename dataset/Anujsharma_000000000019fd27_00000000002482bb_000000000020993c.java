/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.


*******************************************************************************/

import java.util.*;
import java.lang.*;
import java.io.*;
 class Main
{
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		for(int i=1;i<=t;i++)    
		{
		    int n=sc.nextInt();
		    
		    int a[][]=new int[n][n];
		    for(int j=0;j<n;j++)
		    for(int j1=0;j1<n;j1++)
		    a[j][j1]=sc.nextInt();
		    int p=((n)*(n+1))/2;
		    
		    long p1=1;
		    for(int m=1;m<=n;m++)
		    p1=p1*m;
		    
		    int r=0,c=0;
		    for (int k = 0; k < n;k++)
		    {
		        int sum=0,sum1=0;
		        long p2=1,p3=1;
		        //loop through columns
    for (int j2 =0; j2 < n; j2++)
     { sum =sum+a[k][j2];
      p2=p2*a[k][j2];
        
        }if((sum==p)&& p2==p1)
      r++;
      
        for(int j3=0;j3<n;j3++)
        {
            sum1=sum1+a[j3][k];
             p3=p3*a[j3][k];
        }   
      if(sum1==p&& p3==p1)
      c++;
      
            }
            int sum2=0;
            for(int j=0;j<n;j++)
		 sum2=sum2+a[j][j];
         
         System.out.println("Case #"+t+": "+sum2+" "+(n-r)+" "+(n-c));
            
      
    }
  }
}
		    
		    
		    
		    
