import java.util.Scanner;

public class Solution {
	static Scanner reader = new Scanner(System.in);
	public static void main(String[] args) {
		int T = reader.nextInt();
		
		for(int t= 0; t < T;t++) {
			int N = reader.nextInt();
			int rr =0;
			int cc =0;
			int kk = 0;
			int[][] mat = new int[N][N];
			for(int r =0; r < N; r++) {
				for(int c = 0; c < N; c++) {
					int val =reader.nextInt();
					if(c==r) {
						kk+= val;
					}
					mat[r][c] = val;
				}
			}
			for(int r= 0; r <N;r++) {
				int mem[] = new int[N];
				for(int c= 0; c <N; c++) {
					int in = mat[r][c]-1;
					if(mem[in]!=0) {
						rr++;
						break;
					}
					mem[in]++;
				}
			}
			for(int c= 0; c <N; c++) {
				int mem[] = new int[N];
				for(int r= 0; r <N;r++) {
					int in = mat[r][c]-1;
					if(mem[in]!=0) {
						cc++;
						break;
					}
					mem[in]++;
				}
			}
			
			System.out.printf("Case #%d: %d %d %d\n", t+1,kk,rr,cc);
		}
	}

}
