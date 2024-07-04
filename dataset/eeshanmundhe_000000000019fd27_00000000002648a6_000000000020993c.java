import java.io.*;
import java.util.*;
public class Solution
{
	public static void main(String[] args)throws IOException 
	{
		InputStreamReader read = new InputStreamReader(System.in);
		BufferedReader in = new BufferedReader(read);
		int t1=Integer.parseInt(in.readLine());
		for(int i=1;i<=t1;i++)
		{
		    int n=Integer.parseInt(in.readLine());
		    int arr[][]=new int[n][n];
		    for(int j=0;j<n;j++)
		    {
		        String s[]=in.readLine().split(" ");
		        for(int k=0;k<n;k++)
		        {
		            arr[j][k]=Integer.parseInt(s[k]);
		        }
		    }
		    int r=0,c=0,t=0;
		    for(int j=0;j<n;j++)
		    {
		        t+=arr[j][j];
		    }
		    for(int j=0;j<n;j++)
		    {
		        ArrayList<Integer> a = new ArrayList<>();
		        for(int k=0;k<n;k++)
		        {
		            if(a.contains(arr[j][k]))
		            {
		                r++;
		                break;
		            }
		            else
		            {
		                a.add(arr[j][k]);
		            }
		        }
		    }
		    for(int j=0;j<n;j++)
		    {
		        ArrayList<Integer> a = new ArrayList<>();
		        for(int k=0;k<n;k++)
		        {
		            if(a.contains(arr[k][j]))
		            {
		                c++;
		                break;
		            }
		            else
		            {
		                a.add(arr[k][j]);
		            }
		        }
		    }
		    System.out.println("Case #"+i+": "+t+" "+r+" "+c);
		}
	}
}
