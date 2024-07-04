import java.io.*;
import java.util.*;
public class Solution
{
    public static void main(String args[])
    {
        int T;
        Scanner sc=new Scanner(System.in);
        T=sc.nextInt();
        int N[]=new int[T];
        int M[][][]=new int[T][100][100];
        for(int i=0;i<T;i++)
        {
            N[i]=sc.nextInt();
            for(int a=0;a<N[i];a++)
            {
                for(int b=0;b<N[i];b++)
                {
                    M[i][a][b]=sc.nextInt();
                }
            }
        }
        int k,r,c;
        int col[]=new int[100];
        int row[]=new int[100];
        for(int i=0;i<T;i++)
        {
            k=r=c=0;
            for(int a=0;a<N[i];a++)
            {
                col[a]=row[a]=0;
                for(int b=0;b<N[i];b++)
                {
                    if(a==b)
                    {
                        k=k+M[i][a][b];
                    }
                    for(int d=1;d<N[i];d++)
                    {
                        if(M[i][a][b]==M[i][a][b+d]&&row[a]==0)
                        {
                            row[a]=1;
                            r++;
                        }
                        if(M[i][b][a]==M[i][b+d][a]&&col[a]==0)
                        {
                            col[a]=1;
                            c++;
                        }
                    }
                }
            }
            System.out.println("Case #"+(i+1)+": "+k+" "+r+" "+c);
        }
    }
}