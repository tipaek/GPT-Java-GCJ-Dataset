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
	
	public static void printResult(int current, int result) {
		System.out.println("Case #" + current + ": " + result);
	}
	
	public static void processInput(int testCase) {
		String line = in.nextLine();
		
		String [] lineS = line.split(" ");
		
		int result = solve (Integer.parseInt(lineS[0]) , Integer.parseInt(lineS[1]) , in.nextLine().split(" "));
		
		printResult(testCase, result);
	}
	
	public static List<List<Integer>> helper(int [] diag, int T) {
		return null;
	}
	
	public static int solve(int div , int guest, String [] slices) {
		HashMap<Long, Integer> map = new HashMap<>();
		int maxSame = 1;
		long maxsize= 0;
		long [] pieces = new long [slices.length];
		for (int i = 0; i < slices.length; ++i) {
			pieces[i] = Long.parseLong(slices[i]);
			if (pieces[i] > maxsize) 
				maxsize = pieces[i];
			if (map.containsKey(pieces[i])) {
				int val = map.get(pieces[i]);
				map.put(pieces[i], val + 1);
				if (maxSame <= val)
					maxSame = val + 1;
			} else {
				map.put(pieces[i], 1);
			}
		}
		
		if (maxSame >= guest) {
			return 0;
		}
		
		if (guest == 2) {
			return 1;
		} else {
			if (maxSame == 2) {
				for (Entry entry: map.entrySet()) {
					if ((int)entry.getValue() == 2 && (long)entry.getKey() < maxsize)
						return 1;
				}
			}
			
			for (Entry entry: map.entrySet()) {
				if (map.containsKey(2* (long)entry.getKey()) ){
					return 1;
				}
			}
			
			return 2;
		}
	}

}