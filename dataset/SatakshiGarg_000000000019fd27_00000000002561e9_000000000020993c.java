import java.io.*;
import java.util.*;
public class Solution
{
	public static void main(String[] args)throws IOException {
		InputStreamReader read=new InputStreamReader(System.in);
		BufferedReader in=new BufferedReader(read);
		int t=Integer.parseInt(in.readLine());
		for(int z=1;z<=t;z++)
		{
		    int n=Integer.parseInt(in.readLine());
		    int arr[][]=new int[n][n];
		    int i,j,k;
		    for(i=0;i<n;i++)
		    {
		        String str=in.readLine();
		        String line[]=str.trim().split(" ");
		        for(j=0;j<n;j++)
		        {
		            arr[i][j]=Integer.parseInt(line[j]);
		        }
		    }
		    int trace=0;
		    for(i=0;i<n;i++)
		    {
		        trace+=arr[i][i];
		    }
		    int r=0;
		    for(i=0;i<n;i++)
		    {
		        for(j=0;j<n;j++)
		        {
		            int flag=0;
		            int check=arr[i][j];
		            for(k=j+1;k<n;k++)
		            {
		                if(arr[i][k]==check)
		                {
		                    r++;
		                    flag=1;
		                    break;
		                }
		            }
		            if(flag==1)
		            break;
		        }
		    }
		    int c=0;
		    for(i=0;i<n;i++)
		    {
		        for(j=0;j<n;j++)
		        {
		            int flag=0;
		            int check=arr[j][i];
		            for(k=j+1;k<n;k++)
		            {
		                if(arr[k][i]==check)
		                {
		                    c++;
		                    flag=1;
		                    break;
		                }
		            }
		            if(flag==1)
		            break;
		        }
		    }
		    System.out.println("Case #"+z+": "+trace+" "+r+" "+c);
		}
	}
}
