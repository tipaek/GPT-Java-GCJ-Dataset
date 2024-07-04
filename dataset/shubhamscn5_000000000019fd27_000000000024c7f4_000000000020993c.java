import java.io.*;
import java.util.*;
public class Solution
{
    public static void main(String args[])throws IOException
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        int cases=1;
        while(t-->0)
        {
            int n=sc.nextInt();
            int matrix[][]=new int[n][n];
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    matrix[i][j]=sc.nextInt();
                }
            }
            int matrixDup[][]=new int[n+1][n+1];
            int sum=0;
            int xtra=0;
            int r=0;
            int c=0;
            for(int i=0;i<n;i++)
            {
                xtra=0;
                for(int j=0;j<n;j++)
                {
                    if(matrixDup[i][matrix[i][j]]>0)
                    {
                        xtra=1;
                    }
                    if(i==j)
                    {
                        sum=sum+matrix[i][j];
                    }
                    matrixDup[i][matrix[i][j]]+=1;
                }
                r=r+xtra;
            }
            //--------------------------
            matrixDup=new int[n+1][n+1];
            for(int i=0;i<n;i++)
            {
                xtra=0;
                for(int j=0;j<n;j++)
                {
                    if(matrixDup[i][matrix[j][i]]>0)
                    {
                        xtra=1;
                    }
                    matrixDup[i][matrix[j][i]]+=1;
                }
                c=c+xtra;
            }
            System.out.println("Case #"+cases+": "+sum+" "+r+" "+c);
            cases+=1;
            
        }
    }
}