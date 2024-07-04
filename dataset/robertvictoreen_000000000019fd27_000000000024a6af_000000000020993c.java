import java.util.Scanner;
class Solution {
public static void main(String[] args) {
    
    Scanner s = new Scanner(System.in);

    int T = s.nextInt();

    int N;

    for (int Tcase = 1; Tcase <= T; Tcase++) {
    	N = s.nextInt();
    	int[][] mat = new int[N][N];
    	int trace = 0;
    	int traceIndex = 0;
    	for (int row = 0; row < N; row++) {
    		for (int col = 0; col < N; col++) {
    			mat[row][col] = s.nextInt();
    			if (row == traceIndex && col == traceIndex) {
    				trace += mat[row][col];
    				traceIndex++;
    			}
    		}
    	}

    	int r = 0;
    	int c = 0;
    	int xor;
    	for (int row = 0; row < N; row++) {
    		xor = 0;
    		for (int col = 0; col < N; col++) {
    			xor ^= mat[row][col];
    			xor ^= col + 1;
    		}
    		if (xor > 0) {
    			r++;
    		}
    	}

    	for (int col = 0; col < N; col++) {
    		xor = 0;
    		for (int row = 0; row < N; row++) {
    			xor ^= mat[row][col];
    			xor ^= row + 1;
    		}
    		if (xor > 0) {
    			c++;
    		}
    	}


    	System.out.println("Case #" + Tcase + ": " + trace + " "+r+" "+c);
    }
}
}