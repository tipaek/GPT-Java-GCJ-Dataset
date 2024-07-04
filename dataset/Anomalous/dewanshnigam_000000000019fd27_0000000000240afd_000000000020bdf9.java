import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        StringBuilder result = new StringBuilder();
        int caseNumber = 1;

        while (t-- > 0) {
            int n = scanner.nextInt();
            Activity[] activities = new Activity[n];
            Activity[] originalActivities = new Activity[n];

            for (int i = 0; i < n; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                activities[i] = new Activity(start, end, i);
                originalActivities[i] = new Activity(start, end, i);
            }

            Arrays.sort(activities, new ActivityComparator());
            int[] assignments = new int[n]; // 1 for Cameron, 2 for Jamie
            assignments[0] = 1; // Cameron takes the first activity
            boolean[] isFree = new boolean[3];
            isFree[1] = false; // Cameron is busy
            isFree[2] = true; // Jamie is free

            int[] finishTimes = new int[3];
            finishTimes[1] = activities[0].end; // Cameron's end time
            boolean isImpossible = false;

            for (int i = 1; i < n; i++) {
                if (activities[i].st >= finishTimes[1]) {
                    finishTimes[1] = 0;
                    isFree[1] = true;
                }
                if (activities[i].st >= finishTimes[2]) {
                    finishTimes[2] = 0;
                    isFree[2] = true;
                }

                if (activities[i].st >= activities[i - 1].end) {
                    assignments[i] = assignments[i - 1];
                    isFree[assignments[i]] = false;
                    finishTimes[assignments[i]] = activities[i].end;
                } else if (isFree[1]) {
                    isFree[1] = false;
                    finishTimes[1] = activities[i].end;
                    assignments[i] = 1;
                } else if (isFree[2]) {
                    isFree[2] = false;
                    finishTimes[2] = activities[i].end;
                    assignments[i] = 2;
                } else {
                    isImpossible = true;
                    break;
                }
            }

            if (isImpossible) {
                result.append("Case #").append(caseNumber).append(": IMPOSSIBLE\n");
            } else {
                Map<Integer, Integer> indexMap = new HashMap<>();
                for (int i = 0; i < n; i++) {
                    indexMap.put(activities[i].index, i);
                }
                result.append("Case #").append(caseNumber).append(": ");
                for (int i = 0; i < n; i++) {
                    int assignedIndex = indexMap.get(originalActivities[i].index);
                    result.append(assignments[assignedIndex] == 1 ? "C" : "J");
                }
                result.append("\n");
            }
            caseNumber++;
        }

        System.out.println(result);
    }

    static class Activity {
        int st;
        int end;
        int index;

        public Activity(int st, int end, int index) {
            this.st = st;
            this.end = end;
            this.index = index;
        }
    }

    static class ActivityComparator implements Comparator<Activity> {
        public int compare(Activity a, Activity b) {
            if (a.st == b.st) {
                return a.end - b.end;
            }
            return a.st - b.st;
        }
    }
}