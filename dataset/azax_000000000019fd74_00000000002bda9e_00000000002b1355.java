import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.ArrayList;

public class Solution {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int numCases = Integer.parseInt(sc.nextLine());
		for (int index = 0; index < numCases; index++) {
			String[] line = sc.nextLine().split(" ");
			int r = Integer.parseInt(line[0]);
			int c = Integer.parseInt(line[1]);
			
			int[][] dancers = new int[r][c];
			for (int row = 0; row < r; row++) {
				String[] thisRow = sc.nextLine().split(" ");
				for (int col = 0; col < c; col++) {
					dancers[row][col] = Integer.parseInt(thisRow[col]);
				}
			}
			
			long result = simulate(dancers);
			System.out.println("Case #" + (index + 1) + ": " + result);
		}
		sc.close();
		
	}
	
	private static long simulate(int[][] dancers) {
		long interest = 0;
		
		boolean eliminated = true;
		int roundNumber = 0;
		while (eliminated) {
			eliminated = advance(dancers, roundNumber + 1);
			roundNumber++;
		}
		for (int r = 0; r < dancers.length; r++) {
			for (int c = 0; c < dancers[0].length; c++) {
				int val = dancers[r][c];
				if (val < 0) {
					interest -= val;
				} else {
					interest += roundNumber * val;
				}
			}
		}
		
		return interest;
	}
	
	private static boolean advance(int[][] dancers, int roundNumber) {
		boolean eliminated = false;
		
		ArrayList<Integer> toEliminate = new ArrayList<>();
		for (int r = 0; r < dancers.length; r++) {
			for (int c = 0; c < dancers[0].length; c++) {
				if (dancers[r][c] < 0) { continue; }
				
				int[] neighbors = getNeighbors(dancers, r, c);
				
				int leftR = neighbors[0], leftC = neighbors[1];
				int rightR = neighbors[2], rightC = neighbors[3];
				int upR = neighbors[4], upC = neighbors[5];
				int downR = neighbors[6], downC = neighbors[7];
				
				int extant = 0;
				long sum = 0;
				if (leftR != -1) {
					sum += dancers[leftR][leftC];
					extant++;
				}
				if (rightR != -1) {
					sum += dancers[rightR][rightC];
					extant++;
				}
				if (upR != -1) {
					sum += dancers[upR][upC];
					extant++;
				}
				if (downR != -1) {
					sum += dancers[downR][downC];
					extant++;
				}
				
				long comp = ((long) extant) * dancers[r][c];
				if (sum > comp) {
					eliminated = true;
					toEliminate.add(r);
					toEliminate.add(c);
				}
			}
		}
		
		for (int i = 0; i < toEliminate.size(); i += 2) {
			int r = toEliminate.get(i);
			int c = toEliminate.get(i + 1);

			dancers[r][c] = - (roundNumber * dancers[r][c]);
		}
		
		return eliminated;
	}
	
	private static int[] getNeighbors(int[][] dancers, int r, int c) {
		int[] ret = new int[8];
		
		int r1 = r - 1, c1 = c;
		while (r1 >= 0 && dancers[r1][c1] < 0) {
			r1--;
		}
		if (r1 == -1) {
			ret[0] = -1;
			ret[1] = -1;
		} else {
			ret[0] = r1;
			ret[1] = c1;
		}
		
		r1 = r + 1;
		while (r1 < dancers.length && dancers[r1][c1] < 0) {
			r1++;
		}
		if (r1 == dancers.length) {
			ret[2] = -1;
			ret[3] = -1;
		} else {
			ret[2] = r1;
			ret[3] = c1;
		}
		
		r1 = r; c1 = c - 1;
		while (c1 >= 0 && dancers[r1][c1] < 0) {
			c1--;
		}
		if (c1 == -1) {
			ret[4] = -1;
			ret[5] = -1;
		} else {
			ret[4] = r1;
			ret[5] = c1;
		}
		
		c1 = c + 1;
		while (c1 < dancers[0].length && dancers[r1][c1] < 0) {
			c1++;
		}
		if (c1 == dancers[0].length) {
			ret[6] = -1;
			ret[7] = -1;
		} else {
			ret[6] = r1;
			ret[7] = c1;
		}	
		
		return ret;
	}
}
