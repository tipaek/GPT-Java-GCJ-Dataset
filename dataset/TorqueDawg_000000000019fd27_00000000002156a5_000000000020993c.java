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
			
			int[][] arr = new int[n][n];
			for(int j = 0; j < n; j++)
			{
				int[] mVals = new int[n];
				for(int p = 0; p < mVals.length; p++)
				{
					mVals[p] = input.nextInt();
				}
				arr[j] = mVals;
			}
			
			int k = 0;
			for(int d = 0; d < arr.length; d++)
			{
				k += arr[d][d];
			}
			
			int r = 0;
			for(int[] row: arr)
			{
				int c1 = 0;
				boolean anyRepeats = false;
				while(c1 < row.length-1 && !anyRepeats)
				{
					int c2 = c1+1;
					while(c2 < row.length && row[c1] != row[c2])
					{
						c2++;
					}
					if(c2 != row.length)
					{
						anyRepeats = true;
					}
					c1++;
				}
				if(anyRepeats)
				{
					r++;
				}
			}
			
			int c = 0;
			for(int col = 0; col < arr.length; col++)
			{
				int r1 = 0;
				boolean anyRepeats = false;
				while(r1 < arr.length && !anyRepeats)
				{
					int r2 = r1+1;
					while(r2 < arr.length && arr[r1][col] != arr[r2][col])
					{
						r2++;
					}
					if(r2 != arr.length)
					{
						anyRepeats = true;
					}
					r1++;
				}
				if(anyRepeats)
				{
					c++;
				}
			}
			System.out.println("Case #" + i + ": " + k + " " + r + " " + c);
		}
	}
}
