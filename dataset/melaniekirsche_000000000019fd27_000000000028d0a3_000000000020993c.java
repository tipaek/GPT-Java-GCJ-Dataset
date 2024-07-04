import java.util.*;
public class Solution {
public static void main(String[] args)
{
	Scanner input = new Scanner(System.in);
	int T = input.nextInt();
	for(int t = 1; t<=T; t++)
	{
		int n = input.nextInt();
		int[][] a = new int[n][n];
		for(int i = 0; i<n; i++)
			for(int j = 0; j<n; j++)
				a[i][j] = input.nextInt();
		int trace = 0;
		for(int i = 0; i<n; i++) trace += a[i][i];
		int badRows = 0, badCols = 0;
		for(int i = 0; i<n; i++)
		{
			boolean badR = false, badC = false;
			HashSet<Integer> curR = new HashSet<Integer>(), curC = new HashSet<Integer>();
			for(int j = 0; j<n; j++)
			{
				if(curR.contains(a[i][j])) badR = true;
				curR.add(a[i][j]);
				if(curC.contains(a[j][i])) badC = true;
				curC.add(a[j][i]);
			}
			if(badR) badRows++;
			if(badC) badCols++;
		}
		System.out.println("Case #" + t + ": " + trace + " " + badRows + " " + badCols);
	}
}
}
