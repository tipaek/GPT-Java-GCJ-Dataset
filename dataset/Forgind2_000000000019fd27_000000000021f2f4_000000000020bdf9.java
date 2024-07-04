import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int z = in.nextInt();
		in.nextLine();
		for (int y = 1; y <= z; y++) {
			int n = in.nextInt();
			in.nextLine();
			ArrayList<Time> times = new ArrayList<Time>();
			for (int a = 0; a < n; a++) {
				String[] l = in.nextLine().trim().split(" ");
				times.add(new Time(Integer.parseInt(l[0]), Integer.parseInt(l[1]), a));
			}
			Collections.sort(times);
			int jav = 0;
			int cav = 0;
			boolean failed = false;
			for (int a = 0; a < n; a++) {
				if (jav <= times.get(a).start) {
					times.get(a).ans = 'J';
					jav = times.get(a).end;
				}
				else if (cav <= times.get(a).start) {
					times.get(a).ans = 'C';
					cav = times.get(a).end;
				}
				else {
					failed = true;
					break;
				}
			}
			if (failed) {
				System.out.println("Case #" + y + ": IMPOSSIBLE");
			}
			else {
				char[] ret = new char[n];
				for (Time t: times) {
					ret[t.pos] = t.ans;
				}
				StringBuilder sb = new StringBuilder();
				sb.append("Case #");
				sb.append(y);
				sb.append(": ");
				for (char c: ret)
					sb.append(c);
				System.out.println(sb.toString());
			}
		}
		in.close();
	}
	private static class Time implements Comparable<Time> {
		private int start;
		private int end;
		private int pos;
		private char ans = 'u';
		
		public Time(int a, int b, int c) {
			start = a;
			end = b;
			pos = c;
		}
		
		public int compareTo(Time ot) {
			return start < ot.start ? -1 : start > ot.start ? 1 : end < ot.end ? -1 : end > ot.end ? 1 : 0;
		}
	}
}
