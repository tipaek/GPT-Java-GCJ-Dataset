import java.util.HashSet;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		for (int i = 0; i < t; i++) {
			int n = scan.nextInt();
			int[][] matrix = new int[n][n];
			for (int j = 0; j < matrix.length; j++) {
				for (int k = 0; k < matrix[j].length; k++) {
					matrix[j][k] = scan.nextInt();
				}
			}
			int[] ret = solve(matrix);
			System.out.println("Case #" + (i + 1) + ": " + ret[0] + " " + ret[1] + " " + ret[2]);
		}
	}
	
	public static int[] solve(int[][] matrix) {
		int[] ret = new int[3];
		
		//Finding Trace
		int sum = 0;
		for (int i = 0; i < matrix.length; i++) {
			sum += matrix[i][i];
		}
		ret[0] = sum;
		
		//Finding number of rows with repeated elements
		int rNU = 0;
		for (int i = 0; i < matrix.length; i++) {
			HashSet<Integer> set = new HashSet<>();
			for (int j = 0; j < matrix[i].length; j++) {
				if (set.contains(matrix[i][j])) {
					rNU++;
					break;
				}
				else set.add(matrix[i][j]);
			}
		}
		ret[1] = rNU;
		
		//Finding number of columns with repeated elements
		int cNU = 0;
		for (int i = 0; i < matrix.length; i++) {
			HashSet<Integer> set = new HashSet<>();
			for (int j = 0; j < matrix[i].length; j++) {
				if (set.contains(matrix[j][i])) {
					cNU++;
					break;
				}
				else set.add(matrix[j][i]);
			}
		}
		ret[2] = cNU;
		return ret;
	}
}