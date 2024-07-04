import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

/*Quick Notes
Use BigInteger & BigDecimal for large numbers - They are arbitrarily precise.

*/
public class Solution {
	
	public static void main(String[] args) {
		
		//System.out.println("Some*some".replace("*",""));
		Scanner in = new Scanner(System.in);
		int totalTestCases = Integer.parseInt(in.nextLine());

		for(int i = 0; i < totalTestCases; i++) {
			
			int N = Integer.parseInt(in.nextLine());
			ArrayList<String> asteriskEnd = new ArrayList<String>();
			ArrayList<String> asteriskStart = new ArrayList<String>();
			ArrayList<String> asteriskStartRev = new ArrayList<String>();
			
			for(int j = 0; j < N; j++) {
				String pattern = in.nextLine();
				if(pattern.indexOf("*") == 0) {
					asteriskStart.add(pattern.replace("*", ""));
				} else if (pattern.indexOf("*") == pattern.length() - 1) {
					asteriskEnd.add(pattern.replace("*", ""));
				} else {
					asteriskStart.add(pattern.split("\\*")[1]);
					asteriskEnd.add(pattern.split("\\*")[0]);
				}
			}
			
			for(String pattern : asteriskStart) {	
				StringBuilder input1 = new StringBuilder(pattern);
				String input = input1.reverse().toString();
				asteriskStartRev.add(input);
			}
			
			String outputStart = output(asteriskStartRev).reverse().toString();
			String outputEnd = output(asteriskEnd).toString();
			
			//System.out.println(outputEnd);
			//System.out.println(outputStart);
			
			if(outputStart != "*" && outputEnd != "*") {
				System.out.println("Case #" + (i+1) + ": " + outputEnd + outputStart);
			} else {
				System.out.println("Case #" + (i+1) + ": *");
			}
			
		}
		
		in.close();
	}
	
	public static StringBuilder output(ArrayList<String> patterns) {
		
		String output = "";
			
		for(String pattern1 : patterns) {
			
			for(String pattern2 : patterns) {
				
				if(pattern1 != pattern2) {
					for(int j = 0; j < Math.min(pattern1.length(), pattern2.length()); j++) {
						if(pattern1.charAt(j) != pattern2.charAt(j)) {
							return new StringBuilder("*");
						}
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
