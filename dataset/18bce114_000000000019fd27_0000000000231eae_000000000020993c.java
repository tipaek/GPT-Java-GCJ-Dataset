import java.util.*;
import java.lang.*; 
public class Solution{

     public static void main(String []args){
         Scanner in=new Scanner(System.in);
        int t,n;
        t=in.nextInt();
        for(int i=0;i<t;i++)
        {
            n=in.nextInt();
            int a[][]=new int[n][n];
            int r[][]=new int[n][n];
            int c[][]=new int[n][n];
            int tr=0,rc=0,cc=0;
            for(int j=0;j<n;j++)
            {
                for(int k=0;k<n;k++)
                {
                    a[j][k]=in.nextInt();
                    r[a[j][k]-1][j]++;
                    if(j==k)
                    {
                        tr+=a[j][k];
                    }
                }
                for(int k=0;k<n;k++)
                {
                    if(r[k][j]>1)
                    {
                        rc++;
                        break;
                    }
                }
            }
            for(int k=0;k<n;k++)
            {
                for(int j=0;j<n;j++)
                {
                    c[a[j][k]-1][j]++;
                }
            }
            for(int j=0;j<n;j++)
            {
                for(int k=0;k<n;k++)
                {
                    if(c[k][j]>1)
                    {
                        cc++;
                        break;
                    }
                }
            }
            System.out.println("Case #"+i+1+": "+tr+" "+rc+" "+cc);
        }
    }
} 