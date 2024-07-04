import java.util.*;

public class Main {

	public static void main(String[] args) {
	
		Scanner stdin = new Scanner(System.in);
		int nC = stdin.nextInt();
		
		for (int loop=1; loop<=nC; loop++) {
		
			int n = stdin.nextInt();
			int[][] g = new int[n][n];
			
			
			// Read in.
			for (int i=0; i<n; i++) 
				for (int j=0; j<n; j++)
					g[i][j] = stdin.nextInt();
					
			// Get trace.
			int trace = 0;
			for (int i=0; i<n; i++) trace += g[i][i];
			
			// See rows with repeats.
			int sameRow = 0;
			for (int i=0; i<n; i++) {
				int[] freq = new int[n];
				boolean ok = true;
				for (int j=0; j<n; j++) {
					freq[g[i][j]-1]++;
					if (freq[g[i][j]-1] > 1) ok = false;
				}
				if (!ok) sameRow++;
			}
				
			// And columns.
			int sameCol= 0;
			for (int j=0; j<n; j++) {
				int[] freq = new int[n];
				boolean ok = true;
				for (int i=0; i<n; i++) {
					freq[g[i][j]-1]++;
					if (freq[g[i][j]-1] > 1) ok = false;
				}
				if (!ok) sameCol++;
			}

			// Ta da!
			System.out.println("Case #"+loop+": "+trace+" "+sameRow+" "+sameCol);
		}
	}
}