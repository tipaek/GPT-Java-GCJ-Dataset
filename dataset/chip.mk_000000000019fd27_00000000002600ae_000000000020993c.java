import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) {
		try (
			//BufferedReader ibr = new BufferedReader(new FileReader("D:/codejam_in.txt"));
			BufferedReader ibr = new BufferedReader(new InputStreamReader(System.in));
			Scanner sc = new Scanner(ibr)
			)
		{
			sc.useLocale(new Locale("US"));
			int parT = sc.nextInt();
			
			for (int t = 1; t <= parT; t++) {

				int n = sc.nextInt();
				
				int[][] m = new int[n][n];
				
				for (int i = 0; i < n; i++) 
					for (int j = 0; j < n; j++) 
						m[i][j] = sc.nextInt();
				
				int sum = 0;
				for (int i = 0; i < n; i++) sum += m[i][i];

				int[] ocs = new int[n];
				
				int rc = 0;
				for (int i = 0; i < n; i++) {
					Arrays.fill(ocs, 0);
					for (int j = 0; j < n; j++) 
						if (++ocs[m[i][j] - 1] > 1) {
							rc++;
							break;
						}
				}
				
				int cc = 0;
				for (int j = 0; j < n; j++) {
					Arrays.fill(ocs, 0);
					for (int i = 0; i < n; i++) 
						if (++ocs[m[i][j] - 1] > 1) {
							cc++;
							break;
						}
				}

				System.out.println(String.format("Case #%s: %s %s %s", t, sum, rc, cc));
				System.out.flush();

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}