import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Solution
{
	public static void main (String[] args) throws java.lang.Exception
	{
Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));	 int t=sc.nextInt();
	 for(int j=0;j<t;++j)
	 {
	     int n=sc.nextInt();
	     int arr[][]=new int[n][n];
	     int trace=0;
	     for(int i=0;i<n;++i)
	     {
	         for(int k=0;k<n;++k)
	         {
	             
	             arr[i][k]=sc.nextInt();
	             if(i==k)
	             {
	                 trace=trace+arr[i][k];
	             }
	         }
	     }
	     int row=0;
	     for(int i=0;i<n;++i)
	     {
	         int flag=0;
	         for(int k=0;k<n;++k)
	         {
	             for(int y=k+1;y<n;++y)
	             {
	                 if(arr[i][k]==arr[i][y])
	                 {
	                     ++flag;
	                     ++row;
	                     break;
	                 }
	             }
	             if(flag!=0)
	             {
	                 break;
	             }
	         }
	     }
	     
	     
	     
	     int column=0;
	      for(int i=0;i<n;++i)
	     {
	         int flag=0;
	         for(int k=0;k<n;++k)
	         {
	             for(int y=k+1;y<n;++y)
	             {
	                 if(arr[k][i]==arr[y][i])
	                 {
	                     ++flag;
	                     ++column;
	                     break;
	                 }
	             }
	             if(flag!=0)
	             {
	                 break;
	             }
	         }
	     }
	     
	     
	  System.out.println("Case"+" "+"#"+(j+1)+": "+trace+" "+row+" "+column);   
	     
	     
	     
	 }
	}
}
