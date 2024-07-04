

import java.util.Scanner;


public class Solution {
	static String calculateString(String S) {
		int current_max = 0; // current count
		int max = 0; // overall maximum count
		int n = S.length();
		String newString = new String();

		// Traverse the input string
		int a = Integer.parseInt(String.valueOf(S.charAt(0)));
		System.out.println(newString);

		for (int j = 1; j <= a; j++) {
			newString = newString + "(";
		}
		newString = newString + S.charAt(0);

		for (int i = 1; i < n; i++) {
			int b = Integer.parseInt(String.valueOf(S.charAt(i)));
			int c = Integer.parseInt(String.valueOf(S.charAt(i - 1)));

			if (c > b) {
				int diff = c - b;
				for (int k = 1; k <= diff; k++)
					newString = newString + ")";
			} else if (c < b) {
				int diff = b - c;
				for (int k = 1; k <= diff; k++)
					newString = newString + "(";
			}

			newString = newString + S.charAt(i);
			if (i == n - 1) {
				for (int j = 1; j <= b; j++) {
					newString = newString + ")";
				}

			}
		}

		if (n == 1) {
			for (int j = 1; j <= a; j++) {
				newString = newString + ")";
			}

		}
		return newString;
	}

	public static void main(String[] args) {
		
        Scanner scanner = new Scanner(System. in);
        int testcases = scanner.nextInt();
        String [] output = new String[testcases];
        scanner.nextLine();
        for (int m = 0; m < testcases; m++) {
  
        String inputString = scanner.nextLine();
		String out = calculateString(inputString);
		output[m] = out;
        }
        for (int i = 0; i <  testcases; i++) {
			System.out.print("Case #"+(i+1)+": "+output[i]);
        }
	}

}
