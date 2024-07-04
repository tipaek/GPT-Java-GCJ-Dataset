import java.util.Scanner;

public class Solution {

    static void complement(StringBuilder s) {
    	for (int i = 0; i < s.length(); i++) {
    		if (s.charAt(i) == '0') {
    			s.replace(i,i+1,"1");
    		} else
        		if (s.charAt(i) == '1') {
        			s.replace(i,i+1,"0");
        		}
    	}
    }
    
    public static void main(String[] args) {
    	Scanner inp = new Scanner(System.in);

	    int cases = inp.nextInt();
    	int B = inp.nextInt();
	    for (int c = 0; c < cases; c++) {

        	StringBuilder guess = new StringBuilder(B);
        	for (int i = 0; i < B; i++) {
        		guess.append(" ");
        	}
	    	
	    	if (B == 10) {
	    		for (int i = 0; i < 10; i++) {
	    			System.out.println(i+1);
	    			String bit = inp.next();
	    			guess.replace(i,i+1,bit);
	    		}
	    		System.out.println(guess);
	    		String answer = inp.next();

	    	} else if (B == 20) {

	    	} else { // B = 100
	    	
	    	}
	    }
        inp.close();
    }
}
