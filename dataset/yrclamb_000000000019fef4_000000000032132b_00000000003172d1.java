import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Solution {
	
	public int solve(long[] A, int D) {
		if(D == 2) {
			Set<Long> set = new HashSet<>();
			for(long a : A) {
				if(set.contains(a)) return 0;
				set.add(a);
			}
			return 1;
		}
		else if(D == 3) {
			Map<Long, Integer> map = new HashMap<>();
			int maxCount = 0;
			long maxSize = 0;
			for(long a : A) {
				map.put(a, map.getOrDefault(a, 0) + 1);
				maxCount = Math.max(maxCount, map.get(a));
				maxSize = Math.max(maxSize, a);
			}
			if(maxCount >= 3) return 0;
			else if(maxCount >= 2) {
				for(long k : map.keySet()) {
					if(map.get(k) >= 2 && k < maxSize) return 1;
				}
				return 2;
			}
			else {
				for(long a : A) {
					if(map.containsKey(a * 2)) return 1;
				}
			}
			return 2;
		}
		
		return 0;
	}
	
	public static void mainX(String[] args) {
		Solution Q = new Solution();
		System.out.println(Q.solve(new long[] {1}, 3));
		System.out.println(Q.solve(new long[] {10, 5, 359999999999L, 123456789L, 10}, 2));
		System.out.println(Q.solve(new long[] {8, 4}, 3));
		System.out.println(Q.solve(new long[] {1, 2, 3}, 2));
		System.out.println(Q.solve(new long[] {4, 4, 9, 9}, 3));
		System.out.println(Q.solve(new long[] {4, 3, 9, 9}, 3));
	}
	
	
	public static void main(String[] args) throws FileNotFoundException {
		Solution Q = new Solution();
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
		in.nextLine();
		for (int i = 1; i <= t; ++i) {
			int N = in.nextInt();
			int D = in.nextInt();
			in.nextLine();
			long[] input = new long[N];
			for(int j = 0; j < N; j++) {
				input[j] = in.nextLong();
			}
			in.nextLine();
			int output = Q.solve(input, D);
			System.out.println("Case #" + i + ": " + output);
			System.out.flush();
		}
	}

}
