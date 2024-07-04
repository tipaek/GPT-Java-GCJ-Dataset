
//2020 Code Jam Qualification Round   20200403 - 20200405 UTC
//Problem:  Nesting Depth
//Submitted by jm5D

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;
import java.io.PrintWriter;
//import java.io.FileReader;
//import java.io.FileWriter;


public class Solution {

	public static void main(String[] args) throws Exception{
		
		//BufferedReader reader = new BufferedReader(new FileReader("testData2020QualProbB"));
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		writer.flush();
		String inputString = reader.readLine();
		int numberOfCases = Integer.parseInt(inputString);
		int caseNumber = 1;
		while (caseNumber <= numberOfCases) {
			
			inputString = reader.readLine();
			int stringLength = inputString.length();
			
			StringBuilder outputString = new StringBuilder(stringLength);
			char digit = inputString.charAt(0);
			int number = Character.getNumericValue(digit);
			for (int i = 0; i < number; i++) {
				outputString = outputString.append('(');
			}
			outputString = outputString.append(digit);
			int leftParenthesesCount = number;
			int previousNumber = number;
			for (int i = 1; i < stringLength; i++) {
				digit = inputString.charAt(i);
				number = Character.getNumericValue(digit);
				int difference = 0;
				if (number == previousNumber) {
					outputString = outputString.append(digit);
				}
				else if (previousNumber > number) {
					difference = previousNumber - number;
					for (int j = 0; j < difference; j++) {
						outputString = outputString.append(')');
						leftParenthesesCount -= 1;
					}
					outputString = outputString.append(digit);
					previousNumber = number;
				}
				else {
					difference = number - previousNumber;
					for (int j = 0; j < difference; j++) {
						outputString = outputString.append('(');
						leftParenthesesCount += 1;	
					}
					outputString = outputString.append(digit);
					previousNumber = number;
				}
			}
			
			if (leftParenthesesCount > 0) {
				for (int i = 0; i < leftParenthesesCount; i++) {
					outputString = outputString.append(')');
				}
			}
			
			writer.println("Case #" + caseNumber + ": " + outputString);
			writer.flush();
			caseNumber++;
		}
		reader.close();
		writer.close();
		
	}
}