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
			int n=Integer.parseInt(br.readLine().trim());
			int act[][]=new int[n][3];
			for (int i=0;i<n;i++)
			{
				String inp[]=br.readLine().split(" ");
				act[i][0]=i;
				act[i][1]=Integer.parseInt(inp[0]);
				act[i][2]=Integer.parseInt(inp[1]);
			}
			Arrays.sort(act, new Comparator<int[]>() { 
				//@Override
				public int compare(int a[], int b[])
				{
					if (a[1]>b[1])
						return 1;
					else if (a[1]==b[1])
					{
						if (a[2]>b[2])
							return 1;
					}
					return -1;
				}
			});
			int jstart=0;
			int jend=0;
			int cstart=0;
			int cend=0;
			boolean notpossible=false;
			StringBuilder sb=new StringBuilder();
			char ans[]=new char[n];
			for (int i=0;i<n;i++)
			{
				int start=act[i][1];
				int end=act[i][2];
				if (jend<=start)
				{
					//sb.append("J");
					ans[act[i][0]]='J';
					jstart=start;
					jend=end;
					continue;
				}
				else if (cend<=start)
				{
					//sb.append("C");
					ans[act[i][0]]='C';
					cstart=start;
					cend=end;
					continue;
				}
				else
				{
					//System.out.println(cend+" "+jend);
					notpossible=true;
					break;
				}
			}
			if (notpossible)
				System.out.println("Case #"+tc+": IMPOSSIBLE");
			else
			{
				for (int i=0;i<n;i++)
					sb.append(ans[i]);
				System.out.println("Case #"+tc+": "+sb.toString());
			}		
			tc++;
			t--;
		}
	}
}
