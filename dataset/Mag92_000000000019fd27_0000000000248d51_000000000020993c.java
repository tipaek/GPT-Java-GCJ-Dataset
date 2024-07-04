package com.magdysul;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
class Matrix {
	int[][] val;
	int trace;
	int size;
	public int getTrace() {
		int sum = 0;
		for(int i = 0; i < size; i++) {
			sum += val[i][i];
		}
		return sum;
	}
}
public class Vestigium {
	public static void main(String[] args) {
		List<Matrix> matrices = new ArrayList<>();
		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt();
		for (int i = 0; i < T; i++) {
			// new matrix
			Matrix x = new Matrix();
			x.size = scanner.nextInt();
			x.val = new int[x.size][x.size];
			for(int j = 0; j < x.size; j++) {
				for(int k = 0; k < x.size; k++) {
					x.val[j][k] = scanner.nextInt();
				}
			}
			matrices.add(x);
			generateSolution(T, x);
		}
		scanner.close();
		
	}

	private static void generateSolution(int T, Matrix x) {
		// case number? T
		System.out.print("Case #" + T + ": ");
		// calculate trace
		System.out.print(x.getTrace());
		// num of rows containing repeated items
		int repeatedR = 0;
		Map<Integer, Integer> rows = new HashMap<>();
		for(int i = 0; i < x.size; i++) {
			for(int j = 0; j < x.size; j++) {
				if (rows.get(x.val[i][j]) != null) { repeatedR++; break; }
				else { rows.put(x.val[i][j], 1); }
			}
			rows.clear();
		}
		// print rows:
		System.out.print(" " + repeatedR + " ");
		// num of columns containing repeated items
		int repeatedC = 0;
		Map<Integer, Integer> columns = new HashMap<>();
		for(int i = 0; i < x.size; i++) {
			for(int j = 0; j < x.size; j++) {
				if (columns.get(x.val[j][i]) != null) { repeatedC++; break; }
				else { columns.put(x.val[j][i], 1); }
			}
			columns.clear();
		}
		// print rows:
		System.out.print(repeatedC + "\n");
			
	}
}
