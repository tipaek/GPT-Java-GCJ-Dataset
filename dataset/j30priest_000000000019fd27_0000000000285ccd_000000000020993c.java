import java.util.*;
import java.io.*;
public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();
		for (int i = 0; i < t; ++i) {
			int sizeOfMatrix = in.nextInt();
			int matrix[][] = new int[sizeOfMatrix][sizeOfMatrix];
			for (int j = 0; j < sizeOfMatrix; ++j) {
				for(int k = 0; k < sizeOfMatrix; ++k) {
					matrix[j][k] = in.nextInt();
				}
			}
			solve(matrix, sizeOfMatrix, i+1);
		}
	}

	private static void solve(int[][] matrix, int sizeOfMatrix, int testCase) {
		int trace = 0;
		int rowsWithReps = 0;
		int colsWithReps = 0;
		int sum = sizeOfMatrix * (sizeOfMatrix + 1) /2;
		int fact = 1;

		for(int j = 0; j < sizeOfMatrix; j++){
			int arr[] = new int[sizeOfMatrix+1];
			trace += matrix[j][j];
			for(int k = 0; k < sizeOfMatrix; k++){
				arr[matrix[j][k]]++; 
			}
			for(int k = 1; k < sizeOfMatrix+1; k++){
				if(arr[k] > 1){
					rowsWithReps++;
					break;
				}
			}
		}

		for(int j = 0; j < sizeOfMatrix; j++){
			int arr[] = new int[sizeOfMatrix+1];;
			for(int k = 0; k < sizeOfMatrix; k++){
				arr[matrix[k][j]]++; 
			}
			for(int k = 1; k < sizeOfMatrix+1; k++){
				if(arr[k] > 1){
					colsWithReps++;
					break;
				}
			}
		}
		System.out.println("Case #" + testCase+ ": " + trace + " " + rowsWithReps + " " + colsWithReps);
	}
}