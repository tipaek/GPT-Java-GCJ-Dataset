import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    static Scanner scanner = new Scanner(System.in);

    public static class Time {
        int start;
        int end;
    }

    public static void main(String[] args) {
        int T = scanner.nextInt();
        String[] results = new String[T];

        for (int i = 0; i < T; i++) {
            results[i] = processTestCase(i + 1);
        }

        for (int i = 0; i < T; i++) {
            System.out.print(results[i]);
            if (i != T - 1) {
                System.out.println();
            }
        }
    }

    public static String processTestCase(int testCaseNumber) {
        int N = scanner.nextInt();
        Time[] intervals = new Time[N];
        
        for (int i = 0; i < N; i++) {
            intervals[i] = new Time();
            intervals[i].start = scanner.nextInt();
            intervals[i].end = scanner.nextInt();
        }

        List<Time> jSchedule = new ArrayList<>();
        List<Time> cSchedule = new ArrayList<>();
        StringBuilder result = new StringBuilder("Case #" + testCaseNumber + ": ");

        jSchedule.add(intervals[0]);
        result.append("J");
        String lastAssigned = "J";

        for (int i = 1; i < N; i++) {
            boolean canAssign = true;

            if (lastAssigned.equals("J")) {
                if (canBeAssigned(intervals[i], jSchedule)) {
                    jSchedule.add(intervals[i]);
                    result.append("J");
                } else if (canBeAssigned(intervals[i], cSchedule)) {
                    cSchedule.add(intervals[i]);
                    result.append("C");
                    lastAssigned = "C";
                } else {
                    canAssign = false;
                }
            } else {
                if (canBeAssigned(intervals[i], cSchedule)) {
                    cSchedule.add(intervals[i]);
                    result.append("C");
                } else if (canBeAssigned(intervals[i], jSchedule)) {
                    jSchedule.add(intervals[i]);
                    result.append("J");
                    lastAssigned = "J";
                } else {
                    canAssign = false;
                }
            }

            if (!canAssign) {
                return "Case #" + testCaseNumber + ": Impossible";
            }
        }

        return result.toString();
    }

    public static boolean canBeAssigned(Time interval, List<Time> schedule) {
        for (Time t : schedule) {
            if (interval.start < t.end && interval.end > t.start) {
                return false;
            }
        }
        return true;
    }
}