import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

public class Solution {
	public static void main(String args[]) {

		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
		for (int i = 1; i <= t; ++i) {
			int a = in.nextInt();
			
			TreeMap<Integer, Integer> map1J = new TreeMap<Integer, Integer>();
			TreeMap<Integer, Integer> map2C = new TreeMap<Integer, Integer>();
			StringBuilder res = new StringBuilder();
			boolean continueFor=false;
			for (int j = 0; j < a; j++) {
				int ss1 = in.nextInt();
				int ee1 = in.nextInt();
				if(continueFor) {
					continue;
				}
				if(canBeAssigned(map1J, j, ss1, ee1)) {
					map1J.put(ss1, ee1);
					res.append("J");
				} else if(canBeAssigned(map2C, j, ss1, ee1)) {
					map2C.put(ss1, ee1);
					res.append("C");
				} else {
					res = new StringBuilder();
					res.append("IMPOSSIBLE");
					continueFor=true;
				}
			}

			System.out.println("Case #" + i + ": " + res.toString());

		}
		in.close();
	}

	private static boolean canBeAssigned(TreeMap<Integer, Integer> map1, int j, int ss1, int ee1) {
		
		Entry<Integer, Integer> e1 = map1.floorEntry(ss1);
		if (e1 != null) {
			int startTime = e1.getKey();
			int endTime = e1.getValue();
			if(startTime < ss1 && endTime <=ss1) {
				return true;
			} else {
				return false;
			}
		} else {

			Entry<Integer, Integer> e2 = map1.ceilingEntry(ss1);
			if (e2 != null) {
				int startTime = e2.getKey();
				//int endTime = e2.getValue();
				if(startTime >= ee1) {
					return true;
				} else {
					return false;
				}
			} 
		}
		
		return true;
	}

	

}
