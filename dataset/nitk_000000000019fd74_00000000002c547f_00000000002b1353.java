import java.util.*;
import java.io.*;

public class Solution
{
	private static Scanner infile = new Scanner(System.in);
	private static int[][] triangle;
	
	public static void main(String[] args)
	{
		triangle = new int[41][];
		fillTriangle();
		int numTestCases = infile.nextInt();
		for(int t = 1; t <= numTestCases; t++)
		{
			int n = infile.nextInt();
			System.out.println("Case #" + t + ":");
			if(n <= 500)
			{
			int row = 1;
				while(n > 0)
				{
					System.out.println(row + " 1");
					n--;
					row++;
				}
			}
			else if(n <= 1000)
			{
				System.out.println("1 1");
				System.out.println("2 2");
				n -= 2;
				int row = 1;
				while(triangle[row + 1][1] < n)
				{
					row++;
					n -= triangle[row][1];
					System.out.println((row + 1) + " 2");
				}
				while(n > 0)
				{
					System.out.println((row + 1) + " 1");
					n--;
					row++;
				}
			}
			else
			{
				for(int i = 1; i <= 10; i++)
					System.out.println(i + i);
				n -= 10;
				int row = 9;
				int maxPlace = 9;
				while(n > 0)
				{
					while(sum(row + 1, maxPlace) < n)
					{
						row++;
						System.out.println((row + 1) + " 10");
						n -= triangle[row][9];
					}
					maxPlace--;
				}
				for(int place = 8; place >= 0; place--)
				{
					n -= triangle[row][place];
					System.out.println((row + 1) + " " + (place + 1));
				}
				while(n > 0)
				{
					System.out.println(row + "1");
					n--;
					row++;
				}
			}
		}
	}
	
	private static void fillTriangle()
	{
		triangle[0] = new int[1];
		triangle[0][0] = 1;
		triangle[1] = new int[2];
		triangle[1][0] = 1;
		triangle[1][1] = 1;
		for(int i = 0; i < 41; i++)
		{
			triangle[i] = new int[i+1];
			triangle[i][0] = 1;
			triangle[i][i] = 1;
			for(int j = 1; j < i; j++)
				triangle[i][j] = triangle[i-1][j-1] + triangle[i-1][j];
		}
	}
	
	private static int sum(int row, int maxPlace)
	{
		int sum = 0;
		for(int i = 0; i <= maxPlace; i++)
			sum += triangle[row][i];
		return sum;
	}
}