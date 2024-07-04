import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Solution s = new Solution();
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
		for (int i = 1; i <= t; ++i) {
			int r = in.nextInt();
			int c = in.nextInt();
			int[][] floor = new int[r][c];

			int initialsum = 0;
			for (int a = 0; a < r; a++) {
				for (int b = 0; b < c; b++) {
					floor[a][b] = in.nextInt();
					initialsum += floor[a][b];
				}
			}

			int ans = s.dance(floor, initialsum);

			System.out.println("Case #" + i + ": " + ans);
		}
		in.close();

	}

	int[][] dirs = new int[][] {{1,0},{0,1},{-1,0},{0,-1}};
	
	private int dance(int[][] floor, int sum) {
		
		for (int a = 0; a < floor.length; a++) {
			for (int b = 0; b < floor[0].length; b++) {
				if (floor[a][b] != Integer.MAX_VALUE) {
					checkCandidate(floor, a, b);
				}
			}
		}

		int round = 0;
		boolean next = false;
		for (int a = 0; a < floor.length; a++) {
			for (int b = 0; b < floor[0].length; b++) {
				if (floor[a][b] < 0) {
					floor[a][b] = Integer.MAX_VALUE;
					next = true;
				} else if (floor[a][b] != Integer.MAX_VALUE) {
					round += floor[a][b];
					
				}
			}
		}
		
		if (next) {
			return dance(floor, sum + round);
		} else {
			return sum;
		}

	}
	
	private int getNeigboorSkill(int[][] floor, int a, int b, int dir) {
		if (a < 0 || b < 0 || a >= floor.length || b >= floor[0].length) {
			return 0;
		}
		int skill = floor[a][b];
		if (floor[a][b] == Integer.MAX_VALUE) {
			skill = getNeigboorSkill(floor, a + dirs[dir][0], b + dirs[dir][1], dir); 
		} 
		return skill;
	}

	private void checkCandidate(int[][] floor, int a, int b) {
		int count = 0;
		double sum = 0;
		
		for (int i = 0; i < dirs.length; i++) {
			int skill = getNeigboorSkill(floor, a + dirs[i][0], b + dirs[i][1], i);
			if (skill != 0 ) {
				count++;
				sum += Math.abs(skill);
			}
		}
		if (count > 0) {
			double avg = (sum / count);
			if (floor[a][b] < avg) { 
				floor[a][b] = floor[a][b] * -1;
			}
			
		}
		
	}

}
