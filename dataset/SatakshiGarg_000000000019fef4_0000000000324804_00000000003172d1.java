import java.io.*;
import java.util.*;
public class Solution
{
	public static void main(String[] args)throws IOException {
		InputStreamReader read=new InputStreamReader(System.in);
		BufferedReader in=new BufferedReader(read);
		long t=Long.parseLong(in.readLine());
		for(long z=1;z<=t;z++)
		{
		    String line[]=in.readLine().trim().split(" ");
		    int n=Integer.parseInt(line[0]);
		    int d=Integer.parseInt(line[1]);
		    long a[]=new long[n];
		    int i,j,k;
		    String li[]=in.readLine().trim().split(" ");
		    long ans=0;
		    for(i=0;i<n;i++)
		    {
		        a[i]=Long.parseLong(li[i]);
		    }
		    Arrays.sort(a);
		    long countMax=0,maxEle=0;
		    for(i=0;i<(n-1);i++)
		    {
		        long count=0;
		        for(j=(i+1);j<n;j++)
		        {
		            if(a[i]==a[j])
		            count++;
		        }
		        if(count>countMax)
		        {
		            countMax=count;
		            maxEle=a[i];
		        }
		    }
		    if((countMax+1)>=d)
		    {
		        ans=0;
		    }
		    else
		    {
		        ans=countMax;
		        long diff=d-countMax;
		        i=n-1;
		        while(i>0 && diff!=0)
		        {
		            if(a[i-1]!=maxEle)
		            {
		                if((a[i]/d)<=d)
		                {
		                diff-=a[i-1]/d;
		                countMax+=a[i-1]/d;
		                }
		                else
		                {
		                    diff=0;
		                    countMax+=diff;
		                }
		            }
		            i--;
		        }
		        if(n==1)
		        {
		            ans=d-1;
		        }
		        else
		        ans+=countMax;
		    }
		    
		  
		     System.out.println("Case #"+z+": "+ans);
		     
		}
	}
}
