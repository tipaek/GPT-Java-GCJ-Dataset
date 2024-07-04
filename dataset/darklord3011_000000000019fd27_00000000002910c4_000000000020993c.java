import java.util.*;
import java.io.*;

public class Solution{
    

	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		for (int l = 0; l < t; l++) {
			int n = scan.nextInt();
			int a[][] = new int[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					a[i][j] = scan.nextInt();
				}
			}
			int rcount = 0;
			int trace = 0;
			int ccount = 0;
			for (int i = 0; i < n; i++) {
				ArrayList<Integer> b = new ArrayList<Integer>();
				for (int j = 0; j < n; j++) {
					if (b.contains(a[i][j])) {
						rcount++;
						break;
					} else {
						b.add(a[i][j]);
					}
					
				}
				//System.out.println(b);
			}

			for (int i = 0; i < n; i++) {
				ArrayList<Integer> c = new ArrayList<Integer>();
				for (int j = 0; j < n; j++) {
					if (c.contains(a[j][i])) {
						ccount++;
						break;
					} else {
						c.add(a[j][i]);
					}
				}
			}
			for (int i = 0; i < n; i++) {
				trace += a[i][i];
			}

			System.out.println("Case #" + (l+1) + ": " + trace + " " + rcount + " " + ccount);
		}
	}


}