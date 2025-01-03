import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Solution {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int numCases = Integer.parseInt(sc.nextLine());
		
		for (int index = 0; index < numCases; index++) {
			int[] qs = new int[10000];
			String[] strings = new String[10000];
			
			sc.nextLine();
			
			for (int i = 0; i < 10000; i++) {
				String[] line = sc.nextLine().split(" ");
				qs[i] = Integer.parseInt(line[0]);
				strings[i] = line[1];
			}
			
			System.out.println(
					"Case #" + (index + 1) + ": " +  solve(qs, strings)
			);
		}
		sc.close();
		
	}
	
	private static String solve(int[] qs, String[] strings) {
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
			int m = qs[i];
			String s = strings[i];
			
			char c = s.charAt(0);
			Set<Integer> set = chars.get(c);
			if (s.length() == 1) { // c != 0
				set.remove(0);
			}
			
			if (Integer.toString(m).length() == s.length()) {
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
	
	private static int getMostSigDig(int x) {
		while (x >= 10) {
			x /= 10;
		}
		return x;
	}
}
