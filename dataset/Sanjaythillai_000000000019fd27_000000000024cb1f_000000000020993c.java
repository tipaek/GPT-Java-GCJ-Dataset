//package com.sanjay.google.code.jam.qual.services;
/**
 * 
 */
//package com.sanjay.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author s0t01cz
 *
 */
class Solution {

	/**
	 * @param args
	 * @throws IOException
	 * @throws NumberFormatException
	 */

	//
//	 3
//	 4
//	 1 2 3 4
//	 2 1 4 3
//	 3 4 1 2
//	 4 3 2 1
	public static void main(String[] args) {

		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			Integer T = Integer.parseInt(br.readLine());
			Integer arr[][] = null;
			int count = 0;
			while (T > 0) {
				String NStr = br.readLine();
				Integer N = Integer.parseInt(NStr);
				arr = new Integer[N][N];
				for (int i = 0; i < N; i++) {
					String C = br.readLine();
					String CBArr[] = C.split(" ");
					for (int j = 0; j < CBArr.length; j++) {
						arr[i][j] = Integer.parseInt(CBArr[j]);
					}
				}

				List<Integer> latinSquareList = findLatinTraceAndCount(arr, N);
				count++;
				System.out.println("Case #" + count + ": " + latinSquareList.get(0) + " " + latinSquareList.get(1) + " "
						+ latinSquareList.get(2));
				T--;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static List<Integer> findLatinTraceAndCount(Integer[][] arr, int N) {
		List<Integer> resultList = new ArrayList<Integer>();
		if (arr == null) {
			return null;
		}
		Integer diagonal=0,rowCount=0,colCount=0;
		diagonal += calculateDiagonal(arr, N);
		for(int i=0;i<N;i++)
		{
		 rowCount += calculateRowCount(arr, N, i);
		 colCount += calculateColCount(arr, N, i);
		}
		resultList.add(diagonal);
		resultList.add(rowCount);
		resultList.add(colCount);
		return resultList;
	}
//	 1 2 3 4
//	 2 1 4 3
//	 3 4 1 2
//	 4 3 2 1

	private static Integer calculateColCount(Integer[][] arr, int n, int col) {
		int colCount = 0;
		HashSet<Integer> duplicateColSet = new HashSet<Integer>();

		for (int i = 0; i < n; i++) {
			if (!duplicateColSet.contains(arr[i][col])) {
				duplicateColSet.add(arr[i][col]);
			} else {
				colCount = colCount + 1;
				return colCount;
			}
		}
		return colCount;
	}

	private static Integer calculateRowCount(Integer[][] arr, int n, int col) {
		int rowCount = 0;
		HashSet<Integer> duplicateRowSet = new HashSet<Integer>();

		for (int i = 0; i < n; i++) {
			if (!duplicateRowSet.contains(arr[col][i])) {
				duplicateRowSet.add(arr[col][i]);
			} else {
				rowCount = rowCount + 1;
				return rowCount;
			}
		}
		return rowCount;
	}

	private static Integer calculateDiagonal(Integer[][] arr, int n) {
		int diagonal = 0;
		for(int i=0,j=0; i<n&&j<n ;i++,j++)
		{
			diagonal += arr[i][j];
		}
		return diagonal;
	}

}
