import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
	static Scanner in;
	static int T;
	
	static int N;
	static int[][] mat;
	
	public static void main(String[] args) {
		in = new Scanner(System.in);
		T = in.nextInt();
		
		for(int c = 1; c <= T; c++) {
			readInput();
			
			String sol = trace() + " " + repeatRows() + " " + repeatCols();
			
			System.out.println("Case #" + c + ": " + sol);
		}
		
		in.close();
	}
	
	public static void readInput() {
		N = in.nextInt();
		
		mat = new int[N][N];
		for(int i = 0; i < N; i++)
			for(int j = 0; j < N; j++)
				mat[i][j] = in.nextInt();
	}
	
	public static int trace() {
		int trace = 0;
		for(int i = 0; i < N; i++)
			trace += mat[i][i];
		return trace;
	}
	
	public static int repeatRows() {
		int count = 0;
		for(int i = 0; i < N; i++) {
			Set<Integer> seen = new HashSet<>();
			for(int j = 0; j < N; j++)
				seen.add(mat[i][j]);
			if(seen.size() < N)
				count++;
		}
		return count;
	}
	
	public static int repeatCols() {
		int count = 0;
		for(int i = 0; i < N; i++) {
			Set<Integer> seen = new HashSet<>();
			for(int j = 0; j < N; j++)
				seen.add(mat[j][i]);
			if(seen.size() < N)
				count++;
		}
		return count;
	}
}
