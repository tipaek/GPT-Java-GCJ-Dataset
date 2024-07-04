/**
 * 
 */
//package com.sanjay.google.code.jam.round1b.services;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author s0t01cz
 *
 */
public class Solution {

	/**
	 * @param args
	 */
//	4
//	2 3
//	-2 -3
//	3 0
//	-1 1
//	Case #1: SEN
//	Case #2: NWS
//	Case #3: EE
//	Case #4: IMPOSSIBLE

	static class Pair {
		int first;
		int second;

		Pair(int first, int second) {
			this.first = first;
			this.second = second;
		}

		public int getFirst() {
			return first;
		}

		public void setFirst(int first) {
			this.first = first;
		}

		public int getSecond() {
			return second;
		}

		public void setSecond(int second) {
			this.second = second;
		}

	}

	private static final String IMPOSSIBLE = "IMPOSSIBLE";

	public static void main(String[] args) {

		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			Integer T = Integer.parseInt(br.readLine());

			int count = 0;
			while (T > 0) {
				String[] str = br.readLine().split(" ");
				int[] arr = new int[str.length];
				for (int i = 0; i < str.length; i++) {
					arr[i] = Integer.parseInt(str[i]);
				}
				Pair dest = new Pair(arr[0], arr[1]);
				String result = backtrack(dest);
				count++;
				System.out.println("Case #" + count + ": " + result);

				T--;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static String backtrack(Pair dest) {
		if (dest == null)
			return IMPOSSIBLE;

		String result = "";
		Pair source = new Pair(0, 0);
		Pair delimiter = new Pair(-1, -1);
		Queue<Pair> queue = new LinkedList<Pair>();
		HashMap<String, String> pairResMap = new HashMap<String, String>();
		queue.add(source);
		int multiplier = 1;
		while (!queue.isEmpty()) {

			while (!isDelim(queue.peek(), delimiter)) {
				Pair element = queue.poll();
				String path = pairResMap.getOrDefault(element.getFirst() + "" + element.getSecond(), "");
				System.out.println("path " + path);
				if (isMatchFound(element, dest)) {
					return getResultFromMap(element, pairResMap);
				}
				// add north
				Pair newPair = new Pair(element.getFirst(), element.getSecond() + multiplier);
				System.out.println(newPair.getFirst() + "" + newPair.getSecond());
				pairResMap.put(newPair.getFirst() + "" + newPair.getSecond(), path + "N");
				queue.add(newPair);
				if (isMatchFound(newPair, dest)) {
					return getResultFromMap(element, pairResMap);
				}

				// add south
				newPair = new Pair(element.getFirst(), element.getSecond() - multiplier);
				pairResMap.put(newPair.getFirst() + "" + newPair.getSecond(), path + "S");
				queue.add(newPair);
				if (isMatchFound(newPair, dest)) {
					return getResultFromMap(element, pairResMap);
				}

				// add west
				newPair = new Pair(element.getFirst() - multiplier, element.getSecond());
				pairResMap.put(newPair.getFirst() + "" + newPair.getSecond(), path + "W");
				queue.add(newPair);
				if (isMatchFound(newPair, dest)) {
					return getResultFromMap(element, pairResMap);
				}

				// add east
				newPair = new Pair(element.getFirst() + multiplier, element.getSecond());
				pairResMap.put(newPair.getFirst() + "" + newPair.getSecond(), path + "E");
				queue.add(newPair);
				if (isMatchFound(newPair, dest)) {
					return getResultFromMap(element, pairResMap);
				}
			}
			queue.poll();
			if (!queue.isEmpty()) {
				queue.add(delimiter);
			}
			multiplier = multiplier * 2;
//			if (queue.peek() == delimiter) {
//				break;
//			}
		}

		result = getResultFromMap(dest, pairResMap);
		return result;
	}

	private static boolean isDelim(Pair peek, Pair delimiter) {
		if (peek.getFirst() == delimiter.getFirst() && peek.getSecond() == delimiter.getSecond()) {
			return true;
		}
		return false;
	}

	private static boolean isMatchFound(Pair source, Pair destination) {
		if (source.getFirst() == destination.getFirst() && source.getSecond() == destination.getSecond()) {
			return true;
		}
		return false;
	}

	public static String getResultFromMap(Pair dest, HashMap<String, String> pairResMap) {
		return pairResMap.getOrDefault(dest.getFirst() + "" + dest.getSecond(), IMPOSSIBLE);
	}

}