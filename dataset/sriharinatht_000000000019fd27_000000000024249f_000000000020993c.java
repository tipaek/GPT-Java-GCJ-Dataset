import java.io.*;
import java.util.*;
 class Solution
{
    public static void main(String args[])
    {int j,k,l;
        Scanner sc=new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T=sc.nextInt();
        for(int i=0;i<T;i++)
        {   int K=0;
            int N=sc.nextInt();
            int a[][]=new int[N][N];
            for(j=0;j<N;j++)
            for(k=0;k<N;k++)
            a[j][k]=sc.nextInt();
            for(k=0;k<N;k++)
            K+=a[k][k];
            int cc=0,count=0;
            for(j=0;j<N;j++)
            {
            for(k=0;k<N;k++)
            for(l=k+1;l<N;l++)
            {
                if(a[j][k]==a[j][l])
                {
                    cc++;
                }
            }
            if(cc>=1)
            count++;
            }
            int r=count;
            count=0;
            for(j=0;j<N;j++)
            {cc=0;
            for(k=0;k<N;k++)
            for(l=k+1;l<N;l++)
            {
                if(a[k][j]==a[l][j])
                {
                    cc++;
                }
            }
            if(cc>=1)
            count++;
            }
            int c=count;
            System.out.println("Case #"+(i+1)+": "+K+" "+r+" "+c);
            
         
            
                
            
            
            
        }
    }
}