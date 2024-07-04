import java.util.*;
public class Solution
{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		for(int k=1;k<=t;k++)
		{   int sum=0,c1=0,c2=0;
		    int n=sc.nextInt();
		    int arr[][]=new int[n][n];
		    for(int i=0;i<n;i++)
		    {
		        for(int j=0;j<n;j++)
		        {
		            arr[i][j]=sc.nextInt();
		        }
		    }
		    for(int i=0;i<n;i++)
		    {
		        for(int j=0;j<n;j++)
		        {
		          if(i==j)
		          {
		              sum=sum+arr[i][j];
		          }
		        }
		    }
		    for(int i=0;i<n;i++)
		    {   HashSet<Integer> hs=new HashSet<>();
		        for(int j=0;j<n;j++)
		        {
		           hs.add(arr[i][j]); 
		        }
		        if(hs.size()<n&&hs.size()>0)
		        {
		            c1++;
		        }
		    }
		     for(int i=0;i<n;i++)
		    {   HashSet<Integer> hs=new HashSet<>();
		        for(int j=0;j<n;j++)
		        {
		           hs.add(arr[j][i]); 
		        }
		        if(hs.size()<n&&hs.size()>0)
		        {
		            c2++;
		        }
		    }
		       System.out.println("Case #"+k+":"+" "+sum+" "+c1+" "+c2);
		    
		}
	}
}
