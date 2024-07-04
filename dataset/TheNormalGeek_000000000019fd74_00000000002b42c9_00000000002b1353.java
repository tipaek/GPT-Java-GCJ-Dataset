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

				int n = ret2;

			if(n <= 500) {
				sb.append("Case #" + t + ":\n");
				for(int i = 1; i <= n; i++) {
					sb.append(i);
					sb.append(' ');
					sb.append(i);
					sb.append('\n');
				}
			} else {
				sb.append("Case #" + t + ":\n");
	
				int cursum = 0;

				sb.append(1);
				sb.append(' ');
				sb.append(1);
				sb.append('\n');

				cursum = 2;

				sb.append(2);
				sb.append(' ');
				sb.append(2);
				sb.append('\n');

				int nextadd = 2;


				while(cursum <= n) {
					if(cursum + nextadd <= n) {
						sb.append(nextadd + 1);
						sb.append(' ');
						sb.append(nextadd);
						sb.append('\n');
						cursum += nextadd;
						nextadd++;
					} else {
						break;
					}
				}

				int extra = n - cursum;

				//nextadd++;

				for(int i = 0; i < extra; i++) {
					sb.append(nextadd);
					sb.append(' ');
					sb.append(nextadd);
					sb.append('\n');
					nextadd++;
				}
			}




			

		}

		System.out.println(sb);

	}


	public static void main(String[] args) throws Exception {
		Solution s = new Solution();
		s.realMain();
	}
}