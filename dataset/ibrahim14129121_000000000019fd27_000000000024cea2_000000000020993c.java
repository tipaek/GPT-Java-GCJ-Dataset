import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/*
 * Copyright 2019 BJIT Ltd All rights reserved.
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
			HashMap<Integer, HashMap<Integer, Integer>> columnMap = new HashMap<Integer, HashMap<Integer, Integer>>();

			for (int j = 0; j < dSize; j++) {

				TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
				for (int k = 0; k < dSize; k++) {
					int p = scanner.nextInt();
					arr[j][k] = p;
					if (j == k) {
						traceSum += p;
					}
					map.put(p, (map.get(p) == null ? 0 : map.get(p)) + 1);
					HashMap<Integer, Integer> aMap = columnMap.get(k) == null ? new HashMap<Integer, Integer>()
							: columnMap.get(k);
					aMap.put(p, (aMap.get(p) == null ? 0 : aMap.get(p)) + 1);
					columnMap.put(k, aMap);

				}

				Object[] arr2 = map.values().toArray();
				Arrays.sort(arr2, Collections.reverseOrder());
				if ((int) arr2[0] > 1) {
					rowRepeated += 1;
				}

				for (Map.Entry<Integer, HashMap<Integer, Integer>> entry : columnMap.entrySet()) {
					Object[] arr1 = entry.getValue().values().toArray();
					Arrays.sort(arr1, Collections.reverseOrder());
					if ((int) arr1[0] > 1) {
						columnRepeated = (int) arr1[0];
						break;
					}
				}
			}

			System.out.println("Case #" + (i + 1) + ":" + " " + traceSum + " " + rowRepeated + " " + columnRepeated);

		}

	}
}
