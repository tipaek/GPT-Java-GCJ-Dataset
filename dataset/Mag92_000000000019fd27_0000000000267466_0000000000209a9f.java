import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner scanner = new Scanner((Readable) new BufferedReader(new InputStreamReader(System.in)));
		String input;
		
		// T cases
		int T = scanner.nextInt();
		for(int t = 0; t < T; t++) {
			input = scanner.next();
			char[] inputC = input.toCharArray();
			StringBuilder finalString = new StringBuilder();
			
			// get a digit
			for(int i = 0; i < inputC.length; i++) {
				int val = Character.getNumericValue(inputC[i]);
				if (val > 0) {
					for(int v = 0; v < val; v++) finalString.append("(");
					while(i < inputC.length-1 && val == Character.getNumericValue(inputC[i+1])) {
						finalString.append(val);
						i++;
					}
					finalString.append(val);
					for(int v = 0; v < val; v++) finalString.append(")");
				}
				else finalString.append(val);
			}
			System.out.println("Case #" + (t+1) + ": " + finalString);
		}
		
		
	}

}
