import java.util.*;

public class Solution {
	public static void main(String[] args) {
	    
	    Scanner scanner = new Scanner(System.in);
	    int T = scanner.nextInt();
	    String[] str = new String[T];
	    String openedParents = "(((((((((";
	    String closedParents = ")))))))))";

	    for (int i = 0; i < T; i++) {
	        String S = scanner.next();
	        int leftOpenedParents = 0;
	        str[i] = "";
	        
	        for (int j = 0; j < S.length(); j++) {
	            String c = S.substring(j,j+1);
	            int digit = Integer.parseInt(c);
	            int toBeOpened = 0;
	            int toBeClosed = 0;
	            
	            if ((digit - leftOpenedParents) > 0) {
	                toBeOpened = digit - leftOpenedParents;
	                leftOpenedParents += toBeOpened;
	            } else {
	                toBeClosed = leftOpenedParents - digit;
	                leftOpenedParents -= toBeClosed;
	            }
	            str[i] += openedParents.substring(0, toBeOpened) + closedParents.substring(0, toBeClosed) + digit;
	        }
	        str[i] += closedParents.substring(0, leftOpenedParents);
	   }
	    
	    for (int i = 1; i <= T; i++) {
	        System.out.println("Case #" + i + ": " + str[i - 1]);
	    }
	}
}
