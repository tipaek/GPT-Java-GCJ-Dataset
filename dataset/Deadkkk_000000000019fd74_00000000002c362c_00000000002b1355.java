import java.util.*;
import java.io.*;


public class Solution
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();
		int[][] matrix;
		int[] output =  new int[t];
		for (int i = 1; i <= t; ++i) {
			int n = in.nextInt();
			int m = in.nextInt();
			matrix = new int[n][m];
			for(int j = 1; j<=n; j++)
			{
				for(int k = 1; k<=m; k++)
				{
					matrix[j-1][k-1] = in.nextInt();
				}
			}
			output[i-1] = resolveRound(n,m,0, matrix);
		}

		for (int i = 1; i <= t; ++i) {
			System.out.println("Case #" + i + ": " + output[i-1]);
		}
	}

	private static int resolveRound(int n, int m, int sum, int[][] matrix) {
		int[][] newMatrix = new int[n][m];
		List<Integer> arr = new ArrayList<>();
		int x;
		boolean lastRound = true;
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<m;j++)
			{
				arr = new ArrayList<>();
				sum+=matrix[i][j];
				if(matrix[i][j]>0) {
					x = up(i, j, matrix);
					if (x > 0) {
						arr.add(x);
					}
					x = left(i, j, matrix);
					if (x > 0) {
						arr.add(x);
					}
					x = down(i, j, n, matrix);
					if (x > 0) {
						arr.add(x);
					}
					x = right(i, j, m, matrix);
					if (x > 0) {
						arr.add(x);
					}
					if (average(arr) > matrix[i][j]) {
						lastRound = false;
						newMatrix[i][j] = 0;
					}
					else {
						newMatrix[i][j] = matrix[i][j];
					}
				}
			}
		}
		if(lastRound)
		{
			return sum;
		}
		return resolveRound(n,m, sum, newMatrix);
	}

	public static float average(List<Integer> input) {
		float sum = 0f;
		int i =0;
		for (int number : input) {
			sum = sum + number;
			if(number > 0)
			{
				i++;
			}
		}
		return i==0? 0 :sum / i;
	}

	public static int up(int i, int j, int[][] matrix)
	{
		for(int k=i-1; k>=0;k--)
		{
			if(matrix[k][j]>0)
			{
				return matrix[k][j];
			}
		}
		return 0;
	}
	public static int down(int i, int j, int n, int[][] matrix)
	{
		for(int k=i+1; k<n;k++)
		{
			if(matrix[k][j]>0)
			{
				return matrix[k][j];
			}
		}
		return 0;
	}
	public static int left(int i, int j, int[][] matrix)
	{
		for(int k=j-1; k>=0;k--)
		{
			if(matrix[i][k]>0)
			{
				return matrix[i][k];
			}
		}
		return 0;
	}
	public static int right(int i, int j,int m, int[][] matrix)
	{
		for(int k=j+1; k<m; k++)
		{
			if(matrix[i][k]>0)
			{
				return matrix[i][k];
			}
		}
		return 0;
	}
}


