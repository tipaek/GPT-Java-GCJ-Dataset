import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner s = new Scanner (System.in);
		int t = s.nextInt();
		int z = 1;
		while (z<=t)
		{
			int n = s.nextInt();
			int[][] mat = new int[n][n];
			for (int i=0;i<n;i++)
			{
				for (int j=0;j<n;j++)
				{
					mat[i][j] = s.nextInt();
				}
			}
			boolean[] map = new boolean[n+1];
			int r = 0;
			for (int i=0;i<n;i++)
			{
				for (int j=0;j<n;j++)
				{
					if(map[mat[i][j]])
					{
					r++;
					break;
					}
					map[mat[i][j]] = true;
				}
				Arrays.fill(map, false);
			}
			Arrays.fill(map, false);
			int c = 0;
			for (int i=0;i<n;i++)
			{
				for (int j=0;j<n;j++)
				{
					if(map[mat[j][i]])
					{
					c++;
					break;
					}
					map[mat[j][i]] = true;
				}
				Arrays.fill(map, false);
			}
			int sum = 0;
			for (int i=0;i<n;i++)
			{
				sum = sum+mat[i][i];
			}
			System.out.println("Case #"+z+": "+sum+" "+r+" "+c);
			z++;
		}

	}

}
