import java.util.Scanner;
import java.util.*;
import java.lang.*;
import java.io.*;

class CodeJam1
{
    
    static int trace(int arr[][], int n)
    {
        int count=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(i==j)
                    count=arr[i][j]+count;
            }
        }
        return count;
    }
    static int row(int arr[][],int n)
    {
        int rowCount=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(rowCount>=n)
                    break;
                if(arr[i][j]==arr[i][j+1])
                    rowCount=rowCount+1;
                    
            }
        }
        return rowCount;
    }
    
    static int column(int arr[][],int n)
    {
        int columnCount=0;
        for(int j=0;j<n;j++)
        {
            for(int i=0;i<n;i++)
            {
                if(columnCount>=n)
                    break;
                if(arr[i][j]==arr[i+1][j])
                    columnCount=columnCount+1;
            }
        }
        return columnCount;
    }
public static void main(String[] args)
    {
        Scanner ac=new Scanner (System.in);
        CodeJam1 obj=new CodeJam1();
        int tc=ac.nextInt();
        
        while(tc-->0)
        {
            for(int k=1;k<=tc;k++)
            {
            int n= ac.nextInt();
            int arr[][]=new int[n+1][n+1];
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                arr[i][j]=ac.nextInt();
                 }
            }
            
             System.out.println("case #"+k+":"+obj.trace(arr,n)+" "+obj.row(arr,n)+" "+obj.column(arr,n));
        }
        }
    }
    
}
