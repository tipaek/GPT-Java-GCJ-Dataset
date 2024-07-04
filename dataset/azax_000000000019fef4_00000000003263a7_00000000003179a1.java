import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class Solution {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int numCases = Integer.parseInt(sc.nextLine());
		
		for (int index = 0; index < numCases; index++) {
			long[] qs = new long[10000];
			String[] strings = new String[10000];
			
			sc.nextLine(); // 2 or 16; it doesn't matter
			
			for (int i = 0; i < 10000; i++) {
				String[] line = sc.nextLine().split(" ");
				qs[i] = Long.parseLong(line[0]);
				strings[i] = line[1];
			}

			// my first solution works for the first two cases! best not mess with perfection
			boolean sadness = (qs[0] == -1);
			
			if (!sadness) {
				System.out.println(
						"Case #" + (index + 1) + ": " +  solve(qs, strings)
				);
			} else {
				System.out.println(
						"Case #" + (index + 1) + ": " +  solveSadly(strings)
				);
			}
		}
		sc.close();
		
	}
	
	private static String solve(long[] qs, String[] strings) {
		ArrayList<Integer> reference = new ArrayList<>(10);
		for (int i = 0; i < 10; i++) {
			reference.add(i);
		}
		
		Map<Character, Set<Integer>> chars = new HashMap<Character, Set<Integer>>();
		for (int i = 0; i < 10000; i++) {
			String s = strings[i];
			for (int j = 0; j < s.length(); j++) {
				chars.put(s.charAt(j), new HashSet<Integer>(reference));
				if (chars.size() == 10) {
					break;
				}
			}
		}
		for (int i = 0; i < 10000; i++) {
			long m = qs[i];
			String s = strings[i];
			
			char c = s.charAt(0);
			Set<Integer> set = chars.get(c);
			set.remove(0);
			
			if (Long.toString(m).length() == s.length()) {
				for (int j = getMostSigDig(m) + 1; j < 10; j++) {
					set.remove(j);
				}
			}
		}
		
		char[] ret = new char[10];
		for (Character c : chars.keySet()) {
			Set<Integer> s = chars.get(c);
			if (s.contains(0)) {
				ret[0] = c;
			} else {
				for (int i = 9; i > 0; i--) {
					if (s.contains(i)) {
						ret[i] = c;
						break;
					}
				}
			}
		}
		return new String(ret);
	}
	
	private static String solveSadly(String[] strings) {
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < 10000; i++) {
			String s = strings[i];
			for (int j = 0; j < s.length(); j++) {
				map.put(s.charAt(j), 0);
				if (map.size() == 10) {
					break;
				}
			}
		}
		
		for(int i = 0; i < 10000; i++) {
			String s = strings[i];
			if (s.length() == 16) {
				map.put(s.charAt(0), map.get(s.charAt(0)) + 1);
			}
		}
		
		List<Map.Entry<Character, Integer>> l = new ArrayList<Map.Entry<Character, Integer>>();
		for (Map.Entry<Character, Integer> entry : map.entrySet()) {
			l.add(entry);
			System.out.println(entry.getKey() + " " + entry.getValue());
		}
		Collections.sort(l, new EntryComparator());
		
		char[] ret = new char[10];
		ret[0] = l.get(0).getKey();
		for (int i = 0; i < 9; i++) {
			ret[i + 1] = l.get(9 - i).getKey();
		}
		
		return new String(ret);
	}
	
	private static int getMostSigDig(long x) {
		while (x >= 10) {
			x /= 10;
		}
		return (int) x;
	}
	
	private static class EntryComparator implements Comparator<Map.Entry<Character, Integer>> {

		@Override
		public int compare(Entry<Character, Integer> o1, Entry<Character, Integer> o2) {
			return o1.getValue() - o2.getValue();
		}
		
	}
}
