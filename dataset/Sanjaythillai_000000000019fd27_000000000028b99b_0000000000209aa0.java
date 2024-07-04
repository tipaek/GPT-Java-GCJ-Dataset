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
public class Solution {

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
				for (int i = 1; i <= N; i++) {
					mat[0][0] = i;
					if (formLatinMatrix(N, K, mat, 0, 1)) {
						resultList.setMatrixPossible(POSSIBLE);
						resultList.setMat(mat);
						break;
					} else {
						resultList.setMatrixPossible(IMPOSSIBLE);
						resultList.setMat(mat);
					}
				}
//				if (formLatinMatrix(N, K, mat, 0, 0)) {
//					Integer diagonal = calculateDiagonal(mat, N);
//					if (diagonal != K) {
//						resultList.setMatrixPossible(IMPOSSIBLE);
//						resultList.setMat(mat);
//					} else {
//						resultList.setMatrixPossible(POSSIBLE);
//						resultList.setMat(mat);
//					}
//				} else {
//					resultList.setMatrixPossible(IMPOSSIBLE);
//					resultList.setMat(mat);
//				}
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

	private static boolean formLatinMatrix(int N, int K, int mat[][], int i, int j) {
		// System.out.println("entering formlatinmatrix" + " row:" + i + " col:" + j);

		if (i >= N && j >= N) {
			return true;
		}
//		if (validateMatrix(mat, N, K)) {
////			System.out.println("coming outside ");
//			return true;
//		}
		for (int num = 1; num <= N; num++) {
			//printMatrix(mat, N);
			if (isSafe(mat, N, i, j, num)) {

				mat[i][j] = num;
			//	printMatrix(mat, N);
				if (i == N - 1 && j == N - 1) {
					Integer diagonal = calculateDiagonal(mat, N);
					if (diagonal == K) {
						return true;
					}
				} else if (j == N - 1) {
					if (formLatinMatrix(N, K, mat, i + 1, 0))
						return true;

				} else {
					if (formLatinMatrix(N, K, mat, i, j + 1))
						return true;
				}
			} else {
				mat[i][j] = 0;
			}
		}
		// mat[i][j] = 0;
		return false;
	}


	private static boolean isSafe(int[][] mat, int n, int row, int col, int num) {
//		for (int i = 0; i < n; i++) {
//			if (calculateColCount(mat, n, i) != 0) {
//				System.out.println("returning false from issafe");
//				return false;
//			}
//			if (calculateRowCount(mat, n, i) != 0) {
//				System.out.println("returning false from issafe");
//				return false;
//			}
//		}
		for (int i = col; i >= 0; i--) {
			if (mat[row][i] == num) {
				return false;
			}
		}
		for (int i = row; i >= 0; i--) {
			if (mat[i][col] == num) {
				return false;
			}
		}

		//System.out.println("returning true from issafe");
		return true;
	}

	

	private static Integer calculateDiagonal(int[][] mat, int n) {
		int diagonal = 0;
		for (int i = 0, j = 0; i < n && j < n; i++, j++) {
			diagonal += mat[i][j];
		}
		return diagonal;
	}

}
