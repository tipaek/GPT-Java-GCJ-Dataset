import java.util.*;
import java.io.*;

public class Solution
{
	private static Scanner infile;
	private static int numTestCases, n, numWrongRows, numWrongColumns, trace;
	private static int[][] square;
	
	public static void main(String[] args)
	{
		infile = new Scanner(System.in);
		numTestCases = infile.nextInt();
		for(int c = 1; c <= numTestCases; c++)
		{
			n = infile.nextInt();
			square = new int[n][n];
			for(int i = 0; i < n; i++)
				for(int j = 0; j < n; j++)
					square[i][j] = infile.nextInt();
			
			trace = 0;
			for(int i = 0; i < n; i++)
				trace += square[i][i];
			
			numWrongRows = 0;
			numWrongColumns = 0;
			for(int i = 0; i < n; i++)
			{
				if(!rowCheck(i))
					numWrongRows++;
				if(!columnCheck(i))
					numWrongColumns++;
			}
			
			System.out.println("Case #" + c + ": " + trace + " " + numWrongRows + " " + numWrongColumns);
		}
	}
	
	private static boolean rowCheck(int row)
	{
		boolean[] check = new boolean[n + 1];
		for(int i = 0; i < n; i++)
		{
			if(check[square[row][i]])
				return false;
			check[square[row][i]] = true;
		}
		return true;
	}
	
	private static boolean columnCheck(int col)
	{
		boolean[] check = new boolean[n + 1];
		for(int i = 0; i < n; i++)
		{
			if(check[square[i][col]])
				return false;
			check[square[i][col]] = true;
		}
		return true;
	}
}