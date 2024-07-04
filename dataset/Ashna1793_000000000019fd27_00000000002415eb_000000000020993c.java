import java.util.*;
import java.io.*;

public class Solution {
	public static boolean isLatinArray(int[] row){
		int temp = 0;
		for(int i = 1; i < row.length; i++){
			while(row[i] != i){
				temp = row[row[i]];
				if(temp == row[i]) return false;
				row[row[i]] = row[i];
				row[i] = temp;
			}
		}
		return true;
	}
	
	public static int[] getVestigium(int[][] matrix) {
		int[] ans = new int[3];
		int[] arr = new int[matrix.length];
		for(int i = 1; i < matrix.length; i++){
			ans[0] += matrix[i][i];
			arr = Arrays.copyOf(matrix[i], matrix[0].length); 
			if(!isLatinArray(arr)) ans[1] += 1;
			for(int j = 1; j < matrix.length; j++) {
				arr[j] = matrix[j][i];
			}
			if(!isLatinArray(arr)) ans[2] += 1;
		}
		return ans;
	}
	
	public static void main(String[] args){
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int T = in.nextInt();
		for(int i = 1; i <= T; i++) {
			int N = in.nextInt();
			int [][] matrix = new int[N + 1][N + 1];
			for(int row = 1; row <= N; row++) {
				for(int col = 1; col <= N; col ++) {
					matrix[row][col] = in.nextInt();
				}
			}
			int[] ans = getVestigium(matrix);
			System.out.println("Case #" + i + ": " + ans[0] + " " + ans[1] + " " + ans[2]);
		}
		in.close();
	}
}
