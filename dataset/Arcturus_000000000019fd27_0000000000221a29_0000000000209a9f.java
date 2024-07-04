import java.util.*;
import java.io.*;

public class Solution {
	
	public static void printOpenParens(int count) {
		for(int i = 0; i < count; i++) {
			System.out.print("(");
		}
	}
	
	public static void printCloseParens(int count) {
		for(int i = 0; i < count; i++) {
			System.out.print(")");
		}
	}
	
	public static void nestingDepth(int caseNum, Scanner in) {
		System.out.print("Case #" + caseNum + ": ");

		String digits = in.nextLine();
		
		int level = 0;
		
		for(int i = 0; i < digits.length(); i++) {
			int digit = digits.charAt(i) - 48;
			if(digit > level) {
				printOpenParens(digit - level);
			} else {
				printCloseParens(level - digit);
			}
			
			level = digit;
			
			System.out.print(digit);
		}
		
		printCloseParens(level);
		System.out.println();
		
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	    int cases = in.nextInt(); 
	    in.nextLine();
	    for (int i = 1; i <= cases; i++) {
	    	nestingDepth(i, in);
	    }
	    in.close();
	}
}
