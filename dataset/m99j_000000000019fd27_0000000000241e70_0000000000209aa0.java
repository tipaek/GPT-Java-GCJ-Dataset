import java.util.*;
import java.io.*;
public class Solution {
	
	public static boolean solve(int arr[][], int n, int k, int tc)
	{
		if (k<n || k>n*n)
			return false;
		ArrayList<HashSet<Integer>> rows=new ArrayList<>();
		ArrayList<HashSet<Integer>> cols=new ArrayList<>();
		for (int i=0;i<n;i++)
		{
			HashSet<Integer> set=new HashSet<>();
			rows.add(set);
			HashSet<Integer> set2=new HashSet<>();
			cols.add(set2);
		}
		arr[0][0]=k-((n-1)*(k/n));
		rows.get(0).add(arr[0][0]);
		rows.get(0).add(arr[0][0]);
		for (int i=1;i<n;i++)
		{
			arr[i][i]=k/n;
			rows.get(i).add(k/n);
			cols.get(i).add(k/n);
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
					{
						//System.out.println(i+" "+j);
						return false;
					}
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
		int tc=1;
		while (t>0)
		{
			String inp[]=br.readLine().split(" ");
			int n=Integer.parseInt(inp[0]);
			int k=Integer.parseInt(inp[1]);
			int arr[][]=new int[n][n];
			if (!solve(arr, n, k, tc))
				System.out.println("Case #"+tc+": IMPOSSIBLE");		
			tc++;
			t--;
		}
	}
}
