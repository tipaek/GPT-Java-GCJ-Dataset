package codeJam;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class Vestigium {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int numOfTestCases = sc.nextInt();

		String[] result = new String[numOfTestCases];

		for (int repeat = 0; repeat < numOfTestCases; repeat++) {

			int n = sc.nextInt();

			int arr[][] = new int[n][n];

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					arr[i][j] = sc.nextInt();
				}
			}

			int maxR = 0;
			int maxC = 0;

			int diagSum = 0;

			for (int i = 0; i < n; i++) {

				Map<Integer, Integer> cols = new HashMap<Integer, Integer>();

				Map<Integer, Integer> rows = new HashMap<Integer, Integer>();

				for (int j = 0; j < n; j++) {

					rows.put(arr[i][j], (rows.get(arr[i][j]) == null) ? 1 : rows.get(arr[i][j]) + 1);

					cols.put(arr[j][i], (cols.get(arr[j][i]) == null) ? 1 : cols.get(arr[j][i]) + 1);

					if (i == j) {
						diagSum += arr[i][j];
					}

				}

				for (Entry<Integer, Integer> entry : cols.entrySet()) {
					int temp = 0;
					if (entry.getValue() > 1) {

						temp += entry.getValue();
					}

					if (temp > maxC)
						maxC = temp;
				}

				for (Entry<Integer, Integer> entry : rows.entrySet()) {
					int temp = 0;
					if (entry.getValue() > 1) {

						temp += entry.getValue();
					}

					if (temp > maxR)
						maxR = temp;
				}
			}
					
			String res = "Case " + "#" + (repeat +1) + ":" + " " + diagSum + " " + maxR + " " + maxC;

			result[repeat] = res;
		}

		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
	}

}
