import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.nextLine());
		
		
		
		for (int x = 0; x < T; x++) {
			String newS = "";
			String S = sc.nextLine();
			newS = generateString(S);			
			System.out.format("Case #%d: %s\n", (x + 1), newS);
		}
		
		sc.close();
	}
	
	public static String generateString(String S) {
		char[] s = S.toCharArray();
		String newS = "";
		int paranthesisDepth = 0;
		int i = -1;
		while(++i < s.length) {
			int val = (int)s[i] - 48;
			if (paranthesisDepth < val) {
				while (paranthesisDepth < val) {
					newS += '(';
					paranthesisDepth++;
				}
			} else if (paranthesisDepth > val) {
				while (paranthesisDepth > val) {
					newS += ')';
					paranthesisDepth--;
				}
			}
			
			newS += s[i];
		}
		
		while (paranthesisDepth > 0) {
			newS += ')';
			paranthesisDepth--;
		}
		
		return newS;
	}
	
}
