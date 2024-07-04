import java.util.*;
import java.util.Scanner;
 class Trace
{
     public static void main(String[] args)
    {
        int i,j,k,size,sum=0;
       
        Scanner sc=new Scanner(System.in);
         
        int n=sc.nextInt();
        for(k=1;k<=n;k++)
        {
            size=sc.nextInt();
            int arr[][]=new int[size][size];
            for(i=0;i<size;i++)
            {
                for(j=0;j<size;j++)
                {
                    arr[i][j]=sc.nextInt();
                }
            }
            for(i=0;i<size;i++)
     { 
      for(j=0;j<size;j++)
      { 
 if(i==j) 
 {
 sum = sum + arr[i][j];
 }
     }
 }
 
     System.out.printf("SUM of DIAGONAL elements of the matrix = "+sum) ;
 } 
        }
}
