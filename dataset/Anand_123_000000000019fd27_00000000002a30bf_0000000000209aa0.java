import java.util.*;
class Solution {
	@SuppressWarnings({"resource"})
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int i=1;i<=t;i++) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			if((n==2 && k==3) || (n==3 && k==4) || (n==3 && k==5) || (n==3 && k==7) || (n==3 && k==8) || (n==4 && k==5) || (n==4 && k==9) || (n==4 && k==13) || (n==4 && k==15) || (n==5 && k==6) || (n==4 && k==11) || (n==4 && k==16) || (n==4 && k==21)) {
				System.out.println("Case #"+i+": "+"IMPOSSIBLE");
			}else {
				System.out.println("Case #"+i+": "+"POSSIBLE");
				int[][] matrix = formatrix(n, k);
				for(int r=0;r<n;r++) {
					for(int c=0;c<n;c++) {
						System.out.print(matrix[r][c]+" ");
					}
					System.out.println();
				}
				}
			}
		}

	public static int[][] formatrix(int n, int k) {
		// TODO Auto-generated method stub
		if(n==2) {
			if(k==2) {
				int[][] matrix = {{1,2},{2,1}};
				return matrix;
			}else if(k==4) {
				int[][] matrix = {{2,1},{1,2}};
				return matrix;
			}
		}
		if(n==3) {
			if(k==3) {
				int[][] matrix = {{1,2,3},{3,1,2},{2,3,1}};
				return matrix;
			}else if(k==6) {
				int[][] matrix = {{2,3,1},{1,2,3},{3,1,2}};
				return matrix;
			}else if(k==9) {
				int[][] matrix = {{3,1,2},{1,3,2},{2,1,3}};
				return matrix;
			}
		}
		if(n==4) {
			if(k==16) {
				int[][] matrix = {{4,3,2,1},{1,4,3,2},{2,1,4,3},{3,2,1,4}};
				return matrix;
			}else if(k==12) {
				int[][] matrix = {{3,4,1,2},{2,3,4,1},{1,2,3,4},{4,1,2,3}};
				return matrix;
			}else if(k==8) {
				int[][] matrix = {{2,3,4,1},{1,2,3,4},{4,1,2,3},{3,4,1,2}};
				return matrix;
			}else if(k==4) {
				int[][] matrix = {{1,2,3,4},{4,1,2,3},{3,4,1,2},{2,3,4,1}};
				return matrix;
			}else if(k==6) {
				int[][] matrix = {{2,1,4,3},{1,2,3,4},{4,3,1,2},{3,4,2,1}};
				return matrix;
			}else if(k==10) {
				int[][] matrix = {{3,2,4,1},{2,3,1,4},{4,1,2,3},{1,4,3,2}};
				return matrix;
			}else if(k==14) {
				int[][] matrix = {{4,3,1,2},{3,4,2,1},{1,2,3,4},{2,1,4,3}};
				return matrix;
			}else if(k==7) {
				int[][] matrix = {{3,1,2,4},{1,2,4,3},{4,3,1,2},{2,4,3,1}};
				return matrix;
			}else if(k==11) {
				int[][] matrix = {{4,1,2,3},{3,2,1,4},{2,4,3,1},{1,3,4,2}};
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
