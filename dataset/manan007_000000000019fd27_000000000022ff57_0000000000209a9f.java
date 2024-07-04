import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
	Scanner input = new Scanner(System.in);

	int numberOfTestCases = input.nextInt();
	input.nextLine();

	for (int i = 1; i <= numberOfTestCases; i++) {

	    String inputString = input.nextLine();
	    String outputString = "";

	    int numOpenBrackets = 0;

	    for (int j = 0; j < inputString.length(); j++) {
		int currentNum = Character.getNumericValue(inputString.charAt(j));

		if (currentNum > numOpenBrackets) {
		    while (currentNum != numOpenBrackets) {
			outputString += "(";
			numOpenBrackets++;
		    }
		} else {
		    int diff = numOpenBrackets - currentNum;
		    while (diff > 0) {
			outputString += ")";
			diff--;
			numOpenBrackets--;
		    }
		}
		outputString += currentNum;
	    }
	    while (numOpenBrackets != 0) {
		outputString += ")";
		numOpenBrackets--;
	    }
	    System.out.println("Case #" + i + ": " + outputString);
	}

    }
}