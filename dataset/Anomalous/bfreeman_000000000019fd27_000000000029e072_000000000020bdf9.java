import java.util.Scanner;

public class Solution {
    private static final Scanner scanner = new Scanner(System.in);

    private static class Activity {
        private final int start;
        private final int end;

        private Activity(int start, int end) {
            this.start = start;
            this.end = end;
        }

        private boolean isAfter(Activity other) {
            return this.start > other.start || (this.start == other.start && this.end > other.end);
        }
    }

    public static void main(String[] args) {
        int numberOfCases = scanner.nextInt();
        for (int i = 0; i < numberOfCases; i++) {
            processCase(i + 1);
        }
    }

    private static void processCase(int caseNumber) {
        final String IMPOSSIBLE = "IMPOSSIBLE";
        int numberOfActivities = scanner.nextInt();
        Activity[] activities = new Activity[numberOfActivities];
        for (int i = 0; i < numberOfActivities; i++) {
            activities[i] = new Activity(scanner.nextInt(), scanner.nextInt());
        }
        sortActivities(activities);
        char[] schedule = new char[numberOfActivities];
        boolean isCameronBusy = false;
        boolean isJamieBusy = false;
        boolean reevaluate = false;

        for (int i = 0; i < numberOfActivities; i++) {
            if (!isCameronBusy) {
                schedule[i] = 'C';
                isCameronBusy = true;
                reevaluate = false;
            } else if (!isJamieBusy) {
                schedule[i] = 'J';
                isJamieBusy = true;
                reevaluate = false;
            } else {
                if (reevaluate) {
                    break;
                } else {
                    reevaluate = true;
                    isCameronBusy = updateBusyStatus('C', schedule, activities, i);
                    isJamieBusy = updateBusyStatus('J', schedule, activities, i);
                    i--;
                }
            }
        }
        printResult(caseNumber, reevaluate ? IMPOSSIBLE : new String(schedule));
    }

    private static void sortActivities(Activity[] activities) {
        if (activities.length <= 1) {
            return;
        }
        int mid = activities.length / 2;
        Activity[] left = new Activity[mid];
        Activity[] right = new Activity[activities.length - mid];

        System.arraycopy(activities, 0, left, 0, mid);
        System.arraycopy(activities, mid, right, 0, activities.length - mid);

        sortActivities(left);
        sortActivities(right);
        merge(activities, left, right);
    }

    private static void merge(Activity[] activities, Activity[] left, Activity[] right) {
        int leftIndex = 0, rightIndex = 0;
        for (int i = 0; i < activities.length; i++) {
            if (leftIndex == left.length || (rightIndex < right.length && right[rightIndex].isAfter(left[leftIndex]))) {
                activities[i] = right[rightIndex++];
            } else {
                activities[i] = left[leftIndex++];
            }
        }
    }

    private static boolean updateBusyStatus(char person, char[] schedule, Activity[] activities, int currentIndex) {
        int lastAssignedIndex = -1;
        for (int i = currentIndex; i >= 0; i--) {
            if (schedule[i] == person) {
                lastAssignedIndex = i;
                break;
            }
        }
        return activities[lastAssignedIndex].end > activities[currentIndex].start;
    }

    private static void printResult(int caseNumber, String result) {
        System.out.printf("Case #%d: %s%n", caseNumber, result);
    }
}