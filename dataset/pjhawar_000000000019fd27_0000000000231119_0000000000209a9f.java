import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int i = 1; i <= t; i++) {
			String s = sc.next();
			String res = getMinNestingDepth(s);
			System.out.println("Case #" + i + ": " + res);
		}
		sc.close();
	}

	private static String getMinNestingDepth(String s) {
		if(s == null || s.isEmpty()) return s;				
		StringBuilder sb = new StringBuilder();
		int first = s.charAt(0) - '0';
		while(first-- != 0) sb.append("(");		
		for(int i = 0; i < s.length() - 1; i++) {
			int a = s.charAt(i) - '0';
			int b = s.charAt(i + 1) - '0';
			sb.append(s.charAt(i));
			if(a == b) continue;
			else if(b > a) {
				int c = b - a;
				while(c-- != 0) sb.append("(");
			}
			else {
				int c = a - b;
				while(c-- != 0) sb.append(")");
			}
		}
		sb.append(s.charAt(s.length() - 1));
		int last = s.charAt(s.length() - 1) - '0';
		while(last-- != 0) sb.append(")");
		return sb.toString();
	}

}
