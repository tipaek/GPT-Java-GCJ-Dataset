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
			
			//Insert opening bracket when we find a 1, and a closing bracket when we find a 0, if there was an open bracket.
			boolean unclosedBrackets = false;
			for(int i = 0; i < line.length(); i++)
			{
				if(line.charAt(i)=='1')
				{
					if(!unclosedBrackets)
					{
						line = insertBefore(line, i, "(");
						unclosedBrackets=true;
						i++;
					}
				}
				else if(line.charAt(i)=='0')
				{
					if(unclosedBrackets)
					{
						line = insertBefore(line, i, ")");
						unclosedBrackets=false;
						i++;
					}
				}
			}
			if(unclosedBrackets)
			{
				line = insertBefore(line, line.length(), ")");
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
