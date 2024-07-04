import java.util.Scanner;

public class Solution {


	public static void main(String[] args) {
		// TODO
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();

		for (int i=1;i<=t;i++) {
			int r = sc.nextInt();
			int c = sc.nextInt();
			int[][] floor = new int[r][c];
			for (int j=0;j<r;j++) {
				for (int k=0;k<c;k++) {
					floor[j][k]=sc.nextInt();
				}
			}
			
			long lastScore = 0;
			long sum = 0;
			while (true) {
				long roundScore = round(floor);
				if (roundScore==lastScore) {
					break;
				} else {
					lastScore = roundScore;
					sum += roundScore;
				}
			}
			
			System.out.println("Case #"+i+": "+sum);
		}
	}
	
	static int neighbor (int[][] floor, int x, int y, int dx, int dy) {
		int r = floor.length;
		int c = floor[0].length;
		int newX = x;
		int newY = y;
		while (true) {
			newX+=dx;
			newY+=dy;
			if (newX<0 || newX>=r || newY<0 || newY>=c) {
				return 0;
			}
			if (floor[newX][newY] > 0) {
				return floor[newX][newY];
			}
		}
	}
	
	static boolean eliminate (int[][] floor, int x, int y) {
		int sum = 0;
		int count = 0;
		int l = neighbor(floor,x,y,0,-1);
		if (l>0) {
			sum+=l;
			count++;
		}
		int d = neighbor(floor,x,y,1,0);
		if (d>0) {
			sum+=d;
			count++;
		}
		int r = neighbor(floor,x,y,0,1);
		if (r>0) {
			sum+=r;
			count++;
		}
		int u = neighbor(floor,x,y,-1,0);
		if (u>0) {
			sum+=u;
			count++;
		}
		return sum>count*floor[x][y];
	}
	
	static long round(int[][] floor) {
		int r = floor.length;
		int c = floor[0].length;
		long ret = 0;
		boolean[][] elimination = new boolean[r][c];
		for (int i=0;i<r;i++) {
			for (int j=0;j<c;j++) {
				ret += floor[i][j];
				elimination[i][j] = eliminate(floor, i, j);
			}
		}
		for (int i=0;i<r;i++) {
			for (int j=0;j<c;j++) {
				if (elimination[i][j]) {
					floor[i][j]=0;
				}
			}
		}
		return ret;
	}

}
