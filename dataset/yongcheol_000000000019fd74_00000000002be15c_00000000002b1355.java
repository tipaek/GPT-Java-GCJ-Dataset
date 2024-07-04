import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
	
	
	public static int compute(int[][] mat, int R, int C) {
		int ret = 0;
		
		for(int i = 0; i < R; i++) 
			for(int j= 0; j < C; j++) {
				ret += mat[i][j];
			}
		
		return ret;
	}
	
	public static int findupCompetitor(int[][] mat, int r, int c) {
		int ret = 0;
		
		int R = mat.length;
		
		while(r >= 0) {
			if(mat[r][c] != 0) {
				ret = mat[r][c];
				break;
			}
			r--;
		}
		
		return ret;
	}
	public static int finddownCompetitor(int[][] mat, int r, int c) {
		int ret = 0;
		
		int R = mat.length;
		
		while(r < R) {
			if(mat[r][c] != 0) {
				ret = mat[r][c];
				break;
			}
			r++;
		}
		
		return ret;
	}
	public static int findleftCompetitor(int[][] mat, int r, int c) {
		int ret = 0;
		
		int C = mat[0].length;
		
		while(c >= 0) {
			if(mat[r][c] != 0) {
				ret = mat[r][c];
				break;
			}
			c--;
		}
		
		return ret;
	}
	public static int findrightCompetitor(int[][] mat, int r, int c) {
		int ret = 0;
		
		int C = mat[0].length;
		
		while(c < C) {
			if(mat[r][c] != 0) {
				ret = mat[r][c];
				break;
			}
			c++;
		}
		
		return ret;
	}
	
	public static boolean compareCompetitor(int[][] mat, int R, int C) {
		
		boolean ret = false;

		int[][] result = new int[R][C];
		
		for(int r = 0; r < R; r++) {
			for(int c = 0; c < C ; c++) {
				
				int upCompetitor = findupCompetitor(mat, r-1, c);
				int downCompetitor= finddownCompetitor(mat, r+1, c);
				int leftCompetitor= findleftCompetitor(mat, r, c-1);
				int rightCompetitor = findrightCompetitor(mat, r, c+1);
				
				int cnt = 0;
				double avg = upCompetitor + downCompetitor + leftCompetitor + rightCompetitor;
				
				if(upCompetitor > 0)cnt++;
				if(downCompetitor > 0) cnt++;
				if(leftCompetitor > 0) cnt++;
				if(rightCompetitor > 0) cnt++;
				
				if(cnt != 0)
					avg /= cnt;
				else 
					avg = 0;
				
				if((double)mat[r][c] < avg && avg > 0) {
					result[r][c] = 0;
				} else {
					result[r][c] = mat[r][c];
				}
			}
		}
		
		for(int r = 0; r < R; r++) {
			for(int c = 0; c < C ; c++) {
				if(mat[r][c] != result[r][c])
					ret = true;
			}
		}
		
		for(int r = 0; r < R; r++) {
			for(int c = 0; c < C ; c++) {
				mat[r][c] = result[r][c];
			}
		}
		return ret;
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		
		int T = sc.nextInt();
		
		for(int tc = 1 ; tc <=T ;tc++) {
		
			int R = sc.nextInt();
			int C = sc.nextInt();
			
			int[][] mat = new int[R][C];
			
			for(int i = 0; i < R; i++)
				for(int j = 0; j < C; j++)
					mat[i][j] = sc.nextInt();
			
			int sum = 0;
			boolean isContinue = true;
			while(isContinue) {
				
				sum += compute(mat, R, C);
				
				isContinue = compareCompetitor(mat, R, C);
				
			}
			
			System.out.println("Case #" + tc + ": " + sum);
		}
	}
	
}
