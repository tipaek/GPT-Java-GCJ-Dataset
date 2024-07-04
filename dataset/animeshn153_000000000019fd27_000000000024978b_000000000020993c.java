import java.util.*;
import java.util.Arrays;
public class Main
{
	public static void main(String[] args)
	{
		Scanner s=new Scanner(System.in);
		int i,j,k,sum=0,count=0;
		int t=s.nextInt();
		for(i=0;i<t;i++)
		{
		    int n=s.nextInt();
		    int a[][]=new int[n][n];
		    for(j=0;j<n;j++)
		    {
		        for(k=0;k<n;k++)
		        {
		            a[j][k]=s.nextInt();
		            if(a[j]==a[k])
		            {
		                sum=sum+a[j][k];
		            }
		        }
		    }
		    int q=0;
		    for(j=0;j<n;j++)
		    {
		        for(k=0;k<n;k++)
		        {
		            
		            if(a[j][k]==a[q][k] && j!=q)
		            q=q+1;
		            
		        }
		    }
		    int w=0;
		    for(j=0;j<n;j++)
		    {
		        for(k=0;k<n;k++)
		        {
		            if(a[j][k]==a[j][w]&&k!=w)
		            w=w+1;
		        }
		    }
		    System.out.println(sum+" "+q+" "+w);
		}
	}
}
