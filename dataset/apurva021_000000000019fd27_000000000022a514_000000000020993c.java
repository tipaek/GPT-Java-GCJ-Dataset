import java.io.*;
import java.util.*;
import java.math.*;

class Solution
{
	public static void main(String []args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		PrintWriter w = new PrintWriter(System.out);
		int tc=Integer.parseInt(br.readLine());
		
		for(int t=1;t<=tc;t++)
		{
			int n=Integer.parseInt(br.readLine());
			int a[][]= new int[n][n];
			for(int i=0;i<n;++i)
			{
				String nums[]=br.readLine().split(" ");
				for(int j=0;j<n;++j) a[i][j]=Integer.parseInt(nums[j]);
			}
			
			long trace=0;
			for(int i=0;i<n;++i) trace+=a[i][i];
			
			int r=0,c=0;
			
			for(int i=0;i<n;++i)
			{
				HashSet<Integer> row = new HashSet<>();
				for(int j=0;j<n;++j)
				{
					row.add(a[i][j]);
				}
				if(row.size()<n) r++;
			}
			
			for(int i=0;i<n;++i)
			{
				HashSet<Integer> col = new HashSet<>();
				for(int j=0;j<n;++j)
				{
					col.add(a[j][i]);
				}
				if(col.size()<n) c++;
			}
			
			w.println("Case #"+t+": "+trace+" "+r+" "+c);
		}
		
		w.flush();
		w.close();
	}
}