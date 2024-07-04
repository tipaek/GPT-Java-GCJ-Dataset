import java.sql.Time;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		String[] res = new String[T];
		for(int i = 0; i < T; i++) {
			int N = sc.nextInt();
			res[i] = createSchedule(N, sc);
		}
		
		for(int i = 1; i <= T; i++) {
			System.out.println("Case #" + i + ": " + res[i - 1]);
		}
	}

	static class TimeObject implements Comparable<TimeObject> {
		boolean isStart;
		int time;
		int id;
		char asignee;
		public TimeObject(int t, boolean start, int id) {
			this.isStart = start;
			this.time = t;
			this.id = id;
		}
		@Override
		public int compareTo(TimeObject that) {
			if(this.time != that.time)
				return this.time - that.time;
			if(!this.isStart)
				return -1;
			return 1;
		}
		
	}
	private static String createSchedule(int N, Scanner sc) {
		TimeObject[] arr = new TimeObject[2 * N];
		for(int i = 0; i < N; i++) {
			arr[2 * i] = new TimeObject(sc.nextInt(), true, i);
			arr[2 * i + 1] = new TimeObject(sc.nextInt(), false, i);
		}
		Queue<Character> idle = new LinkedList();
		idle.add('C');
		idle.add('J');
		Arrays.sort(arr);
		return getScheduleFromTimeObjects(arr, idle, N); 
	}
	private static String getScheduleFromTimeObjects(TimeObject[] arr, Queue<Character> idle, int N) {
		Map<Integer, Character> assignMap = new HashMap<>();
		StringBuilder stbr = new StringBuilder("");
		List<TimeObject> res = new ArrayList<>();
		for(TimeObject o : arr) {
			if(o.isStart) {
				if(idle.isEmpty())
					return "IMPOSSIBLE";
				char c = idle.poll();
				assignMap.put(o.id, c);
				o.asignee = c;
				res.add(o);
			} else {
				idle.add(assignMap.get(o.id));
			}
		}
		Collections.sort(res, new Comparator<TimeObject>() {
			@Override
			public int compare(TimeObject o1, TimeObject o2) {
				// TODO Auto-generated method stub
				return o1.id - o2.id;
			};
		});
		
		for(TimeObject o : res) {
			stbr.append("" + o.asignee);
		}
		return stbr.toString();
	}
}
