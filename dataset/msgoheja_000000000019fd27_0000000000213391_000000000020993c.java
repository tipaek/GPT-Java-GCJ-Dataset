import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

class Solution {

	public static void main(String[] args) throws Exception{
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int N, value, sum, r, c;
		int[] arr;
		int[][] matrix;
		boolean flag;
		int T = in.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			N = in.nextInt();
			sum = 0; r = 0; c = 0;
			arr = new int[N+1];
			matrix = new int[N+1][N+1];
			for(int i = 1;i <= N; i++) {
				flag = true;
				arr = new int[N+1];
				value = 0;
				for(int j = 1;j <= N; j++) {
					value = in.nextInt();
					
					arr[value]++;
					matrix[value][j]++;
					
					if(i == j) {
						sum += value;
					}
					
					if(flag && arr[value] > 1) {
						r++;
						flag = false;
					}
				}
			}
			
			for(int col = 1; col <= N; col++) {
				for(int row = 1; row <= N; row++) {
					if(matrix[row][col] > 1) {
						c++;
						break;
					}
				}
			}
			
			System.out.println("Case #" + tc + ": " + sum + " " + r + " " + c);
		}
		in.close();
	}

}
