import java.util.*;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int tc = in.nextInt();
		for(int ts = 0; ts < tc; ts++) {
			int n = in.nextInt();
			int trace = 0, row = 0, col = 0;
			int cols[][] = new int[n][n];
			for(int i = 0; i < n; i++) {
				int rows[] = new int[n];
				for(int j = 0; j < n; j++) {
					int t = in.nextInt() - 1;
					if(t >= 0 && t < n) {
						rows[t]++;
						cols[j][t]++;
					}
					if(i == j)
						trace += t + 1;
				}
				//System.out.println(Arrays.toString(rows));
				for(int j = 0; j < n; j++)
					if(rows[j] > 1) {
						row++;
						break;
					}
			}
			for(int i = 0; i < n; i++)
				for(int j = 0; j < n; j++)
					if(cols[i][j] > 1) {
						col++;
						break;
					}
			System.out.println("Case #" + (ts + 1) + ": " + trace + " " + row + " " + col);
		}
		in.close();

	}

}