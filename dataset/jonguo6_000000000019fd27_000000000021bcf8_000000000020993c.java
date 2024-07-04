import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int tests = Integer.parseInt(in.nextLine());
		for(int test=1;test<=tests;test++) {
			int n = Integer.parseInt(in.nextLine());
			int[][] matrix = new int[n][n];
			int trace = 0;
			int duprow = 0;
			int dupcol = 0;
			boolean[][] row = new boolean[n+1][n+1];
			boolean[][] col = new boolean[n+1][n+1];
			for(int i=0;i<n;i++) {
				String[] input = in.nextLine().split(" ");
				for(int j=0;j<n;j++) {
					int entry = Integer.parseInt(input[j]);
					if(i==j) trace+=entry;
					matrix[i][j] = entry;
					boolean rowdup = row[i][entry];
					if(rowdup) {
						boolean rowdup2 = row[i][0];
						if(!rowdup2) {
							row[i][0] = true;
							duprow++;
						}
					} else {
						row[i][entry] = true;
					}
					boolean coldup = col[j][entry];
					if(coldup) {
						boolean coldup2 = col[j][0];
						if(!coldup2) {
							col[j][0] = true;
							dupcol++;
						}
					} else {
						col[j][entry] = true;
					}
				}
			}
			System.out.println("Case #"+test+": "+trace+" "+duprow+" "+dupcol);
		}
		in.close();
	}
}