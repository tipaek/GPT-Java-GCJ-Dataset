

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		String ans[] = new String[T];
		HashMap<Character, ArrayList<Integer>> map = new HashMap<>();
		for (int i = 0; i < T; i++) {
			int U = sc.nextInt();
			for (int j = 0; j < 10000; j++) {
				String a = sc.next();
				String b = sc.next();
				if (a.length() == b.length()) {
					int first = Integer.parseInt(String.valueOf(a.charAt(0)));
					ArrayList<Integer> set = new ArrayList<>();
					if (map.containsKey(b.charAt(0)) && map.get(b.charAt(0)).size() > 0) {
						set = map.get(b.charAt(0));
						first++;
						while (first <= 9) {
							if (set.contains(first)) {
								set.remove(first);
								first++;
							} else {
								break;
							}
						}
					} else {
						for (int k = 0; k < first; k++) {
							set.add(k + 1);
						}
					}
					for (int k = 1; k < b.length(); k++) {
						ArrayList<Integer> set1 = new ArrayList<>();
						map.put(b.charAt(k), set1);
					}
					map.put(b.charAt(0), set);
				}
			}
			int count = 0;
			char[] ch = new char[10];
			for (Map.Entry<Character, ArrayList<Integer>> entry : map.entrySet()) {
				if (entry.getValue().size() == 0) {
					ch[0] = entry.getKey();
					count++;
					break;
				}
			}
			System.out.println(ch[0]);
			while (count < 10) {
				Integer index = 0;
				for (Map.Entry<Character, ArrayList<Integer>> entry : map.entrySet()) {
					if (entry.getValue().size() == 1) {
						ch[entry.getValue().get(0)] = entry.getKey();
						count++;
						index = entry.getValue().get(0);
						break;
					}
				}
				for (Map.Entry<Character, ArrayList<Integer>> entry : map.entrySet()) {
					ArrayList<Integer> set = entry.getValue();
					set.remove(index);
					map.put(entry.getKey(), set);
				}
			}
			StringBuffer sb = new StringBuffer();
			for (int l = 0; l < ch.length; l++) {
				sb.append(ch[l]);
			}
			ans[i] = sb.toString();
		}
		for (int i = 0; i < T; i++) {
			int index = i + 1;
			System.out.println("Case #" + index + ": " + ans[i]);
		}
	}
}
