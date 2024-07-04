import java.io.PrintStream;
import java.math.BigInteger;
import java.util.*;
import java.util.Map.Entry;

/**
 * 2020-Q. Nesting Depth
 * @author Albert Choi
 */
public class Solution {
	static Scanner in = new Scanner(System.in);
	static PrintStream sout = System.out, serr = System.err;
	static int nint() {return in.nextInt();}
	static long nlong() {return in.nextLong();}
	static BigInteger nbig() {return in.nextBigInteger();}
	static String nline() {return in.nextLine();}

	public static void main(String[] args) {
		int T = nint(); nline();
		for (int t=1; t<=T; t++) {
			sout.println("Case #" + t + ": " + String.valueOf(
					new Solution().doProblem()
			));
		}
	}

	Object doProblem() {
		char[] s = nline().toCharArray();
		int lv = 0;
		StringBuilder sb = new StringBuilder();
		for (int i=0; i < s.length; i++) {
			char c = s[i];
			int d = c - '0';
			while (lv < d) {
				sb.append('(');
				lv++;
			}
			while (lv > d) {
				sb.append(')');
				lv--;
			}
			sb.append(d);
		}
		while (lv > 0) {
			sb.append(')');
			lv--;
		}
		return sb;
	}
}