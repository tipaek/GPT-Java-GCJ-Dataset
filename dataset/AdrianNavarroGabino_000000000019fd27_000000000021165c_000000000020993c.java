import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		int cases = sc.nextInt();
		int size, trace, repRows, repCols;
		int[][] matrix;
		
		boolean repeatedRow, repeatedCol;
		
		
		for(int index = 1; index <= cases; index++)
		{
			trace = 0;
			repRows = 0;
			repCols = 0;
			
			size = sc.nextInt();
			matrix = new int[size][];
			
			for(int i = 0; i < size; i++)
			{
				matrix[i] = new int[size];
				
				for(int j = 0; j < size; j++)
				{
					matrix[i][j] = sc.nextInt();
				}
			}
			
			for(int i = 0; i < size; i++)
			{
				trace += matrix[i][i];
				
				repeatedRow = false;
				repeatedCol = false;
				
				for(int j = 0; j < size - 1; j++)
				{
					if(!repeatedRow)
						for(int k = j + 1; k < size; k++)
						{
							if(matrix[i][j] == matrix[i][k])
							{
								repRows++;
								repeatedRow = true;
								break;
							}
						}
					
					if(!repeatedCol)
						for(int k = j + 1; k < size; k++)
						{
							if(matrix[j][i] == matrix[k][i])
							{
								repCols++;
								repeatedCol = true;
								break;
							}
						}
				}
			}
			
			System.out.println("Case #" + index + ": " + trace + " " + repRows + " " + repCols);
		}
	}
}
