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
		int opens = 0;
		for (int i = 0; i < input.length; i++) {
			if (input[i] > opens) {
				for (int j = 0; j < input[i] - opens; j++) {
					solution += "(";
				}
				opens = input[i];
			} else if (input[i] < opens) {
				for (int j = 0; j < opens - input[i]; j++) {
					solution += ")";
				}
				opens = input[i];
			}
			solution += input[i];
			if (i < input.length - 1 && input[i+1] < input[i]) {
				for (int j = 0; j < input[i+1] - input[i]; j++) {
					solution += ")";
				}
			}
			if (i == input.length - 1) {
				for (int j = 0; j < input[i]; j++) {
					solution += ")";
				}
			}
		}
		System.out.println("Case #" + (number + 1) + ": " + solution);
	}	
}