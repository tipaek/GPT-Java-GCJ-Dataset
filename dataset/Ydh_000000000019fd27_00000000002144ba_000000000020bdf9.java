

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuffer sb = new StringBuffer();

		int tc = Integer.parseInt(bf.readLine());

		StringBuffer imp = new StringBuffer("IMPOSSIBLE");
		for (int test_Case = 1; test_Case <= tc; test_Case++) {
			boolean[][] check = new boolean[2][1441];
			boolean result = true;

			StringBuffer cur = new StringBuffer();

			int cmd = Integer.parseInt(bf.readLine());

			for (int i = 0; i < cmd; i++) {

				st = new StringTokenizer(bf.readLine());
				boolean[] cj = { true, true };
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());

				if (!result)
					continue;

				for (int j = start; j < end; j++) {
					if (cj[0] && check[0][j])
						cj[0] = false;
					if (cj[1] && check[1][j])
						cj[1] = false;
				}

				if (cj[0]) {
					for (int j = start; j < end; j++) {
						check[0][j] = true;
					}
					cur.append('C');
				} else if (cj[1]) {
					for (int j = start; j < end; j++) {
						check[1][j] = true;
					}
					cur.append('J');
				} else {
					result = false;
				}

			}

			sb.append("Case #");
			sb.append(test_Case);
			sb.append(": ");
			if (result)
				sb.append(cur);
			else
				sb.append(imp);

			sb.append('\n');
		}
		System.out.println(sb.toString());
	}

}
