import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		String openBracket = "(((((((((((";
		String closeBracket = ")))))))))))";
		
		int testCasesNum = in.nextInt();
		in.nextLine();
		for(int i = 1;i <= testCasesNum; i++) {
			String input = in.nextLine();
			String output = null;
			int previousDepth = -1;
			int nextDepth = -1;
			int currentDepth;
			int openBracketCount = 0;
			for(int j = 0; j < input.length(); j++)
			{
				//System.out.println(input.charAt(j));
				currentDepth = Integer.parseInt(String.valueOf(input.charAt(j)));
				if(output == null)
				{
					output = openBracket.substring(0, currentDepth) + currentDepth;
					openBracketCount = currentDepth;
				}
				else
				{
					//same
					if(currentDepth == previousDepth)
					{
						output = output + currentDepth;
					}
					//big
					else if(currentDepth > previousDepth)
					{
						output = output + openBracket.substring(0, currentDepth - previousDepth) + currentDepth;
						openBracketCount = openBracketCount + (currentDepth - previousDepth);
					}
					//small
					else if(currentDepth < previousDepth)
					{
						output = output + closeBracket.substring(0, previousDepth - currentDepth) + currentDepth;
						openBracketCount = openBracketCount - (previousDepth - currentDepth);
					}
				}
				previousDepth = currentDepth;
			}
			output = output + closeBracket.substring(0, openBracketCount);
			System.out.println("Case #"+i+": "+output);
		}
	}
}
