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
			for(int i=1;i<n;i++) {
				mat[0][0]=i;
				findAll(mat, 0, 0);
			}
			if(!isPossible)
				System.out.println("IMPOSSIBLE");
		}
	}
	public static boolean isVestigium(int mat[][]) {
		int max_row=0, max_col=0;
		for(int i=0;i<n;i++) {
			int cnt_row[]=new int[n+1];
			int cnt_col[]=new int[n+1];
			for(int j=0;j<n;j++) {
				cnt_row[mat[i][j]]++;
				cnt_col[mat[j][i]]++;
			}
			Arrays.parallelSort(cnt_row);
			Arrays.parallelSort(cnt_col);
			if(cnt_row[n]!=1)
				max_row++;
			if(cnt_col[n]!=1)
				max_col++;
		}
		if(max_row==0 && max_col==0)
			return true;
		else
			return false;
	}
	public static void findAll(int mat[][], int row, int col) {
		if(row==n-1 && col==n-1) {
			int add=0;
			for(int i=0;i<n;i++) {
				add+=mat[i][i];
			}
			
			if(add==ans && isVestigium(mat)) {
				isPossible=true;
				System.out.println("POSSIBLE");
				for(int i=0;i<n;i++) {
					for(int j=0;j<n;j++) {
						System.out.print(mat[i][j]+" ");
					}
					System.out.println();
				}
			}
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
