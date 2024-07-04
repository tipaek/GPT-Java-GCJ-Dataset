import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    private static int caseNumber = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int i = 0; i < testCases; i++) {
            processTestCase(scanner);
        }
    }

    private static void processTestCase(Scanner scanner) {
        int numActivities = scanner.nextInt();
        List<Activity> activities = new ArrayList<>();
        StringBuilder schedule = new StringBuilder();

        int cameronEndTime = 0;
        int jaimeEndTime = 0;

        for (int i = 0; i < numActivities; i++) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            activities.add(new Activity(start, end));
        }

        for (Activity activity : activities) {
            if (activity.start >= cameronEndTime) {
                cameronEndTime = activity.end;
                schedule.append('C');
            } else if (activity.start >= jaimeEndTime) {
                jaimeEndTime = activity.end;
                schedule.append('J');
            } else {
                schedule.setLength(0);
                break;
            }
        }

        if (schedule.length() == 0) {
            System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
        } else {
            System.out.println("Case #" + caseNumber + ": " + schedule.toString());
        }
        caseNumber++;
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