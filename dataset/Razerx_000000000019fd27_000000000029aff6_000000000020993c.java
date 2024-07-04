import java.util.Scanner;
import java.util.HashSet;

public class Solution {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int i = 0; i < t; i++) {
			int r = 0, c = 0, s = 0;
			int n = sc.nextInt();
			int a[][] = new int[n][n];
			for (int j = 0; j < n; j++) {
				HashSet<Integer> hs = new HashSet<>();
				boolean flag = true;
				for (int k = 0; k < n; k++) {
					a[j][k] = sc.nextInt();
					if (hs.contains(a[j][k]) && flag) {
						r++;
						flag = false;
					} else {
						hs.add(a[j][k]);
					}
					if (j == k) {
						s += a[j][k];
					}
				}
			}
			for (int j = 0; j < n; j++) {
				HashSet<Integer> hs = new HashSet<>();
				for (int k = 0; k < n; k++) {
					if (hs.contains(a[k][j])) {
						c++;
						break;
					} else {
						hs.add(a[k][j]);
					}
				}
			}
			System.out.println("Case #" + (i + 1) + ": " + s + " " + r + " " + c);
		}
		sc.close();
	}
}