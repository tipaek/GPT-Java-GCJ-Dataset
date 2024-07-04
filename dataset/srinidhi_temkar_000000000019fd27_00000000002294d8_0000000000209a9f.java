import java.util.*;
class Solution {
    public static String insertOpen(int n, String S) {
		while(n-- > 0) {
			S += "(";
		}
		return S;
	}
	public static String insertClosed(int n, String S) {
		while(n-- > 0) {
			S += ")";
		}
		return S;
	} 
	public static String nesting(String S) {
		int len = S.length();
		String S1 = new String();
		int depth = 0;
		int currDigit;
		for(int i=0; i<len; i++) {
			currDigit = S.charAt(i) - '0';
			if(depth < currDigit) {
				S1 = insertOpen(currDigit-depth, S1);
				depth = currDigit;
			}
			else if(depth > currDigit) {
				S1 = insertClosed(depth-currDigit, S1);
				depth = currDigit;
			}
			S1+=currDigit;
		}	
		S1 = insertClosed(depth, S1);
		return S1;
	}

	public static void main(String[] args) {
		int t;
		String S;
		Scanner scan = new Scanner(System.in);
		t = scan.nextInt();
		for(int c=1; c<=t; c++) {
			S = scan.next();
			System.out.println("Case #"+c+": "+nesting(S));
		}
	}
}