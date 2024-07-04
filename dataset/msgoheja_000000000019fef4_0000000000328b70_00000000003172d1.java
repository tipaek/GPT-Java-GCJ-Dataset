import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeSet;

public class Solution {
	static long solve(int slices, int diners, Map<Long, Long> map) {
		long cuts = 0;
		if(diners <= slices) {
			if(map.containsValue((long)diners)) {
				return 0;
			} else {
				return Math.abs(diners - slices);
			}
		} else {
			cuts = Math.abs(diners - slices);
		}
		
		return cuts;
	}
	
	public static void main(String[] args) throws Exception{
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int slices, diners;
		long value, output;
		long[] arr;
		Map<Long, Long> map;
		int T = in.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			slices = in.nextInt();
			diners = in.nextInt();
			map = new HashMap<Long, Long>();
			for(int i = 0; i < slices; i++) {
				value = in.nextLong();
				if(!map.containsKey(value)) {
					map.put(value, 1L);
				} else {
					map.put(value, map.get(value) + 1);
				}
			}
			output = solve(slices, diners, map);
			
			System.out.println("Case #" + tc + ": " + output);
		}
		in.close(); 
	}

}
