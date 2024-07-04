import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for(int t = 1; t <= T; t++){
			
			System.out.print("Case " + t + ": ");
			
			int n = in.nextInt();
			int[][] matrix = new int[n][n];
			for(int i = 0; i < n; i++){
				for(int j = 0; j < n; j++){
					matrix[i][j] = in.nextInt();
				}
			}
			
			int sum = 0;
			for(int i = 0; i < n; i++){
				sum += matrix[i][i];
			}
			
			int reprows = 0;
			int repcols = 0;
			
			for(int row = 0; row < n; row++){
				loop1: for(int i = 0; i < n-1; i++){
					int x = matrix[row][i];
					for(int j = i+1; j < n; j++){
						if(matrix[row][j] == x){
							reprows++;
							break loop1;
						}
					}
				}
			}
			
			for(int col = 0; col < n; col++){
				loop2: for(int i = 0; i < n-1; i++){
					int x = matrix[i][col];
					for(int j = i+1; j < n; j++){
						if(matrix[j][col] == x){
							repcols++;
							break loop2;
						}
					}
				}
			}

			System.out.println(sum + " " + reprows + " " + repcols);
		}
		in.close();
	}

}
