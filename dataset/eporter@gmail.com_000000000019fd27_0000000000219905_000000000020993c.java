package a;

import java.io.IOException;
import java.util.Scanner;

public class Solution {
    final Scanner in;

	public static void main(String [] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
        Solution.run(scanner);
		scanner.close();
	}
    
    public static void run(Scanner in) {
        int cases = in.nextInt();
        for (int cs = 1; cs <= cases; cs++) {
            new Solution(in).runCase(cs);
        }
    }
	
	public Solution(Scanner in) {
	    this.in = in;
	}
	
	private void runCase(int cs) {
	    int n = in.nextInt();
	    int [][] m = new int[n][n];
	    int k = 0, r = 0, c = 0;
	    for (int i = 0; i < n; i++) {
	        boolean [] rep = new boolean[n+1];
	        boolean isValid = true;
	        for (int j = 0; j < n; j++) {
	            int cur = in.nextInt();
	            m[i][j] = cur;
	            if (i == j) {
	                k += cur;
	            }
	            if (rep[cur]) {
	                isValid = false;
	            }
	            rep[cur] = true;
	        }
	        if (!isValid) {
	            r++;
	        }
	    }

        for (int j = 0; j < n; j++) {
            boolean [] rep = new boolean[n+1];
            boolean isValid = true;
            for (int i = 0; i < n; i++) {
                int cur = m[i][j];
                if (rep[cur]) {
                    isValid = false;
                }
                rep[cur] = true;
            }    
            if (!isValid) {
                c++;
            }
        }
	    println(String.format("Case #%s: %s %s %s", cs, k, r, c));
	}
    
    private static void println(String s) {
        System.out.println(s);
        System.out.flush();
    }
}
