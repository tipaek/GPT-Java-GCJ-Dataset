import java.util.Scanner;

public class Solution{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
		int tests = s.nextInt();
		
		for (int i = 1; i <= tests; i++) {
			int n = s.nextInt();
		
			int trace = 0;
			
			boolean[][] rows = new boolean[n][n];
			boolean[][] cols = new boolean[n][n];
			for (int r = 0; r < n; r++) {
				for (int c = 0; c < n; c++) {
					int num = s.nextInt() - 1;
					rows[r][num] = true;
					cols[c][num] = true;
					
					if (r == c)
						trace += num + 1;
				}
			}
			
			int row = 0;
			int col = 0;
			
			for (int r = 0; r < n; r++) {
				for (int j = 0; j < n; j++) {
					if (!rows[r][j]) {
						row++;
						break;
					}
				}
			}
			
			for (int c = 0; c < n; c++) {
				for (int j = 0; j < n; j++) {
					if (!cols[c][j]) {
						col++;
						break;
					}
				}
			}
			
			System.out.println("Case #" + i + ": " + trace + " " + row + " " + col);
		}

		s.close();
		
	}
}