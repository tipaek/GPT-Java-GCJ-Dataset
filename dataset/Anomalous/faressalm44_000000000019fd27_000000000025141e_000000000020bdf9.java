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

    public static String processTestCase(int testCaseNumber) {
        int N = scanner.nextInt();
        Time[] intervals = new Time[N];

        for (int i = 0; i < N; i++) {
            intervals[i] = new Time();
            intervals[i].start = scanner.nextInt();
            intervals[i].end = scanner.nextInt();
        }

        StringBuilder result = new StringBuilder("Case #" + testCaseNumber + ": ");
        List<Time> jList = new ArrayList<>();
        List<Time> cList = new ArrayList<>();
        boolean possible = true;
        String currentAssignment = "J";

        jList.add(intervals[0]);
        result.append(currentAssignment);

        for (int i = 1; i < N; i++) {
            boolean canAssignToJ = true;
            boolean canAssignToC = true;

            for (Time t : jList) {
                if (intervals[i].start < t.end && intervals[i].end > t.start) {
                    canAssignToJ = false;
                    break;
                }
            }

            if (canAssignToJ) {
                jList.add(intervals[i]);
                result.append("J");
                continue;
            }

            for (Time t : cList) {
                if (intervals[i].start < t.end && intervals[i].end > t.start) {
                    canAssignToC = false;
                    break;
                }
            }

            if (canAssignToC) {
                cList.add(intervals[i]);
                result.append("C");
            } else {
                possible = false;
                break;
            }
        }

        if (!possible) {
            return "Case #" + testCaseNumber + ": IMPOSSIBLE";
        }

        return result.toString();
    }
}