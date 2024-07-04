import java.util.Scanner;

public class Solution {
	
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int T = Integer.valueOf(scanner.nextLine());
		for (int i = 0; i < T; i++) {
		    String caseString = scanner.nextLine();
		    int caseSize = caseString.length();
		    int[] input = new int[caseSize];
		    for (int j = 0; j < caseSize; j++) {
		    	if (caseString.length() == 1) {
		    		input[j] = Integer.valueOf(caseString);
		    	} else {
			        input[j] = Integer.valueOf(caseString.substring(0, 1));
			        caseString = caseString.substring(1);
		    	}
		    }
		    solve(input, i);
		}
	}

		
	public static void solve (int[] input, int number) {
		String solution = "";
		String groupedNumbers = "";
		for (int i = 0; i < input.length; i++) {
			if (i < input.length - 1 && input[i] == input[i+1]) {
				groupedNumbers += input[i];
			} else if (groupedNumbers.length() > 0){
				groupedNumbers += input[i];
				int amount = input[i];
				solution += parenthisize(amount, groupedNumbers);
				groupedNumbers = "";
			} else {
				solution += parenthisize(input[i], (input[i] + ""));
			}
		}
		System.out.println("Case #" + (number + 1) + ": " + solution);
	}
	
	public static String parenthisize(int amount, String n) {
		String p = "";
		for (int i = 0; i < amount; i++) {
			p += "(";
		}
		p += n;
		for (int i = 0; i < amount; i++) {
			p += ")";
		}
		return p;
	}
	
}