import java.io.*;
import java.util.Scanner;

public class Solution {
    static int calTrace(int mat[][], int n)
    {
        int sum=0;
        for(int i=0;i<n;i++)
        {
            sum=sum+mat[i][i];
        }
        return sum;
    }
    static int rowSum(int mat[][], int n)
    {
        int count=0;
        boolean match=false;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n-1;j++)
            {
                for(int k=j+1;k<n;k++)
                {
                    if (mat[i][j]==mat[i][k])
                    {    
                        match=true;
                        break;
                    }    
                }
                if(match==true)
                {
                    count=count+1;
                    break;
                }    
            }
            match=false;
        }
        return count;
    }
    
    static int colSum(int mat[][], int n)
    {
        int count=0;
        boolean match=false;
        for(int j=0;j<n;j++)
        {
            for(int i=0;i<n-1;i++)
            {
                for(int k=i+1;k<n;k++)
                {
                    if (mat[i][j]==mat[k][j])
                    {    
                        match=true;
                        break;
                    }    
                }
                if(match==true)
                {
                    count=count+1;
                    break;
                }    
            }
            match=false;
        }
        return count;
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        for (int i=0;i<t;i++)
        {
            int n=sc.nextInt();
            int matrix[][] = new int[n][n];
            for(int j=0;j<n;j++)
            {
                for(int k=0;k<n;k++)
                {
                    matrix[j][k] = sc.nextInt();
                }
            }
            int row=rowSum(matrix,n);
            int col=colSum(matrix,n);
            int output=calTrace(matrix,n);
            System.out.println("Case #"+(i+1)+": "+output+" "+row+" "+col);
        }
        sc.close();
    }
}