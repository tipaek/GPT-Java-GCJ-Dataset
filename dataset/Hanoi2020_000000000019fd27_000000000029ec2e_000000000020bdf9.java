import java.util.*;
import java.io.*;

//Parenting Partenering Returns
public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
		for (int i1 = 1; i1 <= t; ++i1) {
			
			int N = in.nextInt();
			StringBuilder sb = new StringBuilder();
			boolean[] cal = new boolean[24*60 + 1];
			boolean[] jal = new boolean[24*60 + 1];
			int si, se;

			boolean canC,canJ, isPossible = true;


			for (int i = 0 ; i < N ; i++) {
				si = in.nextInt();
				se = in.nextInt();
				canC = false; canJ = false;

				if (!cal[si + 1] && !cal[se - 1]) {
					for (int j = si ; j <= se; j++) cal[j] = true;
					sb.append('C'); canC = true; continue;

				} else if (!jal[si + 1] && !jal[se - 1]) {
					for (int j = si ; j <= se; j++) jal[j] = true;
					sb.append('J'); canJ = true; continue;
				}

				if (!canJ && !canC) {
					isPossible = false;
					break;
				}

			}

			if(isPossible)
			System.out.println("Case #" + i1 + ": " + sb.toString());
			else System.out.println("Case #" + i1 + ": " + "IMPOSSIBLE");
		}
		in.close();
	}

}
