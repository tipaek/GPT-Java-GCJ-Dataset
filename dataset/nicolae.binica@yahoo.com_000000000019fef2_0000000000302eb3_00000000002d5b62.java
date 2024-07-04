import java.util.Scanner;
import java.io.*;
import java.util.*;

class Solution {

	public static void main(String[] args) {

	    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int Q = in.nextInt();
		for(int test = 1; test <= Q; test ++){
			int X = in.nextInt();
			int Y = in.nextInt();
			
			//System.out.println(test);
			solve(test, X, Y);
		}
	}
	
	public static void solve(int test, int X, int Y) {
		int[] op = new int[100];
		int lastOpX = -1;
		int lastOpY = -1;
		boolean ok = false;
		int[] x = new int[] {Math.abs(X), -Math.abs(X)};
		int[] y = new int[] {Math.abs(Y), -Math.abs(Y)};
		for(int i = 0; i < 2 && ok == false; i ++)
			for(int j = 0; j < 2 && ok == false; j ++) {
				ok = true;
				lastOpX = -1;
				lastOpY = -1;
				for(int b = 0; b < 32 && ok == true; b ++) {
					int bitX = x[i] & (1<<b);
					int bitY = y[j] & (1<<b);
					if(bitX == 0 && bitY == 0) {
						break;
					}
					if(bitX == bitY)
						ok = false;
					
					if(bitX != 0) { /// E +1  or  W -1
						op[b] = 1;//x[i] > 0 ? 1 : -1;
						op[b] = sameSign(x[i], X) ? op[b] : -op[b];
						lastOpX = x[i] > 0 ? -b : b;
					}
					if(bitY != 0) { /// N +2  or  S -2
						op[b] = 2;//y[j] > 0 ? 2 : -2;
						op[b] = sameSign(y[j],Y) ? op[b] : -op[b];
						lastOpY = y[j] > 0 ? -b : b;
					}
					
				}
			}
		if(lastOpX > 0)
			op[lastOpX] *= -1;
		if(lastOpY > 0)
			op[lastOpY] *= -1;
		System.out.printf("Case #%d: ", test);
		if(!ok) {
			System.out.println("IMPOSSIBLE");
			return;
		}
		String result = "";
		for(int i = 0; i < 32 && op[i] != 0; i ++)
			switch(op[i]) {
			case 1: 
				result += 'E';
				break;
			case -1: 
				result += 'W';
				break;
			case 2: 
				result += 'N';
				break;
			case -2: 
				result += 'S';
				break;
			}
		while((result.charAt(result.length() - 2) == 'S' && result.charAt(result.length() - 1) == 'N') ||
			(result.charAt(result.length() - 2) == 'N' && result.charAt(result.length() - 1) == 'S') ||
			(result.charAt(result.length() - 2) == 'E' && result.charAt(result.length() - 1) == 'W')||
			(result.charAt(result.length() - 2) == 'W' && result.charAt(result.length() - 1) == 'E'))
			result = result.substring(0, result.length() - 2) + result.substring(result.length() - 1);
		System.out.println(result);
	}
	
	static boolean sameSign(int A, int B) {
		return A*B > 0;
	}

}
