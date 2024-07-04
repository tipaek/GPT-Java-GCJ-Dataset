import java.util.*;
class vestigium 
{
    public static void main(String args[]) 
    {
        Scanner in=new Scanner(System.in);
        int t=in.nextInt();int q=0;
        for(int i=0;i<t;i++)
         {
             int n=in.nextInt();int f=1;int x=0;int z=0;
             int k=0;int j=0;int l=0;
             int[][] arr=new Int[n][n];
             for(j=0;j<n;j++)
             {for(l=0;l<n;l++)
             {arr[j][l]=in.nextInt();
             if(j==l)
             q+=arr[j][l];}}
             for(j=0;j<n;j++)
             {for(l=0;l<n;l++)
              {for(k=0;k<n;k++)
              if(arr[j][l]==arr[j][k])
              {z++;}
              if(arr[l][j]==arr[k][j])
              {x++;}
              }}
              System.out.println("Case #"+f+":"+q+" "+z+" "+x);
              f++;}}}