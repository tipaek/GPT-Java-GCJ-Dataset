import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= numberOfCases; caseNumber++) {
            int numberOfActivities = scanner.nextInt();
            List<int[]> activities = new ArrayList<>();

            for (int i = 0; i < numberOfActivities; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                activities.add(new int[]{start, end});
            }

            int cameronEnd = 0;
            int jamieEnd = 0;
            StringBuilder schedule = new StringBuilder();
            boolean possible = true;

            for (int[] activity : activities) {
                int start = activity[0];
                int end = activity[1];

                if (cameronEnd <= start) {
                    cameronEnd = end;
                    schedule.append("C");
                } else if (jamieEnd <= start) {
                    jamieEnd = end;
                    schedule.append("J");
                } else {
                    possible = false;
                    break;
                }
            }

            if (!possible) {
                schedule = new StringBuilder("IMPOSSIBLE");
            }

            System.out.println("Case #" + caseNumber + ": " + schedule.toString());
        }
    }
}