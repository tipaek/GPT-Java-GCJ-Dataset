import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int numberOfCases = Integer.parseInt(reader.readLine());

            for (int caseIndex = 1; caseIndex <= numberOfCases; caseIndex++) {
                int numberOfActivities = Integer.parseInt(reader.readLine());
                List<int[]> activities = new ArrayList<>();

                for (int i = 0; i < numberOfActivities; i++) {
                    String[] parts = reader.readLine().split(" ");
                    int start = Integer.parseInt(parts[0]);
                    int end = Integer.parseInt(parts[1]);
                    activities.add(new int[]{start, end});
                }

                List<int[]> sortedActivities = new ArrayList<>(activities);
                sortedActivities.sort(Comparator.comparingInt(a -> a[0]));

                int firstPersonEnd = 0;
                int secondPersonEnd = 0;
                char[] assignments = new char[numberOfActivities];
                boolean possible = true;

                for (int[] activity : sortedActivities) {
                    int originalIndex = activities.indexOf(activity);
                    if (firstPersonEnd <= activity[0]) {
                        firstPersonEnd = activity[1];
                        assignments[originalIndex] = 'J';
                    } else if (secondPersonEnd <= activity[0]) {
                        secondPersonEnd = activity[1];
                        assignments[originalIndex] = 'C';
                    } else {
                        possible = false;
                        break;
                    }
                }

                String result = possible ? new String(assignments) : "IMPOSSIBLE";
                System.out.println("Case #" + caseIndex + ": " + result);
            }
        }
    }
}