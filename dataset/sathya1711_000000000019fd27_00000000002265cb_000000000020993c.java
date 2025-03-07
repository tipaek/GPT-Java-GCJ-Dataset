import java.util.*;
import java.io.*;
class Solution
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t=sc.nextInt();
        int c=0;
        while(t-->0)
        {
            c++;
            int n=sc.nextInt();
            int matrix[][]=new int[n][n];
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    matrix[i][j]=sc.nextInt();
                }
            }
            System.out.println("Case #"+c+": "+dia(matrix,n)+" "+row(matrix,n)+" "+col(matrix,n));
        }
    }
    public static int dia(int matrix[][],int n)
    {
        int sum=0;
        for(int i=0;i<n;i++)
        {
            sum+=matrix[i][i];
        }
        return sum;
    }
    public static int row(int matrix[][],int n)
    {
        int count=0;
        for(int i=0;i<n;i++)
        {
            int row[]=new int[n+1];
            for(int j=0;j<n;j++)
            {
                row[matrix[i][j]]++;
                if(row[matrix[i][j]]>1)
                {
                    count++;
                    break;
                }
            }
        }
        return count;
    }
    public static int col(int matrix[][],int n)
    {
        int count=0;
        for(int i=0;i<n;i++)
        {
            int row[]=new int[n+1];
            for(int j=0;j<n;j++)
            {
                row[matrix[j][i]]++;
                if(row[matrix[j][i]]>1)
                {
                    count++;
                    break;
                }
            }
        }
        return count;
    }
}