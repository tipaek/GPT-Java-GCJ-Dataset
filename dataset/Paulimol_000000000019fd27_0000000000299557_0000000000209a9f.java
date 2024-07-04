import java.io.*;
import java.util.*;

public class Solution {
	
	public static int[] getNumericValue(char[] array)
	{
		int[] values = new int[array.length];
		
		for(int j = 0; j < array.length; j++)
		{
			int value = Character.getNumericValue(array[j]);
			values[j] = value;
			System.out.println(value);		
		}
		
		return values;
	}
	
	public static String addParenthesis(int[] array)
	{
		String answer = "";
		
		for(int i = 0; i < array.length; i++)
		{
			int j = i+1;
			int value = array[i];
			int next = array[j];
			String right = "(";
			String left = ")";
			
			if( i == 0)
			{
				int numeroParentesis = 0;
				while(numeroParentesis < value)
				{
					answer = answer + right;
					numeroParentesis++;
				}
				
				String add = Integer.toString(value);
				answer = answer + add;
			}
			else if(value == next)
			{
				String add = Integer.toString(next);
				answer = answer + add;
			}
			else if(value != next)
			{
				int numeroParentesis = 0;
				while(numeroParentesis < value)
				{
					answer = answer + left;
					numeroParentesis++;
				}

				int numeroParentesis2 = 0;
				while(numeroParentesis2 < next)
				{
					answer = answer + right;
					numeroParentesis++;
				}
				
				String add = Integer.toString(next);
				answer = answer + add;
			}
		}
		
		return answer;
	}

	public static void main(String[] args) {

		// Input
		Scanner input = new Scanner(System.in);

		// Number of test cases
		int t = input.nextInt();

        //Read each string S
		for (int i = 1; i <= t; ++i) {
		
			// Read line
			String s = input.next();
			// Array of characters
			char[] digits = s.toCharArray();
			int [] values = getNumericValue(digits);
		
			//Output
			String answer = addParenthesis(values);
			System.out.println("Case #" + i + ": " + answer);

		}

	}
}