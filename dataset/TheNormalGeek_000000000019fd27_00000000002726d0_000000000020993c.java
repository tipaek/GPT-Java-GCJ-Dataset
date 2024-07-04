import java.io.*;
import java.util.*;
import java.math.*;

public class Solution {

	public void realMain() throws Exception {

		BufferedReader fin = new BufferedReader(new InputStreamReader(System.in), 1000000);

		String in = fin.readLine();

		int T = Integer.parseInt(in);

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

			int[][] m = new int[n][n];

			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					int ret = 0;
					boolean dig = false;
					for (int ch = 0; (ch = fin.read()) != -1; ) {
        					if (ch >= '0' && ch <= '9') {
            						dig = true;
           						ret = ret * 10 + ch - '0';
        					} else if (dig) break;
    					}

					m[i][j] = ret;
				}
			
			}

			int trace = 0;

			for(int i = 0; i < n; i++) {
				trace += m[i][i];
			}

			int r = 0;
			int c = 0;

			for(int i = 0; i < n; i++) {
				boolean[] has = new boolean[n + 1];
				boolean hasdup = false;

				for(int j = 0; j < n; j++) {
					if(has[ m[i][j] ]) {
						hasdup = true;
					}

					has[ m[i][j] ] = true;
				}
				
				if(hasdup) {
					r++;
				}
			}

			for(int j = 0; j < n; j++) {
				boolean[] has = new boolean[n + 1];
				boolean hasdup = false;

				for(int i = 0; i < n; i++) {
					if(has[ m[i][j] ]) {
						hasdup = true;
					}

					has[ m[i][j] ] = true;
				}
				
				if(hasdup) {
					c++;
				}
			}





			System.out.println("Case #" + t + ": " + trace + " " + r + " " + c);		
		}
	}


	public static void main(String[] args) throws Exception {
		Solution s = new Solution();
		s.realMain();
	}
}