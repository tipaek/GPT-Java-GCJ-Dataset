import java.util.Scanner;

class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int i=0; i<t;i++) {
			int n = sc.nextInt();
			int[][] matrix = new int[n][n];
			int k = 0;
			int r = 0;
			int c = 0;
			for(int x=0;x<n;x++) {
				boolean[] row = new boolean[n];
				boolean rowFlag = false;
				for(int y=0;y<n;y++) {
					matrix[x][y]=sc.nextInt();
					if(row[matrix[x][y]-1]) rowFlag=true;					
					row[matrix[x][y]-1]=true;
					if(x==y) k+=matrix[x][y];
				}
				if(rowFlag) r++;
			}
			for(int y=0;y<n;y++) {
				boolean[] col = new boolean[n];
				boolean colFlag = false;
				for(int x=0;x<n;x++) {
					if(col[matrix[x][y]-1]) {
						colFlag = true;
						break;
					}
					col[matrix[x][y]-1]=true;
				}
				if(colFlag) c++;
			}
			System.out.println("Case #"+(i+1)+": "+k+" "+r+" "+c);
		}
	}
}