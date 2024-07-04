import java.util.*;


public class Solution {
	private static int t;
	private static int n;
	//private static int[][] m = new int [n][n];
	private static int trace(Scanner input,int n,int [][] m) {
		int s = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				m[i][j] = input.nextInt();
				if(i == j) s+= m[i][j];
			}
		}
		return s;
	}
	
	private static int row(int x, int [][] m) {
		int s = 0;
		int r = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				s+= m[i][j];
			}
			if(s != x) r++;
			s = 0;
		}
		return r;
	}
	
	private static int column(int x,int [][] m) {
		int s = 0;
		int c = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				s+= m[j][i];
			}
			if(s != x) c++;
			s = 0;
		}
		return c;
	}
	
	public static void main(String[] args) {
		int x = 0;
		Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        for(int i = 1;i <= t;i++) {
        	n = input.nextInt();
        	int[][] m = new int[n][n];
        	for (int j = 1; j <= n; j++) x+=j;
            System.out.println(String.format("Case #%d: %d %d %d", i, trace(input,n,m),row(x,m),column(x,m)));
        }
		
	}
}
 