import java.util.*;
import java.io.*;

public class Solution {

	public static int n;
	public static int m;
	public static int k;
	public static int[] arr;
	public static int[] sum;
	public static HashSet<Integer> set;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine());
		int tc=1;
		while (t-->0)
		{
			String inp[]=br.readLine().split(" ");
			int x=Integer.parseInt(inp[0]);
			int y=Integer.parseInt(inp[1]);
			String path=inp[2].trim();
			int ans=-1;
			if (x==0 && y==0)
			{
				System.out.println("Case #" + tc+": 0");
				tc++;
				continue;
			}
			int time=0;
			for (int i=0;i<path.length();i++)
			{
				time++;
				char dir=path.charAt(i);
				if (dir=='S')
					y--;
				else if (dir=='N')
					y++;
				else if (dir=='E')
					x++;
				else
					x--;
				//System.out.println(x+" "+y);
				int movesreq=Math.abs(x)+Math.abs(y);
				if (time>=movesreq)
				{
					ans=time;
					break;
				}
			}
			if (ans==-1)
				System.out.println("Case #" + tc+": IMPOSSIBLE");
			else
				System.out.println("Case #" + tc+": "+ ans);
			tc++;
		}
	}
}