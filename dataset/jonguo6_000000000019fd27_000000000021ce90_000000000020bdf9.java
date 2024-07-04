import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int tests = Integer.parseInt(in.nextLine());
		for(int test=1;test<=tests;test++) {
			String answer = "";
			boolean cfree = true;
			boolean jfree = true;
			int ctime = -1;
			int jtime = -1;
			int n = Integer.parseInt(in.nextLine());
			activity[] list = new activity[n];
			for(int i=0;i<n;i++) {
				String[] input = in.nextLine().split(" ");
				int s = Integer.parseInt(input[0]);
				int e = Integer.parseInt(input[1]);
				list[i] = new activity(s,e,i);
			}
			Arrays.sort(list);
			for(int i=0;i<n;i++) {
				int time = list[i].start;
				if(ctime <= time) {
					cfree = true;
					ctime = -1;
				}
				if(jtime <= time) {
					jfree = true;
					jtime = -1;
				}
				if(cfree) {
					//answer = answer + "C";
					cfree = false;
					ctime = list[i].end;
					list[i].person = "C";
				} else if(jfree) {
					//answer = answer + "J";
					jfree = false;
					jtime = list[i].end;
					list[i].person = "J";
				} else {
					answer = "IMPOSSIBLE";
					break;
				}
			}
			if(!answer.equals("IMPOSSIBLE")) {
				for(int i=0;i<n;i++) {
					list[i].start = list[i].index;
				}
				Arrays.sort(list);
				for(int i=0;i<n;i++) {
					answer = answer + list[i].person;
				}
			}
			System.out.println("Case #"+test+": "+answer);
		}
		in.close();
	}
	static class activity implements Comparable<activity> {
		int start, end;
		int index;
		String person = "A";
		public activity(int a, int b, int c) {
			start = a;
			end = b;
			index = c;
		}
		@Override
		public int compareTo(activity o) {
			return Integer.compare(start, o.start);
		}
	}
}