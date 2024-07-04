import java.util.*;
import java.lang.*;
import java.io.*;
class Solution
 {
	public static void main (String[] args)
	 {
	    Scanner sc=new Scanner(System.in);
	    int test=sc.nextInt();
	    for(int x=0;x<test;x++)
	    {
	       int n=sc.nextInt();
	       int arr[][]=new int[n][n];
            int k=0;
	       for(int i=0;i<n;i++)
	       {
               for(int j=0;j<n;j++){
                   arr[i][j]=sc.nextInt();	
                   if(i==j)
                       k+=arr[i][j];
               }
	       }
            
            int row[][]=new int[n][n];
            int column[][]=new int[n][n];
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    row[i][arr[i][j]-1]+=1;
                    column[j][arr[i][j]-1]+=1;
                }
            }
            int r=0;
            for(int i=0;i<n;i++)
            {
                boolean flag=false;
                for(int j=0;j<n;j++)
                {
                    if(row[i][j]!=1)
                        flag=true;
                }
                if(flag==true)
                    r++;
                
            }
            int c=0;
            for(int i=0;i<n;i++)
            {
                boolean flag=false;
                for(int j=0;j<n;j++)
                {
                    if(column[i][j]!=1)
                        flag=true;
                }
                if(flag==true)
                    c++;
                
            }
            System.out.println("Case #"+(x+1)+": "+k+" "+ r+" "+ c);
	    
	    }
	 }
}