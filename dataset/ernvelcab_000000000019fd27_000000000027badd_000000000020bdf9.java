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

				List<int[]> activityTimes = new ArrayList<>();

				for (int a = 0; a < numberOfActivities; a++) {
					line = bufferedReader.readLine();
					String[] lineParts = line.split(" ");
					int start = Integer.parseInt(lineParts[0]);
					int end = Integer.parseInt(lineParts[1]);
					activityTimes.add(new int[]{start, end});
				}

				int firstPersonTime = 0;
				int secondPersonTime = 0;

				final List<Integer> processedActivities = new ArrayList<>();

				final List<int[]> orderedActivityTimes = new ArrayList<>();
				final int[] orderedActivityIndices = new int[numberOfActivities];

				for (int a = 0; a < numberOfActivities; a ++) {
					int selectedActivity = -1;
					int[] selectedActivityTimes = null;
					for (int j = 0; j < numberOfActivities; j++) {
						if (!processedActivities.contains(j)) {
							if ((selectedActivity == -1)
									|| activityTimes.get(j)[0] < selectedActivityTimes[0]) {
								selectedActivity = j;
								selectedActivityTimes = activityTimes.get(j);
							}
						}
					}
					processedActivities.add(selectedActivity);
					orderedActivityTimes.add(selectedActivityTimes);
					orderedActivityIndices[a] = selectedActivity;
				}

				final boolean[] assignedToFirstPerson = new boolean[numberOfActivities];
				String result = null;
				for (int a = 0; a < numberOfActivities; a ++) {
					final int[] currentActivityTimes = orderedActivityTimes.get(a);
					if (firstPersonTime <= currentActivityTimes[0]) {
						firstPersonTime = currentActivityTimes[1];
						assignedToFirstPerson[orderedActivityIndices[a]] = true;
					} else if (secondPersonTime <= currentActivityTimes[0]) {
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
