package CodeJam;

import java.util.*;

public class Vestigium {
	public static int[] latinSquareCheck(int[][] arr) {
		int rowCheck = 0;
		int colCheck = 0;
		int trace = 0;
		// check the row
		for (int i = 0; i < arr.length; i++) {
			HashSet<Integer> row = new HashSet<Integer>();
			for (int j = 0; j < arr[i].length; j++) {
				if (row.add(arr[i][j]) == false) {
					rowCheck++;
				}
				else
				{
					row.add(arr[i][j]);
				}
			}
		}
		for (int i = 0; i < arr.length; i++) {
			HashSet<Integer> col = new HashSet<Integer>();
			for (int j = 0; j < arr[i].length; j++) {
				if (col.add(arr[j][i]) == false) {
					colCheck++;
				}
				else
				{
					col.add(arr[j][i]);
				}
			}
		}

		for (int i = 0; i < arr.length; i++) {
			trace += arr[i][i];
		}
		int[] result = { trace, rowCheck, colCheck };
		return result;
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int testcase = scan.nextInt();
		for (int i = 1; i <= testcase+1; i++) {
			int dimension = scan.nextInt();
			int[][] arr = new int[dimension][dimension];
			for (int k = 0; k < arr.length; k++) {
				for (int l = 0; l < arr[k].length; l++) {
					arr[k][l] = scan.nextInt();
				}
			}
			int[] result = Vestigium.latinSquareCheck(arr);
			System.out.println("Case #" + i + ": " + result[0] + " " + result[1] + " " + result[2]);
		}
	}
}
