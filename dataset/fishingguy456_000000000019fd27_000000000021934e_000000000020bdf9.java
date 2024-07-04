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
				times[j] = g.new time(a, b, j);
			}Arrays.sort(times);
			time cameron = g.new time(0, 0, -1);
			time james = g.new time(0, 0, -1);
			ArrayList<role> roles = new ArrayList<role>();
			cameron = g.new time(times[0].a, times[0].b, times[0].i);
			roles.add(g.new role(times[0].i,'C'));
			for(int j = 1; j < n; j++) {
				if(times[j].a>=cameron.b) {
					roles.add(g.new role(times[j].i,'C'));
					cameron = times[j];
				}else if(times[j].a>=james.b) {
					roles.add(g.new role(times[j].i,'J'));
					james = times[j];
				}else {
					System.out.println("Case #"+(i+1)+": IMPOSSIBLE");
					continue rr;
				}
			}Collections.sort(roles);
			String ans = "";
			for(int j = 0; j < n; j++) {
				ans+=roles.get(j).c;
			}System.out.println("Case #"+(i+1)+": "+ans);
		}
	}public class time implements Comparable<time>{
		int a;
		int b;
		int i;
		public time(int A, int B, int I) {
			a = A;
			b = B;
			i = I;
		}
		@Override
		public int compareTo(time o) {
			// TODO Auto-generated method stub
			return this.a-o.a;
		}
	}public class role implements Comparable<role>{
		int i;
		char c;
		public role(int I, char C) {
			i = I;
			c = C;
		}
		@Override
		public int compareTo(role o) {
			// TODO Auto-generated method stub
			return this.i-o.i;
		}
	}

}
