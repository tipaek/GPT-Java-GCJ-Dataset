import java.io.*;
import java.util.*;
public class Solution
{
	public static void main(String[] args)throws IOException 
	{
		InputStreamReader read = new InputStreamReader(System.in);
		BufferedReader in = new BufferedReader(read);
		int t1=Integer.parseInt(in.readLine());
		for(int k=1;k<=t1;k++)
		{
		    int n=Integer.parseInt(in.readLine());
		    int j[]=new int[1441];
		    int c[]=new int[1441];
		    int a[][]=new int[n][2];
		    for(int i=0;i<1441;i++)
		    {
		        j[i]=0;
		        c[i]=0;
		    }
		    for(int i=0;i<n;i++)
		    {
		        String s=in.readLine();
		        String b[]=s.split(" ");
		        a[i][0]=Integer.parseInt(b[0]);
		        a[i][1]=Integer.parseInt(b[1]);
		    }
		    int z=0;
		    String ans="";
		    for(int i=0;i<n;i++)
		    {
		        int cc=0,jj=0;
		        if(a[i][1]-a[i][0]!=1)
		        {
		        for(int m=a[i][0]+1;m<a[i][1];m++)
		        {
		            if(j[m]==1)
		            {
		                jj=1;
		            }
		            if(c[m]==1)
		            {
		                cc=1;
		            }
		        }
		        if(jj==1&&cc==1)
		            {
		                ans="IMPOSSIBLE";
		                break;
		            }
		            if(jj==0&&cc!=0)
		            {
		                for(int m=a[i][0];m<=a[i][1];m++)
		                {
		                    j[m]=1;
		                }
		                ans+="J";
		            }
		            if(jj!=0&&cc==0)
		            {
		               for(int m=a[i][0];m<=a[i][1];m++)
		                {
		                    c[m]=1;
		                } 
		                ans+="C";
		            }
		            if(jj==0&&cc==0)
		            {
		                for(int m=a[i][0];m<=a[i][1];m++)
		                {
		                    j[m]=1;
		                }
		                ans+="J";
		            }
		        }
		        else
		        {
		            for(int m=a[i][0];m<a[i][1];m++)
		            {
		                if(j[m]==1&&j[m+1]==1&&c[m]==1&&c[m+1]==1)
		                {
		                    ans="IMPOSSIBLE";
		                    break;
		                }
		                if(j[m]==0||j[m+1]==0)
		                {
		                    ans+="J";
		                    j[m]=1;
		                    j[m+1]=1;
		                }
		                if(c[m]==0||c[m+1]==0)
		                {
		                    ans+="C";
		                    c[m]=1;
		                    c[m+1]=1;
		                }
		            }
		        }
		    }
		    ans=ans.trim();
		    System.out.println("Case #"+k+": "+ans);
		    }
	}
}
