import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
	    for (int i = 1; i <= t; ++i) {
	    		int n = in.nextInt();
	    		String prefix = "";
	    		String next = "";
	    		String rev = "";
	    		for(int j = 0; j < n; j++) {
	    			next = in.next().substring(1);
	    			rev = new StringBuilder(next).reverse().toString();
	    			if(prefix.startsWith(rev)) {
	    				continue;
	    			}
	    			else {
	    				if(rev.startsWith(prefix)) {
		    				prefix = rev;
		    			}
		    			else {
		    				prefix = "*";
		    			}
	    			}
	    			
	    		}
	    		System.out.println("Case #" + i + ": " + new StringBuilder(prefix).reverse().toString());
	    	}
	}
}
