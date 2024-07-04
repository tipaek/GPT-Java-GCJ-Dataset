import java.io.*;
import java.util.*;

public class Solution
{
    public static void main(String[]args)
    {
        Scanner s=new Scanner(System.in);
        int T=s.nextInt();
        for(int i=0;i<T;i++)
        {
            int N=s.nextInt();
            int [][]arr=new int [N][N];
            for(int j=0;j<N;j++)
            {
                for(int k=0;k<N;k++)
                {
                   arr[j][k]=s.nextInt(); 
                }
            }
            System.out.print("Case #"+T+": ");
            matrixOps(N,arr);
        }
    }
    public static void matrixOps(int n,int [][]arr)
    {
      int k,r,c;
      k=trace(n,arr);
      r=rows(n,arr);
      c=columns(n,arr);
      System.out.print(k+" "+r+" "+c+"\n");
    }
    public static int trace(int n,int[][]arr)
    {
        int soln=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(i==j)
                {
                    soln+=arr[i][j];
                }
            }  
         }
         return soln;
        }
    public static int rows(int n,int[][]arr1)
        {
            int r=0;
            for(int j=0;j<n;j++)
            { 
                
                int []arr=arr1[j];
        for (int i = 0; i < n; i++) { 
           arr[arr[i] %n] = arr[arr[i] %n] + n; 
        } 
        for (int i = 0; i < n; i++) { 
            if (arr[i] >= n*2) { 
                r=1;
                break;
            } 
        } 
    } 
    return r;
        }
        public static int columns(int n,int[][]arr1)
        {
            int r=0;
            for(int j=0;j<n;j++)
            { 
                
                int []arr=arr1[j];
        for (int i = 0; i < n; i++) { 
           arr[arr[i] %n] = arr[arr[i] %n] + n; 
        } 
        for (int i = 0; i < n; i++) { 
            if (arr[i] >= n*2) { 
                r=1;
                 break;
            } 
        } 
    }
    return r;
        }
}