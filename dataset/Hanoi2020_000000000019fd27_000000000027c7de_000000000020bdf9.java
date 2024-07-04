import java.util.*;
import java.io.*;

//Parenting Partenerin
public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
		for (int i1 = 1; i1 <= t; ++i1) {
			
			int N = in.nextInt();
			StringBuilder sb = new StringBuilder();
			ArrayList<Integer[]> cal = new ArrayList<>();
			ArrayList<Integer[]> jal = new ArrayList<>();
			boolean canC = true, canJ = true, isPossible = true;


			for (int i = 0 ; i < N ; i++) {
				Integer[] tmp = {in.nextInt(), in.nextInt()};
				canC = true; canJ = true;

				for (Integer[] j : cal ) {
					if (!(tmp[1] <= j[0] || tmp[0] >= j[1])) {
						canC = false; break;
					}
				}

				if (canC) {
					cal.add(tmp);sb.append("C");
					continue;
				}

				for (Integer[] j : jal ) {
					if (!(tmp[1] <= j[0] || tmp[0] >= j[1])) {
						canJ = false; break;
					}
				}

				if (canJ) {
					jal.add(tmp);sb.append("J");
					continue;
				}

				if (!canJ && !canC) {
					isPossible = false;
					break;
				}

			}

			cal = null; jal = null;
			//System.out.println(Arrays.deepToString(cal.toArray()));
			//System.out.println(Arrays.deepToString(jal.toArray()));

			if(isPossible)
			System.out.println("Case #" + i1 + ": " + sb.toString());
			else System.out.println("Case #" + i1 + ": " + "IMPOSSIBLE");
		}
		//in.close();
	}

}
