import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int tests = in.nextInt();
		for (int test = 1; test <= tests; test++) {
			int size =  in.nextInt();
			int[][] matrix = new int[size][size];
			for (int i=0; i<size; i++) {
				for (int j=0; j<size; j++) {
					matrix[i][j]=in.nextInt();
				}
			}
			print(test, matrix);
		}
	}
	
	private static void print(int test, int[][] matrix) {
		int sum=0;
		int col=0;
		int row=0;
		for (int i=0; i<matrix.length;i++) {
			sum+=matrix[i][i];
			rows:
			for (int j=1; j<matrix[i].length;j++) {
				for (int q=0; q<j;q++) {
					if (matrix[i][q]==matrix[i][j]) {
						row++;
						break rows;
					}
				}
			}
			cols:
			for (int j=1; j<matrix[i].length;j++) {
				for (int q=0; q<j;q++) {
					if (matrix[q][i]==matrix[j][i]) {
						col++;
						break cols;
					}
				}
			}
		}
		
		System.out.println("Case #"+test+": "+sum+" "+row+" "+col);
	}
}
