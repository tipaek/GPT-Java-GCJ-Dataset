import java.io.*;
import java.util.*;
import java.math.*;

public class Solution {

	public void realMain() throws Exception {

		BufferedReader fin = new BufferedReader(new InputStreamReader(System.in), 1000000);

		String in = fin.readLine();

		int T = Integer.parseInt(in);

		StringBuilder sb = new StringBuilder("");

		for(int t = 1; t <= T; t++) {
				int ret2 = 0;
				boolean dig2 = false;
				for (int ch = 0; (ch = fin.read()) != -1; ) {
        				if (ch >= '0' && ch <= '9') {
            					dig2 = true;
           					ret2 = ret2 * 10 + ch - '0';
        				} else if (dig2) break;
    				}

				int r = ret2;

				ret2 = 0;
				dig2 = false;
				for (int ch = 0; (ch = fin.read()) != -1; ) {
        				if (ch >= '0' && ch <= '9') {
            					dig2 = true;
           					ret2 = ret2 * 10 + ch - '0';
        				} else if (dig2) break;
    				}

				int s = ret2;

			int num = (r - 1) * (s - 1);

			int[] p1 = new int[num];
			int[] p2 = new int[num];

			int ind = 0;

			for(int i = 0; i < r - 1; i++) {
				for(int j = 0; j < s - 1; j++) {
					
					p1[ind] = (r - i) * s - (r - (i + 1)) - 1 - j;
					p2[ind] = r - (i + 1);

					ind++;
				}
			}

			
			sb.append("Case #" + t + ": " + num + "\n");

			for(int i = 0; i < num; i++) {
				sb.append(p1[i] + " " + p2[i] + "\n");
			}

		}

		System.out.println(sb);

	}


	public static void main(String[] args) throws Exception {
		Solution s = new Solution();
		s.realMain();
	}
}