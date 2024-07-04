import java.util.*;
import java.io.*;
public class Solution {
	static int ttl=0;
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
		for (int i = 1; i <= t; ++i) {
			int r = in.nextInt();
			int c = in.nextInt();
			int [][] grid=new int [r][c];
			int prev=0;
			for (int j=0; j<r; j++) {
				for (int k=0; k<c; k++) {
					int tp=in.nextInt ();
					grid[j][k]=tp;
					prev+=tp;
				}
			}
			ArrayList <pt> skip=new ArrayList <pt> ();
			int ans=0;
			do {
				prev-=ans;
				ttl+=prev;
				ans=round (prev, grid, skip);
			} while (ans!=0);
			System.out.println("Case #" + i + ": " + ttl);
			ttl=0;
		}
	}
	public static int round (int sum, int [][] grid, ArrayList <pt> skip) {
		ArrayList <pt> rem=new ArrayList <pt> ();
		for (int i=0; i<grid.length; i++) {
			for (int j=0; j<grid[0].length; j++) {
				if (grid[i][j]!=-1&&!comp(i, j, grid)) {
					pt tp=new pt (i, j);
					rem.add(tp);
				}
			}
		}
		int subtract=0;
		for (pt s: rem) {
			subtract+=grid[s.r][s.c];
			grid[s.r][s.c]=-1;
		}
		return subtract;
	}
	public static boolean comp (int r, int c, int [][] grid) {
		int num=0;
		int skill=0;
		for (int i=r-1; i>=0; i--) {
			if (grid[i][c]!=-1) {
				num+=1;
				skill+=grid[i][c];
				break;
			}
		}
		for (int i=r+1; i<grid.length; i++) {
			if (grid[i][c]!=-1) {
				num+=1;
				skill+=grid[i][c];
				break;
			}
		}
		for (int i=c+1; i<grid[0].length; i++) {
			if (grid[r][i]!=-1) {
				num+=1;
				skill+=grid[r][i];
				break;
			}
		}
		for (int i=c-1; i>=0; i--) {
			if (grid[r][i]!=-1) {
				num+=1;
				skill+=grid[r][i];
				break;
			}
		}
		if (num==0) {
			return true;
		}
		double sk=grid[r][c];
		double avg=(double)skill/num;
		if (sk<avg) {
			return false;
		}
		return true;
	}
	static class pt {
		int r;
		int c;
		public pt (int a, int b) {
			r=a;
			c=b;
		}
	}
}