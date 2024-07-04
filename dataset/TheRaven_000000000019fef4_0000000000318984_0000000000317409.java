import java.util.*;
public class Solution {
	public static void main (String [] arg) {
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.nextLine());
		for (int ii = 1; ii<=T; ++ii) {
			int X = sc.nextInt();
			int Y = sc.nextInt();
			char [] M = sc.next().toCharArray();
			int ans = Integer.MAX_VALUE;
			int step = 0;
			for (char c : M) {
				if (Math.abs(X) + Math.abs(Y) <= step ) {
					ans = Math.min(ans, step);
				}
				if (c == 'N') Y++;
				if (c == 'S') Y--;
				if (c == 'E') X++;
				if (c == 'W') X--;
				step++;
			}
			if (Math.abs(X) + Math.abs(Y) <= step )
				ans = Math.min(ans, step);
			

			System.out.printf("Case #%d: %s\n",ii, (ans == Integer.MAX_VALUE) ? "IMPOSSIBLE" : ans+"");
		}
	}
}