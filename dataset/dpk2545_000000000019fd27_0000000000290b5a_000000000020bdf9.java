import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner in = null;
		try {
			in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
			int t = in.nextInt();
			int count = 1;
			while (t > 0) {
				int n = in.nextInt();
				List<Interval> list = new ArrayList<Interval>();
				for (int i = 0; i < n; i++) {
					list.add(new Interval(in.nextInt(), in.nextInt()));
				}
				findDifferentIntervals(list, count);
				count++;
				t--;
			}
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
	}
	
	public static void findDifferentIntervals(List<Interval> list, int count) {
		Collections.sort(list, new Comparator<Interval>() {

			@Override
			public int compare(Interval o1, Interval o2) {
				return o1.startTime - o2.startTime;
			}

		});
		String s = "J";
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		map.put('J',list.get(0).endTime);
		for (int i = 1; i < list.size(); i++) {
			Interval i2 = list.get(i);
			if (map.get('J') <= i2.getStartTime()) {
					s += 'J';
				map.put('J', i2.getEndTime());
			}
			else if (map.get('C') != null && map.get('C') <= i2.getStartTime()) {
					s += 'C';
				map.put('C', i2.getEndTime());
			}
			else if (map.get('C') != null) {
					s = "IMPOSSIBLE";
					break;
			} else {
				map.put('C', i2.getEndTime());
				s += 'C';
			}
		}

		System.out.println("Case #" + count + ": " + s);

	}
}

class Interval {
	int startTime;
	int endTime;

	public Interval(int startTime, int endTime) {
		super();
		this.startTime = startTime;
		this.endTime = endTime;
	}

	public int getStartTime() {
		return startTime;
	}

	public int getEndTime() {
		return endTime;
	}
}