import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int T = input.nextInt();
		for (int i = 0; i < T; i++) {
			int N = input.nextInt();
			int[][] matrix = new int[N][N];
			int[][] dummy = new int[N][N];
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					matrix[j][k]=input.nextInt();
					dummy[k][j]=matrix[j][k];
				}
			}
			int trace = 0; int r = 0; int c = 0;
			for (int j = 0; j < N; j++) {
				trace+=matrix[j][j];
			}
			for (int j = 0; j < N; j++) {
				int[] temp = matrix[j];
				Arrays.sort(temp);
				for (int k = 0; k < N-1; k++) {
					if (temp[k]==temp[k+1]) {
						r++;
						break;
					} 
				}
			}
			for (int j = 0; j < N; j++) {
				int[] temp = dummy[j];
				Arrays.sort(temp);
				for (int k = 0; k < N-1; k++) {
					if (temp[k]==temp[k+1]) {
						c++;
						break;
					} 
				}
			}
			System.out.println("Case #"+(i+1)+": "+trace+" "+r+" "+c);
		}
	}
}