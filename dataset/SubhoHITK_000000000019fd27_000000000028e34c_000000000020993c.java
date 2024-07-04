import java.io.*;
import java.util.*;
import java.lang.*;
class vestigium
{
    public static void main(String args[])
    {
        Scanner scan=new Scanner(System.in);
        int t=scan.nextInt();
        int sum=0;
        int v=0;
        int n,i,u,j,k;
        int count=0;
        int trace[]=new int[t];
        int row[]=new int[t];
        int column[]=new int[t];
        int arr[][];
        for(i=1;i<=t;i++)
        {
            n=scan.nextInt();
            arr=new int[n][n];
            for(j=0;j<n;j++)
            {
                for(k=0;k<n;k++)
                {
                    arr[j][k]=scan.nextInt();
                }
            }
            for(int r=0;r<n;r++) 
            {
                for(int c=0;c<n;c++) 
                {   
                    int dumy=c+1;
                    if(arr[r][c]==arr[r][dumy])
                    {
                        count++;
                        break;
                    }
                }
            }
            row[i]=count;
            count=0;
            for(int c=0;c<n;c++) 
            {
                for(int r=0;r<n;r++) 
                {   
                    int dumy=r+1;
                    if(arr[r][c]==arr[dumy][c])
                    {
                        count++;
                        break;
                    }
                }
            }
            column[i]=count;
            count=0;
            for(u=0;u<n;u++)
            {
                for(v=0;v<n;v++)
                {
                    if(u==v)
                    {
                        sum+=arr[u][u];
                    }
                }
            }
            trace[i]=sum;
        
            System.out.print("Case #");
            System.out.print(i);
            System.out.print(":");
        }
        for(int l=1;l<=t;l++)
        {
            System.out.print(trace[v]);
            System.out.print(row[v]);
            System.out.print(column[v]);
            v++;
        }
      
      }
   }
 
   