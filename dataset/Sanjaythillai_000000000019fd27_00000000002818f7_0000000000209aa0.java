/**
 * 
 */
//package com.sanjay.google.code.jam.qual.services;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

/**
 * @author s0t01cz
 *
 */
class Solution {

	/**
	 * @param args
	 */

//Input
// 	
//Output
// 
//2
//3 6
//2 3
//
//  
//Case #1: POSSIBLE
//2 1 3
//3 2 1
//1 3 2
//Case #2: IMPOSSIBLE
	static class Result {
		String matrixPossible;
		int[][] mat;

		public String getMatrixPossible() {
			return matrixPossible;
		}

		public void setMatrixPossible(String matrixPossible) {
			this.matrixPossible = matrixPossible;
		}

		public int[][] getMat() {
			return mat;
		}

		public void setMat(int[][] mat) {
			this.mat = mat;
		}
	}

	private static final String POSSIBLE = "POSSIBLE";
	private static final String IMPOSSIBLE = "IMPOSSIBLE";

	public static void main(String[] args) {

		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			Integer T = Integer.parseInt(br.readLine());
			int mat[][] = null;
			int count = 0;
			while (T > 0) {
				String NK = br.readLine();
				String[] NKArr = NK.split(" ");
				int N = Integer.parseInt(NKArr[0]);
				int K = Integer.parseInt(NKArr[1]);

				mat = new int[N][N];
				for (int[] ar : mat) {
					Arrays.fill(ar, 0);
				}
				Result resultList = new Result();
				if (formLatinMatrix(N, K, mat, 0, 0)) {
					Integer diagonal = calculateDiagonal(mat, N);
					if (diagonal != K) {
						resultList.setMatrixPossible(IMPOSSIBLE);
						resultList.setMat(mat);
					} else {
						resultList.setMatrixPossible(POSSIBLE);
						resultList.setMat(mat);
					}
				} else {
					resultList.setMatrixPossible(IMPOSSIBLE);
					resultList.setMat(mat);
				}
				count++;
				System.out.println("Case #" + count + ": " + resultList.getMatrixPossible());
				if (resultList.getMatrixPossible() != null && !resultList.getMatrixPossible().equals(IMPOSSIBLE)) {
					printMatrix(resultList.getMat(), N);
				}
				T--;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void printMatrix(int[][] mat, int N) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(mat[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static boolean formLatinMatrix(int N, int K, int mat[][], int row, int col) {

		if (row >= N && col >= N) {
//			System.out.println("coming outside row ");
			return true;
		}
		if (validateMatrix(mat, N)) {
//			System.out.println("coming outside ");
			return true;
		}
		for (int i = row; i < N; i++) {
			for (int j = col; j < N; j++) {
				int sum = j + 1 + i;
				if (sum > N) {
					sum = sum % N;
				}
//				System.out.println("ren" + sum);
				mat[i][j] = sum;

				if (isSafe(mat, N)) {
//					mat[i][j] = (i + j + 1)%N;
					if (j == N - 1) {
						if (formLatinMatrix(N, K, mat, i + 1, 0))
							return true;
						else {
							mat[i][j] = 0;
						}
					} else {
						if (formLatinMatrix(N, K, mat, i, j + 1))
							return true;
						else {
							mat[i][j] = 0;
						}
					}
				} else {
					printMatrix(mat, N);
//					System.out.println("not safe ");
					mat[i][j] = 0;
				}
			}

		}
		return false;
	}

	private static boolean validateMatrix(int[][] mat, int N) {

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (mat[i][j] == 0) {
					return false;
				}
			}
		}
		return true;
	}

	private static boolean isSafe(int[][] mat, int n) {
		for (int i = 0; i < n; i++) {
			if (calculateColCount(mat, n, i) != 0) {
				return false;
			}
			if (calculateRowCount(mat, n, i) != 0) {
				return false;
			}
		}
		return true;
	}

	private static Integer calculateColCount(int[][] arr, int n, int col) {
		int colCount = 0;
		HashSet<Integer> duplicateColSet = new HashSet<Integer>();

		for (int i = 0; i < n; i++) {
			if (!duplicateColSet.contains(arr[i][col])) {
				duplicateColSet.add(arr[i][col]);
			} else if (arr[i][col] != 0) {
				colCount = colCount + 1;
				return colCount;
			}
		}
		return colCount;
	}

	private static Integer calculateRowCount(int[][] arr, int n, int col) {
		int rowCount = 0;
		HashSet<Integer> duplicateRowSet = new HashSet<Integer>();

		for (int i = 0; i < n; i++) {
			if (!duplicateRowSet.contains(arr[col][i])) {
				duplicateRowSet.add(arr[col][i]);
			} else if (arr[col][i] != 0) {
				rowCount = rowCount + 1;
				return rowCount;
			}
		}
		return rowCount;
	}

	private static Integer calculateDiagonal(int[][] mat, int n) {
		int diagonal = 0;
		for (int i = 0, j = 0; i < n && j < n; i++, j++) {
			diagonal += mat[i][j];
		}
		return diagonal;
	}

}
