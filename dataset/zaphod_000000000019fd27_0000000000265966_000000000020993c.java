import java.io.*;
import java.util.StringTokenizer;

public class Solution
{
	public static int N;
	public static int[][] M;
	
	public static boolean isDupInRow(int row)
	{
		boolean [] used = new boolean[N+1];
		for (int col = 0; col < N; col++)
			if (used[M[row][col]])
				return true;
			else
				used[M[row][col]] = true;
		return false;
	}
	
	public static boolean isDupInCol(int col)
	{
		boolean [] used = new boolean[N+1];
		for (int row = 0; row < N; row++)
			if (used[M[row][col]])
				return true;
			else
				used[M[row][col]] = true;
		return false;
	}


	public static void main(String[] args) throws IOException
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int noOfCases = Integer.parseInt(in.readLine());

		for (int caseNo = 1; caseNo <= noOfCases; caseNo++)
		{
			N = Integer.parseInt(in.readLine());
			M = new int[N][N];

			int trace = 0;
			for (int row = 0; row < N; row++)
			{
				StringTokenizer data = new StringTokenizer(in.readLine());
				for (int col = 0; col < N; col++)
				{
					int next = Integer.parseInt(data.nextToken());
					M[row][col] = next;
					if (row == col)
						trace += next;
				}
			}
			
            int rowsWithDups = 0;
            for (int row = 0; row < N; row++)
            	if (isDupInRow(row))
            		rowsWithDups++;
            
            int colsWithDups = 0;
            for (int col = 0; col < N; col++)
            	if (isDupInCol(col))
            		colsWithDups++;

			System.out.printf("Case #%d: %d %d %d%n", caseNo, trace, rowsWithDups, colsWithDups);
		}
		in.close();

	}
}
