import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class Solution {
	
	static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int testCases = Integer.parseInt(in.nextLine());
		
		for (int i = 0; i < testCases; ++i) {
			processInput(i + 1);
		}
	}
	
	public static void printResult(int current, String result) {
		System.out.println("Case #" + current + ": " + result);
	}
	
	public static void processInput(int testCase) {
		int length = Integer.parseInt(in.nextLine());
		String s;
		String [] split;
		int uniqueChar = 0;
		Map<Character, Integer> charMap = new HashMap<>();
		Set <Character> first = new HashSet<>();
		char [] result = new char[10];
		StringBuilder D = new StringBuilder();
		
		for (int i = 0; i < 10000; ++i) {
			s = in.nextLine();
			split = s.split(" ");
			first.add(split[1].charAt(0));
			if (uniqueChar < 10 ) {
				for (int j = 0; j < split[1].length(); ++j ) {
					if (!charMap.containsKey(split[1].charAt(j) ) ) {
						charMap.put(split[1].charAt(j), 9 );
						++uniqueChar;
					}
				}
			}
			if (split[0].length() == split[1].length() && split[0].charAt(0) != '-' ) {
				int currentMax = charMap.get(split[1].charAt(0));
				int nowMax = Integer.parseInt(split[0].charAt(0) + "");
				
				if (nowMax < currentMax) {
					charMap.put(split[1].charAt(0), nowMax);
				}
				int index = 1;
				while (split[0].charAt(index - 1) == '1' && split[0].length() > index && split[1].length() > index) {
					currentMax = charMap.get(split[1].charAt(index));
					nowMax = Integer.parseInt(split[0].charAt(index) + "");
					
					if (nowMax < currentMax) {
						charMap.put(split[1].charAt(index), nowMax);
					}
				} 
			} else {
			
			}
		}
		
		for (Entry entry : charMap.entrySet()) {
			int val = (int) entry.getValue();
			if (val == 9 && !first.contains(entry.getKey())) {
				val = 0;
			}
			result[val] = (char) entry.getKey();
		}
		
		for (char c: result )
			D.append(c);
		
		printResult(testCase, D.toString());
		
	}
	
	public static List<List<Integer>> helper(int [] diag, int T) {
		return null;
	}
	
}


