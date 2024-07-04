import java.util.*;
import java.io.*;
public class Solution
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int N, a[][], sum=0,i,j,k,r,c;
        int T=in.nextInt();
        for(int x=1;x<=T;x++)
        {
            sum=0;
            N=in.nextInt();
            a=new int[N][N]; 
            for(i=0;i<N;i++)
            {
                for(j=0;j<N;j++)
                {
                    a[i][j]=in.nextInt();
                    if(i==j)
                    sum=sum+a[i][j];
                }
            }
            r=0; c=0;
            for(i=0;i<N;i++)
            {
                for(j=0;j<N;j++)
                {
                    for(k=j+1;k<N;k++)
                    {
                        if(a[i][j]==a[i][k])
                        {
                            r++; j=N;
                            break;
                        }
                    }
                }
            }
            for(j=0;j<N;j++)
            {
                for(i=0;i<N;i++)
                {
                    for(k=i+1;k<N;k++)
                    {
                        if(a[i][j]==a[k][j])
                        {
                            c++; i=N;
                            break;
                        }
                    }
                }
            }
            //Case #1: 4 0 0
            System.out.println("Case #"+x+": "+sum+" "+r+" "+c);
        }
        in.close();
    }
}