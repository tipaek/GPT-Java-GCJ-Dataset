import java.util.*;
import java.lang.*;
import java.io.*;

public class Solution
{
	public static void main (String[] args)
	{
		Scanner input = new Scanner(System.in);
		
		Boolean first;
		Integer numTestCases = Integer.valueOf(input.nextLine());
		Integer matrixSize = 0;
		int[][] arr_2D;
		
		for(int i=1; i<=numTestCases; i++)
		{
			matrixSize = Integer.valueOf(input.nextLine());
			arr_2D = new int[matrixSize][matrixSize];
			Integer trace=0, rowRepeat = 0, colRepeat = 0;
			HashSet<Integer> r = new HashSet<Integer>(); 
			HashSet<Integer> c = new HashSet<Integer>();
			
			for(int j=0; j<matrixSize; j++)
			{
				String var = input.nextLine();
				String[] splitStr = var.split(" ");
			
				for(int k=0; k<matrixSize; k++)
				{
					arr_2D[j][k] = Integer.valueOf(splitStr[k]);
				}
			}
			
			for(int row=0; row<matrixSize; row++)
			{
				for(int col=0; col<matrixSize; col++)
				{
					if(row == col)
						trace = trace + arr_2D[row][col];
				}
			}
			
			for(int row=0; row<matrixSize; row++)
			{
				for(int col=0; col<matrixSize; col++)
				{
					if(r.contains(arr_2D[row][col]))
					{
						rowRepeat++;
						break;
					}
					else
						r.add(arr_2D[row][col]);
				}
				r = new HashSet<Integer>(); 
			}
			
			for(int row=0; row<matrixSize; row++)
			{
				for(int col=0; col<matrixSize; col++)
				{
					if(c.contains(arr_2D[col][row]))
					{
						colRepeat++;
						break;
					}
					else
						c.add(arr_2D[col][row]);
				}
				c = new HashSet<Integer>();
			}

			System.out.println("Case #" + i + ": " + trace + " " + rowRepeat + " " + colRepeat);
		}
	}
}