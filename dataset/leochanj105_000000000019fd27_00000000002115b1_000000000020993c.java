import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		int T = input.nextInt(), i, N, j, k, trace, row, col;
		Set<Integer> set = new HashSet<>();
		for(i = 0; i < T; i++) {
			N = input.nextInt();
			int M[][] = new int[N][N];
			for(j = 0; j < N; j++) {
				for(k = 0; k < N; k++) {
					M[j][k] = input.nextInt();
				}
			}
			row = 0;
			col = 0;
			trace = 0;
			for(j = 0; j < N;j++) trace += M[j][j];
//			set = new HashSet<>();
			for(j = 0; j < N;j++) {
				set.clear();
				for(k = 0; k < N; k++) {
					if(set.contains(M[j][k])) {
						row++;
						break;
					} else {
						set.add(M[j][k]);
					}
				}
			}
			for(j = 0; j < N;j++) {
				set.clear();
				for(k = 0; k < N; k++) {
					if(set.contains(M[k][j])) {
						col++;
						break;
					} else {
						set.add(M[k][j]);
					}
				}
			}
			System.out.println("Case #" + (i + 1) + ": " + trace + " " + row + " " + col);
			
		}
	}
}
