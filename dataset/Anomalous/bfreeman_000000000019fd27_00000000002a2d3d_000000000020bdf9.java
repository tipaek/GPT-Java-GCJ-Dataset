import java.util.*;

public class Solution {
    private static final Scanner SCANNER = new Scanner(System.in);

    private static class Activity {
        private final int start;
        private final int end;
        private final int id;

        public Activity(int start, int end, int id) {
            this.start = start;
            this.end = end;
            this.id = id;
        }

        public boolean isLaterThan(Activity other) {
            return this.start > other.start || (this.start == other.start && this.end > other.end);
        }
    }

    public static void main(String[] args) {
        int numCases = SCANNER.nextInt();
        for (int i = 0; i < numCases; i++) {
            int numActivities = SCANNER.nextInt();
            Activity[] activities = new Activity[numActivities];
            for (int j = 0; j < numActivities; j++) {
                activities[j] = new Activity(SCANNER.nextInt(), SCANNER.nextInt(), j);
            }
            processCase(i + 1, numActivities, activities);
        }
    }

    private static void processCase(int caseNumber, int numActivities, Activity[] activities) {
        Arrays.sort(activities, Comparator.comparingInt((Activity a) -> a.start).thenComparingInt(a -> a.end));

        char[] schedule = new char[numActivities];
        int bookedActivities = 0;

        for (; bookedActivities < numActivities; bookedActivities++) {
            boolean isCameronBusy = isPersonBusy('C', schedule, activities, bookedActivities);
            boolean isJamieBusy = isPersonBusy('J', schedule, activities, bookedActivities);
            if (!isCameronBusy) {
                schedule[bookedActivities] = 'C';
            } else if (!isJamieBusy) {
                schedule[bookedActivities] = 'J';
            } else {
                break;
            }
        }

        reorderSchedule(schedule, activities);
        printResult(caseNumber, bookedActivities == numActivities ? new String(schedule) : "IMPOSSIBLE");
    }

    private static void reorderSchedule(char[] schedule, Activity[] activities) {
        Map<Integer, Character> activityOrder = new HashMap<>(schedule.length);
        for (int i = 0; i < schedule.length; i++) {
            activityOrder.put(activities[i].id, schedule[i]);
        }
        for (int i = 0; i < schedule.length; i++) {
            schedule[i] = activityOrder.get(i);
        }
    }

    private static boolean isPersonBusy(char person, char[] schedule, Activity[] activities, int currentIndex) {
        int lastActivityIndex = -1;
        for (int i = currentIndex - 1; i >= 0; i--) {
            if (schedule[i] == person) {
                lastActivityIndex = i;
                break;
            }
        }
        return lastActivityIndex != -1 && activities[lastActivityIndex].end > activities[currentIndex].start;
    }

    private static void printResult(int caseNumber, String result) {
        System.out.printf("Case #%d: %s%n", caseNumber, result);
    }
}