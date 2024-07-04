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
			if (split[0].length() == split[1].length() ) {
				int currentMax = charMap.get(split[1].charAt(0));
				int nowMax = Integer.parseInt(split[0].charAt(0) + "");
				
				if (nowMax < currentMax) {
					charMap.put(split[1].charAt(0), nowMax);
				}
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
	
	/*public static int solve(int x , int y, String moves) {
		if (x == 0 && y == 0)
			return 0;
		
		int absDist;
		for (int i = 0; i < moves.length(); ++i) {
			char c = moves.charAt(i);
			if (c == 'N')
				++y;
			else if (c == 'S')
				--y;
			else if (c == 'E')
				++x;
			else if (c == 'W')
				--x;
			absDist = Math.abs(x) + Math.abs(y);
			if (absDist <= i + 1) {
				return i + 1;
			}
		}
		
		return -1;
	}*/

}