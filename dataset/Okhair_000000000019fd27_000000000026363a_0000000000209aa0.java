import java.util.*;
import java.io.*;
public class Solution {
	static int[][] grid, ans;
	static HashSet<Integer>[] row, col;
	static int n,k;
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		PrintWriter out= new PrintWriter(System.out);
		int t=sc.nextInt();
		int testnum=1;
		while(t-->0) {
			n=sc.nextInt();
			k=sc.nextInt();
			grid=new int[n][n];
			row= new HashSet[n];
			col= new HashSet[n];
			for(int i=0;i<n;i++) {
				row[i]=new HashSet<Integer>();
				col[i]=new HashSet<Integer>();
			}
			ans=null;
			for(int x=1; x<=n && ans==null; x++) {
				grid[0][0]=x;
				row[0].add(x);
				col[0].add(x);
				calc(0,0,0);
				row[0].remove(x);
				col[0].remove(x);
			}
			out.printf("Case #%d: ", testnum++);
			if(ans==null)
				out.println("IMPOSSIBLE");
			else {
				out.println("POSSIBLE");
				print(ans, out);
			}

//				out.printf("Case #%d: ", testnum++);
		}
		out.close();
	}
	public static void calc(int i, int j, int trace) {
//		print(grid, new PrintWriter(System.out));
		if(i==j)
			trace+=grid[i][j];
		if(trace>k )
			return;
		if(i==n-1 && j==n-1) {
			if(trace==k)
				ans=grid.clone();
			return;
		}
		if(j>=n-1) {
			i++;
			j=0;
		}
		else
			j++;
		for(int x=1;x<=n;x++) {
			if(!row[i].contains(x) && !col[j].contains(x)) {
				grid[i][j]=x;
				row[i].add(x);
				col[j].add(x);
				calc(i,j,trace);
				row[i].remove(x);
				col[j].remove(x);
			}
		}
	}
	public static boolean isValid(int i, int j) {
		return i<n && j<n && i>=0 && j>=0;
	}
	public static void print(int[][] arr, PrintWriter out) {
		for (int i=0;i<n;i++) {
			for(int j=0;j<n;j++)
				out.print(arr[i][j]+" ");
		out.println();
		}
	}
}
