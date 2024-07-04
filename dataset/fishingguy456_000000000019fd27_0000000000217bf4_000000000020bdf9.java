import java.util.*;
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		Solution g = new Solution();
		rr:
		for(int i = 0; i < t; i++) {
			int n = sc.nextInt();
			time[] times = new time[n];
			for(int j = 0; j < n; j++) {
				int a = sc.nextInt(), b = sc.nextInt();
				times[j] = g.new time(a, b);
			}Arrays.sort(times);
			time cameron = g.new time(0, 0);
			time james = g.new time(0, 0);
			String ans = "";
			cameron = g.new time(times[0].a, times[0].b);
			ans+="C";
			for(int j = 1; j < n; j++) {
				if(times[j].a>=cameron.b) {
					ans+="C";
					cameron = times[j];
				}else if(times[j].a>=james.b) {
					ans+="J";
					james = times[j];
				}else {
					System.out.println("Case #"+(i+1)+": IMPOSSIBLE");
					continue rr;
				}
			}System.out.println("Case #"+(i+1)+": "+ans);
		}
	}public class time implements Comparable<time>{
		int a;
		int b;
		public time(int A, int B) {
			a = A;
			b = B;
		}
		@Override
		public int compareTo(time o) {
			// TODO Auto-generated method stub
			return this.a-o.a;
		}
	}

}
