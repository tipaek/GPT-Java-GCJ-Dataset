import java.io.*;
import java.util.*;

public class Solution {
	static int X, Y;
	static int motion[] = new int[1005];
	static int motion_len;
	static int dx[] = {0, 1, 0, -1};
	static int dy[] = {1, 0, -1, 0};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder out = new StringBuilder();
		StringTokenizer st;
		int numcases = Integer.parseInt(br.readLine());
		for (int casenum = 1; casenum <= numcases; casenum++) {
			st = new StringTokenizer(br.readLine());
			X = Integer.parseInt(st.nextToken());
			Y = Integer.parseInt(st.nextToken());
			String M = st.nextToken();
			motion_len = M.length();
			for (int i = 0; i < M.length(); i++) {
				switch (M.charAt(i)) {
					case 'N': 
						motion[i] = 0;
						break;
					case 'E': 
						motion[i] = 1;
						break;
					case 'S': 
						motion[i] = 2;
						break;
					case 'W': 
						motion[i] = 3;
						break;
				}
			}
			int x = X;
			int y = Y;
			int ans = -1;
			for (int i = 0; i <= motion_len; i++) {
				if (Math.abs(x) + Math.abs(y) <= i) {
					ans = i;
					break;
				}
				x += dx[motion[i]];
				y += dy[motion[i]];
			}
			if (ans == -1)
				System.out.printf("Case #%d: IMPOSSIBLE\n", casenum);
			else
				System.out.printf("Case #%d: %d\n", casenum, ans);
		}
		System.out.print(out);
	}
}