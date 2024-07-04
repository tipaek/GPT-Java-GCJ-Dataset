package com.example.codinground;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int caseNo = sc.nextInt();
		for (int x = 0; x < caseNo; x++) {
			int size = sc.nextInt();
			int trace = 0;
			int rowRepeat = 0;
			int colRepeat = 0;
			int[][] matrix = new int[size][size];
			Set<Integer> set = new HashSet<>();

			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					int val = sc.nextInt();

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
		sc.close();
	}

}
