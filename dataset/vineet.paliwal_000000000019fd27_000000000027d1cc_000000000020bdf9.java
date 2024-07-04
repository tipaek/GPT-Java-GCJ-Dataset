import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	
	public static Solution main;

	public class Act implements Comparable<Act>{
		int st;
		int en;
		public Act(int s , int e) {
			st = s;
			en = e;
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
				acts[j] = main.new Act(s,e);
			}
			Arrays.sort(acts);
			int fir = 0;
			int sec = 0;
			int cur = 0;
			boolean pos = true;
			String sol = "";
			while(cur<n) {
				if(fir<=acts[cur].st) {
					fir = acts[cur].en;
					sol += "C";
				} else if (sec <= acts[cur].st) {
					sec = acts[cur].en;
					sol += "J";
				} else {
					pos = false;
					break;
				}
				cur++;
			}
			System.out.print("Case #" + i + ": ");
			if(pos) {
				System.out.println(sol);
			} else {
				System.out.println("IMPOSSIBLE");
			}
		}
	}

}
