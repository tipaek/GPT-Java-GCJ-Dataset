import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
	
	public static int[] LatinSquare(int Matrix[][], int N){
		int row = 0, col = 0, diagonalSum = 0;
		int[] result = new int[3];
		for(int i = 0; i < N; ++i){
			int[] HashValues = new int[N+1];
			for(int j = 0; j < N; ++j){
				int x = Matrix[i][j];
				HashValues[x]++;
				if(HashValues[x]>1){
					row++;
					break;
				}
			}
		}
		for(int j = 0; j < N; ++j){
			int[] HashValues = new int[N+1];
			for(int i = 0; i < N; ++i){
				int x = Matrix[i][j];
				HashValues[x]++;
				if(HashValues[x]>1){
					col++;
					break;
				}
			}
		}
		
		int i = 0, j = 0;
		while (i<N) {
			diagonalSum += Matrix[i][j];
			++i;
			++j;
		}
		
		result[0] = diagonalSum;
		result[1] = row;
		result[2] = col;
		
		return result;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();
		for(int k = 1; k <= t; ++k){
			int N = in.nextInt();
			int[][] Matrix = new int[N][N];
			for(int i=0;i<N;++i){
				for(int j=0;j<N;++j){
					int x = in.nextInt();
					while(x<1 || x>N){
						System.out.println("Invalid Entry.");
						x = in.nextInt();
					}
					Matrix[i][j] = x;
				}
			}
			
			int[] result = LatinSquare(Matrix, N);
			
			System.out.println("Case #" + k + ": " + result[0] + " " + result[1] + " " + result[2]);
			
			
		}

		in.close();
	}
}
