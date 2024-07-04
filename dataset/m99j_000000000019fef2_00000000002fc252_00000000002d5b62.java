import java.util.*;
import java.io.*;

public class Solution {

	public static int n;
	public static int tc;
	public static String ans;
	public static int x;
	public static int y;
	
	public static boolean solve(long currx, long curry, int i, String tempans)
	{
		if (currx==x && curry==y)
		{
			if (tempans.length()<ans.length())
				ans=tempans;
			else if (ans=="")
				ans=tempans;
			return true;
		}
		boolean ans=false;
		if (i>=10)
			return false;
		if (solve(currx+(long)Math.pow(2, i), curry, i+1, tempans+"E"))
			ans=ans| true;
		if (solve(currx-(long)Math.pow(2, i), curry, i+1, tempans+"W"))
			ans=ans | true;
		if (solve(currx,(long)Math.pow(2, i)+ curry, i+1, tempans+"N"))
			ans=ans |true;
		if (solve(currx, curry-(long)Math.pow(2, i), i+1, tempans+"S"))
			ans=ans | true;
		return ans;
	}
	
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine());
		tc=1;
		while (t>0)
		{
			String inp[]=br.readLine().split(" ");
			x=Integer.parseInt(inp[0]);
			y=Integer.parseInt(inp[1]);
			ans="";
			if (x%2!=0 && y%2!=0)
			{
				System.out.println("Case #"+tc+": "+"IMPOSSIBLE");
				t--;
				tc++;
				continue;
			}
			boolean temp=solve(0,0,0,"");
			if (temp)
				System.out.println("Case #"+tc+": "+ans);
			else
				System.out.println("Case #"+tc+": "+"IMPOSSIBLE");
			t--;
			tc++;
		}
	}
}
