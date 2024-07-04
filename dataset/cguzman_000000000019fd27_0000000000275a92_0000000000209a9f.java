
import java.util.Scanner;

public class Solution {
	 

	public static void main(String[] args) {

		
		try {

			// Scanner s = new Scanner(new FileReader("jam\\T2.in")); 
			Scanner s = new Scanner(System.in); 
			
			int T = s.nextInt(); 
			
			for(int i = 1; i <= T; i++) {
			
				String result = "";
				
				String N = s.next();

				// for each digit
		    	for (int index = 0; index < N.length(); index++) {
		    		
		    		char digit = N.charAt(index);
		    		int number = digit - '0';
		    		int totalParenthesis= number;
		    		
		    		int back = result.length()-1;
		    		while(back >= 0 && totalParenthesis > 0) {
		    			if (result.charAt(back) == ')') {
		    				back--;
		    				totalParenthesis--;
		    				continue;
		    			}
		    			int numberEval = result.charAt(back)-'0';
		    			if (numberEval <= totalParenthesis) {
		    				break;
		    			}
		    		}
		    		
		    		if (back >= 0 )
		    			result = result.substring(0, back+1)+addParenthesis(""+number, totalParenthesis)+result.substring(back+1);
		    		else
		    			result+= addParenthesis(""+number, totalParenthesis);
		    	}
				
				System.out.println("Case #"+i+": "+result);
				
			}
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} 

	}

	public static String addParenthesis(String result, int i) {
		
		if (i <= 0)
			return result;
		
		return addParenthesis("("+result+")", --i);
	}
}
