import java.util.*;
public class Solution {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int cases = scan.nextInt();
		for (int i = 1; i <= cases; i++) {
			int N = scan.nextInt();
			int[][] MAT = new int[N][N];
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					MAT[j][k] = scan.nextInt();
				}
			}
			int k = 0;
			int r = repeatr(MAT,N);
			int c = repeatc(MAT,N);
			for(int j = 0; j < N; j++)
			{k += MAT[j][j];}
			System.out.printf("Cases #%d: %d %d %d\n", i, k, r, c);
		}
	}
	
	public static int repeatr(int[][] MAT, int N) {
		int count = 0;
		boolean check = false;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N-1; j++) {
				for (int k = j+1; k < N; k++) {
					if (MAT[i][j] == MAT[i][k]) {
						count++;
						check = true;
						break;
					}
				}
				if (check)
				break;
			}
		}
		
		return count;
	}
	public static int repeatc(int[][] MAT, int N) {
		boolean check = false;
		int count = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N-1; j++) {
				for (int k = j+1; k < N; k++) {
					if (MAT[j][i] == MAT[k][i]) {
						count++;
						check = true;
						break;
					}
				}
				if (check)
					break;
			}
		}
		
		return count;
	}
}
