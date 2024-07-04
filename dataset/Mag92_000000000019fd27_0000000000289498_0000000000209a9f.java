
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
			int numOpen = 0;
			// get a digit and following digit
			for(int i = 0; i < inputC.length; i++) {
				int val = Character.getNumericValue(inputC[i]);
				int nextVal = 0;
				if (i < inputC.length-1) { nextVal = Character.getNumericValue(inputC[i+1]);}
				
				// if the number is the same as the current depth
				
				for(int v = numOpen; v < val; v++) { 						
					finalString.append("("); numOpen++; }  
				if (numOpen == val) {
					finalString.append(val);
				}
			// should I close?
			//if (val != nextVal) {
				if (i < inputC.length-1) {
					int o = numOpen - nextVal;
					for(int v = 0; v < o; v++) {
						//if (numOpen == val) finalString.append(val);
						finalString.append(")");
						numOpen--;
					}
			}
				else {//finalString.append(val);
				for(int x = 0; x < numOpen; x++) finalString.append(")"); }
				
			//}
			
			}
			System.out.println("Case #" + (t+1) + ": " + finalString);
		}
		
		
	}

}
