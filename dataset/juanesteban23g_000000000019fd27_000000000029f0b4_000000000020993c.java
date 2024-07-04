import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = sc.nextInt();
		for(int i = 1; i <= t; i++) {
			int n = sc.nextInt();
			int[][] matrix = new int[n][n];
			for(int j = 0; j < n; j++) {
				for(int k = 0; k < n; k++) {
					matrix[j][k] = sc.nextInt();
				}
			}
			int sum = 0;
			int rows = 0;
			int colums = 0;
			for(int j = 0; j < n; j++) {
				for(int k = 0; k < n; k++) {
					if(j == k) {
						sum += matrix[j][k];
					}
				}
			}
			for(int j = 0; j < n; j++) {
				boolean x = true;
				for(int k = 0; k < n && x; k++) {
					int aux = matrix[j][k];
					for(int l = k + 1; l < n && x; l++) {
						if(matrix[j][l] == aux) {
							rows++;
							x = false;
						}
					}
				}
			}
			for(int j = 0; j < n; j++) {
				boolean x = true;
				for(int k = 0; k < n && x; k++) {
					int aux = matrix[k][j];
					for(int l = k + 1; l < n && x; l++) {
						if(matrix[l][j] == aux) {
							colums++;
							x = false;
						}
					}
				}
			}
			System.out.println("Case #" + i + ": " + sum + " " + rows + " " + colums);
		}
	}

}