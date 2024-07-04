import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) {
		try (Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
				PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)))) {
			for (int testCases = in.nextInt(), testCase = 1; testCase <= testCases; testCase++) {
				out.println("Case #" + testCase + ": " + solve(in.nextInt(), in.nextInt()));
			}
		}
	}

	private static String solve(int x, int y) {
		return nextStep(x, y, 0, 0, 0, "");
	}
	
	private static String nextStep(int x0, int y0, int x, int y, int i, String s) {
	    String ans = "IMPOSSIBLE", t;
	    if (i > 7) return ans;
	    final int j = 1 << i;
	    if (x0 == x + j && y0 == y) return s + "E"; 
	    if (x0 == x - j && y0 == y) return s + "W"; 
	    if (x0 == x && y0 == y + j) return s + "N"; 
	    if (x0 == x && y0 == y - j) return s + "S";
	    t = nextStep(x0, y0, x + j, y, i + 1, s + "E"); if (t.length() < ans.length()) ans = t;
	    t = nextStep(x0, y0, x - j, y, i + 1, s + "W"); if (t.length() < ans.length()) ans = t;
	    t = nextStep(x0, y0, x, y + j, i + 1, s + "N"); if (t.length() < ans.length()) ans = t;
	    t = nextStep(x0, y0, x, y - j, i + 1, s + "S"); if (t.length() < ans.length()) ans = t;
	    return ans;
	}

}
