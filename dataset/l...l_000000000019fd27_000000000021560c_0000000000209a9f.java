import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

	static StringBuffer buf = new StringBuffer();
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for (int t = 1; t <= T; t++) {
			buf.append("Case #" + t + ": ");
			solve(in.readLine().toCharArray());
		}
		System.out.print(buf);
	}
	
	static void solve(char[] S) {
		int N = S.length;
		int[] D = new int[N];
		for (int i = 0; i < N; i++) D[i] = S[i]-'0';
		StringBuffer sol = new StringBuffer();
		int open = 0;
		for (int i = 0; i < N; i++) {
			if (D[i]>open) {
				append(sol, '(', D[i]-open);
				open = D[i];
			}else if (D[i]<open) {
				append(sol, ')', open-D[i]);
				open = D[i];
			}
			append(sol, (char)(D[i]+'0'), 1);
		}
		append(sol, ')', open);
		buf.append(sol.toString()+"\n");
	}
	
	static void append(StringBuffer sol, char c, int n) {
		for (int i = 0; i < n; i++) sol.append(c);
	} 
}
