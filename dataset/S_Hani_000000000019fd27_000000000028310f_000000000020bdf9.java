

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testcases = Integer.parseInt(sc.nextLine());
		for (int testcase = 1; testcase <= testcases; testcase++) {
			int no_of_activities = Integer.parseInt(sc.nextLine());
			int[][] schedule_C = new int[no_of_activities][2];
			int[][] schedule_J = new int[no_of_activities][2];
			int activity_count_C = 0, activity_count_J = 0;
			String output = "";
			activity: for (int i = 0; i < no_of_activities; i++) {
				String[] timeslot = sc.nextLine().split(" ");
				boolean C_busy = false, J_busy = false;
				int startTime = Integer.parseInt(timeslot[0]);
				int endTime = Integer.parseInt(timeslot[1]);
				C_busy = is_resource_occupied(schedule_C, startTime, endTime, activity_count_C);
				if (!C_busy) {
					schedule_C[activity_count_C][0] = startTime;
					schedule_C[activity_count_C][1] = endTime;
					activity_count_C++;
					output = output.concat("C");
					continue activity;
				} else {
					J_busy = is_resource_occupied(schedule_J, startTime, endTime, activity_count_J);
					if (!J_busy) {
						schedule_J[activity_count_J][0] = startTime;
						schedule_J[activity_count_J][1] = endTime;
						activity_count_J++;
						output = output.concat("J");
						continue activity;
					} else {
						output = "IMPOSSIBLE";
						break activity;
					}
				}

			}
			System.out.println("Case #" + testcase + ": " + output);
		}
		sc.close();
	}

	private static boolean is_resource_occupied(int[][] schedule, int startTime, int endTime, int scehduled_activities) {
		boolean occupied = false;
		for (int[] a : schedule) {
			if (a == schedule[scehduled_activities])
				break;
			if ((startTime > a[0] && startTime < a[1]) || (endTime > a[0] && endTime < a[1])) {
				occupied = true;
				break;
			}
			
		}
		return occupied;
	}
}
