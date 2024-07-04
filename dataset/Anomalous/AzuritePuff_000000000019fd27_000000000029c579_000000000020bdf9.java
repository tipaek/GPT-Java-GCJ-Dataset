import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    private static final Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

    public static void main(String[] args) {
        int numberOfCases = scanner.nextInt();
        for (int caseIndex = 1; caseIndex <= numberOfCases; caseIndex++) {
            int numberOfActivities = scanner.nextInt();
            processActivities(numberOfActivities, caseIndex);
        }
    }

    private static void processActivities(int numberOfActivities, int caseNumber) {
        Activity[] activities = new Activity[numberOfActivities];
        for (int i = 0; i < numberOfActivities; i++) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            activities[i] = new Activity(start, end);
        }

        StringBuilder result = new StringBuilder();
        int i = 0;

        while (i < activities.length) {
            int currentStart = activities[i].start;
            int currentEnd = activities[i].end;

            if (i + 1 < activities.length) {
                int nextStart = activities[i + 1].start;

                if (nextStart < currentEnd) {
                    if (i + 2 < activities.length) {
                        int nextNextStart = activities[i + 2].start;
                        if (nextNextStart < activities[i + 1].end && nextNextStart < currentEnd) {
                            result = new StringBuilder("IMPOSSIBLE");
                            break;
                        }
                    }
                    result.append("JC");
                    i += 2;
                } else {
                    result.append("J");
                    i++;
                }
            } else {
                result.append("J");
                break;
            }
        }

        System.out.println("Case #" + caseNumber + ": " + result.toString());
    }

    private static class Activity {
        int start;
        int end;

        Activity(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}