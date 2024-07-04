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
		}
		
		return values;
	}
	
	public static String addParenthesis(int[] array)
	{
		String answer = "";
		int anterior = -1;
		int size = array.length - 1;
		
		for(int i = 0; i < array.length; i++)
		{
			boolean primero = false;
			int value = array[i];
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
				primero = true;
			}
			else if(value == anterior && primero == false)
			{
				String add = Integer.toString(value);
				answer = answer + add;
			}
			else if(value != anterior && primero == false)
			{
			    int numeroParentesis = 0;
				while(numeroParentesis < anterior)
				{
					answer = answer + left;
					numeroParentesis++;
				}
				int numeroParentesis2 = 0;
				while(numeroParentesis2 < value)
				{
					answer = answer + right;
					numeroParentesis2++;
				}
				String add = Integer.toString(value);
				answer = answer + add;
			}
			
			if(i == size)
			{
			    int numeroParentesis = 0;
				while(numeroParentesis < value)
				{
					answer = answer + left;
					numeroParentesis++;
				}
			}
		anterior = value;
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