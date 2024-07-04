

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner nik = new Scanner(System.in);
		int t = nik.nextInt();
		StringBuilder st = new StringBuilder();
		for (int tc = 1; tc <= t; tc++) {
			int n = nik.nextInt();

			int[][] a = new int[n][n];
			long ds = 0;
			HashSet<Integer>[] r = new HashSet[n];
			HashSet<Integer>[] c = new HashSet[n];
			for (int i = 0; i < n; i++) {
				c[i] = new HashSet<>();
			}
			for (int i = 0; i < n; i++) {
				r[i] = new HashSet<>();
				for (int j = 0; j < n; j++) {
					a[i][j] = nik.nextInt();
					c[j].add(a[i][j]);
					r[i].add(a[i][j]);
					if (i == j) {
						ds += a[i][j];
					}
				}
			}
			int cr = 0, cc = 0;
			for (int i = 0; i < r.length; i++) {

				if (r[i].size() != n) {
					cr++;
				}
				if (c[i].size() != n) {
					cc++;
				}
			}
			System.out.println("Case #" + (tc) + " " + ds + " " + cr + " " + cc);

		}
	//	System.out.println(st);
	}

}