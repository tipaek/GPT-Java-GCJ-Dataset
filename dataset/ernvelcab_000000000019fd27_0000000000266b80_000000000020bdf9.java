import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
		try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
			String line = bufferedReader.readLine();
			final int numberOfCases = Integer.parseInt(line);

			for (int c = 1; c <= numberOfCases; c++) {
				line = bufferedReader.readLine();
				final int numberOfActivities = Integer.parseInt(line);
				List<Calendar[]> activityTimes = new ArrayList<>();

				for (int a = 0; a < numberOfActivities; a++) {
					line = bufferedReader.readLine();
					String[] lineParts = line.split(" ");
					int start = Integer.parseInt(lineParts[0]);
					int end = Integer.parseInt(lineParts[1]);

					Calendar startDateTime = Calendar.getInstance();
					startDateTime.set(2020, 4, 4, 0, 0);
					startDateTime.add(Calendar.MINUTE, start);

					Calendar endDateTime = Calendar.getInstance();
					endDateTime.set(2020, 4, 4, 0, 0);
					endDateTime.add(Calendar.MINUTE, end);

					activityTimes.add(new Calendar[]{startDateTime, endDateTime});
				}

				Calendar firstPersonTime = Calendar.getInstance();
				firstPersonTime.set(2020, 4, 4, 0, 0);

				Calendar secondPersonTime = Calendar.getInstance();
				secondPersonTime.set(2020, 4, 4, 0, 0);

				List<Calendar[]> orderedActivityTimes = new ArrayList<>();
				List<Integer> selectedActivities = new ArrayList<>();
				int[] orderedActivityIndices = new int[numberOfActivities];

				for (int a = 0; a < numberOfActivities; a ++) {
					int selectedActivity = -1;
					Calendar[] selectedActivityTimes = null;
					for (int j = 0; j < numberOfActivities; j++) {
						if (!selectedActivities.contains(j)) {
							if ((selectedActivity == -1) || activityTimes.get(j)[0].before(selectedActivityTimes[0]) || !activityTimes.get(j)[0].after(selectedActivityTimes[0])) {
								selectedActivity = j;
								selectedActivityTimes = activityTimes.get(j);
							}
						}
					}
					selectedActivities.add(selectedActivity);
					orderedActivityTimes.add(selectedActivityTimes);
					orderedActivityIndices[a] = selectedActivity;
				}

				boolean[] assignedToFirstPerson = new boolean[numberOfActivities];
				String result = null;
				for (int a = 0; a < numberOfActivities; a ++) {
					final Calendar[] currentActivityTimes = orderedActivityTimes.get(a);
					if (firstPersonTime.before(currentActivityTimes[0]) || !firstPersonTime.after(currentActivityTimes[0])) {
						firstPersonTime = currentActivityTimes[1];
						assignedToFirstPerson[orderedActivityIndices[a]] = true;
					} else if (secondPersonTime.before(currentActivityTimes[0]) || !secondPersonTime.after(currentActivityTimes[0])) {
						secondPersonTime = currentActivityTimes[1];
						assignedToFirstPerson[orderedActivityIndices[a]] = false;
					} else {
						result = "IMPOSSIBLE";
						break;
					}
				}

				if (result == null) {
					result = "";
					for (int a = 0; a < numberOfActivities; a++) {
						if (assignedToFirstPerson[a]) {
							result += "J";
						} else {
							result += "C";
						}
					}
				}

				System.out.println("Case #" + c + ": " + result);
			}
		}
	}
}
