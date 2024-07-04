
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
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
		Stack<Character> idle = new Stack<>();
		idle.add('J');
		idle.add('C');
		Arrays.sort(arr);
		return getScheduleFromTimeObjects(arr, idle); 
	}
	private static String getScheduleFromTimeObjects(TimeObject[] arr, Stack<Character> idle) {
		Map<Integer, Character> assignMap = new HashMap<>();
		StringBuilder stbr = new StringBuilder("");
		for(TimeObject o : arr) {
			if(o.isStart) {
				if(idle.isEmpty())
					return "IMPOSSIBLE";
				char c = idle.pop();
				assignMap.put(o.id, c);
				stbr.append("" + c);
			} else {
				idle.add(assignMap.get(o.id));
			}
		}
		return stbr.toString();
	}
}
