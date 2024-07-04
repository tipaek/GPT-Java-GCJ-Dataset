
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
	public static void main(String args[]) {

		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
		for (int i = 1; i <= t; ++i) {
			String s = in.next();
			printS(s, i);

		}
		in.close();
	}

	private static void printS(String s, int caseN) {
		StringBuilder res = new StringBuilder();
		// 1 2 3
		// (1(2(3)))
		// 112
		// (11(2))
		// 113
		// (11((3)))
		// 1131
		// (11((3))1)
		// 231
			// ((2(3))1)
		// 213
			// ((2)1((3)))
		int l = -1;
		int j;
		int bC = 0;
		for (int i = 0; i < s.length(); i++) {
			j = Integer.parseInt("" + s.charAt(i));
			if (l != j) {
				if (j - bC > 0) {
					int len = j - bC;
					for (int k = 0; k < len; k++) {
						res.append("(");
						bC++;
					}
					res.append(j);
				} else {
					int len = bC - j;
					for (int k = 0; k < len; k++) {
						res.append(")");
						bC--;
					}
					res.append(j);
				}
			} else {
				res.append(j);
			}
			
			l = j;
		}
		//System.out.println("bc:"+bC);
		while(bC>0) {
			res.append(")");
			bC--;
		}
		//System.out.println("bc:"+bC);
		System.out.println("Case #" + caseN + ": " + res.toString());
	}

}
