import java.util.*;
class Solution {
	public static void main(String[] commands) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		in.nextLine();
		for (int tt = 1; tt <= T; tt++) {
			int count = in.nextInt();
			Interval[] all = new Interval[count];
			for (int i = 0; i < count; i++) {
				all[i] = new Interval();
				all[i].start = in.nextInt();
				all[i].finish = in.nextInt();
			}
			char[] user = new char[count];
			int[] jay = new int[24*60+1];
			int[] cee = new int[24*60+1];
			int lastJ = 0, lastC = 0;
			boolean possible = true;
			for (int i = 0; i < count; i++) {
				boolean jok = true;
				for (int t = all[i].start+1; t <= all[i].finish; t++) {
					if (jay[t] > 0) {
						jok = false;
					}
				}
				if (jok) {
					user[i] = 'J';
					for (int t = all[i].start; t <= all[i].finish; t++) {
						jay[t] += 1;
					}
				} else {
					boolean cok = true;
					for (int t = all[i].start+1; t <= all[i].finish; t++) {
						if (cee[t] > 0) {
							cok = false;
						}
					}
					if (cok) {
						user[i] = 'C';
						for (int t = all[i].start; t <= all[i].finish; t++) {
							cee[t] += 1;
						}
					} else {
						possible = false;
					}
				}
			}
			if (possible) {
				System.out.printf("Case #%d: %s\n", tt, new String(user));
			} else {
				System.out.printf("Case #%d: %s\n", tt, "IMPOSSIBLE");
			}
		}
	}
	
}
class Interval {
	int start;
	int finish;
}