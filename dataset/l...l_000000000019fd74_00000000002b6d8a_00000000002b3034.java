import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int N;
	static String[][] P;
	static StringBuffer buf = new StringBuffer();
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(in.readLine());
			P = new String[N][];
			for (int i = 0; i < N; i++) {
				P[i] = parse(in.readLine());
			}
			buf.append("Case #" + t + ": ");
			solve();
		}
		System.out.print(buf);
	}	
	
	static void solve() {
		String A = common_pre();
		if (A==null) {
			buf.append("*\n");
			return;
		}
		String B = common_suf();
		if (B==null) {
			buf.append("*\n");
			return;
		}
		StringBuffer sol = new StringBuffer();
		sol.append(A);
		for (int i = 0; i < N; i++) {
			for (int j = 1; j < P[i].length-1; j++) {
				sol.append(P[i][j]);
			}
		}
		sol.append(B);
		buf.append(sol);
		buf.append("\n");
	}	

	static String common_pre() {
		String W = "";
		for (int i = 0; i < N; i++) {
			String T = P[i][0];
			if (W.startsWith(T)) continue;
			else {
				if (!T.startsWith(W)) return null; 
				W = T;
			}
		}
		return W;
	}	
	
	static String common_suf() {
		String W = "";
		for (int i = 0; i < N; i++) {
			String T = P[i][P[i].length-1];
			if (W.endsWith(T)) continue;
			else {
				if (!T.endsWith(W)) return null; 
				W = T;
			}
		}
		return W;
	}	
	
	static String[] parse(String S) {
		S = "$" + S + "$";
		String[] X = S.split("\\*+");
		if (X[0].equals("$")) X[0] = "";
		else X[0] = X[0].substring(1);
		if (X[X.length-1].equals("$")) X[X.length-1] = "";
		else X[X.length-1] = X[X.length-1].substring(0, X[X.length-1].length()-1);
		return X;
	}
}