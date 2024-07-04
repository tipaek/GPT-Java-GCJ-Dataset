import java.util.*; 
// 3
// 4
// 1 2 3 4
// 2 1 4 3
// 3 4 1 2
// 4 3 2 1
public class Solution
{
	public static void main(String[] args)
	{
		Scanner scanny = new Scanner(System.in); 
		int numCases = scanny.nextInt();

	for (int x = 0; x < numCases; x++)
	{
		int n = scanny.nextInt(); 
		int[][] board = new int[n][n];
		boolean valid = true; 
		int r = 0;
		int c = 0;
		int k = 0;

		// Store the matrix into board array 
		for (int i = 0; i < n; i++)
		{
			for (int j = 0; j < n; j++)
			{
				board[i][j] = scanny.nextInt();
			}

			
		}
		// Check for repeated elements in each row
		for (int i = 0; i < n; i++)
		{
			HashSet<Integer> rowVals = new HashSet<Integer>(); 
			boolean flag = false;
			k += board[i][i];
			for (int j = 0; j < n; j++)
			{
				if(!rowVals.contains(board[i][j]))
				{
					rowVals.add(board[i][j]);
				}

				else
				{
					flag = true;
				}
			}

			if(flag)
			{
				r++;
			}
		}

		// Check for repeated elements in each column
		for (int i = 0; i < n; i++)
		{
			HashSet<Integer> colVals = new HashSet<Integer>();
			boolean flag = false; 
			for (int j = 0; j < n; j++)
			{
				if(!colVals.contains(board[j][i]))
				{
					colVals.add(board[j][i]);
				}

				else
				{
					flag = true;
				}
			}

			if(flag)
			{
				c++;
			}
		}



		//System.out.println(Arrays.deepToString(board));
		System.out.printf("Case #%d: %d %d %d\n", (x + 1), k, r, c);

	}
		
	}
} 