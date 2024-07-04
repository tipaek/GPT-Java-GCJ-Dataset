import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Solution {
    private Scanner scanner;
    private PrintStream printStream;

    public static void main(String[] args) {
        new Solution().execute(System.in, System.out);
    }

    Solution() {
        // No-op.
    }

    void execute(InputStream in, PrintStream out) {
        scanner = new Scanner(in);
        printStream = out;

        int cases = scanner.nextInt();

        for (int i = 0; i < cases; i++) {
            solveCase(i + 1, new char[] { 'C', 'J' });
        }
    }

    private void solveCase(int caseNo, char[] persons) {
        int[] timetable = new int[24 * 60 + 1];
        Map<Integer, List<Integer>> activityMap = new HashMap<>();

        int count = scanner.nextInt();
        char[] schedule = new char[count];
        int[] endTime = new int[count];

        for (int i = 0; i < count; i++) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();

            timetable[start]++;
            timetable[end]--;

            activityMap.computeIfAbsent(start, ArrayList::new)
                    .add(i);

            endTime[i] = end;
        }

        int activitiesCount = 0;
        boolean impossible = false;

        int[] whenPersonBecomeFree = new int[persons.length];

        for (int i = 0; i < timetable.length; i++) {
            if (timetable[i] != 0) {
                activitiesCount += timetable[i];

                if (activitiesCount > persons.length) {
                    impossible = true;
                    break;
                }
            }

            List<Integer> activities = activityMap.get(i);

            if (activities != null) {
                for (int activityIndex : activities) {
                    for (int personId = 0; personId < persons.length; personId++) {
                        if (whenPersonBecomeFree[personId] <= i) {
                            schedule[activityIndex] = persons[personId];
                            whenPersonBecomeFree[personId] = endTime[activityIndex];
                            break;
                        }
                    }
                }
            }
        }

        String result = impossible ? "IMPOSSIBLE" : String.valueOf(schedule);

        printStream.println(String.format("Case #%d: %s", caseNo, result));
    }
}