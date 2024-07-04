import java.io.*;
import java.util.*;

//change to solution
public class Solution {
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		outer : for (int test = 1; test <= t; test++) {
			int n = sc.nextInt();
			int d = sc.nextInt();
			long[] list = new long[n];
			TreeMap<Long, Integer> map = new TreeMap<>();
			for (int i = 0; i < n; i++) {
				list[i] = sc.nextLong();
				add(map, list[i]);
			}
			int ans = 5;
			if (d == 1) {
				System.out.println("Case #" + test + ": 0");
				continue outer;
			}
// 			if (test == 2)
// 				System.out.println();
			for (Map.Entry<Long, Integer> entry : map.entrySet()) {
				if (entry.getValue() == d) {
					System.out.println("Case #" + test + ": 0");
					continue outer;
				}
			}
			if (d == 2) {
				System.out.println("Case #" + test + ": 1");
				continue outer;
			}
			for (Map.Entry<Long, Integer> entry : map.entrySet()) {
				if (entry.getValue() == 2) {
					if (map.lastKey() != entry.getKey()) {
						System.out.println("Case #" + test + ": 1");
						continue outer;
					}
				}
			} 
			for (Map.Entry<Long, Integer> entry : map.entrySet()) {
				long key = entry.getKey();
				if (entry.getValue() == 1) {
					if (map.containsKey(key * 2)) {
						System.out.println("Case #" + test + ": 1");
						continue outer;
					}
				}
			} 
//			int count = 0;
//			for (Map.Entry<Long, Integer> entry : map.entrySet()) {
//				long key = entry.getKey();
//				count++;
//				if (entry.getKey() == 1) {
//					if (count < n - 1) {
//						System.out.println("Case #" + test + ": 2");
//						continue outer;
//					}
//				}
//			} 
			System.out.println("Case #" + test + ": 2");
		}
	}
	
	static void add(TreeMap<Long, Integer> map, long i) {
		if (map.containsKey(i)) map.put(i, map.get(i) + 1);
		else map.put(i, 1);
	}

}
