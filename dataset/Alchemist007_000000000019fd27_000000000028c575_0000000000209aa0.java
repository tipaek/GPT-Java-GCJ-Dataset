import java.util.Scanner;

public class Solution {

	static Scanner scn = new Scanner(System.in);
	
	static int K;
	
	public static void main(String[] args) {
		int T = scn.nextInt();
		int t = 0;
		while(++t <= T) {
			int N = scn.nextInt();
			K = scn.nextInt();
			int[][] arr = new int[N][N];
			if(solveSudoku(arr, 0, 0)) {
				System.out.println("Case #" + t + ": " + "POSSIBLE");
				print(arr);
			}
			else
				System.out.println("Case #2: IMPOSSIBLE");
		}
	}
	
	public static boolean solveSudoku(int arr[][] , int row, int col) {
		
		if(col == arr[row].length) {
			row++;
			col=0;
		}
		
		if(row == arr.length) {
			if(checkTrace(arr))
				return true;
			return false;
		}
		
		if(arr[row][col] == 0) {
			
			for(int i = 1; i<=arr.length; i++) {
				if(isItSafe(arr, row, col, i)) {
					arr[row][col] = i;
					if(solveSudoku(arr, row, col+1))
						return true;
					arr[row][col] = 0;
				}
			}
			return false;
			
		}
		else
			return solveSudoku(arr, row, col+1);
		
	}
	
	public static boolean isItSafe(int[][] arr , int row, int col, int num) {
		for(int i = 0; i<arr.length; i++) {
			if(arr[i][col] == num)
				return false;
		}
		for(int i = 0; i<arr[row].length; i++) {
			if(arr[row][i] == num)
				return false;
		}
		return true;
	}
	
	public static void print(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static boolean checkTrace(int[][] arr) {
		int sum = 0;
		for(int i = 0; i<arr.length; i++)
			sum += arr[i][i];
		if(sum == K)
			return true;
		return false;
	}


}
