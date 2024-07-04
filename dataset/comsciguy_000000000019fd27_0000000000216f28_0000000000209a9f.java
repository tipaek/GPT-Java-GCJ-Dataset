import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for (int tci = 0; tci < tc; tci++) {
			String x = br.readLine();
			Stack<Character> st = new Stack<Character>();
			
			for (int i = 0; i < x.length(); i++) {
				int cur = Integer.parseInt(""+x.charAt(i));
				for (int j = 0; j < cur; j++) {
					if (!st.isEmpty() && st.peek() == ')')
						st.pop();
					else 
						st.push('(');
				}
				st.push((char)(cur + '0'));
				for (int j = 0; j < cur; j++)
					st.push(')');
			}
					
			String res = "";
			for (char y : st) 
				res += y;
			
			System.out.printf("Case #%d: %s\n", tci+1, res);
		}
	}
}
