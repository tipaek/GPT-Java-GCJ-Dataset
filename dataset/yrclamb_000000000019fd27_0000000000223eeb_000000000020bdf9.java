import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
	
	public String solve(int[][] T) {
		Arrays.sort(T, (a, b) -> a[0]-b[0]);
		int C = 0, J = 0;
		char[] ans = new char[T.length];
		
		for(int i = 0; i < T.length; i++) {
			int S = T[i][0];
			int E = T[i][1];
			
			if(S >= C) {
				ans[T[i][2]] = 'C';
				C = E;
			}
			else if(S >= J) {
				ans[T[i][2]] = 'J';
				J = E;
			}
			else return "IMPOSSIBLE";
		}
		
		return new String(ans);
	}
	
	public static void mainX(String[] args) {
		Solution Q = new Solution();
		System.out.println(Q.solve(new int[][] {{360, 480, 0},{420, 540, 1},{600, 660, 2}}));
		System.out.println(Q.solve(new int[][] {{99, 150, 0},{1, 100, 1},{100, 301, 2},{2,5, 3},{150, 250, 4}}));
		System.out.println(Q.solve(new int[][] {{0, 720, 0},{720, 1440, 1}}));
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		Solution Q = new Solution();
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
		in.nextLine();
		for (int i = 1; i <= t; ++i) {
			int N = in.nextInt();
			in.nextLine();
			int[][] T = new int[N][3];
			for(int j = 0; j < N; j++) {
				T[j][0] = in.nextInt();
				T[j][1] = in.nextInt();
				in.nextLine();
				T[j][2] = j;
			}
			String ans = Q.solve(T);
			System.out.println("Case #" + i + ": " + ans);
			System.out.flush();
		}
	}

}
