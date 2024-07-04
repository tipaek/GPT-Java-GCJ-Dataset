import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        int b = in.nextInt();
        for (int x=1; x<=t; x++) {
        	solve(in, b);
        }
        in.close();
    }

	private static void solve(Scanner in, int b) {
		// A position where a value change indicates a flip (no matter if reversed)
		int flipPos = -1;
		
		// A position where a value change (after flip compensation) indicates a reverse 
		int revPos = -1;
		
		boolean[] bits = new boolean[b];
		
		for (int i=0, j=bits.length-1; i<5; i++, j--) {
			bits[i] = getBit(in, i);
			bits[j] = getBit(in, j);
			if (bits[i] == bits[j]) {
				if (flipPos < 0) flipPos = i;
			} else {
				if (revPos < 0) revPos = i;
			}
		}
		int halfLength = b/2;
		if (b == 10) {
			boolean answer = postSolution(in, bits);
			if (answer) {
				return;
			} else {
				System.exit(1);
			}
		}
		
		// The next position (at the low end) to be analysed.
		int nextAnalyse = 5;
		for (int group=1; group<15; group++) {
			if (flipPos < 0) {
				boolean sample = getBit(in, 0);
				boolean dummy = getBit(in, 0);
				if (sample != bits[0]) {
					flip(bits);
				}
			} else if (revPos < 0) {
				boolean sample = getBit(in, flipPos);
				boolean dummy  = getBit(in, flipPos);
				if (sample != bits[flipPos]) {
					flip(bits);
				}
			} else {
				boolean flipSample = getBit(in, flipPos);
				boolean revSample  = getBit(in, revPos);
				if (flipSample != bits[flipPos]) {
					flip(bits);
				}
				if (revSample != bits[revPos]) {
					reverse(bits);
				}
			}
			for (int step=0; step<4; step++) {
				int mirror = b - 1 - nextAnalyse;
				bits[nextAnalyse] = getBit(in, nextAnalyse);
				bits[mirror] = getBit(in, mirror);
				if (bits[nextAnalyse] == bits[mirror]) {
					if (flipPos < 0) flipPos = nextAnalyse;
				} else {
					if (revPos < 0) revPos = nextAnalyse;
				}
				nextAnalyse++;
				if (nextAnalyse >= halfLength) {
					boolean answer = postSolution(in, bits);
					if (answer) {
						return;
					} else {
						System.exit(1);
					}
				}
			}
		}
	}
    
    private static void flip(boolean[] bits) {
    	for (int i=0; i<bits.length; i++) {
    		bits[i] = !bits[i];
    	}
    }
    
    private static void reverse(boolean[] bits) {
    	int half = bits.length / 2;
    	for (int i=0, j=bits.length-1; i<half; i++, j--) {
    		boolean temp = bits[i];
    		bits[i] = bits[j];
    		bits[j] = temp;
    	}
    }
    
    private static boolean getBit(Scanner in, int pos0) {
    	System.out.println(pos0 + 1);
        System.out.flush();
        String result = in.next();
        if ("0".equals(result)) {
        	return false;
        } else if ("1".equals(result)) {
        	return true;
        }
        throw new IllegalArgumentException("Position " + pos0);
    }
    
    private static boolean postSolution(Scanner in, boolean[] bits) {
    	StringBuilder builder = new StringBuilder();
    	for (int i=0; i<bits.length; i++) {
    		builder.append(bits[i] ? '1' : '0');
    	}
    	System.out.println(builder);
        System.out.flush();
        String result = in.next();
        return "Y".equals(result);
    }
}