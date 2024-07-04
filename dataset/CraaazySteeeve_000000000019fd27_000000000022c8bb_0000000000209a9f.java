import java.util.Scanner;

public class Solution {

	public static void main(String[] args) 
	{
		Scanner keyboard = new Scanner(System.in);
		int tCount = keyboard.nextInt();
		keyboard.nextLine();
		for(int t = 0; t < tCount; t++)
		{
			String line = keyboard.nextLine();
			
			int openBrackets = 0;
			for(int i = 0; i < line.length(); i++)
			{
				int numberOfBracketsRequired = Character.getNumericValue(line.charAt(i));
				while(numberOfBracketsRequired != openBrackets)
				{
					if(numberOfBracketsRequired > openBrackets)
					{
						line = insertBefore(line, i, "(");
						openBrackets++;
						i++;
					}
					else
					{
						line = insertBefore(line, i, ")");
						openBrackets--;
						i++;
					}
				}
			}
			while(openBrackets > 0)
			{
				line = insertBefore(line, line.length(), ")");
				openBrackets--;
			}

			//Print result of test case.
			System.out.println("Case #" + (t+1) + ": " + line);
		}
	}
	
	private static String insertBefore(String str, int index, String value)
	{
		return str.substring(0, index) + value + str.substring(index);
	}
}
