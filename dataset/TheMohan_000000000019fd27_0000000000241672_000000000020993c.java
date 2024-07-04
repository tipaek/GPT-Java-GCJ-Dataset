package com.example.codinground;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int caseNo = in.nextInt();
		for (int x = 0; x < caseNo; x++) {
			int size = in.nextInt();
			int trace = 0;
			int rowRepeat = 0;
			int colRepeat = 0;
			int[][] matrix = new int[size][size];
			Set<Integer> set = new HashSet<Integer>();

			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					int val = in.nextInt();

					if (i == j)
						trace += val;

					matrix[i][j] = val;

					set.add(val);
					if (j == size - 1 && set.size() != size)
						rowRepeat++;
				}
				set.clear();
			}

			for (int j = 0; j < size; j++) {
				for (int i = 0; i < size; i++) {
					set.add(matrix[i][j]);
					if (i == size - 1 && set.size() != size)
						colRepeat++;
				}
				set.clear();
			}
			System.out.println(String.format("Case #%d: %d %d %d", x + 1, trace, rowRepeat, colRepeat));
		}
	}

}
