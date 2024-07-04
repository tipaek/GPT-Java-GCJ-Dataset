import java.util.Arrays;
import java.util.Scanner;

public class Solution {


	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc = 1; tc <=T; tc++) {
			int k = 0, r = 0, c=0;
			
			int N = sc.nextInt();
			int[][] mat = new int[N][N];
			
			for(int i = 0; i < N; i++) 
				for(int j= 0; j < N; j++) {
					mat[i][j] = sc.nextInt();
				}
			
			k = computeTrace(mat, N);
			r = computeRepeatedRow(mat, N);
			c = computeRepeatedCol(mat, N);
			
			System.out.println("Case #" + tc + ": " + k + " " + r + " " + c);
		}
	}
	
    public static int computeTrace(int[][] mat, int N) {

		int sum = 0;
		for(int i=0; i < N; i++) {
			sum += mat[i][i];
		}
		
		return sum;
	}
	
	public static int computeRepeatedRow(int[][] mat, int N) {
		
		int cnt = 0;
		
		boolean[] used = new boolean[N+1];
		boolean repeat = false;
		
		for(int i= 0; i < N; i++) {
			Arrays.fill(used, false);
			repeat = false;
			for(int j= 0; j < N; j++) {
				if(!used[mat[i][j]]) used[mat[i][j]] = true;
				else {
					repeat = true;
					break;
				}
			}
			if(repeat) cnt++;
		}
		
		return cnt;
	}
	
	public static int computeRepeatedCol(int[][] mat, int N) {
	
		int cnt = 0;
		
		boolean[] used = new boolean[N+1];
		boolean repeat = false;
		
		for(int i= 0; i < N; i++) {
			Arrays.fill(used, false);
			repeat = false;
			for(int j= 0; j < N; j++) {
				if(!used[mat[j][i]]) used[mat[j][i]] = true;
				else {
					repeat = true;
					break;
				}
			}
			if(repeat) cnt++;
		}
		
		return cnt;
	
	}

}
