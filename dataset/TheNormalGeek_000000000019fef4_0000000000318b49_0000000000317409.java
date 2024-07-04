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
			String[] ar = in.split(" ");

			int x = Integer.parseInt(ar[0]);
			int y = Integer.parseInt(ar[1]);

			String s = ar[2];

			int ind = 0;

			boolean can = false;
			
			while(ind < s.length()) {
				if(s.charAt(ind) == 'N') {
					y++;
				}
				if(s.charAt(ind) == 'S') {
					y--;
				}
				if(s.charAt(ind) == 'E') {
					x++;
				}
				if(s.charAt(ind) == 'W') {
					x--;
				}

				if(Math.abs(x) + Math.abs(y) <= (ind + 1)) {
					can = true;
					System.out.println("Case #" + t + ": " + (ind + 1));
					break;
				}

				ind++;
			}

			if(!can) {
				System.out.println("Case #" + t + ": IMPOSSIBLE");
			}




			

		}

	}


	public static void main(String[] args) throws Exception {
		Solution s = new Solution();
		s.realMain();
	}
}