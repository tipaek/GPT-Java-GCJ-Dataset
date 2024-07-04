import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		  Scanner input = new Scanner(System.in);	
	        
	        int T = input.nextInt();
	        
	        ArrayList<String> results = new ArrayList<String>();
	        
	        for (int ks = 1; ks <= T; ks++) {
	            results.add(String.format("Case #%d: %s", ks, solve(input)));
	        }
	        
	        for (int i = 0; i < results.size();i++) {
	        	System.out.println(results.get(i));
	        }
	}
	public static String solve(Scanner input) {
		int N = input.nextInt();
		
		List<String> matchingStrings = new ArrayList<String>();
		
		for (int i = 0; i < N; i++) {
			matchingStrings.add(input.next());
		}
		
		int maxLength = 0;
		String maxString = "";
		
		for (int j = 0; j < matchingStrings.size(); j++) {
			if (matchingStrings.get(j).length() > maxLength) {
				maxLength = matchingStrings.get(j).length();
				maxString = matchingStrings.get(j);
			}
		}
				
		boolean test = true;
		
		maxString = maxString.substring(1);
		
		for (int j = 0; j < matchingStrings.size(); j++) {
			
			String currString = matchingStrings.get(j).substring(1);
			
			if (!maxString.contains(currString)) {
				test = false;
				break;
			}
		}
		
		if (test == false) {
			return "*";
		}

		return maxString;
	}
}
