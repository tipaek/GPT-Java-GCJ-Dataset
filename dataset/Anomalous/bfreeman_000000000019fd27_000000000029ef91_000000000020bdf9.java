import java.util.Scanner;
import java.util.Arrays;

public class Solution {
    public static final Scanner scanner = new Scanner(System.in);

    public static class Activity implements Comparable<Activity> {
        public int start;
        public int end;

        public Activity(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Activity other) {
            if (this.start != other.start) {
                return Integer.compare(this.start, other.start);
            }
            return Integer.compare(this.end, other.end);
        }
    }

    public static void main(String[] args) {
        int numCases = scanner.nextInt();
        for (int i = 1; i <= numCases; i++) {
            processCase(i);
        }
    }

    public static void processCase(int caseNum) {
        int numActivities = scanner.nextInt();
        Activity[] activities = new Activity[numActivities];
        for (int i = 0; i < numActivities; i++) {
            activities[i] = new Activity(scanner.nextInt(), scanner.nextInt());
        }

        Arrays.sort(activities);

        char[] schedule = new char[numActivities];
        int endC = 0, endJ = 0;

        for (int i = 0; i < numActivities; i++) {
            if (activities[i].start >= endC) {
                schedule[i] = 'C';
                endC = activities[i].end;
            } else if (activities[i].start >= endJ) {
                schedule[i] = 'J';
                endJ = activities[i].end;
            } else {
                printResult(caseNum, "IMPOSSIBLE");
                return;
            }
        }
        printResult(caseNum, new String(schedule));
    }

    public static void printResult(int caseNum, String result) {
        System.out.printf("Case #%d: %s%n", caseNum, result);
    }
}