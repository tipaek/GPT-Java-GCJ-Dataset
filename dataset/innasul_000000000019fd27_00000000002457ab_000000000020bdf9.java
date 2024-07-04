import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) {

		try (Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));) {
			int numberOfTests = in.nextInt();
			List<String> schedules = new ArrayList<>();
			for (int t = 0; t < numberOfTests; t++) {
				int numberofSchedules = in.nextInt();
				List<List<Integer>> scheduleList = new ArrayList<>();
				List<Integer> b1 = new ArrayList<>();
				List<Integer> b2 = new ArrayList<>();
				List<Integer> nt = new ArrayList<>();
				for (int i = 0; i < numberofSchedules; i++) {
					List<Integer> schedule = new ArrayList<>();
					schedule.add(in.nextInt());
					schedule.add(in.nextInt());
					scheduleList.add(schedule);
				}
				if (isNonConflictTimeSlot(scheduleList.get(0), scheduleList.get(1))) {
					b1.add(0);
					b1.add(1);
				} else {
					b1.add(0);
					b2.add(1);
				}
				String finalSchedule = "";
				for (int i = 2; i < scheduleList.size(); i++) {
					Boolean isBucket1 = isSameBucket(b1, i, scheduleList);
					Boolean isBucket2 = isSameBucket(b2, i, scheduleList);
					if (isBucket1 && isBucket2) {
						nt.add(i);
					} else if (isBucket1) {
						b1.add(i);
					} else if (isBucket2) {
						b2.add(i);
					} else {
						finalSchedule = "IMPOSSIBLE";
						;
						break;
					}
				}
				if (finalSchedule.trim().isEmpty()) {
					for (int i = 0; i < nt.size(); i++) {
						Boolean isBucket1 = isSameBucket(b1, nt.get(i), scheduleList);
						Boolean isBucket2 = isSameBucket(b2, nt.get(i), scheduleList);
						if (isBucket1) {
							b1.add(i);
						} else if (isBucket2) {
							b2.add(i);
						} else {
							finalSchedule = "IMPOSSIBLE";
							;
							break;
						}
					}
				}
				if (finalSchedule.trim().isEmpty()) {
					for (int i = 0; i < numberofSchedules; i++) {
						if (b1.contains(i)) {
							finalSchedule += "C";
						} else {
							finalSchedule += "J";
						}
					}
				}
				schedules.add(finalSchedule);
			}
			for (int i = 0; i < numberOfTests; i++) {
				System.out.println("Case #" + (i + 1) + ": " + schedules.get(i));
			}
		}
	}

	private static Boolean isSameBucket(List<Integer> bucket, int i, List<List<Integer>> scheduleList) {
		Boolean nonConflict = true;
		for (int j = 0; j < bucket.size(); j++) {
			if (!isNonConflictTimeSlot(scheduleList.get(bucket.get(j)), scheduleList.get(i))) {
				nonConflict = false;
				break;
			}
		}
		return nonConflict;
	}

	private static Boolean isNonConflictTimeSlot(List<Integer> schedule0, List<Integer> schedule1) {
		Boolean isNonConflit = false;
		Integer s0st = schedule0.get(0);
		Integer s0et = schedule0.get(1);
		Integer s1st = schedule1.get(0);
		Integer s1et = schedule1.get(1);
		if (s0et <= s1st || s1et <= s0st) {
			isNonConflit = true;
		} else {
			isNonConflit = false;
		}
		if(s0st==s1st && s0et==s1et){ isNonConflit= false; }
		 
		return isNonConflit;
	}

}
