/*
Author:Govind_213
Problem link:

*/
import java.io.*;
import java.io.IOException;

public class Solution
{  
     static void print(int a[][],int n)
     {
         int i=0,j=0;
        for(i=0;i<n;i++)
        {
            for(j=0;j<n;j++)
            {   
                 System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }
     }
    static void swaprow(int a[][],int i,int j,int n)
    {
        int temp=0;
        for(int l=0;l<n;l++)
        {
            temp=a[i][l];
            a[i][l]=a[j][l];
            a[j][l]=temp;
        }
    }
    static void createmat(int mat[][],int a[],int val,int n)
        {
            int i=0,j=0;
             val=val-1;
             int pos=0;
            for(i=0;i<n;i++)
            {   if(val<0)
                {
                    val=n-1;
                }
                pos=val;
                for(j=0;j<n;j++)
                {   
                    if(pos==n)
                    {
                        pos=0;
                    }
                    mat[i][j]=a[pos];
                    pos++;
                }
                val--;
            }
        }
    static int trace(int a[][],int n)
     {   
         int ans=0;
        for(int i=0;i<n;i++)
        {
            ans+=a[i][i];
        }
        return(ans);
     }
   public static void main(String[]args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tcs=Integer.parseInt(br.readLine());
        int i=0;
        int o=0;
       
       
        for(int l=0;l<tcs;l=l+1)
        { 
            String s[]=br.readLine().split(" ");
           int  n=Integer.parseInt(s[0]);
            int k=Integer.parseInt(s[1]);
            int mat[][]=new int[n][n];
            int arr[]=new int[n];
            for(i=0;i<n;i++)
            {
                arr[i]=i+1;
            }         
            if(k%n==0)
            {
                int val=k/n;
                //System.out.println(n+"idhar"+k);
                createmat(mat,arr,val,n);
                //recheck
                if(trace(mat,n)==k)
                {
                    System.out.println("Case #"+(l+1)+": POSSIBLE");
                    print(mat,n);
                }                 
            }
            else
            {
                int val=k/n;
                createmat(mat,arr,val,n);
                boolean nf=false;
                for(i=0;i<n-1;i++)
                {
                    for( int t=i+1;t<n;t++)
                    {
                        swaprow(mat,i,t,n);
                        if(trace(mat,n)==k)
                        {
                            System.out.println("Case #"+(o+1)+": POSSIBLE");
                            nf=true;
                            print(mat,n);
                            break;
                        }

                    }

                }
                if(!nf)
                {
                    System.out.println("Case #"+(l+1)+": IMPOSSIBLE");

                }
    
            }
        
        }
    }
}