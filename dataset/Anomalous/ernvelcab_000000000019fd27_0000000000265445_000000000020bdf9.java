import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int numberOfCases = Integer.parseInt(reader.readLine());

            for (int caseIndex = 1; caseIndex <= numberOfCases; caseIndex++) {
                int numberOfActivities = Integer.parseInt(reader.readLine());
                List<Activity> activities = new ArrayList<>();

                for (int i = 0; i < numberOfActivities; i++) {
                    String[] parts = reader.readLine().split(" ");
                    int start = Integer.parseInt(parts[0]);
                    int end = Integer.parseInt(parts[1]);
                    activities.add(new Activity(start, end, i));
                }

                activities.sort(Comparator.comparingInt(a -> a.start));

                int[] assignedPersons = new int[numberOfActivities];
                Arrays.fill(assignedPersons, -1);
                int endTimeJ = 0, endTimeC = 0;
                boolean possible = true;

                for (Activity activity : activities) {
                    if (activity.start >= endTimeJ) {
                        assignedPersons[activity.index] = 0; // J
                        endTimeJ = activity.end;
                    } else if (activity.start >= endTimeC) {
                        assignedPersons[activity.index] = 1; // C
                        endTimeC = activity.end;
                    } else {
                        possible = false;
                        break;
                    }
                }

                StringBuilder result = new StringBuilder();
                if (possible) {
                    for (int person : assignedPersons) {
                        result.append(person == 0 ? 'J' : 'C');
                    }
                } else {
                    result.append("IMPOSSIBLE");
                }

                System.out.println("Case #" + caseIndex + ": " + result);
            }
        }
    }

    static class Activity {
        int start, end, index;

        Activity(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }
    }
}