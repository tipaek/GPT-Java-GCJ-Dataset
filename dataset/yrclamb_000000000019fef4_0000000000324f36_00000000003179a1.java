import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;

public class Solution {
	
	class Pair{
		String str;
		long num;
	}
	
	public String solve2(List<Pair> input) {
		char[] ans = new char[10];
		Set<Character> charSet = new HashSet<>();
		Set<Character> startSet = new HashSet<>();
		Map<Character, Integer> count = new HashMap<>();
		for(int i = 0; i < input.size(); i++) {
			for(int j = 0; j < input.get(i).str.length(); j++) {
				charSet.add(input.get(i).str.charAt(j));
				count.put(input.get(i).str.charAt(j), count.getOrDefault(input.get(i).str.charAt(j), 0) + 1);
			}
			startSet.add(input.get(i).str.charAt(0));
		}
		StringBuilder sb = new StringBuilder("");
		for(char c : charSet) {
			if(!startSet.contains(c)) {
				Set<Character> set = new HashSet<>();
				set.add(c);
				ans[0] = c;
				charSet.remove(c);
				sb.append(c);
				break;
			}
		}
		count.remove(ans[0]);
		while(count.size() > 0) {
			int max = 0;
			char maxChar = 0;
			for(char c : count.keySet()) {
				if(count.get(c) > max) {
					max = count.get(c);
					maxChar = c;
				}
			}
			sb.append(maxChar);
			count.remove(maxChar);
		}
			
		return sb.toString();
	}
	
	
	public String solve(List<Pair> input) {
		Map<Integer, Set<Character>> ans = new HashMap<>();
		Set<Character> charSet = new HashSet<>();
		Set<Character> startSet = new HashSet<>();
		for(int i = 0; i < input.size(); i++) {
			for(int j = 0; j < input.get(i).str.length(); j++) {
				charSet.add(input.get(i).str.charAt(j));
			}
			startSet.add(input.get(i).str.charAt(0));
			if(charSet.size() == 10 && startSet.size() == 9) break;
		}
		
		for(char c : charSet) {
			if(!startSet.contains(c)) {
				Set<Character> set = new HashSet<>();
				set.add(c);
				ans.put(0, set);
				charSet.remove(c);
				break;
			}
		}
		
		for(int i = 1; i <= 9; i++) {
			Set<Character> set = new HashSet<>();
			for(char c : charSet)
				set.add(c);
			ans.put(i, set);
		}
		
		PriorityQueue<Pair> pq = new PriorityQueue<Pair>((a, b) -> (int)(a.num - b.num));
		for(int i = 0; i < input.size(); i++) pq.add(input.get(i));
		while(!pq.isEmpty()) {
			Pair cur = pq.poll();
			if( (cur.num + "").length() == cur.str.length() ) {
				char maxDigit = cur.str.charAt(0);
				int d = (cur.num + "").charAt(0) - '0';
				//System.out.println("checking " + maxDigit + ", " + d);
				for(int i = d + 1; i <= 9; i++) {
					ans.get(i).remove(maxDigit);
				}
				
				
				for(int i = 1; i <= 9; i++) {
					if(ans.get(i).size() == 1) {
						removeOthers(ans, ans.get(i).iterator().next(), i);
					}
				}
				
				for(char c : charSet) {
					int cnt = 0;
					int targetD = -1;
					for(int i = 1; i <= 9; i++) {
						if(ans.get(i).contains(c)) {
							cnt++;
							targetD = i;
						}
					}
					if(cnt == 1) {
						Set<Character> set = new HashSet<>();
						set.add(c);
						ans.put(targetD, set);
					}
				}
			}
		}
		
		StringBuilder ret = new StringBuilder("");
		
		for(int i = 0; i <= 9; i++) {
			ret.append(ans.get(i).iterator().next());
		}
		
		return ret.toString();
	}
	
	private void removeOthers(Map<Integer, Set<Character>> ans, char targetC, int targetD) {
		for(int i = 1; i <= 9; i++) {
			if(i == targetD) continue;
			ans.get(i).remove(targetC);
		}
	}
	
	public static void mainX(String[] args) {
		Solution Q = new Solution();
	}
	
	
	public static void main(String[] args) throws FileNotFoundException {
		Solution Q = new Solution();
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
		in.nextLine();
		for (int i = 1; i <= t; ++i) {
			int U = in.nextInt();
			in.nextLine();
			List<Pair> input = new ArrayList<>();
			for(int j = 0; j < 10000; j++) {
				Pair p = Q.new Pair();
				p.num = in.nextLong();
				p.str = in.next();
				in.nextLine();
				input.add(p);
			}
			
			String output = Q.solve2(input);
			System.out.println("Case #" + i + ": " + output);
			System.out.flush();
		}
	}

}
