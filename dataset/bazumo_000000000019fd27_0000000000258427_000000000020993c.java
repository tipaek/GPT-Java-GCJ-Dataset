import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws Exception {


		Scanner sc = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);

		int testCases = sc.nextInt();
		for (int testCase = 1; testCase <= testCases; testCase++) {
			int n = sc.nextInt();
			
			int k = 0;
      int r = 0;
      int c = 0;
			
			boolean[][] row = new boolean[n][n];
			boolean[][] col = new boolean[n][n];

      boolean[] row_d = new boolean[n];
			boolean[] col_d = new boolean[n];

			
			for (int i = 0; i < n; i++) {
			    for (int j = 0; j < n; j++) {
			      int x = sc.nextInt();
				    if(i == j){
				        k += x;
				    }


				    if(row[i][x-1] == true){
                if(row_d[i] == false){
                  r += 1;
                }
                row_d[i] = true;
				    }
				    if(col[x-1][j] == true){
              if(col_d[j] == false){
                  c += 1;
                }
                col_d[j] = true;
				    }
            row[i][x-1] = true;
            col[x-1][j] = true;
			    }
			}
		
			

			
			pw.printf("Case #" + testCase + ": %d %d %d\n", k,r,c);
			pw.flush();
		}

		pw.close();
		sc.close();
	}
}