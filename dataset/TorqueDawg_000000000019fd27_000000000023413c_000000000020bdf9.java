//Template for Solution submissions
import java.util.*;
import java.io.*;
public class Solution 
{
	public static void main (String [] args)
	{
		Scanner input = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = input.nextInt();
		for(int i = 1; i <= t; i++)
		{
			int n = input.nextInt();
			int[][] activities = new int[n][2];
			for(int j = 0; j < n; j++)
			{
				int[] timeVals = new int[2];
				for(int p = 0; p < timeVals.length; p++)
				{
					timeVals[p] = input.nextInt();
				}
				activities[j] = timeVals;
			}
			String y = "";
			String[] personResp = new String[n];
			//Determine whether y is impossible or not
			personResp[0] = "C";
			int aStart = activities[0][0];
			int aEnd = activities[0][1];
			int b = 1;
			while(b < activities.length && !(y.equals("IMPOSSIBLE")))
			{		
				HashSet<String> notResp = new HashSet<String>();
				int bStart = activities[b][0];
				int bEnd = activities[b][1];
				int c = b-1;
				while(c >= 0)
				{
					int cStart = activities[c][0];
					int cEnd = activities[c][1];
					if(cEnd > bStart && cStart < bEnd || bEnd > cStart && bStart < cEnd)
					{
						notResp.add(personResp[c]);
					}
					c--;
				}
				if(!(notResp.contains("C")))
				{
					personResp[b] = "C";
				}
				else if(!(notResp.contains("J")))
				{
					personResp[b] = "J";
				}
				else
				{
					y = "IMPOSSIBLE";
				}
				b++;
			}
			if(!(y.equals("IMPOSSIBLE")))
			{
				for(String str: personResp)
				{
					y += str;
				}
			}
			System.out.println("Case #" + i + ": " + y);
		}
	}
}
