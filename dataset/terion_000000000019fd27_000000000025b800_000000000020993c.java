import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int i=0;i<t;i++)
		{
			int n = sc.nextInt();
			int[][] matrix = new int[n][n];
			for(int j=0;j<n;j++)
			{
				for(int k=0;k<n;k++)
				{
					matrix[j][k] = sc.nextInt();
				}
			}
			
			System.out.println("Case #"+(i+1)+": "+solve(n, matrix));
		}
		
	}

	public static String solve(int n, int[][] matrix)
	{
		int k = 0;
		for(int i=0;i<n;i++)
		{
			k += matrix[i][i];
		}

		boolean[] arr = new boolean[n+1];
		
		int r = 0;

		for(int i=0;i<n;i++)
		{
			Arrays.fill(arr, false);
			for(int j=0;j<n;j++)
			{
				int x = matrix[i][j];
				if(!arr[x])
				{
					arr[x]=true;
				}
				else
				{
					r++;
					break;
				}
			}
		}
		
		int c = 0;
		
		for(int i=0;i<n;i++)
		{
			Arrays.fill(arr, false);
			for(int j=0;j<n;j++)
			{
				int x = matrix[j][i];
				if(!arr[x])
				{
					arr[x]=true;
				}
				else
				{
					c++;
					break;
				}
			}
		}
		
		return k+" "+r+" "+c;
	}
}
