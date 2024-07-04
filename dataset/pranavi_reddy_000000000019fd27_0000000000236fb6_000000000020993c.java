import java.io.*;
import java.util.*;
class Solution
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        int mike=1;
        while(t!=0)
        {
            t--;
        
            int n=sc.nextInt();
            int[][] a=new int[n][n];
            int rc=0;
            int tc=0;
            int cc=0;
            for(int i=0;i<n;i++)
            {
                int[] check=new int[n+1];
                int flag=0;
                for(int j=0;j<n;j++)
                {
                    
                    a[i][j]=sc.nextInt();
                    if(i==j)
                    tc=tc+a[i][j];
                    check[a[i][j]]++;
                    if(check[a[i][j]]>1&&flag==0){
                    rc++;
                        flag=1;
                    }
                }
            }
            for(int i=0;i<n;i++)
            {
                int[] check=new int[n+1];
                int flag=0;
                for(int j=0;j<n;j++)
                {
                    check[a[j][i]]++;
                    if(check[a[j][i]]>1&&flag==0)
                    {
                        cc++;
                        flag=1;
                    }
                }
            }
            System.out.println("Case #"+mike+": "+tc+" "+rc+" "+cc);
            mike++;
        }
    }
    
}