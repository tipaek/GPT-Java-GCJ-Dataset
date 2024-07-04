package uke8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Hashtable;

class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String ns = in.readLine();
		int n = Integer.parseInt(ns);
		for (int i = 0; i < n; i++) {
			String gg = in.readLine();
			int g = Integer.parseInt(gg);
			ArrayList<Integer> start = new ArrayList<Integer>();
			ArrayList<Integer> end = new ArrayList<Integer>();
			Hashtable<Integer, Integer> starTable = new Hashtable<Integer, Integer>();
			Hashtable<Integer, Integer> endTable = new Hashtable<Integer, Integer>();
			for (int j = 0; j < g; j++) {
				String ss = in.readLine();
				String[] s = ss.split(" ");
				start.add(Integer.parseInt(s[0]));
				end.add(Integer.parseInt(s[1]));
				starTable.put(start.get(j), j);
				endTable.put(end.get(j), j);
			}

			String handeled = increasing(start, end, g, starTable, endTable);
			System.out.println("Case #" + (i + 1) + ": " + handeled);
		}
	}

	private static String increasing(ArrayList<Integer> start, ArrayList<Integer> end, int length, Hashtable stable,
			Hashtable etable) {
		String[] output = new String[length];
		ArrayList<Integer> copyEnd = copy(end);
		Collections.sort(copyEnd);
		ArrayList<Integer> copyStart = sameSort(copyEnd, start, etable);
		ArrayList<Integer> first = new ArrayList<Integer>();
		ArrayList<Integer> second = new ArrayList<Integer>();
		// longest increasing/decreasing seen
		int increasing[] = new int[length];
		int parent[] = new int[length];
		// original length
		for (int i = 0; i < length; i++) {
			increasing[i] = 1;
			parent[i] = i;
		}

		// finds increasing subsequence
		for (int i = 1; i < length; i++) {
			for (int j = 0; j < i; j++) {
				if (copyEnd.get(i) > copyEnd.get(j) && increasing[i] < increasing[j] + 1
						&& copyStart.get(i) >= copyEnd.get(j)) {
					increasing[i] = increasing[j] + 1;
					parent[i] = j;
				}
			}
		}
		int max = 0;
		int index = 0;
		for (int i = 0; i < length; i++) {
			if (increasing[i] > max) {
				max = increasing[i];
				index = i;
			}
		}
		for (int i = max; i > 0; i--) {
			first.add((Integer) etable.get(copyEnd.get(index)));
			copyStart.remove(index);
			copyEnd.remove(index);
			index = parent[index];
		}
		for(int i = 0; i < length; i++) {
			if(first.contains(i)) {
				output[i] = "J";
			}
		}

//		_______________________________________________________________________________

		// finds increasing subsequence
		for (int i = 1; i < copyEnd.size(); i++) {
			for (int j = 0; j < i; j++) {
				if (copyEnd.get(i) > copyEnd.get(j) && increasing[i] < increasing[j] + 1
						&& copyStart.get(i) >= copyEnd.get(j)) {
					increasing[i] = increasing[j] + 1;
					parent[i] = j;
				}
			}
		}
		max = 0;
		index = 0;
		for (int i = 0; i < copyEnd.size(); i++) {
			if (increasing[i] > max) {
				max = increasing[i];
				index = i;
			}
		}
		for (int i = max; i > 0; i--) {
			copyStart.remove(index);
			copyEnd.remove(index);
			second.add(index);
			index = parent[index];
		}
		if(!copyEnd.isEmpty()) {
			return "IMPOSSIBLE";
		}
		else {
			for(int i = 0; i < length; i++) {
				if(output[i] == null) {
					output[i] = "C";
				}
			}
		}
		String ggg = "";
		for(int i = 0; i < length; i++) {
			ggg += output[i];
		}
		return ggg;
	}

	public static ArrayList<Integer> copy(ArrayList<Integer> list) {
		ArrayList<Integer> copy = new ArrayList<Integer>();
		for (int i = 0; i < list.size(); i++) {
			copy.add(list.get(i));
		}
		return list;
	}

	public static ArrayList<Integer> sameSort(ArrayList<Integer> start, ArrayList<Integer> end, Hashtable table) {
		ArrayList<Integer> copy = new ArrayList<Integer>();
		for (int i = 0; i < start.size(); i++) {
			copy.add(end.get((Integer) table.get(start.get(i))));
		}
		return copy;
	}

}
