import java.util.Scanner;


public class Solution {
	
	static boolean increment(int N, int[] ndx) {
		int i = ndx.length - 1;
		boolean count = true;
		while (i >= 0 && count) {
			ndx[i]++;
			if (ndx[i] == N) {
				ndx[i] = 0;
				i--;
			} else {
				count = false;
			}
		}
		if (i < 0) {
			return false;
		} else {
			return true;
		}
	}
	
    public static void main(String[] args) {
    	Scanner inp = new Scanner(System.in);
	    int cases = inp.nextInt();
	    final int MAX_MOVE = 32;
	    long exp[] = new long[MAX_MOVE];
	    boolean used[] = new boolean[MAX_MOVE];
	    exp[0] = 1;
	    for (int i = 1; i < MAX_MOVE; i++) {
	    	exp[i] = 2 * exp[i-1];
	    }
	    for (int i = 0; i < MAX_MOVE; i++) {
	    	used[i] = false;
	    }

	    for (int c = 0; c < cases; c++) {
	    	final int MAX_TRIAL = 8;
		    int index[] = new int[MAX_TRIAL];
		    int X = inp.nextInt();
	    	int Y = inp.nextInt();
	    	boolean found = false;
	    	String result = "";
	    	for (int k = 0; k < MAX_TRIAL; k++) {
	    		result = result.concat("-");
	    	}
	    	do {
	    		int x = 0;
	    		int y = 0;
	    		if (index[0] == 0 && index[1] == 2) {
	    			index[0] = 0;
	    		}
	    		for (int i = 0; i < index.length; i++) {
	    			switch(index[i]) {
	    			case 0: // S
	    				y -= exp[i];
	    				break;
	    			case 1: // N
	    				y += exp[i];
	    				break;
	    			case 2: // E
	    				x += exp[i];
	    				break;
	    			case 3:
	    				x -= exp[i];
	    				break;
	    			}
	    			if (x == X && y == Y) {
	    				found = true;
	    				if (i < result.length()) {
	    					result = "";
		    	    		for (int k = 0; k <= i; k++) {
		    	    			switch(index[k]) {
		    	    			case 0: // S
		    	    				result = result.concat("S");
		    	    				break;
		    	    			case 1: // N
		    	    				result = result.concat("N");
		    	    				break;
		    	    			case 2: // E
		    	    				result = result.concat("E");
		    	    				break;
		    	    			case 3:
		    	    				result = result.concat("W");
		    	    				break;
		    	    			}
		    	    		}
	    				}
	    			}
	    		}
	    	} while (increment(4, index));
	    	if (!found) {
	    		System.out.println("Case #" + (c+1) + ": IMPOSSIBLE" );
	    	} else {
	    		System.out.println("Case #" + (c+1) + ": " + result );
	    	}
	    } // for cases
        inp.close();
    }
}