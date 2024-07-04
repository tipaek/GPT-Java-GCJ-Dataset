import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int numActivities = scanner.nextInt();
            int[] startTimes = new int[numActivities];
            int[] finishTimes = new int[numActivities];

            for (int i = 0; i < numActivities; i++) {
                startTimes[i] = scanner.nextInt();
                finishTimes[i] = scanner.nextInt();
            }

            Activity[] activities = new Activity[numActivities];
            for (int i = 0; i < numActivities; i++) {
                activities[i] = new Activity(i, startTimes[i], finishTimes[i]);
            }
            Arrays.sort(activities);

            int[] sortedStartTimes = new int[numActivities];
            int[] sortedFinishTimes = new int[numActivities];
            for (int i = 0; i < numActivities; i++) {
                sortedStartTimes[i] = activities[i].start;
                sortedFinishTimes[i] = activities[i].finish;
            }

            Object[] cameronActivities = getMaxActivities(sortedStartTimes, sortedFinishTimes, numActivities);

            int remainingActivitiesCount = numActivities - cameronActivities.length;
            Activity[] remainingActivities = new Activity[remainingActivitiesCount];
            int index = 0;
            for (int i = 0; i < numActivities; i++) {
                if (!isInList(i, cameronActivities)) {
                    remainingActivities[index++] = new Activity(i, sortedStartTimes[i], sortedFinishTimes[i]);
                }
            }

            int[] remainingStartTimes = new int[remainingActivitiesCount];
            int[] remainingFinishTimes = new int[remainingActivitiesCount];
            for (int i = 0; i < remainingActivitiesCount; i++) {
                remainingStartTimes[i] = remainingActivities[i].start;
                remainingFinishTimes[i] = remainingActivities[i].finish;
            }
            Object[] jamesActivities = getMaxActivities(remainingStartTimes, remainingFinishTimes, remainingActivitiesCount);

            int totalActivities = cameronActivities.length + jamesActivities.length;

            ReSort[] result = new ReSort[numActivities];
            System.out.print("Case #" + caseNumber + ": ");
            if (totalActivities == numActivities) {
                for (int i = 0; i < numActivities; i++) {
                    if (isInList(i, cameronActivities)) {
                        result[i] = new ReSort('C', activities[i]);
                    } else {
                        result[i] = new ReSort('J', activities[i]);
                    }
                }
                String output = getResult(result);
                System.out.print(output);
            } else {
                System.out.print("IMPOSSIBLE");
            }
            System.out.println();
        }
    }

    public static Object[] getMaxActivities(int[] startTimes, int[] finishTimes, int numActivities) {
        int i = 0;
        ArrayList<Integer> selectedActivities = new ArrayList<>();
        selectedActivities.add(i);

        for (int j = 1; j < numActivities; j++) {
            if (startTimes[j] >= finishTimes[i]) {
                selectedActivities.add(j);
                i = j;
            }
        }
        return selectedActivities.toArray();
    }

    public static boolean isInList(int num, Object[] objects) {
        for (Object obj : objects) {
            if (num == (int) obj) {
                return true;
            }
        }
        return false;
    }

    public static String getResult(ReSort[] sortedResult) {
        Arrays.sort(sortedResult);
        StringBuilder resultBuilder = new StringBuilder();
        for (ReSort reSort : sortedResult) {
            resultBuilder.append(reSort.character);
        }
        return resultBuilder.toString();
    }
}

class Activity implements Comparable<Activity> {
    int index;
    int start;
    int finish;

    public Activity(int index, int start, int finish) {
        this.index = index;
        this.start = start;
        this.finish = finish;
    }

    @Override
    public int compareTo(Activity other) {
        return Integer.compare(this.finish, other.finish);
    }

    @Override
    public String toString() {
        return "Activity [index=" + index + ", start=" + start + ", finish=" + finish + "]";
    }
}

class ReSort implements Comparable<ReSort> {
    char character;
    Activity activity;

    public ReSort(char character, Activity activity) {
        this.character = character;
        this.activity = activity;
    }

    @Override
    public int compareTo(ReSort other) {
        return Integer.compare(this.activity.index, other.activity.index);
    }
}