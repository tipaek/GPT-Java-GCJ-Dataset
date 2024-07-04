import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

	static Map<String, Integer> map; 
	
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
		for (int testCase = 1; testCase <= t; ++testCase) {
			int num = in.nextInt();
			int[][] activities = new int[num][2];
			map = new HashMap<String,Integer>(); 
			for (int i = 0 ; i < num; i++) {
				activities[i][0] = in.nextInt();
				activities[i][1] = in.nextInt();
				map.put(activities[i][0] + "#" + activities[i][1], i);
			}
			String ans = distribute(activities);
			
			System.out.println("Case #" + testCase + ": " + ans);
		}
		in.close();

	}
	
	
	
	private static String distribute(int[][] act, int index, char[] ans, int jamie, int cameron) {
		if (index == act.length) {
			return new String(ans);
		}
		int start = act[index][0];
		int end = act[index][1];

		// try cameron
		if (start < cameron) { 
			if (start < jamie) {
				return "IMPOSSIBLE";
			} else {
				ans[map.get(start + "#" + end)] = 'J';
				jamie = end;
			}
		} else {
			ans[map.get(start + "#" + end)] = 'C';
			cameron = end;
		}
		return distribute(act, index+1, ans, jamie, cameron);
		
	}

	

	private static String distribute(int[][] act) {
		
		Arrays.sort(act, new Comparator<int[]>() {
			public int compare(int[] obj1, int[] obj2) {
				if (obj1[0] == obj2[0]) { 
					return Integer.compare(obj1[1], obj2[1]);
				} else {
					return Integer.compare(obj1[0], obj2[0]);
				}
 			}
		});

		//return distribute(act, 0, new char[act.length], new boolean[60*24], new boolean[60*24]);
		return distribute(act, 0, new char[act.length], -1, -1);
	}
	
}
