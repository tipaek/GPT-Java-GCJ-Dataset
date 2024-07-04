import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution
{

	public static void main(String[] args) throws IOException
	{
	    List<String> results = new ArrayList<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int numberOfTestCases = Integer.parseInt(br.readLine().trim());
		for (int i = 0; i < numberOfTestCases; i++)
		{
			List<Integer> sizeAndTrace = Arrays.stream(br.readLine().trim().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
			Integer size = sizeAndTrace.get(0);
			Integer trace = sizeAndTrace.get(1);
			Integer[][] matrix = generateMatrix(size);
			Integer[][] solution = findTrace(matrix, trace);
			if (solution == null)
			{
			    String res = "Case #" + (i + 1) + ": IMPOSSIBLE";
			    if (i != numberOfTestCases - 1) {
			        res = res + "\n";
                }
				results.add(res);
			}
			else
			{
			    StringBuilder builder = new StringBuilder("Case #" + (i + 1) + ": POSSIBLE\n");
				printMatrix(solution,builder,i != numberOfTestCases - 1);
				results.add(builder.toString());
			}
		}
		results.forEach(System.out::print);
	}

	private static void printMatrix(Integer[][] matrix, StringBuilder stringBuilder, Boolean b)
	{
		for (int i = 0; i < matrix.length; i++)
		{
			for (int j = 0; j < matrix.length; j++)
			{
				stringBuilder.append(matrix[i][j]);
				stringBuilder.append(" ");
			}
			if(!(!b && i != matrix.length-1))
            {
                stringBuilder.append("\n");
            }
		}
	}

	private static Integer[][] findTrace(Integer[][] matrix, int trace)
	{
		int[] indexes = new int[matrix.length];
		for (int i = 0; i < matrix.length; i++)
		{
			indexes[i] = 0;
		}

		int i = 0;
		while (i < matrix.length)
		{
			if (indexes[i] < i)
			{
				swap(matrix, i % 2 == 0 ? 0 : indexes[i], i);
				if (checkTrace(matrix, trace))
				{
					return matrix;
				}
				indexes[i]++;
				i = 0;
			}
			else
			{
				indexes[i] = 0;
				i++;
			}
		}
		return null;
	}

	private static boolean checkTrace(Integer[][] matrix, int trace)
	{
		int sum = 0;
		for (int i = 0; i < matrix.length; i++)
		{
			sum += matrix[i][i];
		}
		return trace == sum;
	}

	private static void swap(Integer[][] input, int a, int b)
	{
		Integer[] tmp = input[a];
		input[a] = input[b];
		input[b] = tmp;
	}

	private static Integer[][] generateMatrix(Integer size)
	{
		Integer[][] matrix = new Integer[size][size];
		for (int i = 0; i < size; i++)
		{
			int value = i + 1;
			for (int j = 0; j < size; j++)
			{
				matrix[i][j] = value;
				value = value == size - 1 ? value + 1 : (value + 1) % size;
			}
		}
		return matrix;
	}
}
