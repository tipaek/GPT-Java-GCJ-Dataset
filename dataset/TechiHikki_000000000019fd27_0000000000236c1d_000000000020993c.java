import java.util.*;
public class Solution {

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int T = stdIn.nextInt();
		
		for(int i = 0; i < T; i++) {
			int N = stdIn.nextInt();
			int[][] mat = new int[N][N];
			int tra = 0;
			int row = 0;
			int col = 0;
			for(int j = 0; j < N; j++) {
				boolean[] flag = new boolean[N];
				boolean a = false;
				Arrays.fill(flag,false);
				for(int k = 0; k < N; k++) {
					mat[j][k] = stdIn.nextInt();
					if(j == k) tra += mat[j][k];
					if(!flag[mat[j][k]-1]) flag[mat[j][k]-1] = true;
					else if(flag[mat[j][k]-1]) a = true;
				}
				if(a) row++;
			}
			
			for(int j = 0; j < N; j++) {
				boolean[] flag = new boolean[N];
				boolean a = false;
				Arrays.fill(flag,false);
				for(int k = 0; k < N; k++) {
					if(!flag[mat[k][j]-1]) flag[mat[k][j]-1] = true;
					else {
						a = true;
						break;
					}
				}
				if(a) col++;
			}
			System.out.println("Case #" +(i+1)+ ": " +tra+ " " +row+ " " +col);
		}

	}

}