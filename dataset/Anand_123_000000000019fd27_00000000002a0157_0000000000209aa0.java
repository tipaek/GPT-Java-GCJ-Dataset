import java.util.*;
public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int i=1;i<=t;i++) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			if((k%n)==1 || (k%n)==(n-1)) {
				System.out.println("case #"+i+": "+"IMPOSSIBLE");
			}else {
				System.out.println("case #"+i+": "+"POSSIBLE");
				int[][] matrix = new int[n][n];
				if((k%n)==0) {
					int val = (int)(k/n);
					for(int r=0;r<n;r++) {
						for(int c=0;c<n;c++) {
							if((c-r)==0) {
								matrix[r][c] = val;
							}else if((c-r)>0) {
								matrix[r][c] = (val+(c-r))%(n);
								if(matrix[r][c]==0)
									matrix[r][c]=n;
								if(matrix[r][c]<0) {
									matrix[r][c] = n+matrix[r][c];
								}
							}else {
								matrix[r][c] = (val+(c-r))%(n);
								if(matrix[r][c]==0)
									matrix[r][c]=n;
								if(matrix[r][c]<0) {
									matrix[r][c] = n+matrix[r][c];
								}
							}
						}
					}
				}else {
					matrix = formatrix(n, k);
				}
				for(int r=0;r<n;r++) {
					for(int c=0;c<n;c++) {
						System.out.print(matrix[r][c]+" ");
					}
					System.out.println();
				}
			}
		}
	}

	private static int[][] formatrix(int n, int k) {
		// TODO Auto-generated method stub
		if(n==4) {
			if(k==6) {
				int[][] matrix = {{2,1,4,3},{1,2,3,4},{4,3,1,2},{3,4,2,1}};
				return matrix;
			}else if(k==10) {
				int[][] matrix = {{3,2,4,1},{2,3,1,4},{4,1,2,3},{1,4,3,2}};
				return matrix;
			}else {
				int[][] matrix = {{4,3,1,2},{3,4,2,1},{1,2,3,4},{2,1,4,3}};
				return matrix;
			}
		}
		if(n==5) {
			if(k==7) {
				int[][] matrix = {{4,1,3,5,2},{3,2,5,4,1},{2,4,1,3,5},{1,5,4,2,3},{5,3,2,1,4}};
				return matrix;
			}else if(k==8) {
				int[][] matrix = {{2,1,4,5,3},{5,2,1,3,4},{1,3,2,4,5},{4,5,3,1,2},{3,4,5,2,1}};
				return matrix;
			}else if(k==12) {
				int[][] matrix = {{1,3,5,2,4},{3,1,2,4,5},{2,5,4,1,3},{5,4,1,3,2},{4,2,3,5,1}};
				return matrix;
			}else if(k==13) {
				int[][] matrix = {{4,1,2,5,3},{1,2,3,4,5},{5,4,1,3,2},{3,5,4,2,1},{2,3,5,1,4}};
				return matrix;
			}else if(k==17) {
				int[][] matrix = {{5,1,3,4,2},{1,3,2,5,4},{4,5,1,2,3},{2,4,5,3,1},{3,2,4,1,5}};
				return matrix;
			}else if(k==18) {
				int[][] matrix = {{5,2,3,4,1},{2,3,1,5,4},{4,5,2,1,3},{1,4,5,3,2},{3,1,4,2,5}};
				return matrix;
			}else if(k==22) {
				int[][] matrix = {{5,2,4,1,3},{1,4,3,5,2},{4,3,5,2,1},{2,5,1,3,4},{3,1,2,4,5}};
				return matrix;
			}else if(k==23) {
				int[][] matrix = {{5,3,2,1,4},{2,4,3,5,1},{4,1,5,2,3},{3,5,1,4,2},{1,2,4,3,5}};
				return matrix;
			}
		}
		return null;
	}

}
