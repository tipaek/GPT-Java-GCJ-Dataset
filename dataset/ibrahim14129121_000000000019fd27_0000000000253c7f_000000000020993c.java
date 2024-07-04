import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/*
 * Copyright 2019 Ibrahim All rights reserved.
 */

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int testCase = scanner.nextInt();

		for (int i = 0; i < testCase; i++) {
			int traceSum = 0;
			int dSize = scanner.nextInt();
			int arr[][] = new int[dSize][dSize];
			int rowRepeated = 0;
			int columnRepeated = 0;
			LinkedList<int[]> columnMap = new LinkedList<int[]>();

			for (int j = 0; j < dSize; j++) {

				TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
				
				for (int k = 0; k < dSize; k++) {
					int p = scanner.nextInt();
					arr[j][k] = p;
					if (j == k) {
						traceSum += p;
					}
					map.put(p, (map.get(p) == null ? 0 : map.get(p)) + 1);
					int aMap[]=null;
					try {
						aMap = columnMap.get(k);
					} catch (Exception e) {
						aMap = new int[12];
					}
					aMap[p]=aMap[p] + 1;
					try {
						columnMap.set(k,aMap);
					} catch (Exception e) {
						columnMap.add(k,aMap);
					}
				}

				Object[] arr2 = map.values().toArray();
				Arrays.sort(arr2, Collections.reverseOrder());
				if ((int) arr2[0] > 1) {
					rowRepeated += 1;
				}
			}
			for (int k = 0; k <columnMap.size(); k++) {
				int ar[]=columnMap.get(k);
				for (int l = 0; l < ar.length; l++) {
					
					if (ar[l]>1) {
						columnRepeated++;
						break;
					}
				}
			}

			System.out.println("Case #" + (i + 1) + ":" + " " + traceSum + " " + rowRepeated + " " + columnRepeated);

		}

	}
}
