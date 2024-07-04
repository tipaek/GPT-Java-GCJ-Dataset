import java.util.*;
public class Solution {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int i=1; i<=t; i++) {
			int n = sc.nextInt();
			int d = sc.nextInt();
			long[] arr = new long[n];
			for(int j=0; j<n; j++) {
				arr[j] = sc.nextLong();
			}
			if(d == 2) {
				HashSet<Long> set = new HashSet<Long>();
				Boolean flag = false;
				for(long x: arr) {
					if(set.contains(x)) {
						System.out.println("Case #"+i+": "+0);
						flag = true;
						break;
					}
					set.add(x);
				}
				if(!flag) {
					System.out.println("Case #"+i+": "+1);
				}
			} else if(d == 3) {
				Boolean flag = false;
				long[] fremin = new long[n+1];
				HashMap<Long, Integer> map = new HashMap();
				for(long x: arr) {
					if(map.containsKey(x)) {
						map.put(x, map.get(x)+1);
					} else {
						map.put(x, 1);
					}
					int f = map.get(x);
					if(x < fremin[f]) {
						fremin[f] = x;
					}
				}
				for(int j=3; j<n; j++) {
					if(fremin[j] > 0) {
						System.out.println("Case #"+i+": "+0);
						flag = true;
						break;
					}
				}
				if(!flag) {
					if(n>=2 && fremin[2] > 0) {
						long x = fremin[2];
						for(long y: arr) {
							if(y>x) {
								System.out.println("Case #"+i+": "+1);
								flag = true;
								break;
							}
						}
					}
					if(!flag) {
						HashSet<Long> set = new HashSet();
						for(long x : arr) {
							set.add(x);
						}
						for(long x: arr) {
							if(set.contains(2*x)) {
								System.out.println("Case #"+i+": "+1);
								flag = true;
								break;
							}
						}
					}
				}
				if(!flag) {
					System.out.println("Case #"+i+": "+2);
				}
			} else {
				System.out.println("Case #"+i+": "+(d-1));
			}
		}
	}

}
