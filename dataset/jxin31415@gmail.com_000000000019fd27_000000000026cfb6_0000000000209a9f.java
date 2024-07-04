import java.util.*;
import java.io.*;
import java.util.concurrent.TimeUnit;

public class Solution {
	static BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	
    public static void main (String [] args) throws IOException {
	    int T = Integer.parseInt(f.readLine());
	    for(int t = 1; t <= T; t++) {
	    	out.println("Case #" + t + ": " + solve());
	    }
	    
	    out.close();
	    f.close();
	}
	
	public static String solve() throws IOException {
		String s = f.readLine();
		StringBuilder sb = new StringBuilder("");
		
		int depth = 0;
		for(int i = 0; i < s.length(); i++) {
			while(depth < s.charAt(i)-48) {
				sb.append('(');
				depth++;
			}
			while(depth > s.charAt(i)-48) {
				sb.append(')');
				depth--;
			}
			sb.append(s.charAt(i));
		}
		while(depth > 0) {
			sb.append(')');
			depth--;
		}
		return sb.toString();
	}
}