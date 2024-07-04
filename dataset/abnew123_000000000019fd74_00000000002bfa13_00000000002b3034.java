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
	    		String suffix = "";
	    		String next = "";
	    		String middle = "";
	    		String rev = "";
	    		for(int j = 0; j < n; j++) {
	    			next = in.next();
	    			String[] front = next.split("\\*");
	    			rev = new StringBuilder(next).reverse().toString();
	    			String[] back = rev.split("\\*");
	    			if(prefix.startsWith(front[0])) {
	    			}
	    			else {
	    				if(front[0].startsWith(prefix)) {
		    				prefix = front[0];
		    			}
		    			else {
		    				prefix = "*";
		    			}
	    			}
	    			if(suffix.startsWith(back[0])) {
	    			}
	    			else {
	    				if(back[0].startsWith(suffix)) {
		    				suffix = back[0];
		    			}
		    			else {
		    				suffix = "*";
		    			}
	    			}
	    			for(int k = 1; k < (next.substring(next.length() - 1).equals("*")?front.length: front.length - 1); k++) {
	    				middle+= front[k];
	    			}
	    			
	    		}
	    		if(prefix.equals("*") || suffix.equals("*")) {
	    			System.out.println("Case #" + i + ": *" );
	    		}
	    		else {	
	    			System.out.println("Case #" + i + ": " + prefix +middle+ new StringBuilder(suffix).reverse().toString());
	    		}
	    	}
	}
}
