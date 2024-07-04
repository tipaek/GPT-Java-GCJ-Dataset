import java.io.*;
import java.util.*;

public class Solution {
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		outer : for (int test = 1; test <= t; test++) {
			int n = sc.nextInt();
			int d = sc.nextInt();
			long[] list = new long[n];
			long max = 0;
			
//			if (test == 2)
//				System.out.println();
			
			HashMap<Long, Integer> map = new HashMap<>();
			for (int i = 0; i < n; i++) {
				long l = sc.nextLong();
				max = Math.max(max, l);
				add(map, l);
			}
			
			
			System.out.print("Case #" + test + ": ");
			for (Map.Entry<Long, Integer> entry : map.entrySet()) {
				if (entry.getValue() == d) {
					System.out.println(0);
					continue outer;
				}
			}
			if (d == 2) {
				System.out.println(1);
				continue;
			}
			for (Map.Entry<Long, Integer> entry : map.entrySet()) {
				long key = entry.getKey();
				if (map.containsKey(key * 2) || (entry.getValue() == 2 && key < max)) {
					System.out.println(1); continue outer;
				}
			}
			System.out.println(2);
		}
	}
	
	static void add(HashMap<Long, Integer> map, Long lo) {
		if (map.containsKey(lo)) map.put(lo, map.get(lo) + 1);
		else map.put(lo, 1);
	}

}
