import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
	
	public int[] solve(int[][] M) {
		int trace = 0;
		for(int i = 0; i < M.length; i++)
			trace += M[i][i];
		
		int X = 0;
		for(int i = 0; i < M.length; i++) {
			Set<Integer> set = new HashSet<>();
			for(int j = 0; j < M[0].length; j++) {
				if(set.contains(M[i][j])) {
					X++;
					break;
				}
				set.add(M[i][j]);
			}
		}
		
		int Y = 0;
		for(int i = 0; i < M.length; i++) {
			Set<Integer> set = new HashSet<>();
			for(int j = 0; j < M[0].length; j++) {
				if(set.contains(M[j][i])) {
					Y++;
					break;
				}
				set.add(M[j][i]);
			}
		}
		return new int[] {trace, X, Y};
	}
	
	
	public static void main(String[] args) throws FileNotFoundException {
		Solution Q = new Solution();
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
		in.nextLine();
		for (int i = 1; i <= t; ++i) {
			int N = in.nextInt();
			in.nextLine();
			int[][] input = new int[N][N];
			for(int j = 0; j < N; j++) {
				for(int k = 0; k < N; k++) {
					input[j][k] = in.nextInt();
				}
				in.nextLine();
			}
			int[] output = Q.solve(input);
			System.out.println("Case #" + i + ": " + output[0] + " " + output[1] + " " + output[2]);
			System.out.flush();
		}
	}

}
