import java.util.*;
import java.io.*;

public class Solution {


	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
		for (int i = 1; i <= t; ++i) {
			int n = in.nextInt();
			int d = in.nextInt();

			long[] a = new long[n];

			for(int j=0;j<n;j++) a[j] = in.nextLong();

			if(d<=3) {
				Map<Long, Long> map = new HashMap();
				for(int j=0; j<n ; j++) {
					map.put(a[j], map.getOrDefault(a[j], 0L) +1);
				}

				if(d==2) {
					boolean flag = false;
					for(Long val : map.values()) {
//						System.out.println(val);
						if(val>=2) {
							flag = true;
							break;
						}
					}
					if(flag) {
						System.out.println("Case #" + i + ": 0");
					}
					else {
						System.out.println("Case #" + i + ": 1");
					}
				}
				if(d==3) {
					boolean flag = false;
					for(Long val : map.values()) {
						if(val>=3) {
							flag = true;
							break;
						}
					}
					if(flag) {
						System.out.println("Case #" + i + ": 0");
					}
					else {
						for (int j=0; j<n; j++) {
							for (int k=0; k<n; k++) {
								if(map.containsKey(a[j]+a[k])) {
									flag =true;
									break;
								}
							}
							if(flag) break;
						}
						if(flag) {
							System.out.println("Case #" + i + ": 1");
						}
						else {
							System.out.println("Case #" + i + ": 2");
						}
					}
				}

			} else {
				System.out.println("Case #" + i + ": 0");
			}

		}
	}


}
