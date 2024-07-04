import java.util.HashSet;
import java.util.Scanner;

class Solution
{
	public static void main(String arg[])
	{
		Scanner scan = new Scanner(System.in);
		int testcases = scan.nextInt();
		int n[] = new int[testcases];
		int[][][] arr = new int[testcases][][];
		for (int i = 0; i < testcases; i++)
		{
			n[i] = scan.nextInt();
			arr[i] = new int[n[i]][];
			for (int j = 0; j < n[i]; j++)
			{
				arr[i][j] = new int[n[i]];
				for (int k = 0; k < n[i]; k++)
					arr[i][j][k] = scan.nextInt();
			}
		}
		scan.close();
		
		for (int testcase = 0; testcase < testcases; testcase++)
		{
			int k = 0;
			int r = 0;
			int c = 0;
			
			for (int j = 0; j < n[testcase]; j++)
				if(!isUniqColumnValues(arr, testcase, j))
					c++;
			
			for (int j = 0; j < n[testcase]; j++)
				if(!isUniqRowValues(arr, testcase, j))
					r++;
			
			k = diagonalSum(arr, testcase);
			System.out.println("Case #" + (testcase + 1) + ": " + k + " " + r + " " + c);
		}
				
	}
	
	public static boolean isUniqColumnValues(int[][][] arr, int testcase, int column)
	{
		int squareSize = arr[testcase].length;
		HashSet<Integer> numbers = new HashSet<>(squareSize);
		
		for (int row = 0; row < squareSize; row++)
			numbers.add(arr[testcase][row][column]);
		
		return numbers.size() == squareSize;
	}
	
	public static boolean isUniqRowValues(int[][][] arr, int testcase, int row)
	{
		int squareSize = arr[testcase].length;
		HashSet<Integer> numbers = new HashSet<>(squareSize);
		
		for (int column = 0; column < squareSize; column++)
			numbers.add(arr[testcase][row][column]);
		
		return numbers.size() == squareSize;
	}
	
	public static int diagonalSum(int[][][] arr, int testcase)
	{
		int squareSize = arr[testcase].length;
		int sum = 0;
		
		for (int index = 0; index < squareSize; index++)
			sum += arr[testcase][index][index];
		
		return sum;
	}
	
}
