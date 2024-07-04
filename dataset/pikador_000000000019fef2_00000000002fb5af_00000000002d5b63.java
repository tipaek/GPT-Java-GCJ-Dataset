import java.util.Scanner;


public class Solution {
	

    public static void main(String[] args) {
    	Scanner inp = new Scanner(System.in);
	    int cases = inp.nextInt();
    	int A = inp.nextInt();
    	int B = inp.nextInt();
	    for (int c = 0; c < cases; c++) {
	    	if (A == 1000000000-5) {
	    		boolean hit = false;
	    		for (int x = -5; !hit && x <= 5; x++) {
		    		for (int y = -5; !hit && y <= 5; y++) {
		    			System.out.println(x + " " +y);
		    			String response = inp.next();
		    			if (response.equals("CENTER")) {
		    				hit = true;
		    			}
		    		}
	    		}
	    	}
	    } // for cases
        inp.close();
    }
 }