import java.util.*;
public class Solution {
	public static int n=0, ans=0;
	public static boolean isPossible=false;
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int test=in.nextInt();
		for(int t=1;t<=test;t++) {
			System.out.print("Case #"+t+": ");
			n=in.nextInt();
			ans=in.nextInt();
			isPossible=false;
			int mat[][]=new int[n][n];
			findAll(mat, 0, 0);
			if(isPossible)
				System.out.println("POSSIBLE");
			else
				System.out.println("IMPOSSIBLE");
		}
	}
	public static void findAll(int mat[][], int row, int col) {
		if(row==n-1 && col==n-1) {
			int add=0;
			for(int i=0;i<n;i++) {
				add+=mat[i][i];
			}
			//System.out.println(add);
			if(add==ans)
				isPossible=true;
			return;
		}
		
		if(isPossible)
			return;
		
		if(col==n-1) {
			for(int i=1;i<=n;i++) {
				mat[row+1][0]=i;
				findAll(mat, row+1, 0);
			}
		}
		else {
			for(int i=1;i<=n;i++) {
				mat[row][col+1]=i;
				findAll(mat, row, col+1);
			}
		}
	}
}
