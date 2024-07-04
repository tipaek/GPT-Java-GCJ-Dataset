import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int tests = Integer.parseInt(in.nextLine());
		for(int test=1;test<=tests;test++) {
			String[] input = in.nextLine().split(" ");
			int n = Integer.parseInt(input[0]);
			int k = Integer.parseInt(input[1]);
			if((n<=3&&k%n!=0)||(n>=4 && (k==n+1||k==n*n-1))) {
				System.out.println("Case #"+test+": IMPOSSIBLE");
				continue;
			}
			int[][] matrix = new int[n][n];
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					matrix[i][j] = (i-j+2*n)%n+1;
				}
			}
			int[] perm = new int[n];
			Arrays.fill(perm, 1);
			
			boolean overhalf = false;
			if(2 * k > n * n+n) {
				overhalf = true;
				k=n*n+n-k;
			}
			
			if(k > n) {
				perm[0]++;
				perm[1]++;
				int sum = n+2;
				int index = 0;
				while(sum < k) {
					while(perm[index] >= n) index++;
					perm[index]++;
					sum++;
				}
			}
			
//			for(int i=0;i<n;i++) {
//				System.out.print(perm[i]+" ");
//			}
//			System.out.println();
			int[][] mat = new int[n][n];
			boolean[][][] pos = new boolean[n][n][n+1];
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					Arrays.fill(pos[i][j], true);
				}
			}
			for(int i=0;i<n;i++) {
				mat[i][i] = perm[i];
				for(int j=1;j<=n;j++) {
					pos[i][i][j] = false;
				}
				for(int j=0;j<n;j++) {
					pos[i][j][perm[i]] = false;
					pos[j][i][perm[i]] = false;
				}
			}
			int[][] ans = dfs(0,mat,pos,n);
			
//			int swaptimes = (k-n)/n;
//			int swaprow2 = n-1-swaptimes;
//			int[][] nmatrix = new int[n][n];
//			for(int i=0;i<n;i++) {
//				int rowindex = i;
//				if(i == swaprow2) rowindex = n-1;
//				else if(i > swaprow2) rowindex = i-1;
//				for(int j=0;j<n;j++) {
//					nmatrix[i][j] = matrix[rowindex][j];
//				}
//			}
			System.out.println("Case #"+test+": POSSIBLE");
			for(int i=0;i<n;i++) {
				String print = "";
				for(int j=0;j<n;j++) {
					if(overhalf) ans[i][j] = n +1 - ans[i][j];
					print = print + ans[i][j] + " ";
				}
				print = print.substring(0,print.length()-1);
				System.out.println(print);
			}
		}
		in.close();
	}
	public static int[][] dfs(int index, int [][] mat, boolean[][][] pos, int n) {
		//System.out.println(index);
		if(index==n*n) return mat;
		int row = index / n;
		int col = index % n;
		if(mat[row][col] != 0) {
			return dfs(index+1,mat,pos,n);
		}
		for(int i=1;i<=n;i++) {
			if(!pos[row][col][i]) continue;
			int[][] nmat = new int[n][n];
			boolean[][][] npos = new boolean[n][n][n+1];
			for(int j=0;j<n;j++) {
				for(int k=0;k<n;k++) {
					nmat[j][k] = mat[j][k];
					for(int l=1;l<=n;l++) {
						npos[j][k][l] = pos[j][k][l];
					}
				}
			}
			nmat[row][col] = i;
			for(int j=1;j<=n;j++) {
				npos[row][col][j] = false;
			}
			for(int j=0;j<n;j++) {
				npos[j][col][i] = false;
				npos[row][j][i] = false;
			}
			int[][] ret = dfs(index+1,nmat,npos,n);
			if(ret[0][0] != -1) return ret;
		}
		mat[0][0] = -1;
		return mat;
	}
}