package googl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

	static void vestigium(int[][] m, int n) {
		int trace = 0;
		for (int i = 0; i < n; i++) {
			trace += m[i][i];
		}
		System.out.print(" " + trace);

		boolean[] elements;

		int dupRow = 0;

		for (int i = 0; i < n; i++) {
			elements = new boolean[n + 1];
			for (int j = 0; j < n; j++) {
				if (elements[m[i][j]]) {
					dupRow++;
					break;
				} else
					elements[m[i][j]] = true;
			}
		}

		System.out.print(" " + dupRow);

		int dupCol = 0;

		for (int i = 0; i < n; i++) {
			elements = new boolean[n + 1];
			for (int j = 0; j < n; j++) {
				if (elements[m[j][i]]) {
					dupCol++;
					break;
				} else
					elements[m[j][i]] = true;
			}
		}

		System.out.print(" " + dupCol);
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(
				System.in)));
		int t = in.nextInt();
		for (int i = 1; i <= t; ++i) {
			int n = in.nextInt();
			int m[][] = new int[n][n];

			for (int j = 0; j < n; j++) {
				for (int k = 0; k < n; k++) {
					m[j][k] = in.nextInt();
				}
			}
			System.out.print("\nCase #" + i + ":");
			vestigium(m, n);

		}
	}

}
