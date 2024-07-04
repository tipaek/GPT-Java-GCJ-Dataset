import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	
	public static Solution main;

	public class Act implements Comparable<Act>{
		int st;
		int en;
		int pos;
		public Act(int s , int e, int p) {
			st = s;
			en = e;
			pos = p;
		}
		public int compareTo(Act act) {
			return new Integer(st).compareTo(act.st);
		}
	}
	
	public static void main(String[] args) {
		main = new Solution();
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		for(int i = 1 ; i <= t ; i++) {
			int n = scan.nextInt();
			Act [] acts = new Act[n];
			for(int j = 0 ; j < n ; j++) {
				int s = scan.nextInt();
				int e = scan.nextInt();
				acts[j] = main.new Act(s,e,j);
			}
			Arrays.sort(acts);
			int fir = 0;
			int sec = 0;
			int cur = 0;
			boolean pos = true;
			char [] sol = new char[n];
			Arrays.fill(sol, ' ');
			while(cur<n) {
				if(fir<=acts[cur].st) {
					fir = acts[cur].en;
					sol[cur] = 'C';
				} else if (sec <= acts[cur].st) {
					sec = acts[cur].en;
					sol[cur] = 'J';
				} else {
					pos = false;
					break;
				}
				cur++;
				//System.out.println(fir + " " + sec);
			}
			char [] sor = new char[n];
			for(int j = 0 ; j < n ; j++) {
				sor[acts[j].pos] = sol[j];
			}
			System.out.print("Case #" + i + ": ");
			if(pos) {
				System.out.println(new String(sor));
			} else {
				System.out.println("IMPOSSIBLE");
			}
		}
	}

}
