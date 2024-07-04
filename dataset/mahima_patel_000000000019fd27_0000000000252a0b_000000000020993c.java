import java.util.*;
public class Main
{
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		for(int i=0;i<t;i++)
		{
		    int n=sc.nextInt();
		    int a[][]=new int[n][n];
		    for(int j=0;j<n;j++)
		        for(int k=0;k<n;k++)
		            a[j][k]=sc.nextInt();
		    int tr=0;
		    for(int j=0,k=0;j<n;j++,k++)
		    {
		        tr+=a[j][k];
		    }
		    System.out.print("Case #"+(i+1)+": "+tr+" ");
		    int r=0;
		    int b[]=new int[101];
		    for(int j=0;j<n;j++)
		    {
		        for(int k=0;k<101;k++)
		            b[k]=0;
		        for(int k=0;k<n;k++)
		        {
		            b[a[j][k]]++;
		        }
		        for(int k=0;k<101;k++)
		        {
		            if(b[k]>1)
		            {
		                r++;
		                break;
		            }
		        }
		    }
		    System.out.print(r+" ");
		    int co=0;
		    int c[]=new int[101];
		    for(int j=0;j<n;j++)
		    {
		        for(int k=0;k<101;k++)
		            c[k]=0;
		        for(int k=0;k<n;k++)
		        {
		            c[a[k][j]]++;
		        }
		        for(int k=0;k<101;k++)
		        {
		            if(c[k]>1)
		            {
		                co++;
		                break;
		            }
		        }
		    }
		    System.out.println(co);
		}
	}
}
