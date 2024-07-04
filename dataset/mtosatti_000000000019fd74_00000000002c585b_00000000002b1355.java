import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {


	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int T = in.nextInt();
		for (int t = 1; t <= T; ++t) {
			int R = in.nextInt();
			int C = in.nextInt();
			int [][] s = new int[R][C];
			boolean [][] mm = new boolean[R][C];
			for(int r = 0; r < R; r++) {
				for(int c = 0; c < C; c++) {
					s[r][c] = in.nextInt();
				}
			}
			boolean el;
			int sum = 0;
			do {
				el = false;
				for(int r = 0; r < R; r++) {
					for(int c = 0; c < C; c++) {
						mm[r][c] = false;
						sum += s[r][c];
					}
				}

				for(int r = 0; r < R; r++) {
					for(int c = 0; c < C; c++) {
						if(s[r][c] < 1) continue;
						int m = 0;
						int q = 0;
						// u
						for (int ru = r - 1; ru >= 0; ru--) {
							if(s[ru][c] > 0) {
								m += s[ru][c];
								q++;
							}
						}
						// d
						for (int ru = r + 1; ru < R; ru++) {
							if(s[ru][c] > 0) {
								m += s[ru][c];
								q++;
							}
						}
						// l 
						for (int cu = c - 1; cu >= 0; cu--) {
							if(s[r][cu] > 0) {
								m += s[r][cu];
								q++;
							}
						}
						// r
						for (int cu = c + 1; cu < C; cu++) {
							if(s[r][cu] > 0) {
								m += s[r][cu];
								q++;
							}
						}
						
						if(s[r][c] < m/q) { 
							mm[r][c] = true;
						}
					}
				}
				
				for(int r = 0; r < R; r++) {
					for(int c = 0; c < C; c++) {
						if(mm[r][c]) {
							s[r][c] = 0;
							el = true;
						}
					}
				}
			} while (el);
				
			
			System.out.println("Case #" + t + ": " + sum);
		}
	}

}
