import java.util.Scanner;
public class Solution
{
	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
		int numCase = input.nextInt();
		int caseNum = 1;
		while(numCase >= caseNum)
		{
			int matrixSize = input.nextInt();
			int trace = 0;
			int numRepeatRows = 0;
			int numRepeatColumns = 0;
			int count = 0;
			int[][] matrix = new int[matrixSize][matrixSize];
			for(int i = 0; i < matrixSize; i++)
			{
				for(int j = 0; j < matrixSize; j++)
				{
					matrix[i][j] = input.nextInt();
					if(i == j)
					{
						trace += matrix[i][j];
					}
				}
			}
			for(int k = 0; k < matrix.length; k++)
			{
				int temp = matrix[k][count];
				for(int z = count + 1; z < matrixSize; z++)
				{
					if(temp == matrix[k][z])
					{
						numRepeatRows++;
						count = matrix.length - 2;
						z = matrixSize;
					}
				}
				count++;
				if(count != (matrix.length - 1))
				{
					k--;
				}
				else
				{
					count = 0;
				}
			}
			for(int l = 0; l < matrix.length; l++)
			{
				int temp = matrix[count][l];
				for(int z = count + 1; z < matrixSize; z++)
				{
					if(temp == matrix[z][l])
					{
						numRepeatColumns++;
						count = matrix.length - 2;
						z = matrixSize;
					}
				}
				count++;
				if(count != (matrix.length - 1))
				{
					l--;
				}
				else
				{
					count = 0;
				}
			}
			System.out.println("\nCase #" + caseNum + ": " + trace + " " + numRepeatRows + " " + numRepeatColumns);
			caseNum++;
		}
	}
}