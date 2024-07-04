package codeJam;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.ArrayList;

public class Vestigium {

	static ArrayList<Integer> solveVestigium(int arr[][], int n,int cNum)
	{
		int maxR = 0;
		 int maxC = 0;

		int diagSum = 0;
		
		ArrayList<Integer> result= new ArrayList<Integer>();

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

					maxC++;
					break;
				}
			}

			for (Entry<Integer, Integer> entry : rows.entrySet()) {
				int temp = 0;
				if (entry.getValue() > 1) {

					maxR++;
					break;
				}
			}
		}
		result.add(cNum);
		result.add(diagSum);
		result.add(maxR);
		result.add(maxC);
		
		
		return result;
	}



	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int numOfTestCases = sc.nextInt();
		
		ArrayList<ArrayList<Integer>> sol= new ArrayList<>();

		String[] result = new String[numOfTestCases];

		for (int repeat = 0; repeat < numOfTestCases; repeat++) {

			int n = sc.nextInt();

			int arr[][] = new int[n][n];

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			
			sol.add(solveVestigium(arr, n,repeat+1));
		}	
		for(ArrayList<Integer> r: sol)
		{
			System.out.println("Case #"+r.get(0)+": "+ r.get(1)+" "+ r.get(2)+" "+ r.get(3));
		}
	}
	}
