import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		try (Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
			int t = in.nextInt();
			for (int i = 1; i <= t; ++i) {
				int n = in.nextInt();
				int vs[][] = new int[n][n];
				int sum = 0;
				int r, rr = 0;
				StringBuilder row = null;
				for (int v = 0; v < n; ++v) {
					r = 0;
					row = new StringBuilder("");
					for (int s = 0; s < n; ++s) {
						vs[v][s] = in.nextInt();
						if (v == s) {
							sum += vs[v][s];
						}
						if (row.toString().indexOf(vs[v][s] + "") > -1) {
							r++;
						}
						row.append(vs[v][s]);
					}
					if (r > 0) {
						rr++;
					}
				}
				int c, cc = 0;
				for (int v = 0; v < n; ++v) {
					c = 0;
					row = new StringBuilder("");
					for (int s = 0; s < n; ++s) {
						if (row.toString().indexOf(vs[s][v] + "") > -1) {
							c++;
						}
						row.append(vs[s][v]);
					}
					if (c > 0) {
						cc++;
					}
				}
				System.out.println("Case #" + i + ": " + sum + " " + rr + " " + cc);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}