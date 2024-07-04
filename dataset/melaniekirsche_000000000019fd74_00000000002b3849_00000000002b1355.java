import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
public class Solution {
public static void main(String[] args)
{
	Scanner input = new Scanner(System.in);
	int T = input.nextInt();
	for(int t = 1; t<=T; t++)
	{
		int n = input.nextInt(), m = input.nextInt();
		int[][] a = new int[n][m];
		for(int i =0; i<n; i++)
			for(int j = 0; j<m; j++)
			{
				a[i][j] = input.nextInt();
			}
		boolean[][] there = new boolean[n][m];
		for(boolean[] A : there) Arrays.fill(A, true);
		int[] di = new int[] {1, 0, -1, 0};
		int[] dj = new int[] {0, 1, 0, -1};
		long res = 0;
		while(true)
		{
			int removed = 0;
			boolean[][] toRemove = new boolean[n][m];
			for(int i = 0; i<n; i++)
				for(int j = 0; j<m; j++)
				{
					if(!there[i][j]) continue;
					res += a[i][j];
					ArrayList<Integer> neighbors = new ArrayList<Integer>();
					for(int d = 0; d<4; d++)
					{
						int ni = i, nj = j;
						while(true)
						{
							ni += di[d];
							nj += dj[d];
							if(ni >= 0 && ni < n && nj >= 0 && nj < m)
							{
								if(there[ni][nj])
								{
									neighbors.add(a[ni][nj]);
									break;
								}
							}
							else
							{
								break;
							}
						}
					}
					if(neighbors.size() > 0)
					{
						int sum = 0;
						for(int x : neighbors) sum += x;
						if(sum > neighbors.size() * a[i][j])
						{
							removed++;
							toRemove[i][j] = true;
						}
					}
				}
			if(removed == 0 ) break;
			else
			{
				for(int i = 0; i<n; i++)
					for(int j = 0; j<m; j++)
					{
						if(toRemove[i][j]) there[i][j] = false;
					}
			}
		}
		System.out.println("Case #" + t + ": " + res);
	}
}
}
