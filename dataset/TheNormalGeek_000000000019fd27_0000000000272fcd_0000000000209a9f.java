import java.io.*;
import java.util.*;
import java.math.*;

public class Solution {

	public void realMain() throws Exception {

		BufferedReader fin = new BufferedReader(new InputStreamReader(System.in), 1000000);

		String in = fin.readLine();

		int T = Integer.parseInt(in);

		for(int t = 1; t <= T; t++) {

			in = fin.readLine();
			
			StringBuilder sb = new StringBuilder("");

			int cur = 0;
			for(int i = 0; i < in.length(); i++) {
				while(in.charAt(i) - '0' < cur) {
					sb.append(')');
					cur--;
				}

				while(in.charAt(i) - '0' > cur) {
					sb.append('(');
					cur++;
				}

				sb.append(in.charAt(i));
			}

			while(cur > 0) {
				sb.append(')');
				cur--;
			}



			System.out.println("Case #" + t + ": " + sb);		
		}
	}


	public static void main(String[] args) throws Exception {
		Solution s = new Solution();
		s.realMain();
	}
}