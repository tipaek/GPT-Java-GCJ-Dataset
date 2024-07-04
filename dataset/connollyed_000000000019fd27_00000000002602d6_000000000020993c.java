import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

public class Solution {
	public static void main(String args[]) {
		

		Scanner input = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

		int T = input.nextInt();

		for (int t = 0; t < T; t++) {
			int N = input.nextInt();
			int matrix[][] = new int[N][N];
			
			// Read matrix
			for (int r = 0; r < N; r++) {
				for(int c = 0; c<N; c++) {
					matrix[r][c] = input.nextInt();
				}
			}
			
			int trace = 0;
			for (int r = 0; r < N; r++) {
				for(int c = 0; c<N; c++) {
					if( r == c ) {
						trace = trace + matrix[r][c];
					}
				}
			}
			
			int repeated_rows = 0;
			
			
			for (int r = 0; r < N; r++) {
				HashSet<Integer> seen = new HashSet<>();
				for(int c = 0; c<N; c++) {
					int cur = matrix[r][c];
					if( seen.contains(cur)) {
						repeated_rows++;
						break;
					} else {
						seen.add(cur);
					}
				}
			}
			
			int repeated_cols = 0;
			
			for (int c = 0; c < N; c++) {
				HashSet<Integer> seen = new HashSet<>();
				for(int r = 0; r<N; r++) {
					int cur = matrix[r][c];
					if( seen.contains(cur)) {
						repeated_cols++;
						break;
					} else {
						seen.add(cur);
					}
				}
			}
			
			
			
			
			System.out.println("Case #" + (t+1) +": " + trace + " " + repeated_rows + " " + repeated_cols);
		}
	}
}
