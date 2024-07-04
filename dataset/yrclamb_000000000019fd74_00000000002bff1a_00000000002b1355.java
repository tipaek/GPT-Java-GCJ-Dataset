import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Solution {
	
	public long solve(long[][] M) {
		
		long ans = 0;
		boolean ok = false;
		while(!ok) {
			Map<Integer, Long> sum = new HashMap<>();
			Map<Integer, Long> cnt = new HashMap<>();
			
			for(int i = 0; i < M.length; i++) {
				int curX = -1;
				int curY = -1;
				for(int j = 0; j < M[0].length; j++) {
					ans += M[i][j];
					if(M[i][j] != 0) {
						if(curX == -1) {
							curX = i;
							curY = j;
						}
						else {
							long s = sum.getOrDefault(i*1000+j, 0L);
							sum.put(i*1000+j, s+M[curX][curY]);
							long c = cnt.getOrDefault(i*1000+j, 0L);
							cnt.put(i*1000+j, c+1);
							
							s = sum.getOrDefault(curX*1000+curY, 0L);
							sum.put(curX*1000+curY, s+M[i][j]);
							c = cnt.getOrDefault(curX*1000+curY, 0L);
							cnt.put(curX*1000+curY, c+1);
							
							curX = i;
							curY = j;
						}
					}
				}
			}
			
			for(int j = 0; j < M[0].length; j++) {
				int curX = -1;
				int curY = -1;
				for(int i = 0; i < M.length; i++) {
					if(M[i][j] != 0) {
						if(curX == -1) {
							curX = i;
							curY = j;
						}
						else {
							long s = sum.getOrDefault(i*1000+j, 0L);
							sum.put(i*1000+j, s+M[curX][curY]);
							long c = cnt.getOrDefault(i*1000+j, 0L);
							cnt.put(i*1000+j, c+1);
							
							s = sum.getOrDefault(curX*1000+curY, 0L);
							sum.put(curX*1000+curY, s+M[i][j]);
							c = cnt.getOrDefault(curX*1000+curY, 0L);
							cnt.put(curX*1000+curY, c+1);
							
							curX = i;
							curY = j;
						}
					}
				}
			}
			//System.out.println(sum);
			//System.out.println(cnt);
			ok = true;
			for(int k : sum.keySet()) {
				long s = sum.get(k);
				long c = cnt.get(k);
				
				if(M[k/1000][k%1000] * c < s) {
					ok = false;
					M[k/1000][k%1000] = 0;
					//System.out.println("eliminated: " + k/1000 + ", " + k%1000);
				}
			}
		}
		
		
		return ans;
	}
	
	public static void mainX(String[] args) {
		Solution Q = new Solution();
		System.out.println(Q.solve(new long[][] {{15}}));
		System.out.println(Q.solve(new long[][] {{1,1,1},{1,2,1},{1,1,1}}));
		System.out.println(Q.solve(new long[][] {{3,1,2}}));
		System.out.println(Q.solve(new long[][] {{1,2,3}}));
	}
	
	
	public static void main(String[] args) throws FileNotFoundException {
		Solution Q = new Solution();
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
		in.nextLine();
		for (int i = 1; i <= t; ++i) {
			int R = in.nextInt();
			int C = in.nextInt();
			in.nextLine();
			long[][] M = new long[R][C];
			for(int ii = 0; ii < R; ii++) {
				for(int jj = 0; jj < C; jj++) {
					M[ii][jj] = in.nextInt();
				}
				in.nextLine();
			}
			long output = Q.solve(M);
			System.out.println("Case #" + i + ": " + output);
			//for(String s : output) System.out.println(s);
			System.out.flush();
		}
	}

}
