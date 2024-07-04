import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution {

	static int X, Y;
	static StringBuffer buf = new StringBuffer();
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(in.readLine());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(in.readLine());
			X = Integer.parseInt(st.nextToken());
			Y = Integer.parseInt(st.nextToken());
			buf.append("Case #" + t + ": ");
			solve();
		}
		System.out.print(buf);
	}	
	
	static void solve() {
		int sX = X>=0?0:1;
		int sY = Y>=0?0:1;
		X = Math.abs(X);
		Y = Math.abs(Y);
		if (X%2==Y%2) {
			buf.append("IMPOSSIBLE\n");
			return;
		}
		StringBuffer sol = new StringBuffer();
		while (X+Y>1) {
			if (X%2==1) {
				X=X/2;
				Y=Y/2;
				if(X%2==Y%2) {
					X++;
					if (sX==0) sol.append('W');
					else sol.append('E');
				}else {
					if (sX==0) sol.append('E');
					else sol.append('W');
				}
			}else {
				X=X/2;
				Y=Y/2;
				if(X%2==Y%2) {
					Y++;
					if (sY==0) sol.append('S');
					else sol.append('N');
				}else {
					if (sY==0) sol.append('N');
					else sol.append('S');
				}
			}
		}
		if (X==1 && sX==0) sol.append("E");
		if (X==1 && sX==1) sol.append("W");
		if (Y==1 && sY==0) sol.append("N");
		if (Y==1 && sY==1) sol.append("S");
		buf.append(sol.toString() + "\n");
	}
	
}