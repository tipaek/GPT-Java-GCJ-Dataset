import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int i=0; i<T; i++) {
			System.out.printf("Case #%d: ", i+1);
			solve(sc);
		}
		
		sc.close();
	}
	
	static void solve(Scanner sc) {
		final int[] dx = {0, 1, 0, -1};
		final int[] dy = {1, 0, -1, 0};
		
		int R = sc.nextInt();
		int C = sc.nextInt();
		long[][] v = new long[R][C];
		for(int i=0; i<R; i++)
			for(int j=0; j<C; j++)
				v[i][j] = sc.nextLong();
		
		long ans = 0;
		boolean updated = true;
		
		int[][][] check = new int[R][C][4];
		
		while(updated) {
			updated = false;
			
			long[][] next = new long[R][C];
			
			for(int i=0; i<R; i++) {
				for(int j=0; j<C; j++) {
					if(v[i][j]==0)
						continue;
					ans += v[i][j];
					long neighbor = 0;
					long sum = 0;
					for(int d=0; d<4; d++) {
						int ny=i+dy[d]*check[i][j][d];
						int nx=j+dx[d]*check[i][j][d];
						while(true) {
							ny += dy[d];
							nx += dx[d];
							if(ny<0 || ny>=R || nx<0 || nx>=C) {
								break;
							}
							if(v[ny][nx]>0) {
								neighbor++;
								sum += v[ny][nx];
								break;
							}
							check[i][j][d]++;
						}
					}
					if(sum>=1 && v[i][j]*neighbor < sum) {
						updated = true;
					} else {
						next[i][j] = v[i][j];
					}
				}
			}
			
			v = next;
		}
		
		System.out.println(ans);
	}
}
