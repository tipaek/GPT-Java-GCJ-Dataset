import java.util.HashMap;
import java.util.Scanner;

public class Solution {
    private static final Scanner SCANNER = new Scanner(System.in);

    private static class Activity {
        private int start;
        private int end;
        private int id;

        public Activity(int start, int end, int id) {
            this.start = start;
            this.end = end;
            this.id = id;
        }

        public boolean isAfter(Activity other) {
            return this.start > other.start || (this.start == other.start && this.end > other.end);
        }

        public boolean hasGreaterId(Activity other) {
            return this.id > other.id;
        }
    }

    public static void main(String[] args) {
        int numCases = SCANNER.nextInt();
        for (int i = 0; i < numCases; i++) {
            processCase(i + 1);
        }
    }

    private static void processCase(int caseNum) {
        int numActivities = SCANNER.nextInt();
        Activity[] activities = new Activity[numActivities];
        for (int i = 0; i < numActivities; i++) {
            activities[i] = new Activity(SCANNER.nextInt(), SCANNER.nextInt(), i);
        }
        sortActivities(activities);

        char[] schedule = new char[numActivities];
        boolean isCameronBusy, isJamieBusy;
        int scheduledCount = 0;
        for (; scheduledCount < numActivities; scheduledCount++) {
            isCameronBusy = isPersonBusy('C', schedule, activities, scheduledCount);
            isJamieBusy = isPersonBusy('J', schedule, activities, scheduledCount);
            if (!isCameronBusy) {
                schedule[scheduledCount] = 'C';
            } else if (!isJamieBusy) {
                schedule[scheduledCount] = 'J';
            } else {
                break;
            }
        }
        sortSchedule(schedule, activities);
        printResult(caseNum, scheduledCount == numActivities ? new String(schedule) : "IMPOSSIBLE");
    }

    private static void sortSchedule(char[] schedule, Activity[] activities) {
        HashMap<Integer, Character> orderMap = new HashMap<>(schedule.length);
        for (int i = 0; i < schedule.length; i++) {
            orderMap.put(activities[i].id, schedule[i]);
        }
        for (int i = 0; i < schedule.length; i++) {
            schedule[i] = orderMap.get(i);
        }
    }

    private static void sortActivities(Activity[] activities) {
        if (activities.length <= 1) {
            return;
        }
        if (activities.length == 2) {
            if (activities[0].isAfter(activities[1])) {
                swap(activities, 0, 1);
            }
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
            if (leftIndex == left.length || (rightIndex < right.length && left[leftIndex].isAfter(right[rightIndex]))) {
                activities[i] = right[rightIndex++];
            } else {
                activities[i] = left[leftIndex++];
            }
        }
    }

    private static void swap(Activity[] activities, int i, int j) {
        Activity temp = activities[i];
        activities[i] = activities[j];
        activities[j] = temp;
    }

    private static boolean isPersonBusy(char person, char[] schedule, Activity[] activities, int idx) {
        for (int i = idx - 1; i >= 0; i--) {
            if (schedule[i] == person && activities[i].end > activities[idx].start) {
                return true;
            }
        }
        return false;
    }

    private static void printResult(int caseNum, String result) {
        System.out.printf("Case #%d: %s%n", caseNum, result);
    }
}