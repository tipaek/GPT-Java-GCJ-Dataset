import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCaseCount = sc.nextInt();
        int caseNumber = 1;

        while (testCaseCount-- > 0) {
            int N = sc.nextInt();
            int[][] intervals = new int[N][2];
            Pair[] events = new Pair[2 * N];
            int eventIndex = 0;

            for (int i = 0; i < N; i++) {
                intervals[i][0] = sc.nextInt();
                intervals[i][1] = sc.nextInt();
                events[eventIndex++] = new Pair(0, intervals[i][0], i);
                events[eventIndex++] = new Pair(1, intervals[i][1], i);
            }

            Arrays.sort(events, new EventComparator());
            int[] ongoingTasks = new int[2 * N];

            for (int i = 0; i < 2 * N; i++) {
                ongoingTasks[i] = (events[i].flag == 0) ? 1 : -1;
            }

            boolean possible = true;

            for (int i = 1; i < 2 * N; i++) {
                ongoingTasks[i] += ongoingTasks[i - 1];
                if (ongoingTasks[i] > 2) {
                    possible = false;
                    break;
                }
            }

            if (!possible) {
                System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
            } else {
                StringBuilder schedule = new StringBuilder();
                int start = 0, end = 0;
                char prev = ' ';

                for (int i = 0; i < 2 * N; i++) {
                    int currentId = events[i].id;
                    int startTime = intervals[currentId][0];
                    int endTime = intervals[currentId][1];

                    if (events[i].flag == 0) {
                        if (schedule.length() == 0) {
                            schedule.append('C');
                            start = startTime;
                            end = endTime;
                            prev = 'C';
                        } else if (prev == 'C' && (endTime <= start || startTime >= end)) {
                            schedule.append('C');
                            start = startTime;
                            end = endTime;
                            prev = 'C';
                        } else if (prev == 'J' && (endTime <= start || startTime >= end)) {
                            schedule.append('J');
                            start = startTime;
                            end = endTime;
                            prev = 'J';
                        } else if (prev == 'C') {
                            schedule.append('J');
                            start = startTime;
                            end = endTime;
                            prev = 'J';
                        } else if (prev == 'J') {
                            schedule.append('C');
                            start = startTime;
                            end = endTime;
                            prev = 'C';
                        }
                    }
                }
                System.out.println("Case #" + caseNumber + ": " + schedule.toString());
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
    @Override
    public int compare(Pair p1, Pair p2) {
        return Integer.compare(p1.time, p2.time);
    }
}