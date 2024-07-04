import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCaseCount = sc.nextInt();
        int caseNumber = 1;

        while (testCaseCount-- > 0) {
            int activityCount = sc.nextInt();
            int[][] activities = new int[activityCount][2];
            Pair[] events = new Pair[2 * activityCount];
            int eventIndex = 0;

            for (int i = 0; i < activityCount; i++) {
                activities[i][0] = sc.nextInt();
                activities[i][1] = sc.nextInt();
                events[eventIndex++] = new Pair(0, activities[i][0], i);
                events[eventIndex++] = new Pair(1, activities[i][1], i);
            }

            Arrays.sort(events, new EventComparator());

            int[] eventBalance = new int[2 * activityCount];
            for (int i = 0; i < 2 * activityCount; i++) {
                eventBalance[i] = (events[i].flag == 0) ? 1 : -1;
            }

            boolean isPossible = true;
            for (int i = 1; i < 2 * activityCount; i++) {
                eventBalance[i] += eventBalance[i - 1];
                if (eventBalance[i] > 2) {
                    isPossible = false;
                    break;
                }
            }

            StringBuilder result = new StringBuilder();
            char[] assignment = new char[activityCount];
            char lastAssigned = ' ';
            int start = -1, end = -1;

            for (int i = 0; i < 2 * activityCount; i++) {
                int activityIndex = events[i].id;
                int startTime = activities[activityIndex][0];
                int endTime = activities[activityIndex][1];

                if (events[i].flag == 0) {
                    if (start == -1 && end == -1) {
                        assignment[activityIndex] = 'C';
                        lastAssigned = 'C';
                    } else if (lastAssigned == 'C' && (endTime <= start || startTime >= end)) {
                        assignment[activityIndex] = 'C';
                        lastAssigned = 'C';
                    } else if (lastAssigned == 'J' && (endTime <= start || startTime >= end)) {
                        assignment[activityIndex] = 'J';
                        lastAssigned = 'J';
                    } else if (lastAssigned == 'C') {
                        assignment[activityIndex] = 'J';
                        lastAssigned = 'J';
                    } else if (lastAssigned == 'J') {
                        assignment[activityIndex] = 'C';
                        lastAssigned = 'C';
                    }
                    start = startTime;
                    end = endTime;
                }
            }

            for (char c : assignment) {
                result.append(c);
            }

            if (!isPossible) {
                System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + caseNumber + ": " + result.toString());
            }

            caseNumber++;
        }
    }
}

class Pair {
    int flag;
    int time;
    int id;

    Pair(int flag, int time, int id) {
        this.flag = flag;
        this.time = time;
        this.id = id;
    }
}

class EventComparator implements Comparator<Pair> {
    public int compare(Pair p1, Pair p2) {
        return Integer.compare(p1.time, p2.time);
    }
}