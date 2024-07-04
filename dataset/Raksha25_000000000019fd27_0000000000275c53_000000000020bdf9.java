
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.*;

public class Solution {
	static class Time {
		int startTime;
		int endTime;
		int index;

		public Time(int startTime, int endTime, int index) {
			this.startTime = startTime;
			this.endTime = endTime;
			this.index = index;
		}
	}

	static class Pair {
		char ch;
		int index;

		public Pair(char ch, int index) {
			this.ch = ch;
			this.index = index;
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = sc.nextInt();

		for (int i = 0; i < t; i++) {
			int n = sc.nextInt();
			ArrayList<Time> timeList = new ArrayList<>();
			int cEndTime = -1;
			int jEndTime = -1;
			boolean isImp = false;
			ArrayList<Pair> ans = new ArrayList<>();
			for (int j = 0; j < n; j++) {
				int startTime = sc.nextInt();
				int endTime = sc.nextInt();
				timeList.add(new Time(startTime, endTime, j));
			}
			Collections.sort(timeList, new Comparator<Time>() {
				@Override
				public int compare(Time o1, Time o2) {
					return Integer.compare(o1.startTime, o2.startTime);
				}
			});

			for (int k = 0; k < timeList.size(); k++) {
				Time it = timeList.get(k);
//                System.out.println(it.startTime+" "+ it.endTime+" "+ stringBuilder.toString());
//                System.out.println(cEndTime +" "+ jEndTime+" "+ stringBuilder.toString());
			if (it.startTime >= cEndTime) {
				ans.add(new Pair('J', it.index));
				cEndTime = it.endTime;
			} else if (it.startTime >= jEndTime) {
				ans.add(new Pair('C', it.index));
				jEndTime = it.endTime;
			} else {
				isImp = true;
				break;
			}
		}
		Collections.sort(ans, new Comparator<Pair>() {

			@Override
			public int compare(Pair o1, Pair o2) {
				return Integer.compare(o1.index, o2.index);
			}

		});
		StringBuilder aaAns = new StringBuilder();
		if (isImp) {
			aaAns.append("IMPOSSIBLE");

		} else {
			for (int k = 0; k < ans.size(); k++) {
				aaAns.append(ans.get(k).ch);
			}
		}
		System.out.println("Case #" + (i + 1) + ": " + aaAns.toString());
//            Case #1: CJC
		}
	}

}