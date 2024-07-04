import java.util.*;
import java.io.*;
import java.lang.*;
class Solution
{
public static void main(String [] args)
{
  Scanner s=new Scanner(System.in);
  int T=s.nextInt();
  for(int t=1;t<=T;t++)
  {
     int N=s.nextInt();
     int A[][]=new int[N][N];
     long S=0;
     int F[]=new int[N+1];
     int r=0;
     for(int i=0;i<N;i++)
     {
        Arrays.fill(F,0);
        for(int j=0;j<N;j++)
        {
            A[i][j]=s.nextInt();
            if(i==j)
            {
                S+=A[i][j];
            }
            F[A[i][j]]++;
        }
        for(int k=0;k<=N;k++)
        {
            if(F[k]>1)
            {
               r++;
               break;
            }
        }
     }
     
     int c=0;
     for(int i=0;i<N;i++)
     {
        Arrays.fill(F,0);
        for(int j=0;j<N;j++)
        {
            F[A[j][i]]++;
        }
        for(int k=0;k<=N;k++)
        {
            if(F[k]>1)
            {
               c++;
               break;
            }
        }
     }
     
     System.out.println("Case #"+t+": "+S+" "+r+" "+c);
     
  }
}
}
