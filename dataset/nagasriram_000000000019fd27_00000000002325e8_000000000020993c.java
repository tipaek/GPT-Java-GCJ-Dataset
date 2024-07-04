package demo;

import java.util.Scanner;

public class DemoTranslation {
	public static void main() {
		int n, t = 0, c = 0, ro = 0, r, s, p, m;
		int[][] a = new int[100][100], b = new int[100][20];
		n = STDIN_SCANNER.nextInt();
		for(int i = 1; i <= n; i++) {
			r = STDIN_SCANNER.nextInt();
			for(int j = 1; j <= r; j++) {
				for(int k = 1; k <= r; k++) {
					a[j][k] = STDIN_SCANNER.nextInt();
				}
			}
			for(int j = 1; j <= r; j++) {
				for(int k = 1; k <= r; k++) {
					if(i == k) {
						t = t + a[j][k];
					}
				}
			}
			for(int j = 1; j <= r; j++) {
				s = 0;
				for(int k = 1; k <= r; k++) {
					p = a[j][k];
					for(int l = 1; l <= r; l++) {
						if(l != k) {
							if(a[j][l] == p) {
								s = s + 1;
							}
						}
					}
				}
				if(s > 0) {
					ro = ro + 1;
				}
			}
			for(int j = 1; j <= r; j++) {
				s = 0;
				for(int k = 1; k <= r; k++) {
					p = a[k][j];
					for(int l = 1; l <= r; l++) {
						if(l != k) {
							if(a[l][j] == p) {
								s = s + 1;
							}
						}
					}
				}
				if(s > 0) {
					c = c + 1;
				}
			}
			b[i][1] = t;
			b[i][2] = ro;
			b[i][3] = c;
			t = 0;
			ro = 0;
			c = 0;
		}
		for(int i = 1; i <= n; i++) {
			System.out.println("case #" + i + ": " + b[i][1] + " " + b[i][2] + " " + b[i][3]);
		}
	}

	public final static Scanner STDIN_SCANNER = new Scanner(System.in);
}