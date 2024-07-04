import java.util.*;
import java.io.*;

class Solution{
	public static void main(String args[]) throws IOException
	{
		Scanner inputScanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = inputScanner.nextInt();
		for(int case_n = 0; case_n < t; case_n++)
		{
			int n = inputScanner.nextInt();
			String o = "";
			int[][] activities = new int[n][2];
			for(int i = 0; i < n; i++)
			{
				activities[i][0] = inputScanner.nextInt();
				activities[i][1] = inputScanner.nextInt();
			}
			Arrays.sort(activities, (a, b) -> a[0] - b[0]);
			int j = 0;
			int c = 0;
			for(int i = 0; i < n; i++)
			{
				
				if(activities[i][0] >= j)
				{
					o += "J";
					j = activities[i][1];
				}
				else if(activities[i][0] >= c)
				{
					o += "C";
					c = activities[i][1];
				}
				else
				{
					o = "IMPOSSIBLE";
					break;
				}
			}
			System.out.println("Case #" + (case_n + 1) + ": " + o);
		}
	}
}