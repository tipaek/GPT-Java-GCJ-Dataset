import java.util.*;
import java.io.*;

public class Solution
{
	private static Scanner infile;
	private static int numTestCases;
	private static String sequence;
	private static Queue<Character> nested;
	
	public static void main(String[] args)
	{
		infile = new Scanner(System.in);
		numTestCases = infile.nextInt();
		infile.nextLine();
		for(int c = 1; c <= numTestCases; c++)
		{
			sequence = infile.nextLine();
			nested = new LinkedList<Character>();
			for(int i = 0; i < sequence.length(); i++)
				nested.add(sequence.charAt(i));
			
			String answer = "";
			for(int i = 0; i < Integer.parseInt("" + nested.peek()); i++)
				answer += '(';
			while(nested.size() != 1)
			{
				char temp = nested.remove();
				int parens = temp - nested.peek();
				answer += temp;
				if(parens > 0)
					for(int i = 0; i < parens; i++)
						answer += ')';
				else
					for(int i = 0; i < -1 * parens; i++)
						answer += '(';
			}
			answer += nested.remove();
			int fin = Integer.parseInt("" + answer.charAt(answer.length() - 1));
			for(int i = 0; i < fin; i++)
				answer += ')';
			
			System.out.println("Case #" + c + ": " + answer);
		}
	}
}