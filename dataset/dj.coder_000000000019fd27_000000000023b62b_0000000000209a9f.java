import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
	
	static String solve(String S) {
		StringBuilder S1 = new StringBuilder();
		int l = S.length();
		int t = 0;
		for(int i = 0; i < l; i++) {
			char ch = S.charAt(i);
			int d = ch - 48;
			int diff = d - t;
			if(diff > 0) {
				// open parentheses
				for(int j = 0; j < diff; j++) {
					S1.append('(');
				}
			} else if(diff < 0) {
				// closing parentheses
				diff *= - 1;
				for(int j = 0; j < diff; j++) {
					S1.append(')');
				}
			}
			S1.append(ch);
			
			t = d;
		}
		
		// closing parentheses
		int diff = S.charAt(l - 1) - 48;
		for(int j = 0; j < diff; j++) {
			S1.append(')');
		}
		
		return S1.toString();
	}
	
	static final String NEW_LINE = System.getProperty("line.separator");
	
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(reader.readLine());
		int tc = 0;
		StringBuilder out = new StringBuilder();
		while(++tc <= T) {
			String S = reader.readLine();
			out.append("Case #").append(tc).append(": ").append(solve(S)).append(NEW_LINE);
		}
		System.out.println(out);
		
		reader.close();
	}
}