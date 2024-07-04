import java.io.*;
import java.time.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
		try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
			String line = bufferedReader.readLine();
			final int numberOfCases = Integer.parseInt(line);

			for (int c = 1; c <= numberOfCases; c++) {
				line = bufferedReader.readLine();
				final int numberOfActivities = Integer.parseInt(line);

				List<LocalDateTime[]> activityTimes = new ArrayList<>();
				final LocalTime initialTime = LocalTime.of(0, 0, 0);

				for (int a = 0; a < numberOfActivities; a++) {
					line = bufferedReader.readLine();
					String[] lineParts = line.split(" ");
					int start = Integer.parseInt(lineParts[0]);
					int end = Integer.parseInt(lineParts[1]);

					LocalDateTime startDateTime = LocalDateTime.of(LocalDate.now(), initialTime);
					startDateTime = startDateTime.plus(start, ChronoUnit.MINUTES);

					LocalDateTime endDateTime = LocalDateTime.of(LocalDate.now(), initialTime);
					endDateTime = endDateTime.plus(end, ChronoUnit.MINUTES);

					activityTimes.add(new LocalDateTime[]{startDateTime, endDateTime});
				}

				LocalDateTime firstPersonTime = LocalDateTime.of(LocalDate.now(), initialTime);
				LocalDateTime secondPersonTime = LocalDateTime.of(LocalDate.now(), initialTime);

				List<LocalDateTime[]> orderedActivityTimes = new ArrayList<>();
				List<Integer> selectedActivities = new ArrayList<>();
				int[] orderedActivityIndices = new int[numberOfActivities];

				for (int a = 0; a < numberOfActivities; a ++) {
					int selectedActivity = -1;
					LocalDateTime[] selectedActivityTimes = null;
					for (int j = 0; j < numberOfActivities; j++) {
						if (!selectedActivities.contains(j)) {
							if ((selectedActivity == -1) || activityTimes.get(j)[0].isBefore(selectedActivityTimes[0])) {
								selectedActivity = j;
								selectedActivityTimes = activityTimes.get(j);
							}
						}
					}
					selectedActivities.add(selectedActivity);
					orderedActivityTimes.add(selectedActivityTimes);
					orderedActivityIndices[selectedActivity] = a;
				}

				boolean[] assignedToFirstPerson = new boolean[numberOfActivities];
				String result = null;
				for (int a = 0; a < numberOfActivities; a ++) {
					final LocalDateTime[] currentActivityTimes = orderedActivityTimes.get(a);
					if (firstPersonTime.isBefore(currentActivityTimes[0]) || !firstPersonTime.isAfter(currentActivityTimes[0])) {
						firstPersonTime = currentActivityTimes[1];
						assignedToFirstPerson[orderedActivityIndices[a]] = true;
					} else if (secondPersonTime.isBefore(currentActivityTimes[0]) || !secondPersonTime.isAfter(currentActivityTimes[0])) {
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
