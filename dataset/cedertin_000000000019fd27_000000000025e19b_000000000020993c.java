import java.io.*;
import java.util.*;
class solution
{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0)
		{
		    int n=sc.nextInt();
		    int[][] m=new int[n][n];
		    for(int i=0;i<n;i++)
		    {
		        for(int j=0;j<n;j++)
		        {
		            m[i][j]=sc.nextInt();
		        }
		    }
		    int k=0,r=0,c=0;
		    for(int i=0;i<n;i++)
		    {
		        for(int j=0;j<n;j++)
		        {
		            if(i==j)
		            {
		                k+=m[i][j];
		            }
		            for(int l=j+1;l<n;l++)
		            {
		                if(m[i][j]==m[i][l])
		                {
		                    r++;
		                }
		                if(m[j][i]==m[l][i])
		                {
		                    c++;
		                }
		            }
		        }
		    }
		    System.out.println(k+" "+r+" "+c);
		}
	}
}
