import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		int testsSets;
		int currentCase = 0;
		testsSets = scan.nextInt();
		
		
		while(testsSets > currentCase) {
			String next = scan.next();
			String newString = "";
			int currentDepth = 0;
			
			for(int i = 0; i < next.length(); i++) {
				char currentChar = next.charAt(i);
				int currentInt = currentChar - '0';
				
				for(int j = currentDepth; j < currentInt; j++) {
					newString += '(';
					currentDepth++;
				}
				for(int j = currentInt; j < currentDepth; j++) {
					currentDepth--;
					newString += ')';
				}
				
				newString += next.charAt(i);

			}
			
			for(int j = 0; j < currentDepth; j++) {
				currentDepth--;
				newString += ')';
			}
			
			System.out.printf("Case #%d: %s\n", currentCase + 1, newString);
			
			currentCase++;
		}
	}

}
