import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeMap;

public class Solution {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int cases = sc.nextInt();

		for (int cs = 1; cs <= cases; cs++) {

			int n = sc.nextInt();

			int d = sc.nextInt();

			long[] a = new long[n];

			for (int i = 0; i < n; i++) {
				a[i] = sc.nextLong();
			}
			
			int result = 0;

			if (n == 1) {
				result = d - 1;
			} else {

				TreeMap<Long, Integer> map = new TreeMap<>();

				for (int i = 0; i < n; i++) {

					long key = a[i];

					int value = 0;

					if (map.containsKey(key)) {
						value = map.get(key);
					}

					map.put(key, value + 1);
				}
				
				boolean found = false;
				
				Arrays.sort(a);
				
				for(Long key : map.keySet()) {
					if(map.get(key) >= d) {
						result = 0;
						found = true;
					}
				}
				
				if(!found) {
					for(Long key : map.keySet()) {
						if(map.containsKey(key/2)) {
							result = 1;
							found = true;
						}
					}
				}
				
				if(!found) {
					for(Long key : map.keySet()) {
						if((key != a[a.length - 1]) && (map.get(key) == (d - 1))) {
							result = 1;
							found = true;
						}
					}
				}
				
				
				if(!found) {
					result = d - 1;
				}
			}

			System.out.println("Case #" + cs + ": " + result);

		}
	}
}
