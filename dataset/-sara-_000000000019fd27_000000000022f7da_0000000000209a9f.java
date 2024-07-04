import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt(); 
		in.nextLine(); // advance to the second line to begin reading the input strings
		for (int i = 1; i <= t; ++i) {
			String input = in.nextLine();
			int[] inputNumbers = new int[input.length()];
			String solution = "";
			for (int j = 0; j < input.length(); j++) {
				inputNumbers[j] = Character.getNumericValue(input.charAt(j));
			}
			if(inputNumbers[0] == 0) {
				solution = "0";
			} else {
				solution = "(1";
			}
			for(int j = 1; j < input.length(); j++) {
				if(inputNumbers[j] == inputNumbers[j-1]) {
					solution = solution + inputNumbers[j];
				} else if (inputNumbers[j] == 0 ) {
					solution = solution + ")0";
				} else {
					solution = solution + "(1";
				}
			}
			if(inputNumbers[input.length() - 1] == 1) {
				solution = solution + ")";
			}
			System.out.println("Case #" + i + ": " + solution);
		}
		in.close();
	}
}
