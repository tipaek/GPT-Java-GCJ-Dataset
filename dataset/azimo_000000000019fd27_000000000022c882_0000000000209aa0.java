
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution 
{
	public static void main(String[] args)
	{
		// Read input
		Scanner inFile = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		
		int num_test_cases = inFile.nextInt();
		inFile.nextLine();
		
		for (int test_case = 1; test_case <= num_test_cases; test_case++)
		{
			String lineIn = inFile.nextLine();
			String[] inputs = lineIn.split(" ");
			int array_size = Integer.parseInt(inputs[0]);
			int trace = Integer.parseInt(inputs[1]);
			
			if ((array_size == 2 && (trace == 2 || trace == 4)))
			{
				output(test_case, "POSSIBLE");
				
				for (int i = 1; i <= array_size; i++)
				{	
					String out = "";
					
					for (int j = i; j < i + array_size; j++)
					{
						out += (j % array_size) == 0 ? array_size: j % array_size;
						out += " ";
					}
					
					System.out.println(out.trim());
				}
			}
			else if (array_size > 2 && (trace == array_size || trace == array_size * array_size 
				|| trace == (array_size * (array_size + 1)) / 2))
			{
				output(test_case, "POSSIBLE");
				
				for (int i = 1; i <= array_size; i++)
				{	
					String out = "";
					
					for (int j = i; j < i + array_size; j++)
					{
						out += (j % array_size) == 0 ? array_size: j % array_size;
						out += " ";
					}
					
					System.out.println(out.trim());
				}
			}
			else
			{
				output(test_case, "IMPOSSIBLE");
			}
		}
		
		inFile.close();
	}
	
	private static void output(int test_case, String result)
	{
		System.out.format("Case #%d: %s\n", test_case, result);
	}
}
