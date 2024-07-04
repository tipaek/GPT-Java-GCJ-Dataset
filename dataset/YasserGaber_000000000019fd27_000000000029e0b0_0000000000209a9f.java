import java.util.*;

public class Solution {
	public static void main(String[] args) {
	    
	    Scanner scanner = new Scanner(System.in);
	    int T = scanner.nextInt();
	    String[] str = new String[T];
	    String closedParents = "(((((((((";
	    String openedParents = ")))))))))";

	    for (int i = 0; i < T; i++) {
	        String S = scanner.next();
	        int sDigits = Integer.parseInt(S);
	        int rightOpenedParents = 0;
	        str[i] = "";
	        
	        for (int j = 0; j < S.length(); j++) {
	            int digit = sDigits % 10;
	            sDigits /= 10;
	            int toBeOpened = 0;
	            int toBeClosed = 0;
	            
	            if ((digit - rightOpenedParents) > 0) {
	                toBeOpened = digit - rightOpenedParents;
	                rightOpenedParents += toBeOpened;
	            } else {
	                toBeClosed = rightOpenedParents - digit;
	                rightOpenedParents -= toBeClosed;
	            }
	            str[i] = digit + openedParents.substring(0, toBeOpened) + closedParents.substring(0, toBeClosed) + str[i];
	        }
	        str[i] = closedParents.substring(0, rightOpenedParents) + str[i];
	   }
	    
	    for (int i = 1; i <= T; i++) {
	        System.out.println("Case #" + i + ": " + str[i - 1]);
	    }
	}
}