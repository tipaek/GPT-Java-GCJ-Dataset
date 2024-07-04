import java.util.*;
import java.io.*;
class Solution {

	public static void vestigium(int[][] matrix) {
		int k=0, r=0, c=0;
		boolean rowDup=false, colDup=false;
		Set<Integer> row = new HashSet<>();
		Set<Integer> col = new HashSet<>();

		for(int i=0; i<matrix.length; i++) {
			for(int j=0; j<matrix.length; j++) {
				if(i==j) k+=matrix[i][j];
				if(!row.add(matrix[i][j])) {
					rowDup = true;
				}
				if(!col.add(matrix[j][i])) {
					colDup = true;
				}
			}
			if(rowDup) r++;
			if(colDup) c++;
			rowDup = colDup = false;
			row.clear();
			col.clear();
		}
		System.out.println(k+" "+r+" "+c);
	}
	public static void main(String[] args) {
		int t, n;
		Scanner scan = new Scanner(System.in);
		int[][] matrix;
		t = scan.nextInt();
		for(int c=1; c<=t; c++) {
			n = scan.nextInt();
			matrix = new int[n][n];
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					matrix[i][j] = scan.nextInt();
				}
			}
			System.out.print("Case #"+c+": ");
			vestigium(matrix);
		}
	}
}