import java.io.*;
import java.util.*;
public class Vestigium
{
    static int rowele(int a[][],int n)
    {
        int flag=0,count=0;
        for(int i=0;i<n;i++)
		{
		    Arrays.sort(a[i]);
		    for(int j=0;j<n-1;j++)
		    {
		        if(a[i][j]==a[i][j+1])
		            flag=1;
		    }
		    if(flag==1)
		        {
		            count++;
		            flag=0;
		        }
		}
		return count;
    }
    static int colele(int a[][],int n)
    {
        int flag=0,count=0;
        for(int i=0;i<n;i++)
		    {
		        for(int j=i+1;j<n;j++)
		        {
		            int temp=a[i][j];
		            a[i][j]=a[j][i];
		            a[j][i]=temp;
		        }
		    }
		    
		   for(int i=0;i<n;i++)
		    {
		    Arrays.sort(a[i]);
		    for(int j=0;j<n-1;j++)
		    {
		        if(a[i][j]==a[i][j+1])
		            flag=1;
		    }
		    if(flag==1)
		        {
		            count++;
		            flag=0;
		        }
		}
		return count;
    }
    public static void main(String args[])throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T,trace=0;
        T=Integer.parseInt(br.readLine());
        int res[][]=new int[T][3];
        for(int k=1;k<=T;k++)
        {
            int N=Integer.parseInt(br.readLine());
            int a[][]=new int[N][N];
            int b[][]=new int[N][N];
            for(int p=0;p<N;p++)
		    {
		        String []s=br.readLine().split(" ");
		        for(int q=0;q<N;q++)
		        {
		            a[p][q]=Integer.parseInt(s[q]);
		            b[p][q]=a[p][q];
		        }
		    }
		    
		    for(int z=0;z<N;z++)
		    {
		        trace+=a[z][z];
		    }
		    res[k-1][0]=trace;
		    trace=0;
		    int r=rowele(a,N);
		    res[k-1][1]=r;
		    int c=colele(b,N);
		    res[k-1][2]=c;
        }
        for(int d=0;d<T;d++)
        { 
            System.out.print("Case #"+(d+1)+": ");
            for(int e=0;e<=2;e++)
            {
                System.out.print(res[d][e]+" ");
            }
            System.out.println( );
        }
    }
}