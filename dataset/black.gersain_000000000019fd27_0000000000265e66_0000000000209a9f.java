import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int T = scanner.nextInt();
		scanner.nextLine();
		for (int i = 0; i < T; i++) {
			String s = scanner.nextLine();
			
			System.out.println("Case #" + (i + 1) + ": " + nestingDepth(s));
		}
		scanner.close();
	}
	
	public static String nestingDepth(String s) {
		String s_ = "";
		int depth = 0;
		for (int i = 0; i < s.length(); i++) {
			int digit = Integer.parseInt(s.substring(i, i + 1));
			
			if (depth < digit) {
				while (depth < digit) {
					s_ += "(";
					depth++;
				}	
			}
			else if (depth > digit) {
				while (depth > digit) {
					s_ += ")";
					depth--;
				}
			}
			s_ += digit;
		}
		
		while (depth > 0) {
			s_ += ")";
			depth--;
		}
		return s_;
	}
}
