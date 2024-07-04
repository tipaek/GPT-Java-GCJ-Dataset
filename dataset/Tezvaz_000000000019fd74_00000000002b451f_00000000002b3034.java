import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

/*Quick Notes
Use BigInteger & BigDecimal for large numbers - They are arbitrarily precise.

*/
public class Solution {
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		int totalTestCases = Integer.parseInt(in.nextLine());

		for(int i = 0; i < totalTestCases; i++) {
			
			String output = "";
			int N = Integer.parseInt(in.nextLine());
			String[] patterns = new String[N];
			for(int j = 0; j < N; j++) {
				StringBuilder input1 = new StringBuilder(in.nextLine());
				String input = input1.reverse().toString();
				patterns[j] = input.substring(0, input.length()-1);
				
			}
			
			System.out.println("Case #" + (i+1) + ": " + output(patterns).reverse());
		}
		
		in.close();
	}
	
	public static StringBuilder output(String[] patterns) {
		
		String output = "";
			
		for(String pattern1 : patterns) {
			
			for(String pattern2 : patterns) {
				
				for(int j = 0; j < Math.min(pattern1.length(), pattern2.length()); j++) {
					if(pattern1.charAt(j) != pattern2.charAt(j)) {
						return new StringBuilder("*");
					}
				}
			}
			
			if(output.length() < pattern1.length()) {
				output = pattern1;
			}
		}
		return new StringBuilder(output);
	}
}
