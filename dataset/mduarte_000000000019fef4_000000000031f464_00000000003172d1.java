import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Solution s = new Solution();
		s.solution();
	}
	
	public void solution() {
	    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
	    for (int i = 1; i <= t; ++i) {
	      int slices = in.nextInt();
	      int diners = in.nextInt();
	      long[] pancakes = new long[slices];
	      for (int j = 0; j < slices; j++) {
	    	  pancakes[j] = in.nextLong();
	      }
	      Arrays.sort(pancakes);
	      int ans = cutSlice(diners, pancakes);
	      System.out.println("Case #" + i + ": " + ans);
	    }
	    in.close();

	}

	private int cutSlice(int diners, long[] pancakes) {
		Map<Long, Integer> map = new HashMap<Long, Integer>();
		for (long pancake : pancakes) {
			int slices = map.getOrDefault(pancake, 0) + 1;
			if (slices >= diners) return 0;
			map.put(pancake, slices);
		}
		// cut in half
		if (diners == 2) {
			return 1;
		}
		
		// for 3
		boolean temp = false;
		if (diners == 3) {
			for (long pancake: pancakes) {
				if (map.containsKey(pancake * 2)) {
					return 1;
				}
				if (temp) return 1;
				
				if (map.get(pancake) == 2) {
					temp = true;
				}
			}
			return 2;
		}
		
		
		return 0;
	}
}
