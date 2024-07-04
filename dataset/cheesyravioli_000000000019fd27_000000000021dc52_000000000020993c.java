import java.util.*;
import java.io.*;
import java.math.*;

public class Solution {
	public static void main(String[] args) throws IOException {
		long startTime = System.nanoTime();
		BufferedReader fin = new BufferedReader((new InputStreamReader(System.in)));
		//BufferedReader fin = new BufferedReader((new FileReader("vest.in")));
		int numtestcases = Integer.parseInt(fin.readLine());
		for (int i = 0; i < numtestcases; i++)
		{
			int n = Integer.parseInt(fin.readLine());
			int[][] matrix = new int[n][n];
			int sum = 0;
			int r = 0;
			int c = 0;
			for (int j = 0; j < n; j++)
			{
				StringTokenizer row = new StringTokenizer(fin.readLine());
				boolean[] taken = new boolean[n];
				boolean repeat = false;
				for (int k = 0; k < n; k++)
				{
					matrix[j][k] = Integer.parseInt(row.nextToken());
					if (j == k)
						sum += matrix[j][k];
					if (taken[matrix[j][k]-1])
						repeat = true;
					else
						taken[matrix[j][k]-1] = true;
				}
				if (repeat)
					r++;
			}
			for (int j = 0; j < n; j++)
			{
				boolean[] taken = new boolean[n];
				boolean repeat = false;
				for (int k = 0; k < n; k++)
				{
					if (taken[matrix[k][j]-1])
					{
						repeat = true;
						break;
					}
					else
						taken[matrix[k][j] - 1] = true;
				}
				if (repeat)
					c++;
			}
			System.out.println("Case #" + (i+1) + ": " + sum + " " + r + " " + c);
		}
		
		long endTime   = System.nanoTime();
		long totalTime = endTime - startTime;
		//System.out.println(totalTime/1000000000.0);	  
	}
	
}
