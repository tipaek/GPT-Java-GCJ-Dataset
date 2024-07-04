import java.util.*;
import java.io.*;
public class Solution {
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine());
		int tc=1;
		while (t>0)
		{
			int n= Integer.parseInt(br.readLine().trim());
			int arr[][]=new int[n][n];
			for (int i=0;i<n;i++) {
				String inp[]=br.readLine().split(" ");
				for (int j=0;j<n;j++)
					arr[i][j]=Integer.parseInt(inp[j]);
			}
			int trace=0;
			int repeatedrows=0;
			int repeatedcols=0;
			for (int i=0;i<n;i++)
			{
				HashSet<Integer> set=new HashSet<>();
				for (int j=0;j<n;j++)
				{
					set.add(arr[i][j]);
				}
				if (set.size()<n)
					repeatedrows++;
			}
			for (int i=0;i<n;i++)
			{
				HashSet<Integer> set=new HashSet<>();
				for (int j=0;j<n;j++)
				{
					set.add(arr[j][i]);
				}
				if (set.size()<n)
					repeatedcols++;
			}
			for (int i=0;i<n;i++)
				trace+=arr[i][i];
			System.out.println("Case #"+tc+": "+trace+" "+repeatedrows+" "+repeatedcols);
			tc++;
			t--;
		}
	}

}
