import java.util.*;
import java.io.*;
public class Solution {
	
	public static int tc;
	
	public static boolean solve(int arr[][], int n, int k, int row, int total)
	{
		if (row==n && total==k)
		{
			//System.out.println("hello");
			boolean secondpart=solve(arr, n, k);
			if (secondpart)
				return true;
		}
		if (row==n || total==k)
		{
			return false;
		}
		int sumleft=k-total;
		int min=Math.max(1, sumleft-n*(n-row-1));
		int max=Math.min(n,  sumleft-(n-row-1));
		//if (min>n || max<1)
		//return false;
		//System.out.println(min+" "+max);
		boolean ans=false;
		for (int i=min;i<=max;i++)
		{
			arr[row][row]=i;
			ans=ans || solve(arr, n, k, row+1, total+i);
			if (ans==true)
				return true;
		}
		return false;
	}
	
	public static boolean solve(int arr[][], int n, int k)
	{
		ArrayList<HashSet<Integer>> rows=new ArrayList<>();
		ArrayList<HashSet<Integer>> cols=new ArrayList<>();
		for (int i=0;i<n;i++)
		{
			HashSet<Integer> set=new HashSet<>();
			rows.add(set);
			HashSet<Integer> set2=new HashSet<>();
			cols.add(set2);
		}
		//arr[0][0]=k-((n-1)*(k/n));
		//rows.get(0).add(arr[0][0]);
		//rows.get(0).add(arr[0][0]);
		for (int i=0;i<n;i++)
		{
			//arr[i][i]=k/n;
			rows.get(i).add(arr[i][i]);
			cols.get(i).add(arr[i][i]);
		}
		int start=1;
		for (int i=0;i<n;i++)
		{
			for (int j=0;j<n;j++)
			{
				if (i==j)
					continue;
				int currvalofstart=start;
				while (cols.get(j).contains(start) || rows.get(i).contains(start))
				{
					start++;
					if (start==n+1)
						start=1;
					if (start==currvalofstart)
						return false;
				}
				arr[i][j]=start;
				rows.get(i).add(arr[i][j]);
				cols.get(j).add(arr[i][j]);
			}
		}
		System.out.println("Case #"+tc+": POSSIBLE");	
		for (int i=0;i<n;i++)
		{
			for (int j=0;j<n;j++)
				System.out.print(arr[i][j]+" ");
			System.out.println();
		}
		return true; 
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine());
		tc=1;
		while (t>0)
		{
			String inp[]=br.readLine().split(" ");
			int n=Integer.parseInt(inp[0]);
			int k=Integer.parseInt(inp[1]);
			int arr[][]=new int[n][n];
			if (!solve(arr, n, k, 0, 0))
				System.out.println("Case #"+tc+": IMPOSSIBLE");		
			tc++;
			t--;
		}
	}
}
