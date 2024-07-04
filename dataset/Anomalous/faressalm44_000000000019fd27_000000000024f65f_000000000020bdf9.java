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

        for (String result : results) {
            System.out.println(result);
        }
    }

    public static String processTestCase(int testOrder) {
        int N = scanner.nextInt();
        Time[] intervals = new Time[N];

        for (int i = 0; i < N; i++) {
            intervals[i] = new Time();
            intervals[i].start = scanner.nextInt();
            intervals[i].end = scanner.nextInt();
        }

        List<Time> jList = new ArrayList<>();
        List<Time> cList = new ArrayList<>();
        StringBuilder schedule = new StringBuilder("Case #" + testOrder + ": ");
        boolean isPossible = true;

        jList.add(intervals[0]);
        schedule.append("J");

        for (int i = 1; i < N; i++) {
            boolean canAssignToJ = true;
            for (Time jTime : jList) {
                if (intervals[i].start < jTime.end && intervals[i].end > jTime.start) {
                    canAssignToJ = false;
                    break;
                }
            }

            if (canAssignToJ) {
                jList.add(intervals[i]);
                schedule.append("J");
            } else {
                boolean canAssignToC = true;
                for (Time cTime : cList) {
                    if (intervals[i].start < cTime.end && intervals[i].end > cTime.start) {
                        canAssignToC = false;
                        break;
                    }
                }

                if (canAssignToC) {
                    cList.add(intervals[i]);
                    schedule.append("C");
                } else {
                    isPossible = false;
                    break;
                }
            }
        }

        if (!isPossible) {
            return "Case #" + testOrder + ": IMPOSSIBLE";
        }

        return schedule.toString();
    }
}