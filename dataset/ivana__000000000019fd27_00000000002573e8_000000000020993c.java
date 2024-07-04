package Task1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {

	public static boolean isDifferent(int[] arr) {
		HashSet<Integer> set = new HashSet<>();
		for (int i = 0; i < arr.length; i++) {
			if (set.contains(arr[i]))
				return false;
			else
				set.add(arr[i]);
		}
		return true;
	}

	public static int trace(int[][] mat) {
		int trace = 0;
		for (int i = 0; i < mat[0].length; i++) {
			trace += mat[i][i];
		}
		// 00 11 22

		return trace;

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int testCasesNum;

		String st = sc.nextLine();
		testCasesNum = Integer.parseInt(st);

		for (int i = 0; i < testCasesNum; i++) {

			// ucitavanje matrice
			int n = Integer.parseInt(sc.nextLine());
			int[][] mat = new int[n][n];
			for (int j = 0; j < n; j++) {
				st = sc.nextLine();
				String[] s = st.split(" ");
				for (int k = 0; k < n; k++)
					mat[j][k] = Integer.parseInt(s[k]);
			}

			// provera redova i kolona
			int r = 0, c = 0;
			for (int j = 0; j < n; j++) {
				if (!isDifferent(mat[i]))
					r++;

				int[] col = new int[n];
				for (int k = 0; k < n; k++) {
					col[k] = mat[k][j];
				}
				if (!isDifferent(col))
					c++;
			}

			System.out.println("Case #" + (i + 1) + ": " + trace(mat) + " " + r + " " + c);
		}

	}
}