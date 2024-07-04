import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
	
	public static void main(String[] args) throws Exception
	{
		new Solution().run();
	}
	
	public void run() throws Exception
	{
		BufferedReader file = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(file.readLine());
		for(int z = 0;z<T;z++)
		{
			char[] chars = file.readLine().toCharArray();
			StringBuilder ans = new StringBuilder("");
			for(int i = 0;i<chars[0]-'0';i++)
				ans.append("(");
			ans.append(chars[0]);
			for(int i = 0;i<chars.length-1;i++)
			{
				int diff = chars[i] - chars[i+1];
				if(diff < 0)
				{
					for(int j = 0;j<-diff;j++)
					{
						ans.append("(");
					}
				}else {
					for(int j = 0;j<diff;j++)
					{
						ans.append(")");
					}
				}
				ans.append(chars[i+1]);
			}
			for(int i = 0;i<chars[chars.length - 1]-'0';i++)
			{
				ans.append(")");
			}
			System.out.printf("Case #%d: %s%n", z+1, ans.toString());
		}
	}
	
}
