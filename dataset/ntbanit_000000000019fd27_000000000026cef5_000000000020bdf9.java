//package codejam2020.q1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

class Schedule implements Comparable<Schedule> {
	int start;
	int end;
	int index;

	public Schedule(int start, int end, int index) {
		this.start = start;
		this.end = end;
		this.index = index;
	}

	@Override
	public int compareTo(Schedule o) {
		if (end == o.end) {
			if (start == o.start)
				return 0;
			return (start > o.start) ? 1 : -1;
		}
		return (end > o.end) ? 1 : -1;
	}

	@Override
	public String toString() {
		return start + " " + end;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Schedule) {
			Schedule o = (Schedule) obj;
			return (start == o.start && end == o.end);
		}
		return false;
	}
}

public class Solution {

	static boolean isOK(Schedule schedule, HashMap<Integer, Schedule> history) {
		for (Integer key : history.keySet()) {
			Schedule worked = history.get(key);
			if (worked.equals(schedule)) {
				return false;
			} else if (schedule.start >= worked.start && schedule.start < worked.end) {
				return false;
			} else if (schedule.end > worked.start && schedule.end < worked.end) {
				return false;
			} else if (worked.start >= schedule.start && worked.start < schedule.end) {
				return false;
			} else if (worked.end > schedule.start && worked.end < schedule.end) {
				return false;
			}
		}
		return true;
	}

	static void doTheWork(int person, int result[], Schedule schedule, HashMap<Integer, Schedule> history) {
		result[schedule.index] = person;
		history.put(schedule.index, schedule);
	}

	public static void main(String[] args) throws Exception {
//		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			ArrayList<Schedule> schedules = new ArrayList<>();
			for (int index = 0; index < N; index++) {
				int start = sc.nextInt();
				int end = sc.nextInt();
				schedules.add(new Schedule(start, end, index));
			}
			Collections.sort(schedules);

			HashMap<Integer, Schedule> aBusyMins = new HashMap<>();
			HashMap<Integer, Schedule> bBusyMins = new HashMap<>();
			int result[] = new int[N];
			doTheWork(1, result, schedules.get(0), aBusyMins);

			ArrayList<Schedule> pendings = new ArrayList<>();
			boolean impossible = false;
			for (int i = 1; i < schedules.size(); i++) {
				Schedule schedule = schedules.get(i);
				boolean aCheck = isOK(schedule, aBusyMins);
				boolean bCheck = isOK(schedule, bBusyMins);
				if (aCheck && !bCheck) {
					doTheWork(1, result, schedule, aBusyMins);
				} else if (!aCheck && bCheck) {
					doTheWork(2, result, schedule, bBusyMins);
				} else if (aCheck && bCheck) {
					pendings.add(schedule);
				} else {
					impossible = true;
					break;
				}
			}
			int i = 0;
			while (pendings.size() > 0 && i < pendings.size()) {
				Schedule schedule = pendings.get(i);
				boolean aCheck = isOK(schedule, aBusyMins);
				boolean bCheck = isOK(schedule, bBusyMins);
				if (aCheck && !bCheck) {
					doTheWork(1, result, schedule, aBusyMins);
					i = 0;
					pendings.remove(schedule);
				} else if (!aCheck && bCheck) {
					doTheWork(2, result, schedule, bBusyMins);
					i = 0;
					pendings.remove(schedule);
				} else if (aCheck && bCheck) {
					i++;
				} else {
					impossible = true;
					break;
				}
			}
			while (pendings.size() > 0 ) {
				Schedule schedule = pendings.get(0);
				boolean aCheck = isOK(schedule, aBusyMins);
				boolean bCheck = isOK(schedule, bBusyMins);
				if (aCheck && !bCheck) {
					doTheWork(1, result, schedule, aBusyMins);
					pendings.remove(schedule);
				} else if (bCheck) {
					doTheWork(2, result, schedule, bBusyMins);
					pendings.remove(schedule);
				} else {
					impossible = true;
					break;
				}
			}
			if (impossible ||  pendings.size() > 0) {
				System.out.printf("Case #%d: IMPOSSIBLE\n", tc);
			} else {
				System.out.printf("Case #%d: ", tc);
				for (int j = 0; j < result.length; j++) {
					System.out.print(result[j] == 1 ? "C" : "J");
				}
				System.out.println();
			}
		}
	}
}
