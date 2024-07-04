package CodeJam;

import java.util.*;

public class Solution {
	public static int[] latinSquareCheck(int[][] arr) {
		int rowCheck = 0;
		int colCheck = 0;
		int trace = 0;
		// check the row
		for (int i = 0; i < arr.length; i++) {
			if (duplicates(arr[i])) {
				rowCheck++;
			}
			int[] column = Solution.getColumn(arr, i);
			// check for duplicates in each column
			if (duplicates(column)) {
				colCheck++;
			}
		}
		for (int i = 0; i < arr.length; i++) {
			trace += arr[i][i];
		}
		int[] result = { trace, rowCheck, colCheck };
		return result;
	}
	public static int[] getColumn(int[][] array, int index){
	    int[] column = new int[array[0].length];
	    for(int i=0; i<column.length; i++){
	       column[i] = array[i][index];
	    }
	    return column;
	}

	public static boolean duplicates(int[] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length; j++) {
				if (i != j && array[i] == array[j]) {
					return true;
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int testcase = scan.nextInt();
		int num = 1;
		while(num<=testcase) {
			int dimension = scan.nextInt();
			int[][] arr = new int[dimension][dimension];
			for (int k = 0; k < arr.length; k++) {
				for (int l = 0; l < arr[k].length; l++) {
					arr[k][l] = scan.nextInt();
				}
			}
			int[] result = Solution.latinSquareCheck(arr);
			System.out.println("Case #" + num + ": " + result[0] + " " + result[1] + " " + result[2]);
			num++;
		}
		scan.close();
	}
}
