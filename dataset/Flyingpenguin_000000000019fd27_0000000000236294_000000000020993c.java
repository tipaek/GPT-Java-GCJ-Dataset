import java.util.*;
import java.io.*;

public class Solution{
	public static void main(String args[]) throws IOException
	{
		Scanner inputScanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		String inputStream = inputScanner.nextLine();
		String[] inputData = inputStream.split(" ");
		int t = Integer.parseInt(inputData[0]);
		for(int case_n = 0; case_n < t; case_n++)
		{
			inputStream = inputScanner.nextLine();
			inputData = inputStream.split(" ");
			int n = Integer.parseInt(inputData[0]);
			int[][] m = new int[n][n];
			for(int i = 0; i < n; i++)
			{
				inputStream = inputScanner.nextLine();
				inputData = inputStream.split(" ");
				for(int j = 0; j < n; j++)
				{
					m[i][j] = Integer.parseInt(inputData[j]);
				}
			}
			int k = 0;
			int r = 0;
			int c = 0;
			for(int i = 0; i < n; i++)
			{
				k += m[i][i];
			}
			for(int i = 0; i < n; i++)
			{
				HashSet<Integer> set = new HashSet<Integer>();
				for(int j = 0; j < n; j++)
				{
					if(set.contains(m[i][j]))
					{
						r++;
						break;
					}
					set.add(m[i][j]);
				}
			}
			for(int j = 0; j < n; j++)
			{
				HashSet<Integer> set = new HashSet<Integer>();
				for(int i = 0; i < n; i++)
				{
					if(set.contains(m[i][j]))
					{
						c++;
						break;
					}
					set.add(m[i][j]);
				}
			}
			System.out.println("Case #" + (case_n + 1) + ": " + k + " " + r + " " + c);
		}
	}
}