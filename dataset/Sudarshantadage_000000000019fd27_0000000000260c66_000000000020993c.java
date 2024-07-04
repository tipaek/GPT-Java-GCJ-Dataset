import java.io.*;

import java.util.*;

class Solution 
{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [][] a =new int[100][100];
        int  sum;
        int c,r;
        int m;
        
        for(int k=0;k<n;k++)
        {
             m = sc.nextInt();
            for(int i=0;i<m;i++)
            {
                for(int j=0;j<m;j++)
                {
                 a[i][j]=sc.nextInt();   
                }
            }
        
        sum=0;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<m;j++)
            {
                
                if(i==j)
                {
                 sum = sum + a[i][j];
                }
                
                
            }
        }
        
         int s=0,x=0;
         r=0;
         c=0;
         for(int i=0;i<m;i++)
        {
            int f = 0;
            int t = 0;
            for(int j=0;j<m;j++)
            {
                s=a[i][j];
                x=a[j][i];
                for(int z=j+1;z<m;z++)
                {
                if(s==a[i][z])
                {
                 r = r+1;
                 f=1;
                 break;
                }
                if(x==a[z][i])
                {
                    c=c+1;
                    t=1;
                    break;
                }
                }
                if(f==1)
                {
                    break;
                }
                if(t==1)
                {
                    break;
                }
                
            }
           
        }

        System.out.println(sum+" "+r+" "+c);
        
    }
    
    }
}