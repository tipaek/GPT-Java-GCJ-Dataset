import java.util.*;
import java.io.*;

class Solution{

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int[][] solutions, matrix = null;
		int T = in.nextInt();
		int M = 0;
		solutions = new int[T][3];

		for(int solN = 0; solN < T; solN++) {
			M = in.nextInt();
			matrix = new int[M][M];
			

			for(int i = 0; i < M; i++) {
				for(int j = 0; j < M; j++) {
					matrix[i][j] = in.nextInt();
				}
			}

			int sum = 0;
			for(int i = 0; i < M; i++) {
				sum += matrix[i][i];
			}

			solutions[solN][0] = sum;

			int counter = 0;
			boolean repeat = false;
			int num;
			for(int i = 0; i < M; i++) {
				for(int j = 0; j < M; j++) {
					if(repeat == true) {
						repeat = false;
						counter++;
						break;
					}
					num = matrix[i][j];
					for(int k = j + 1; k < M; k++) {
						if(num == matrix[i][k]) {
							repeat = true;
							break;
						}
					}
				}
			}
			solutions[solN][1] = counter;

			counter = 0;
			repeat = false;
			for(int j = 0; j < M; j++) {
				for(int i = 0; i < M; i++) {
					if(repeat == true) {
						repeat = false;
						counter++;
						break;
					}
					num = matrix[i][j];
					for(int k = i + 1; k < M; k++) {
						if(num == matrix[k][j]) {
							repeat = true;
							break;
						}
					}
				}
			}
			solutions[solN][2] = counter;
		}








		for(int i = 0; i < T; i++) {
			System.out.print("Case #" + (i+1) + ":");
			for(int j = 0; j < 3; j++) {
				System.out.print(" " + solutions[i][j]);
			}
			System.out.print('\n');
		}
	}
}