import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int tests = s.nextInt();
		
		for (int test = 1; test <= tests; test++) {
			int r = s.nextInt();
			int c = s.nextInt();
			
			int[][][] dancers = new int[r][c][5];
			for (int i = 0; i < r; i++) {
				for (int j = 0; j < c; j++) {
					dancers[i][j][0] = s.nextInt();
					dancers[i][j][1] = i-1;
					dancers[i][j][2] = j+1;
					dancers[i][j][3] = i+1;
					dancers[i][j][4] = j-1;
				}
			}
			
			boolean elim = true;
			int total = 0;
			
			while (elim) {
				elim = false;
				
				double[][] avgs = new double[r][c];
				for (int i = 0; i < r; i++) {
					for (int j = 0; j < c; j++) {
						if (dancers[i][j][0] == 0)
							continue;
						
						total += dancers[i][j][0];
						
						int[] around = new int[4];
						if (dancers[i][j][1] >= 0)
							around[0] = dancers[dancers[i][j][1]][j][0];
						if (dancers[i][j][2] < c)
							around[1] = dancers[i][dancers[i][j][2]][0];
						if (dancers[i][j][3] < r)
							around[2] = dancers[dancers[i][j][3]][j][0];
						if (dancers[i][j][4] >= 0)
							around[3] = dancers[i][dancers[i][j][4]][0];
							
						avgs[i][j] = avg(around);
					}
				}
				
				for (int i = 0; i < r; i++) {
					for (int j = 0; j < c; j++) {
						if (avgs[i][j] > dancers[i][j][0]) {
							elim = true;
							dancers[i][j][0] = 0;
							
							if (dancers[i][j][1] >= 0)
								dancers[dancers[i][j][1]][j][3] = dancers[i][j][3];
							if (dancers[i][j][2] < c)
								dancers[i][dancers[i][j][2]][4] = dancers[i][j][4];
							if (dancers[i][j][3] < r)
								dancers[dancers[i][j][3]][j][1] = dancers[i][j][1];
							if (dancers[i][j][4] >= 0)
								dancers[i][dancers[i][j][4]][2] = dancers[i][j][2];
						}
					}
				}
			}
			
			System.out.println("Case #" + test + ": " + total);
		}
		
		s.close();
	}

	
	private static double avg(int[] around) {
		double total = 0; 
		int count = 0;
		for (int i : around) {
			if (i > 0) {
				total += i;
				count++;
			}
		}
		return count > 0 ? total/count : 0;
	}
}