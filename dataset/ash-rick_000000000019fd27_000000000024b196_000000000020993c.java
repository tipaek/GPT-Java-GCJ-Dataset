import java.util.*;
import java.io.*;

public class Vestigium
{
    public static void main(String[] args)
    {
      Scanner sc=new Scanner(System.in);
      Vestigium v=new Vestigium();
      int T=sc.nextInt();
      int t=1;
       while(t<=T&&T<=100)
       {
           //System.out.println("enter size of matrix:");
          int N=sc.nextInt();
          if(N>=2&&N<=100)
          {
           int[][] matrix=new int[N][N];
           v.Trace(matrix,N,t);
           }
           t++;
        
        }
    }
    public void Trace(int[][] matrix,int n,int t)
    {
        Scanner sc=new Scanner(System.in);
        int r=0,c=0,digosum=0;
         for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                matrix[i][j]=sc.nextInt();
            
            }
        }
        for(int i=0;i<n;i++)
        {
            int temprow=0,tempcol=0,flagrow=0,flagcol=0;
            for(int j=0;j<n;j++)
            {
                if(i==j)
                {
                    digosum+=matrix[i][j];
                }
                int k=j;
                while(k<n&&k!=0)
                {
                    if(temprow==matrix[i][k]&&flagrow==0)
                    {
                        r++;
                        flagrow=1;
                    }
                    if(tempcol==matrix[k][i]&&flagcol==0)
                    {
                        c++;
                        flagcol=1;
                    }
                    k++;
                }
                temprow=matrix[i][j];
                tempcol=matrix[j][i];
                
            }
        
        }
        System.out.println("case #"+t+":"+digosum+" "+r+" "+c);
    }
}
