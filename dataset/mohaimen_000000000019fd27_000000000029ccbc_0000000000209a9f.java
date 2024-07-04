
import java.util.Scanner;

public class Solution {
	
	public static void main(String [] args) {
		
		Scanner scanner = new Scanner(System.in);
		int tests = scanner.nextInt();
	
		for(int t = 0; t< tests; t++) {
			
			String s = scanner.next();
			StringBuilder res = new StringBuilder();
			char last = s.charAt(0);
			
			if(last == '0') {
				res.append('0');
			}else {
				res.append("(1");
			}
			 
			for(int i = 1; i < s.length(); i++) {
				if(s.charAt(i) == '1' && last != '1') {
					res.append('(');
				}else if(s.charAt(i) == '0' && last == '1') {
					res.append(')');
				}
				last = s.charAt(i);
				res.append(last);
			}
			
			if(s.charAt(s.length() - 1) == '1') {
				res.append(')');
			}
			
			System.out.println("Case #" + (t + 1) + ": " + res);
			
		}
	
	}
}
