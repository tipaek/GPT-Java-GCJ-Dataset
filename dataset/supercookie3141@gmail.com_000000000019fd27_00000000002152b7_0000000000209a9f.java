import java.util.Scanner;

public class Solution {
	public static void main(String[]args) {
		Scanner kboard = new Scanner(System.in);
		int t = kboard.nextInt();
		for(int i = 1; i <= t; i += 1) {
			String s = kboard.next();
			int nesting = Integer.parseInt(s.substring(0, 1));
			String solution = "";
			for(int j = 0; j < nesting; j += 1) {
				solution += "(";
			}
			solution += nesting;
			for(int j = 1; j < s.length(); j += 1) {
				int nesting2;
				if(j != s.length() - 1) {
					nesting2 = Integer.parseInt(s.substring(j, j + 1));
				}
				else {
					nesting2 = Integer.parseInt(s.substring(j));
				}
				
				if(nesting2 < nesting) {
					for(int k = 0; k < nesting - nesting2; k += 1) {
						solution += ")";
					}
				}
				else if(nesting2 > nesting) {
					for(int k = 0; k < nesting2 - nesting; k += 1) {
						solution += "(";
					}
				}
				solution += nesting2;
				nesting = nesting2;
			}
			for(int j = 0; j < nesting; j += 1) {
				solution += ")";
			}
			System.out.println("Case #" + i + ": " + solution);
		}
	}
}
