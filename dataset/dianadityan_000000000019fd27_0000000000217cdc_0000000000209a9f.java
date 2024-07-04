import java.util.*;
import java.io.*;
	
public class Solution {
	public static void main(String args[]) throws FileNotFoundException {
		/* INPUT */
//		Scanner in = new Scanner(new File("./input.txt"));
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));	
		
		/* VARIABLE */
		int T, len, curParenthesis, curChar;
		String S;
		String SRes;
		
		T = in.nextInt();
		for(int testCase=1; testCase<=T; testCase++) {
			S = in.next();
			SRes = "";
			
			len = S.length();
			curParenthesis = 0;
			for(int i=0; i<len; i++) {
				if(curParenthesis != S.charAt(i) - '0') {
					curChar = S.charAt(i) - '0';
					
					if(curChar > curParenthesis) {
						for(int j=0; j<Math.abs(curChar - curParenthesis); j++) {
							SRes += "(";
						}
					} else {
						for(int j=0; j<Math.abs(curChar - curParenthesis); j++) {
							SRes += ")";
						}
					}
					
					curParenthesis = curChar;
					SRes += curParenthesis;
				} else {
					SRes += curParenthesis;
				}
			}
			
			for(int j=0; j<curParenthesis; j++) {
				SRes += ")";
			}
			
			System.out.println("Case #" + testCase + ": " + SRes);
		}
		
		in.close();
	}
}
