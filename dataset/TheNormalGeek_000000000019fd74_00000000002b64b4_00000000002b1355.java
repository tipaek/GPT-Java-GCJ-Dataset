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

				int r = ret2;

				 ret2 = 0;
				dig2 = false;
				for (int ch = 0; (ch = fin.read()) != -1; ) {
        				if (ch >= '0' && ch <= '9') {
            					dig2 = true;
           					ret2 = ret2 * 10 + ch - '0';
        				} else if (dig2) break;
    				}

				int c = ret2;

			int[][] a = new int[r][c];
			boolean[][] act = new boolean[r][c];

			for(int i = 0; i < r; i++) {
				for(int j = 0; j < c; j++) {
				
				int ret = 0;
				boolean dig = false;
				for (int ch = 0; (ch = fin.read()) != -1; ) {
        				if (ch >= '0' && ch <= '9') {
            					dig = true;
           					ret = ret * 10 + ch - '0';
        				} else if (dig) break;
    				}

				a[i][j] = ret;
				act[i][j] = true;
				
				}
			}

			long ans = 0;

			boolean stillgoing = true;

			
			while(stillgoing) {
				stillgoing = false;

				boolean[][] tobeactive = new boolean[r][c];


				for(int i = 0; i < r; i++) {
					for(int j = 0; j < c; j++) {
						if(act[i][j]) {
							ans += a[i][j];
						}
					}
				}

				for(int i = 0; i < r; i++) {
					for(int j = 0; j < c; j++) {
						if(!act[i][j]) {
							continue;
						}

	
						int numneigh = 0;
						long neighsum = 0;
						//go left
						for(int k = j - 1; k >= 0; k--) {
							if(act[i][k]) {
								numneigh++;
								neighsum += a[i][k];
								break;
							}
						}

						//go right
						for(int k = j + 1; k < c; k++) {
							if(act[i][k]) {
								numneigh++;
								neighsum += a[i][k];
								break;
							}
						}

						//go up
						for(int k = i - 1; k >= 0; k--) {
							if(act[k][j]) {
								numneigh++;
								neighsum += a[k][j];
								break;
							}
						}

						//go down
						for(int k = i + 1; k < r; k++) {
							if(act[k][j]) {
								numneigh++;
								neighsum += a[k][j];
								break;
							}
						}

						if(numneigh * a[i][j] < neighsum) {
							tobeactive[i][j] = false;
							stillgoing = true;
						} else {
							tobeactive[i][j] = true;
						}
					}
				}

				for(int i = 0; i < r; i++) {
					for(int j = 0; j < c; j++) {
						act[i][j] = tobeactive[i][j];
					}
				}
			}

			





			System.out.println("Case #" + t + ": " + ans);

		}

	}


	public static void main(String[] args) throws Exception {
		Solution s = new Solution();
		s.realMain();
	}
}