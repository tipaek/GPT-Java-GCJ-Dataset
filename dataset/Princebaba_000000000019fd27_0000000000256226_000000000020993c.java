import java.io.*;
import java.util.*;
class Solution {
    public static void main(String args[]) throws IOException
{
    int T,N,i,j,r,c,k;
    int M[][][],INDX[];
    Scanner sc=new Scanner(System.in);
    T=sc.nextInt();
    M=new int [T][100][100];
    INDX=new int[T];
    for(int t=0;t<T;t++)
        {
	N=sc.nextInt();
        INDX[t]=N;
        for(i=0;i<N;i++)
        {
            for(j=0;j<N;j++)
            {
                   M[t][i][j]=sc.nextInt();
            }
        }
        }
    for(int t=0;t<T;t++)
        {
            N=INDX[t];
        r=c=k=0;
        for(i=0;i<N;i++)
        {
            for(j=0;j<N;j++)
            {
                if(i==j)
                    k=k+M[t][i][j];
            }
        }
        System.out.print("\nCase #"+t+" :");
        for(i=0;i<N;i++)
        { 
            int f=0;
            for(j=0;j<N;j++)
            {
                for(int l=j+1;l<N;l++)
                {
                    if(M[t][i][j]==M[t][i][l])
                    {
                        f=1;
                        break;
                    }
                }
            }
            if(f==1)
                {
                    r++;
                }
        }
        for(i=0;i<N;i++)
        {
            int f=0;
            for(j=0;j<N;j++)
            {
                for(int o=j+1;o<N;o++)
                {
                    if(M[t][j][i]==M[t][o][i])
                    {
                        f=1;
                    }
                }
            }
                if(f==1)
                {
                    c++;
                }
        }
        System.out.print(k+" "+r+" "+c);
        }
    }
}