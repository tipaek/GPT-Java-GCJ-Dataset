import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        for (int i = 1; i <= testCases; i++) {
            int activities = scanner.nextInt();
            int[][] intervals = new int[activities][2];
            for (int j = 0; j < activities; j++) {
                intervals[j][0] = scanner.nextInt();
                intervals[j][1] = scanner.nextInt();
            }
            Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
            solve(intervals, i);
        }
    }

    static Stack<String> availablePersons = new Stack<>();
    static int[] endTime = new int[2]; // endTime[0] for C, endTime[1] for J

    private static void initialize() {
        availablePersons.push("J");
        availablePersons.push("C");
        endTime[0] = 0;
        endTime[1] = 0;
    }

    private static void solve(int[][] intervals, int caseNumber) {
        initialize();
        StringBuilder schedule = new StringBuilder();
        int activityIndex = 0;
        while (activityIndex < intervals.length) {
            if (activityIndex == 0) {
                schedule.append(availablePersons.pop());
                endTime[0] = intervals[activityIndex][1];
                activityIndex++;
            } else {
                if (!availablePersons.isEmpty()) {
                    String currentPerson = availablePersons.pop();
                    if ("J".equals(currentPerson)) {
                        endTime[1] = intervals[activityIndex][1];
                    } else {
                        endTime[0] = intervals[activityIndex][1];
                    }
                    schedule.append(currentPerson);
                    activityIndex++;
                } else {
                    if (endTime[0] <= intervals[activityIndex][0]) {
                        availablePersons.push("C");
                        endTime[0] = 0;
                        continue;
                    }
                    if (endTime[1] <= intervals[activityIndex][0]) {
                        availablePersons.push("J");
                        endTime[1] = 0;
                        continue;
                    }
                    break;
                }
            }
        }
        if (schedule.length() == intervals.length) {
            System.out.println("Case #" + caseNumber + ": " + schedule);
        } else {
            System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
        }
    }
}