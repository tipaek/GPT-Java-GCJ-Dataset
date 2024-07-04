package com.CodeJam;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Vestiguim {

	public static void main(String[] args) {

		int n;
		int c = 1;

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		while (c <= n) {
			int l = sc.nextInt();
			int i, j, k = 0, rn = 0, cn = 0;
			Set<Integer> rs = new HashSet<Integer>();
			Set<Integer> cs = new HashSet<Integer>();
			int arr[][] = new int[l][l];

			for (i = 0; i < l; i++) {
				for (j = 0; j < l; j++) {
					arr[i][j] = sc.nextInt();
				}
			}

			for (i = 0; i < l; i++) {
				k = k + arr[i][i];
			}

			for (i = 0; i < l; i++) {
				boolean br = false, bc = false;
				for (j = 0; j < l; j++) {
					if (!br) {
						if (!rs.add(arr[i][j])) {
							rn++;
							br = true;
						}

					}
					if (!bc) {
						if (cs.add(arr[j][i])) {
							cn++;
							bc = true;
						}

					}
				}
			}
			System.out.println("Case #" + cs + ": " + k + " " + rn + " " + cn);
			c++;
		}

	}

}
