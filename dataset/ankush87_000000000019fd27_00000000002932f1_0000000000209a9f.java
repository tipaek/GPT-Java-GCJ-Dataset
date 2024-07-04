import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		InputStreamReader inputStreamReader = new InputStreamReader(System.in);
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
		int numberOfTestCases = Integer.parseInt(bufferedReader.readLine());
		StringBuilder answers[] = new StringBuilder[numberOfTestCases];
		int stringofDigitsInstance;
		int cursorInstance;
		int currentDigit;
		int previousDigit;
		for(int testCaseInstance = 0;testCaseInstance < numberOfTestCases;testCaseInstance++)
		{	
			answers[testCaseInstance] = new StringBuilder();
			String stringofDigits = bufferedReader.readLine();
			previousDigit = stringofDigits.charAt(0)-48;
			for(cursorInstance=0; cursorInstance < previousDigit; cursorInstance++)
				answers[testCaseInstance].append("(");
			answers[testCaseInstance].append(previousDigit);
			for(stringofDigitsInstance=1; stringofDigitsInstance < stringofDigits.length(); stringofDigitsInstance++)
			{
				currentDigit = stringofDigits.charAt(stringofDigitsInstance)-48;
				for(cursorInstance=0; cursorInstance < (currentDigit-previousDigit); cursorInstance++)
					answers[testCaseInstance].append("(");
				for(cursorInstance=0; cursorInstance < (previousDigit-currentDigit); cursorInstance++)
					answers[testCaseInstance].append(")");
				answers[testCaseInstance].append(currentDigit);
				previousDigit = currentDigit;
				//System.out.println(answers[testCaseInstance]);
			}
			for(cursorInstance=0; cursorInstance < previousDigit; cursorInstance++)
				answers[testCaseInstance].append(")");
			
		}
		for(int j=0;j<numberOfTestCases;j++)
		{
			System.out.println("Case #"+(j+1)+": "+answers[j]);
		}
	}
}
