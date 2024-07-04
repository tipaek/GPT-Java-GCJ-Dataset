import java.util.*;
import java.io.*;
public class Solution {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		PrintWriter out= new PrintWriter(System.out);
		int t=sc.nextInt();
		int testnum=1;
		while(t-->0) {
			int n=sc.nextInt();
			int[][] grid= new int[n][n];
			int rcount=0, ccount=0;
			int trace=0;
			for(int i=0;i<n;i++) {
				HashSet<Integer> hs= new HashSet<Integer>();
				for(int j=0;j<n;j++) {
					int x=sc.nextInt();
					grid[i][j]=x;
					hs.add(x);
					if(i==j)
						trace+=x;
				}
				if(hs.size()<n)
					rcount++;
			}
			for(int i=0;i<n;i++) {
				HashSet<Integer> hs= new HashSet<Integer>();
				for(int j=0;j<n;j++) {
					hs.add(grid[j][i]);
				}
				if(hs.size()<n)
					ccount++;
			}
			out.printf("Case #%d: %d %d %d%n", testnum++, trace, rcount, ccount);
		}
		out.close();
	}

}
