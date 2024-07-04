import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main (String[] args) {
		boolean debug = false;
		Scanner inputValue = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		String translateString = inputValue.nextLine();
		int vals2Loop = Integer.parseInt(translateString);
		
		//Loop based on the no of input values
		for (int i = 1; i <= vals2Loop; ++i) {
			String temp_val = inputValue.nextLine();
			char[] charArray = temp_val.toCharArray();
			int currentValue = 0;
			String solution = "";

			//Translate the given value
			for (char currentChar: charArray) {
				int currentIntegerValue = Character.getNumericValue(currentChar);
				if (currentIntegerValue > currentValue) {
					while (currentIntegerValue > currentValue) {
						solution += "(";
						currentValue++;
					}
					solution += Integer.toString(currentIntegerValue);
				} else if (currentIntegerValue == currentValue) {
					solution += currentIntegerValue;
				} else if (currentIntegerValue < currentValue) {
					while (currentIntegerValue < currentValue) {
						solution += ")";
						currentValue--;
					}
					solution += Integer.toString(currentIntegerValue);
				}
			}

			while (currentValue > 0) {
				solution += ")";
				currentValue--;
			}

			if (debug) {
				System.out.println("Case #" + i + ": " + Arrays.toString(charArray));
				System.out.println(solution);
			}
			System.out.println("Case #" + i + ": " + solution);
		}
	}
}