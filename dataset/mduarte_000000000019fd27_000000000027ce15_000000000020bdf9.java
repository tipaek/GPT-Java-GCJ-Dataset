import java.io.BufferedReader;
import java.io.InputStreamReader;
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
			char[] arr = new char[num];
			String ans = null;
			if (distribute(activities, arr)) {
				ans = new String(arr);
			} else {
				ans = "IMPOSSIBLE";
			}
			
			System.out.println("Case #" + testCase + ": " + ans);
		}
		in.close();

	}

	
	
	
	private static boolean canAssignTask(int start, int end, boolean[] p) {
		for (int i = start; i < end; i++) {
			if (p[i]) {
				return false;
			}
		}
		return true;
			
	}	
	
	private static void assignTask(int start, int end, boolean[] p, boolean value) {
		for (int i = start; i < end; i++) {
			p[i] = value;
		}
	}
	
	char[] arr = new char[] {'C', 'E'};
	
	private static boolean distribute(int[][] act, int index, char[] ans, boolean[] jamie, boolean[] cameron) {
		if (index == act.length) {
			return true;
		}
		int start = act[index][0];
		int end = act[index][1];

		// try cam
		if (canAssignTask(start, end, cameron)) { 
			ans[map.get(start + "#" + end)] = 'C';
			assignTask(start, end, cameron, true);
			
			boolean ok = distribute(act, index+1, ans, jamie, cameron);
			if (!ok) {
				assignTask(start, end, cameron, false);
			} else {
				return ok;
			}
		} 
		
		if (canAssignTask(start, end, jamie)) { 
			ans[map.get(start + "#" + end)] = 'J';
			assignTask(start, end, jamie, true);
			
			boolean ok = distribute(act, index+1, ans, jamie, cameron);
			if (!ok) {
				assignTask(start, end, jamie, false);
			} else {
				return ok;
			}
			
		} 
	
		
		return false;
		
	}

	private static boolean distribute(int[][] act, char[] ans) {

		return distribute(act, 0, ans, new boolean[60*24], new boolean[60*24]);
		//return distribute(act, 0, new char[act.length], -1, -1);
	}
	
}
