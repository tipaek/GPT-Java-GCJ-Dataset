/**
 * 
 */
//package com.sanjay.google.code.jam.qual.services;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

/**
 * @author s0t01cz
 *
 */
//4
//3
//360 480
//420 540
//600 660
//3
//0 1440
//1 3
//2 4
//5
//99 150
//1 100
//100 301
//2 5
//150 250
//2
//0 720
//720 1440
class Solution {
	// 4
	// 3
	// 360 480
	// 420 540
	// 600 660
	private static final String C = "C";
	private static final String J = "J";
	private static final String IMPOSSIBLE = "IMPOSSIBLE";

	static class Pair {
		Integer first;
		Integer second;
		Integer index;

		Pair(Integer first, Integer second, Integer index) {
			this.first = first;
			this.second = second;
			this.index = index;
		}

		public Integer getFirst() {
			return first;
		}

		public void setFirst(Integer first) {
			this.first = first;
		}

		public Integer getSecond() {
			return second;
		}

		public void setSecond(Integer second) {
			this.second = second;
		}

		public Integer getIndex() {
			return index;
		}

		public void setIndex(Integer index) {
			this.index = index;
		}

	}

	static class SortPair implements Comparator<Pair> {
		@Override
		public int compare(Pair o1, Pair o2) {
			return o1.getFirst().compareTo(o2.getFirst());
		}
	}

	public static void main(String[] args) {

		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			Integer T = Integer.parseInt(br.readLine());

			int count = 0;
			List<Pair> pairArr = null;
			while (T > 0) {
				String number = br.readLine();
				Integer N = Integer.parseInt(number);
				pairArr = new ArrayList<Pair>();
				for (int i = 0; i < N; i++) {
					Pair pair = null;
					String C = br.readLine();
					String CBArr[] = C.split(" ");
					for (int j = 0; j < CBArr.length; j++) {
						pair = new Pair(Integer.parseInt(CBArr[0]), Integer.parseInt(CBArr[1]), i);
					}
					pairArr.add(pair);
				}
				String partner = findPartner(pairArr);
				count++;
				System.out.println("Case #" + count + ": " + partner);
				T--;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static String findPartner(List<Pair> pairArr) {
		HashMap<Integer, String> map = new HashMap<>();
		if (pairArr == null) {
			return null;
		}
		Collections.sort(pairArr, new SortPair());
		Integer maxCAvailable = 0;
		Integer maxJAvailable = 0;

		for (int i = 0; i < pairArr.size(); i++) {
			Pair pair = pairArr.get(i);
			if (i == 0) {
				map.put(pair.getIndex(), C);
				// resultList.add(pair.getIndex(), C);
				maxCAvailable = pair.getSecond();
			} else {
				if (pair.getFirst() >= maxCAvailable) {
					// resultList.add(pair.getIndex(), C);
					map.put(pair.getIndex(), C);
					maxCAvailable = pair.getSecond();
				} else if (pair.getFirst() >= maxJAvailable) {
					// resultList.add(pair.getIndex(), J);
					map.put(pair.getIndex(), J);
					maxJAvailable = pair.getSecond();
				} else {
					return IMPOSSIBLE;
				}
			}

		}
		String result = convertMapToString(map, pairArr.size());
		return result;
	}

	private static String convertMapToString(HashMap<Integer, String> map, int size) {
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < size; i++) {
			result.append(map.get(i));
		}
		return result.toString();
	}

}
