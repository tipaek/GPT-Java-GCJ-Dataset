package code_jam;
import java.util.*;
import java.io.*;
public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();
		for (int i = 1; i <= t; ++i) {
			int n = in.nextInt();
			int [] [] matrix=new int [n][n];
			for (int k=0; k<n; k++) {
				for (int l=0; l<n; l++) {
					matrix[k][l]=in.nextInt ();
				}
			}
			int trace=0;
			for (int m=0; m<n; m++) {
				trace+=matrix[m][m];
			}
			int row=row (matrix);
			int col=col (matrix);
			System.out.println("Case #" + i + ": " + trace +" " + row +" " +col);
		}
	}
	public static int row (int [][] matrix){
		int count=0;
		for (int i=0; i<matrix.length; i++) {
			boolean [] vst=new boolean [matrix.length+1];
			boolean check=false;
			for (int j=0; j<matrix.length; j++) {
				if (vst[matrix[i][j]]==true) {
					check=true;
					break;
				}
				else {
					vst[matrix[i][j]]=true;
				}
			}
			if (check) count++;
		}
		return count;
	}
	public static int col (int [][] matrix){
		int count=0;
		for (int i=0; i<matrix.length; i++) {
			boolean [] vst=new boolean [matrix.length+1];
			boolean check=false;
			for (int j=0; j<matrix.length; j++) {
				if (vst[matrix[j][i]]==true) {
					check=true;
					break;
				}
				else {
					vst[matrix[j][i]]=true;
				}
			}
			if (check) count++;
		}
		return count;
	}
}