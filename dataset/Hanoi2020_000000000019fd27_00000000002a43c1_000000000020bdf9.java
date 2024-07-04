import java.util.*;
import java.io.*;

//Parenting Partenering Returns
public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
		for (int ijk = 1; ijk <= t; ++ijk) {
			
			int N = in.nextInt();
			String ans;
			StringBuilder sb = new StringBuilder();
			boolean[] cal = new boolean[1442];
			boolean[] jal = new boolean[1442];
			int si, se;
			boolean canC,canJ, isPossible = true;

			for (int i = 0 ; i < N ; i++) {
				si = in.nextInt();
				se = in.nextInt();
				canC = false; canJ = false;

				if (cal[si + 1] == false && cal[se] == false || cal[si] == false && cal[se -1] == false) {
					for (int j = si ; j <= se; j++) cal[j] = true;
					sb.append('C'); canC = true; continue;

				} else if (jal[si + 1] == false && jal[se] == false || jal[si] == false && jal[se -1] == false) {
					for (int k = si ; k <= se; k++) jal[k] = true;
					sb.append('J'); canJ = true; continue;
				} else {
					isPossible = false;
					break;
				}
			}

			ans = sb.toString();

			if(isPossible)
			System.out.println("Case #" + ijk + ": " + ans);
			else System.out.println("Case #" + ijk + ": " + "IMPOSSIBLE");
		}
		//in.close();
	}

}
