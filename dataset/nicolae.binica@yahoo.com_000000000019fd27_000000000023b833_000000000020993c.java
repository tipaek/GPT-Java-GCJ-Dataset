import java.util.Scanner;
import java.io.*;
import java.util.*;

class Solution {

	public static void main(String[] args) {

	    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int Q = in.nextInt();
		int[][] a = new int[1000][1000];
		for(int test = 1; test <= Q; test ++){
			int n = in.nextInt();
			
			for(int i = 0 ; i < n; i ++)
				for(int j = 0 ; j < n; j ++)
					a[i][j] = in.nextInt();
			//System.out.println(test);
			solve(test, n, a);
		}
	}
	
	public static void solve(int test, int n, int[][] a) {

		int trace = 0;
		int nrCol = 0;
		int nrRow = 0;
		
		for(int i = 0; i < n; i ++) {
			int[] viz = new int[n+1];
			for(int j = 0; j < n; j ++) {
				viz[a[i][j]] ++;
				if(viz[a[i][j]] == 2) {
					nrRow ++;
					break;
				}
			}
			trace += a[i][i];
			viz = new int[n+1];
			for(int j = 0; j < n; j ++) {
				viz[a[j][i]] ++;
				if(viz[a[j][i]] == 2) {
					nrCol ++;
					break;
				}
			}
		}
		System.out.printf("Case #%d: %d %d %d\n", test, trace, nrRow, nrCol);
	}

}
