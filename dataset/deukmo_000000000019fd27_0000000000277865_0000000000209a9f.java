import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int T = in.nextInt();
        for (int t=1; t<=T; t++) {
        	String S = in.next();
        	int[] digits = new int[S.length()];
        	for (int i=0; i<S.length(); i++) {
        		digits[i] = S.charAt(i) - '0';
        	}

    		System.out.print("Case #" + t + ": ");
    		printParenthesis(0, digits[0]);
    		System.out.print(digits[0]);
    		for (int i=1; i<S.length(); i++) {
    			printParenthesis(digits[i-1], digits[i]);
        		System.out.print(digits[i]);
        	}
    		printParenthesis(digits[S.length()-1], 0);
    		System.out.print("\n");
        }

        in.close();
	}
	
	private static void printParenthesis(int left, int right) {
		int diff = right - left;
		if (diff > 0) {
			for (int i=0; i<diff; i++) {
				System.out.print("(");
			}
		} else if (diff < 0) {
			for (int i=0; i<-diff; i++) {
				System.out.print(")");
			}
		}
	}
}