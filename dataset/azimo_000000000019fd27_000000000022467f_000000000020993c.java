import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Hashtable;
import java.util.Scanner;

public class Solution 
{
	public static void main(String [] args)
	{
		// Read input
		Scanner inFile = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		
		int num_test_cases = inFile.nextInt();
		
		for (int test_case = 1; test_case <= num_test_cases; test_case++)
		{
			int array_size = inFile.nextInt();
			inFile.nextLine();
			int[] array = new int[array_size * array_size];
			
			for (int i = 0; i < array_size; i++)
			{
				String input_string = inFile.nextLine();
				
				String[] to_parse = input_string.split(" ");
				
				for (int j = i * array_size; j < array_size * (i + 1); j++)
				{
					array[j] = Integer.parseInt(to_parse[j % array_size]);
				}
			}
			
			// Compute trace
			int trace = 0;
			
			for (int i = 0; i < array_size; i++)
			{
				trace += array[i * (array_size + 1)];
			}
			
			//System.out.println(trace);

			int lower = 0;
			int upper = array_size * (array_size - 1);
			
			// Determine number of duplicate columns
			
			int num_col_with_repeated = findNumberOfRepeated(lower, upper, array_size, 1, array_size,
					array);
			
			// Determine number of duplicate rows
			upper = array_size - 1;
			int num_row_with_repeated = findNumberOfRepeated(lower, upper, 1, array_size, array_size,
					array);
			
			output(test_case, trace, num_row_with_repeated, num_col_with_repeated);
		}
		
		inFile.close();
	}
	
	private static void output(int test_case, int trace, int num_row_with_repeated, int num_col_with_repeated)
	{
		System.out.format("Case #%d: %d %d %d\n", test_case, trace, num_row_with_repeated, num_col_with_repeated);
	}
	
	private static int findNumberOfRepeated(int lower, int upper, int step, int iteration_step, 
			final int ARRAY_SIZE, int[] array)
	{
		Hashtable<Integer, Integer> table = new Hashtable<>();
		
		int repeated = 0;
		
		for (int i = 0; i < ARRAY_SIZE; i++)
		{
			//System.out.println("i :" + i + " lower: " + lower + " " + "upper: " + upper);
			
			for (int j = lower; j <= upper; j += step)
			{
				//System.out.println("Comparing: @ " + array[j] + " and @ " + array[(j + step)]);
				//System.out.println(j + " -> " + array[j]);
				
				if (table.containsKey(array[j]))
				{
					repeated++;
					break;
				}
				else
				{
					table.put(array[j], 1);
				}
			}
			//System.out.println(table);
			table.clear();
			
			lower += iteration_step;
			upper += iteration_step;
		}
		
		return repeated;
	}
}
