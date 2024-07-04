package qualRound2020;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int k = 1; k <=t; k++) {
			int n = sc.nextInt();
			int trace = 0; int element = 0; int row = 0; int col = 0; boolean counted = false;
			int[][] matrix = new int[n][n];
			boolean[] check = new boolean[n+1];
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					element = sc.nextInt();
					if(i == j) trace += element;
					matrix[i][j] = element;
					if(check[matrix[i][j]] && !counted) {
						row++;
						counted = true;
					}
					else check[matrix[i][j]] = true;
				}
				Arrays.fill(check, false);
				counted = false;
			}
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					if(check[matrix[j][i]]) {
						col++;
						break;
					}
					else check[matrix[j][i]] = true;
				}
				Arrays.fill(check, false);
			}
			System.out.println("Case #"+k+": "+trace+" "+row+" "+col);
		}
		sc.close();
	}
	
	
	

}
