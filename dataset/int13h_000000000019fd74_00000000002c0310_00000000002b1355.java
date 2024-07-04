import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		solve();
	}

	private static void solve() {
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

		int t = sc.nextInt();
		for (int i2 = 1; i2 <= t; i2++) {
			int r = sc.nextInt();
			int c = sc.nextInt();
			int levels [][] = new int[r][c];
			for (int i = 0; i < r; i++) {
				for (int j = 0; j < c; j++) {
					int s = sc.nextInt();
					levels[i][j] = s;
				}
			}
			System.out.println("Case #" + i2 + ": " + solution(r, c, levels));
		}

		sc.close();
	}

	private static String solution(int r, int c, int[][] levels) {
		//
		
		int total= 0;
		
		while (true) {
			//System.out.println(Arrays.deepToString(levels));
			int sum = sum(levels);
			
			boolean[][] skills = new boolean [r][c];
			
			for (int i = 0; i < r; i++) {
				for (int j = 0; j < c; j++) {
					if (levels[i][j] > 0) {
						skills[i][j] = calc(levels, i, j, r, c);
					}
				}
			}
			
			int eliminated = 0;
			for (int i = 0; i < r; i++) {
				for (int j = 0; j < c; j++) {
					if (levels[i][j] > 0) {
						if (skills[i][j]) {
							levels[i][j] = 0;
							eliminated++;
						}
					}
				}
			}
			//System.out.println("eli: " + eliminated);
			//System.out.println("sum: " + sum);
			total+=sum;
			
			if (eliminated == 0) {
				break;
			}

			
		}
		
		return ""+total;
	}

	private static boolean calc(int[][] levels, int r, int c, int rr, int cc) {
		ArrayList<Integer> rez = new ArrayList<Integer>();
		for (int j = c+1; j < cc; j++) {
			int f = levels[r][j];
			if (f != 0) {
				rez.add(f);
				break;
			}
		}
		for (int j = c-1; j >= 0; j--) {
			int f = levels[r][j];
			if (f != 0) {
				rez.add(f);
				break;
			}
		}
		
		
		for (int j = r+1; j < rr; j++) {
			int f = levels[j][c];
			if (f != 0) {
				rez.add(f);
				break;
			}
		}
		for (int j = r-1; j >= 0; j--) {
			int f = levels[j][c];
			if (f != 0) {
				rez.add(f);
				break;
			}
		}
		
		int ss = 0;
		for (int i = 0; i < rez.size(); i++) {
			ss+= rez.get(i);
		}
		boolean eli = levels[r][c]*rez.size() < ss; 
		//System.out.println(r + " " + c + " " + rez + " " + eli);
		
		return eli;
	}

	private static int sum(int[][] levels) {
		int sum = 0;
		for (int i = 0; i < levels.length; i++) {
			for (int j = 0; j < levels[i].length; j++) {
				sum += levels[i][j];
			}
		}
		return sum;
	}



}
