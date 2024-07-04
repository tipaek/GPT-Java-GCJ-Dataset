import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            int numberOfCases = Integer.parseInt(bufferedReader.readLine());

            for (int caseNumber = 1; caseNumber <= numberOfCases; caseNumber++) {
                int numberOfActivities = Integer.parseInt(bufferedReader.readLine());
                List<Activity> activities = new ArrayList<>();

                for (int i = 0; i < numberOfActivities; i++) {
                    String[] parts = bufferedReader.readLine().split(" ");
                    int start = Integer.parseInt(parts[0]);
                    int end = Integer.parseInt(parts[1]);
                    activities.add(new Activity(start, end, i));
                }

                activities.sort(Comparator.comparingInt(a -> a.start));

                int[] assignments = new int[numberOfActivities];
                int cameronEnd = 0;
                int jamieEnd = 0;
                boolean possible = true;

                for (Activity activity : activities) {
                    if (activity.start >= cameronEnd) {
                        assignments[activity.index] = 'C';
                        cameronEnd = activity.end;
                    } else if (activity.start >= jamieEnd) {
                        assignments[activity.index] = 'J';
                        jamieEnd = activity.end;
                    } else {
                        possible = false;
                        break;
                    }
                }

                StringBuilder result = new StringBuilder();
                if (possible) {
                    for (int assignment : assignments) {
                        result.append((char) assignment);
                    }
                } else {
                    result.append("IMPOSSIBLE");
                }

                System.out.println("Case #" + caseNumber + ": " + result);
            }
        }
    }

    static class Activity {
        int start;
        int end;
        int index;

        Activity(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }
    }
}