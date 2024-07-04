
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static String[] RESOURCES = { "C", "J" };
	public static int[][][] schedule;
	public static int[] activity_count = new int[RESOURCES.length];
	public static boolean[] resource_busy = new boolean[RESOURCES.length];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testcases = Integer.parseInt(sc.nextLine());
		for (int testcase = 1; testcase <= testcases; testcase++) {
			int no_of_activities = Integer.parseInt(sc.nextLine());
			schedule = new int[RESOURCES.length][no_of_activities][2];
			String output = "";
			Arrays.fill(activity_count, 0);
			for (int i = 0; i < no_of_activities; i++) {
				String[] timeslot = sc.nextLine().split(" ");
				Arrays.fill(resource_busy, false);
				int startTime = Integer.parseInt(timeslot[0]);
				int endTime = Integer.parseInt(timeslot[1]);
				String available = book_appointment( startTime, endTime);
				if(available.equals("IMPOSSIBLE")) {
					output = available;
					break;
				}
				else {
					output = output + available;
				}
			}
			
			System.out.println("Case #" + testcase + ": " + output);
		}
		sc.close();
	}

	private static String book_appointment(int startTime, int endTime) {
		for (int res = 0; res < RESOURCES.length; res++) {
			resource_busy[res] = is_resource_occupied(res, startTime, endTime);
			if (!resource_busy[res]) {
				schedule[res][activity_count[res]][0] = startTime;
				schedule[res][activity_count[res]][1] = endTime;
				activity_count[res]++;
				return RESOURCES[res];
			}
		}
		return "IMPOSSIBLE";
	}

	private static boolean is_resource_occupied(int res, int startTime, int endTime) {
		boolean occupied = false;
		for (int i = 0; i < activity_count[res]; i++) {
			if ((startTime > schedule[res][i][0] && startTime < schedule[res][i][1])
					|| (endTime > schedule[res][i][0] && endTime < schedule[res][i][1])) {
				occupied = true;
				break;
			}

		}
		return occupied;
	}

	public static boolean areAllTrue(boolean[] array) {
		for (boolean b : array)
			if (!b)
				return false;
		return true;
	}
}

