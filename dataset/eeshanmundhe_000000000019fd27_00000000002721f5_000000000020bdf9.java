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
		    Arrays.sort(a, (x, y) -> Double.compare(x[0], y[0]));
		    int z=0;
		    String ans="";
		    for(int i=0;i<n;i++)
		    {
		        int cc=0,jj=0;
		        for(int m=a[i][0];m<a[i][1];m++)
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
		                for(int m=a[i][0];m<a[i][1];m++)
		                {
		                    j[m]=1;
		                }
		                ans+="J";
		            }
		            if(jj!=0&&cc==0)
		            {
		               for(int m=a[i][0];m<a[i][1];m++)
		                {
		                    c[m]=1;
		                } 
		                ans+="C";
		            }
		            if(jj==0&&cc==0)
		            {
		                for(int m=a[i][0];m<a[i][1];m++)
		                {
		                    j[m]=1;
		                }
		                ans+="J";
		            }
		    }
		    
		    /*for(int i=0;i<n;i++)
		    {
		        for(int i1=0;i1<2;i1++)
		        {
		            System.out.print(a[i][i1]+" ");
		        }
		        System.out.println();
		    }*/
		    System.out.println("Case #"+k+": "+ans);
		}
	}
}
