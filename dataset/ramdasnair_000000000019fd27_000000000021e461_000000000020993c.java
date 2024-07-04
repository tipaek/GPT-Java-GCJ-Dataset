import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		
		for(int x = 0; x < t; x++) {
			int n = sc.nextInt();
			
			int[][] a = new int[n][n];
			
			int trace = 0;
			int rReps = 0;
			int cReps = 0;
			
			Set<Integer> reps = new HashSet<Integer>();
			boolean isRep = false;
			
			for(int r=0; r < n; r++) {
				
				reps = new HashSet<Integer>();
				isRep = false;
				
				for(int c=0; c < n; c++) {
					a[r][c] = sc.nextInt();
					if (r == c) {
						trace += a[r][c];
					}
					
					if (!(reps).contains(Integer.valueOf(a[r][c]))) {
						(reps).add(a[r][c]);
					} else {
						isRep = true;
					}
				}
				
				if (isRep) rReps++;
			}
			
			for(int c=0; c < n; c++) {
				
				reps = new HashSet<Integer>();
				isRep = false;
				
				for(int r=0; r < n; r++) {
					if (!(reps).contains(Integer.valueOf(a[r][c]))) {
						(reps).add(a[r][c]);
					} else {
						isRep = true;
					}
				}
				
				if (isRep) cReps++;
			}
			
			System.out.println("Case #" + (x+1) + ": " + trace + " " + rReps + " " + cReps);
		}
	}
}
