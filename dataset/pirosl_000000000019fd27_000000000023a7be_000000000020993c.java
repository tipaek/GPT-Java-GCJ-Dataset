import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.HashSet;
import java.util.Scanner;



public class Vestigium {
	
	static int[][] matr;
	
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); 
        for (int i = 1; i <= t; ++i) {
          int n = in.nextInt();
          readMatr(in, n);
          
          process(i);
        }
	}
	
	static void readMatr(Scanner in, int n) {
		matr = new int[n][n];
		
		for (int r = 0; r < n; ++r) {
			for (int c = 0; c < n; ++c) {
				matr[r][c] = in.nextInt();
			}
		}
	}
	
	static void process(int i) {
		int latin = calculateLatin();
		int rdup = 0;
		for (int r = 0; r < matr.length; r++) {
			if (dupRow(r)) {
				++rdup;
			}
		}
		int cdup = 0;
		for (int r = 0; r < matr.length; r++) {
			if (dupCol(r)) {
				++cdup;
			}
		}
		System.out.println("Case #" + i + ": " + latin + " " + rdup + " " + cdup);
	}
	
	static int calculateLatin() {
		int latin = 0;
		for (int i = 0; i < matr.length; ++i) {
			latin += matr[i][i];
		}
		
		return latin;
	}
	
	static boolean dupRow(int r) {
		Set<Integer> set = new HashSet<>();
		
		for (int c = 0; c < matr.length; ++c) {
			if (set.contains(matr[r][c])) {
				return true;
			}
			set.add(matr[r][c]);
		}
		
		return false;
	}
	
	static boolean dupCol(int c) {
		Set<Integer> set = new HashSet<>();
		
		for (int r = 0; r < matr.length; ++r) {
			if (set.contains(matr[r][c])) {
				return true;
			}
			set.add(matr[r][c]);
		}
		
		return false;
	}

}
