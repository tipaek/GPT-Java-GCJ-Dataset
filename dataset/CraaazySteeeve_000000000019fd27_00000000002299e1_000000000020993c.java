import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) 
	{
		Scanner keyboard = new Scanner(System.in);
		int tCount = keyboard.nextInt();
		for(int t = 0; t < tCount; t++)
		{
			int n = keyboard.nextInt();
			int[][] matrix = new int[n][];
			for(int i = 0; i < n; i++)
			{
				matrix[i] = new int[n];
				for(int j = 0; j < n; j++)
				{
					matrix[i][j] = keyboard.nextInt();
				}
			}
			
			//Calculate the main diagonal (trace value.
			int trace = 0;
			for(int i = 0; i < n; i++)
			{
				trace += matrix[i][i];
			}
			
			//Check rows.
			int rows = 0;
			for(int i = 0; i < n; i++)
			{
				if(containsDuplicates(matrix[i]))
				{
					rows++;
				}
			}
			
			//Check cols.
			int cols = 0;
			for(int i = 0; i < n; i++)
			{
				//Build vertical array.
				int[] colArray = new int[n];
				for(int j = 0; j < n; j++)
				{
					colArray[j] = matrix[j][i];
				}
				if(containsDuplicates(colArray))
				{
					cols++;
				}
			}
			
			//Print result of test case.
			System.out.println("Case #" + (t+1) + ": " + trace + " " + rows + " " + cols);
		}
	}
	
	private static boolean containsDuplicates(int[] values)
	{
		for(int i = 0; i < values.length; i++)
		{
			for(int j = i+1; j < values.length; j++)
			{
				if(values[i] == values[j])
				{
					return true;
				}
			}
		}
		return false;
	}
}