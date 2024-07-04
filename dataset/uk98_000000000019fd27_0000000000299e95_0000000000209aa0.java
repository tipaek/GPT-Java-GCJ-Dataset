import java.util.*;
import java.io.*;
class Solution{
	static int n,k,ca=1;
	static int[][] sqr;
	static boolean solved;
	static boolean[][] row_m, col_m;
	public static void sol(int row, int col, int m) {
	    if (row == n && col == n + 1 && m == k && !solved) {
	        solved = true;
	        System.out.println("Case #"+ca+": "+"POSSIBLE");
	        for (int i = 1; i <= n; ++i) {
	            for (int j = 1; j <= n; ++j) {
	                System.out.printf(sqr[i][j]+" ");
	            }
	            System.out.println();
	        }
	        return;
	    } else if (row > n) {
	        return;
	    } else if (col > n) {
	        sol(row + 1, 1, m);
	    }
	    for (int i = 1; i <= n && !solved; ++i) {
	        if (!row_m[row][i] && !col_m[col][i]) {
	            row_m[row][i] = col_m[col][i] = true;
	            if (row == col) {
	                m += i;
	            }
	            sqr[row][col] = i;

	            sol(row, col + 1, m);

	            row_m[row][i] = col_m[col][i] = false;
	            if (row == col) {
	                m -= i;
	            }
	            sqr[row][col] = 0;
	        }
	    }
	}
	public static void main(String args[]){
		int t,ca=1;
		Scanner s = new Scanner(System.in);
		if(s.hasNext()) {
			t = s.nextInt();
			while(t>0) {
				n = s.nextInt();
				k = s.nextInt();
				sol(1,1,0);
				if(!solved) {
					System.out.println("Case #"+ca+": "+"IMPOSSIBLE");
				}
				solved=false;
				t--;
				ca++;
			}
			s.close();
		}
	}
}
