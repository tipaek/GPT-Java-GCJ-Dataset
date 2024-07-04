/*
 *created by Kraken on 29-03-2020 at 14:17
 */
//package com.kraken;

import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) {
		FastReader sc = new FastReader();
		int tt = sc.nextInt();
		for (int t = 1; t <= tt; t++) {
			int n = sc.nextInt();
			int[][] mat = new int[n][n];
			long k = 0, r = 0, c = 0;
			for (int i = 0; i < n; i++) for (int j = 0; j < n; j++) {
				mat[i][j] = sc.nextInt();
				if (i == j) k += mat[i][j];
			}
			Set<Integer> set;
			for (int i = 0; i < n; i++) {
				set = new HashSet<>();
				boolean found = false;
				for (int j = 0; j < n; j++) {
					if (set.contains(mat[i][j])) found = true;
					else set.add(mat[i][j]);
				}
				if (found) r++;
			}
			for (int i = 0; i < n; i++) {
				set = new HashSet<>();
				boolean found = false;
				for (int j = 0; j < n; j++) {
					if (set.contains(mat[j][i])) found = true;
					else set.add(mat[j][i]);
				}
				if (found) c++;
			}
			System.out.printf("Case #%d: %d %d %d\n", t, k, r, c);
		}
	}

	static class FastReader {

		BufferedReader br;

		StringTokenizer st;

		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				}
				catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		long nextLong() {
			return Long.parseLong(next());
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}

		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			}
			catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}
}
