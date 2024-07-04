import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
	    for (int i = 1; i <= t; ++i) {
	    		int n = in.nextInt();
	    		System.out.println("Case #" + i + ":");
	    		if(n <= 501) {
	    			if(n == 501) {
	    				System.out.println(1 + " " + 1);
	    				System.out.println(2 + " " + 2);
	    			}
	    			else {
	    				System.out.println(1 + " " + 1);
	    			}
	    			for(int j = 1; j < (n == 501? 500: n); j++) {
	    				System.out.println((j+1) + " " + 1);
	    			}
	    		}
	    		else {
	    			if(n < 998) {
	    				for(int j = 0; j < 499; j++) {
	    					if(j == n - 499) {
	    						System.out.println((j+1) + " " + 2);
	    					}
		    				System.out.println((j+1) + " " + 1);
		    			}
	    			}
	    			if(n < 1001 && n > 997) {
	    				
	    			}
	    		}
	    		
	    }
	}
}
