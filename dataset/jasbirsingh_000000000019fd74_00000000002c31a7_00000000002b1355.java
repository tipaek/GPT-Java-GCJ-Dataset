
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.TreeSet;

public class Solution {

	public static void main (String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 Integer numOfTestCases = Integer.parseInt(br.readLine().trim());
		 
		 for(int i =1; i <= numOfTestCases;i++)
		 {
			 String[] in = br.readLine().split(" ");
			 
			 int row = Integer.parseInt(in[0]);
			 int column = Integer.parseInt(in[1]);
			 
			 int input[][] = new int[row][column];
			 
			 for(int j =0; j < row;j++)
			 {
				 String temp[] = br.readLine().split(" ");
				 for(int k =0; k < column;k++)
				 {
					 input[j][k] = Integer.parseInt(temp[k]);
				 }
			 }
			 
			 if(column == 1 && row == 1)
			 {
				 System.out.println("Case #" + i + ": " + input[0][0]);
				 continue;
			 }
			 
			 int sum = 0;
			 if(row == 1)
			 {
				 for(int j =0; j < column;j++)
				 {
					 sum += input[0][j];
				 }
				 
				 //first remove from the center
				 
				 
				 Boolean removedOne = false;
				 
				 int tempArray[] = new int[column];
				 for(int j =0; j < column;j++)
				 {
					 tempArray[j] = input[0][j];
				 }
				Arrays.sort(tempArray);
				 
				for(int k =0; k < column;k++)
				{
					removedOne = false;
					for(int j = k; j < column - 1;j++)
					{
						if(tempArray[j] != tempArray[j+1])
						{
							removedOne = true;
							tempArray[j] = 0;
							break;
						}
					}
					if(removedOne)
					{
						for(int j = k; j < column;j++)
						{
							sum+= tempArray[j];
						}
					}else {
						if(k == column-1)
						{
							tempArray[column-1] = 0;
						}
					}
					
					
				
					
				}
				for(int j = 0; j < column;j++)
				{
					sum+= tempArray[j];
				}
				
				//System.out.println(sum);
				System.out.println("Case #" + i + ": " + sum);
				 
			 }else
			 {

				
				 for(int j = 0; j < row;j++)
				 {
					 for(int k = 0; k < column;k++)
					 {
						 sum += input[j][k];
					 }
				 }
				 
				 
				 for(int j = 0; j < row;j++)
				 {
					 for(int k = 0; k < column;k++)
					 {
						 if(j+1 < row && k-1>= 0 && k+1 < column && j-1 >= 0)
						 {
							 if(input[j][k] <= (input[j+1][k] + input[j][k-1] + input[j][k+1] + input[j-1][k])/4)
							 {
								input[j][k] =0; 
								// sum += calculateSum(input, row, column);
							 }
							 continue;
						 }
						
						 if(j+1 == row && k-1>= 0 && k+1 < column && j-1 >= 0)
						 {
							 if(input[j][k] <= (input[j][k-1] + input[j][k+1] + input[j-1][k])/3)
							 {
								input[j][k] =0; 
								//sum += calculateSum(input, row, column);
							 }
							 continue;
						 }
						 
						 if(j+1 < row && k-1 < 0 && k+1 < column && j-1 >= 0)
						 {
							 if(input[j][k] <= (input[j+1][k] + input[j][k+1] + input[j-1][k])/3)
							 {
								input[j][k] =0; 
								// sum += calculateSum(input, row, column);
							 }
							 continue;
						 }
						 
						 if(j+1 < row && k-1>= 0 && k+1 == column && j-1 >= 0)
						 {
							 if(input[j][k] <= (input[j+1][k] + input[j][k-1] + input[j-1][k])/3)
							 {
								input[j][k] =0; 
								// sum += calculateSum(input, row, column);
							 }
							 continue;
						 }
						 
						 if(j+1 < row && k-1>= 0 && k+1 < column && j-1 < 0)
						 {
							 if(input[j][k] <= (input[j+1][k] + input[j][k-1] + input[j][k+1])/3)
							 {
								input[j][k] =0; 
								// sum += calculateSum(input, row, column);
							 }
							 continue;
						 }
						 
					 }
				 }
				 
				 sum += calculateSum(input, row, column);
				 for(int j =0; j < row;j++)
				 {
					 for(int k =0; k < column;k++)
					 {
						 if(j == 0 && k == 0)
						 {
							 if(input[j][k] < (input[j+1][k] + input[j][k+1])/2)
							 {
								 input[j][k] = 0;
								 //sum += calculateSum(input, row, column);
							 }
							 continue;
						 }
						 if(j == 0 && k == column-1)
						 {
							 if(input[j][k] < (input[j][k-1] + input[j+1][k])/2)
							 {
								 input[j][k] = 0;
								// sum += calculateSum(input, row, column);
							 }
							 continue;
						 }
						 
						 if(j == row-1 && k == 0)
						 {
							 if(input[j][k] < (input[j][k+1] + input[j-1][k])/2)
							 {
								 input[j][k] = 0;
								// sum += calculateSum(input, row, column);
							 }
							 continue;
							 
						 }
						 if(j == row-1 && k == column -1)
						 {
							 if(input[j][k] < (input[j][k-1] + input[j-1][k])/2)
							 {
								 input[j][k] = 0;
								 //sum += calculateSum(input, row, column);
							 }
							 continue;
							 
						 }
					 }
				 }
				 
				 calculateSum(input, row, column);
				 
				 //System.out.println(sum);
				 System.out.println("Case #" + i + ": " + sum);
				 
				 
			 }
			 
		 }
	}
	
	public static int calculateSum(int[][] input, int row, int column)
	{
		int sum = 0;
		for(int i =0; i < row;i++)
		{
			for(int j =0; j < column;j++)
			{
				sum+= input[i][j];
			}
		}
		
		return sum;
	}
}
