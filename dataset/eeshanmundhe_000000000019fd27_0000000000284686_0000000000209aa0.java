import java.io.*;
import java.util.*;
public class Solution
{
	public static void main(String[] args)throws IOException 
	{
		InputStreamReader read = new InputStreamReader(System.in);
		BufferedReader in = new BufferedReader(read);
		int t1=Integer.parseInt(in.readLine());
		for(int l=1;l<=t1;l++)
		{
		    String s=in.readLine();
		    String s1[]=s.split(" ");
		    int n=Integer.parseInt(s1[0]);
		    int k=Integer.parseInt(s1[1]);
		    int a[][]=new int[n][n];
		    String ans="";
		    if(k%n!=0)
		    {
		        ans="IMPOSSIBLE";
		    }
		    else
		    {
		        ans="POSSIBLE";
		        
		        for(int i=0;i<n;i++)
		        {
		            int p=i;
		            for(int j=i;j<p+4;j++)
		            {
		                if(i==j%n)
		                {
		                    a[i][j%n]=k/n;
		                }
		                else
		                {
		                    a[i][j%n]=a[i][(j-1)%n]%n +1;
		                }
		            }
		        }
		    }
		    if(ans=="POSSIBLE")
		    {
		        System.out.println("Case #"+l+": "+ans);
		        for(int i=0;i<n;i++)
		        {
		            for(int j=0;j<n;j++)
		            {
		                System.out.print(a[i][j]+" ");
		            }
		            System.out.println(); 
		        }
		    }
		    else
		    {
		        System.out.println("Case #"+l+": "+ans);
		    }
		}
	}
}