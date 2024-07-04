import java.io.BufferedReader; 
import java.io.InputStreamReader;

public class Solution {


	public static String vestigium(int[][] nums) 
	{
//		System.out.println("----------");
		int numCol = nums[0].length;
//		for(int i = 0; i < numCol; i++)
//		{
//			String rowActual = "";
//			for(int j = 0; j < numCol; j++)
//			{
//				rowActual = rowActual + " " + nums[i][j];
//			}
//			System.out.println(rowActual);
//		}
//		System.out.println("----------");

		//Trace
		int trace = 0;
		for(int i = 0; i < numCol; i++)
		{
			trace += nums[i][i];
		}

		//Rows with repeated elements
		int rRows = 0;
		for(int i = 0; i < numCol; i++)
		{
			int [] rowActual = nums[i];
			int duplicated = 0;
			for(int j = 0; j < rowActual.length; j++)
			{
				for(int k = j+1; k < rowActual.length; k++)
				{
					if(rowActual[j] == rowActual[k])
						duplicated++;
				}
			}
			if(duplicated>0)
			{
				rRows++;
			}
		}

		//Columns with repeated elements
		int rCols = 0;
		for(int i = 0; i < numCol; i++)
		{
			int duplicated = 0;
			for(int j = 0; j < numCol; j++)
			{
				for(int k = j+1; k < numCol; k++)
				{
					if(nums[j][i] == nums[k][i])
						duplicated++;
				}
			}
			if(duplicated>0)
			{
				rCols++;
			}
		}

		return trace + " " + rRows + " " + rCols;
	}

	public static void main(String[] args) 
	{
		try
		{
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);
			String line = br.readLine();
			int numTests = Integer.parseInt(line);

			for(int i = 0; i < numTests; i++)
			{
				String line2 = br.readLine();
				int numRows = Integer.parseInt(line2);
				int[][] actual = new int [numRows][numRows];
				for(int j = 0; j < numRows; j++)
				{
					String line3 = br.readLine();
					String[] linea3 = line3.split(" ");

					for(int k = 0; k < numRows; k++)
					{
						actual[j][k] = Integer.parseInt(linea3[k]);
					}
				}
				String res = vestigium(actual);
				System.out.println("Case #" + (i+1) + ": " + res);
			}
		}
		catch( Exception e )
		{

		}
	}
}
