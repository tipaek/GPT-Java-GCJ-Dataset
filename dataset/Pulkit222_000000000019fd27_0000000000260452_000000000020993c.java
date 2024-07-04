package Vestigum;

import java.util.*;

public class Vestigum {
	
	public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        for(int i=0;i<testcase;i++)
        {
           int n=sc.nextInt();
           int[][] arr = new int[n][n];
           for(int j=0;j<n;j++)
           {
        	   for(int k=0;k<n;k++)
        	   {
        		   arr[j][k]=sc.nextInt();
        	   }
           }
           int[][] arr1 = new int[n][n];
           int trace=0;
           int row=0;
           int coloum=0;
           for(int j=0;j<n;j++)
           {
               trace=trace+arr[j][j];
               for(int k=0;k<n;k++)
               {
                   if(arr1[j][arr[j][k]-1]==0)
                       {
                	   		arr1[j][arr[j][k]-1]++;
                       }
                   else
                   {
                	   row++;
                	   break;
                   }
                   
                   
               }
           }
           int arr2[][] = new int[n][n];
           for(int j=0;j<n;j++)
           {
               for(int k=0;k<n;k++)
               {
                   if(arr2[arr[k][j]-1][j]==0)
                   {
                	   arr2[arr[k][j]-1][j]=1;
                   }
                   else
                   {
                	   coloum++;
                	   break;
                   }
                       
                   
               }
           }
           System.out.println("Case #"+i+": "+trace+" "+row+" "+coloum);
           
        }
    }

}
