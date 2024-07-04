import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

//2020

public class Solution {
	public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = Integer.parseInt(in.nextLine());

        for (int z = 1; z <= t; ++z) {
        	StringBuilder solution = new StringBuilder();
	    	String given = in.nextLine();
	    	int c, o = 0;
	    	
	    	for (int i = 0; i < given.length(); ++i) {
	    		c = given.charAt(i) - '0';
	    		
	    		while (o < c) {
	    			solution.append('(');
	    			++o;
	    		}
	    		
	    		while (o > c) {
	    			solution.append(')');
	    			--o;
	    		}
	    		
	    		solution.append(c);
	    	}
	    	
	    	while (o > 0) {
	    		solution.append(')');
    			--o;
	    	}
	    	
            System.out.println("Case #" + z + ": " + solution.toString());
        }
        in.close();

        System.exit(0);
    }
}
