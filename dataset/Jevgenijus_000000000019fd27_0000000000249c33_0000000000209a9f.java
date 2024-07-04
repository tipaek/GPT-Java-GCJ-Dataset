import java.util.Scanner;

public class Solution {
	static Scanner reader = new Scanner(System.in);

	public static void main(String[] args) {
		int T = reader.nextInt();

		for (int t = 0; t < T; t++) {
			String inp = reader.next();
			// try with string cocncat
			int len = inp.length();
			StringBuffer sb = new StringBuffer();
			solve(inp,0,0,sb);
			System.out.printf("Case #%d: %s\n", t+1, sb.toString());
		}
	}
	
	static int solve(String inp, int index, int depth,StringBuffer sb) {
		if(index >= inp.length()) {
			if(depth!= 0) {
				sb.append(")");
			}
			return index;
		}
		int i = index;
		while(i<inp.length()) {
			int val = getInt(inp.charAt(i));
			if(val==depth) {
				sb.append(val);
				i++;
				continue;
			}
			if( val > depth) {
				sb.append("(");
				i = solve(inp,i,depth+1,sb);
			}
			if( val < depth) {
				sb.append(")");
				return i;
			}
		}
		
		if(i >= inp.length()) {
			if(depth!= 0) {
				sb.append(")");
			}
			return i;
		}
		return i;
		
	}
	
	static int getInt(char c) {
		return c - '0';
	}

}
