import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		
		int t = scanner.nextInt();
		
		for(int i = 0; i<t;i ++)
		{
			int n = scanner.nextInt();
			int matrix[][] = new int[n][n];
			int trace = 0;
			for(int row = 0; row< n; row++)
			{
				for(int col = 0 ; col <n ; col++)
				{
					matrix[row][col] = scanner.nextInt();
					if(row == col)
						trace+= matrix[row][col];
				}
			}
			
			int repeatedCols = 0;
			
			for(int row = 0; row<n;row++)
			{
				for(int col = 0; col < n-1; col++)
				{
					int nextCol = col+1;
					for( ; nextCol<n; nextCol++)
					{
						if(matrix[row][col] == matrix[row][nextCol])
						{
							repeatedCols++;
							break;
						}
					}
					if(nextCol != n)
						break;
				}
			}
			
			int repeatedRows = 0;
			for(int col = 0; col<n;col++)
			{
				for(int row = 0; row < n-1; row++)
				{
					int nextRow = row+1;
					for( ; nextRow<n; nextRow++)
					{
						if(matrix[row][col] == matrix[nextRow][col])
						{
							repeatedRows++;
							break;
						}
					}	
					if(nextRow != n)
						break;
				}
			}
			
			System.out.println("Case #"+(i+1)+": "+trace+" "+repeatedCols+" "+repeatedRows);
		}
		scanner.close();
	}
}