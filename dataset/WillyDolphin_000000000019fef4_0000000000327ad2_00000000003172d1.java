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
			Boolean flag = false;
			if(d == 2) {
				HashSet<Long> set = new HashSet();
				
				for(long x: arr) {
					if(set.contains(x)) {
						System.out.println("Case #"+i+": 0");
						flag = true;
						break;
					}
					set.add(x);
				}
				if(!flag) {
					System.out.println("Case #"+i+": 1");
				}
			} else if(d == 3) {
				for(long x: arr) {
					int count = 0;
					for(long xx: arr) {
						if(xx == x) {
							count++;
						}
					}
					if(count >= 3) {
						System.out.println("Case #"+i+": 0");
						flag = true;
						break;
					}
				}
				if(!flag) {
					HashSet<Long> set= new HashSet();
					for(long x: arr) {
						set.add(x);
					}
					for(long x: arr) {
						if(set.contains(2*x)) {
							System.out.println("Case #"+i+": 1");
							flag = true;
							break;
						}
					}
				}
				if(!flag) {
					for(long x: arr) {
						int count = 0;
						for(long xx: arr) {
							if(xx == x) {
								count++;
							}
						}
						if(count == 2) {
							for(long xx: arr) {
								if(xx > x) {
									System.out.println("Case #"+i+": 1");
									flag = true;
									break;
								}
							}
						}
					}
				}
				if(!flag) {
					System.out.println("Case #"+i+": 2");
				}
			}

		}
	}

}
