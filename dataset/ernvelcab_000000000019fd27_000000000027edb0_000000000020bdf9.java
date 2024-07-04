import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
		try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
			final int numberOfCases = Integer.parseInt(bufferedReader.readLine());

			for (int c = 1; c <= numberOfCases; c++) {
				final int numberOfActivities = Integer.parseInt(bufferedReader.readLine());
				final int[][] activityTimes = new int[numberOfActivities][2];

				for (int a = 0; a < numberOfActivities; a++) {
					final String[] lineParts = bufferedReader.readLine().split(" ");
					activityTimes[a] = new int[]{Integer.parseInt(lineParts[0]), Integer.parseInt(lineParts[1])};
				}

				final Set<Integer> processedActivities = new HashSet<>();
				final int[] toUnsorted = new int[numberOfActivities];

				for (int a = 0; a < numberOfActivities; a++) {
					int selectedActivity = -1;
					int selectedActivityTime = -1;
					for (int j = 0; j < numberOfActivities; j++) {
						if (!processedActivities.contains(j)) {
							if ((selectedActivity == -1)
									|| activityTimes[j][0] < selectedActivityTime) {
								selectedActivity = j;
								selectedActivityTime = activityTimes[j][0];
							}
						}
					}
					processedActivities.add(selectedActivity);
					toUnsorted[a] = selectedActivity;
				}

				final boolean[] assignedToFirstPerson = new boolean[numberOfActivities];
				int firstPersonTime = 0;
				int secondPersonTime = 0;
				boolean possible = true;
				for (int a = 0; a < numberOfActivities; a++) {
					final int[] currentActivityTimes = activityTimes[toUnsorted[a]];
					if (firstPersonTime <= currentActivityTimes[0]) {
						firstPersonTime = currentActivityTimes[1];
						assignedToFirstPerson[toUnsorted[a]] = true;
					} else if (secondPersonTime <= currentActivityTimes[0]) {
						secondPersonTime = currentActivityTimes[1];
						assignedToFirstPerson[toUnsorted[a]] = false;
					} else {
						System.out.println("Case #" + c + ": IMPOSSIBLE" + sb.toString());
						possible = false;
						break;
					}
				}

				if (possible) {
					final StringBuilder sb = new StringBuilder();
					for (int a = 0; a < numberOfActivities; a++) {
						if (assignedToFirstPerson[a]) {
							sb.append("J");
						} else {
							sb.append("C");
						}
					}
					System.out.println("Case #" + c + ": " + sb.toString());
				}
			}
		}
	}
}
