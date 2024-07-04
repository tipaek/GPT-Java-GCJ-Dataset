import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		try (Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
				PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)))) {
			for (int testCases = in.nextInt(), testCase = 1; testCase <= testCases; testCase++) {
			    final int n = in.nextInt();
			    final String[] a = new String[n];
			    for (int i = 0; i < n; i++) {
			        a[i] = in.next();
			    }
				out.println("Case #" + testCase + ": " + solve(a));
			}
		}
	}

	private static String solve(String[] a) {
	    String prefix = "", suffix = "";
	    for (String s : a) {
	        final int i = s.indexOf("*");
	        final String x = s.substring(0, i), y = s.substring(i + 1, s.length());
	        if (x.length() > prefix.length()) {
	            if (!x.startsWith(prefix)) {
	                return "*";
	            }
	            prefix = x;
	        } else {
	            if (!prefix.startsWith(x)) {
	                return "*";
	            }
	        }
	        if (y.length() > suffix.length()) {
	            if (!y.endsWith(suffix)) {
	                return "*";
	            }
	            suffix = y;
	        } else {
	            if (!suffix.endsWith(y)) {
	                return "*";
	            }
	        }
	    }
		return prefix + suffix;
	}

}
